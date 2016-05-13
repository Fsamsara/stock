package com.metersbonwe.stock.biz.common.service.impl;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.localcache.CacheManager;
import com.metersbonwe.stock.biz.common.localcache.CacheName;
import com.metersbonwe.stock.biz.common.service.*;
import com.metersbonwe.stock.configuration.ThreadConfig;
import com.metersbonwe.stock.configuration.ThreadConfigFactory;
import com.metersbonwe.stock.dal.define.core.mapper.UsefulWarehChangeCoreMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.UsefulWarehChangeSyncMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpChannelScope;
import com.metersbonwe.stock.po.sync.define.ChannelReservedBean;
import com.metersbonwe.stock.po.sync.define.TmpStockWareh;
import com.metersbonwe.stock.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/* *
 * @description 获取SKU最终自由量,锁定量,预留独占量，并更新渠道+sku表，且推送线上
 * @author huangbiao
 * @date 2016/03/17
 * @version V1.0
 */
@Service public class ChannelCalServiceImpl implements ChannelCalService {

    private static StockLog                                        stockLog = StockLogFactory.getLogger(ChannelCalServiceImpl.class);

    @Autowired TmpTableService                                     tmpTableService;

    @Autowired UsefulWarehChangeCoreMapper                         usefulWarehChangeCoreMapper;

    @Autowired UsefulWarehChangeSyncMapper                         usefulWarehChangeSyncMapper;

    @Autowired FullChannelGroupService                             fullChannelGroupService;

    @Autowired MqSendService                                       mqSendService;

    @Resource CacheService                                         cacheServiceImpl;

    @Resource CacheManager                                         cacheManagerImpl;

    @Resource(name = "stockCommonExecutor") ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public boolean processChannelUsefulWarehChange(boolean isFullSyncFlag) {
        try {
            resetCatch();
            List<TmpChannelScope> tmpChannelScopeList;
            if (!isFullSyncFlag) {
                tmpChannelScopeList = getTmpData();
            } else {
                tmpChannelScopeList = getFullSyncData();
            }
            Map<String, List<TmpChannelScope>> channelWarehMap = getChannelWarehMap(tmpChannelScopeList);
            Map<List<String>, List<String>> scopeChannelMap = getScopeChannelMap(channelWarehMap);
            process(scopeChannelMap);
            if (!isFullSyncFlag) {
                long maxId = getMaxId(tmpChannelScopeList);
                tmpTableService.delSyncTmpData(Constants.TmpDataTable.TMP_CHANNEL_SCOPE, maxId);
            }
            return true;
        } catch (Exception e) {
            //程序报错后还是要释放缓存中更新渠道商品表的FLG为 false
            stockLog.error("处理渠道可用仓变化出错：" + e.getMessage(), e);
            return false;
        }
    }

    /**
     * @description 重新设置缓存的值
     */
    private void resetCatch() {
        cacheManagerImpl.syncOnce(CacheName.CHANNELSCOPE.getCacheName());
        cacheManagerImpl.syncOnce(CacheName.CHANNELUSEFULWAREH.getCacheName());
    }

    /**
     * @param tmpChannelScopeList
     *            tmp_channel_scope表对应的javaBean对象
     * @return 最大ID
     * @description 获取临时表的最大ID
     */
    private long getMaxId(List<TmpChannelScope> tmpChannelScopeList) {
        long maxId = 0l;
        for (TmpChannelScope tmpChannelScope : tmpChannelScopeList) {
            long tmpId = tmpChannelScope.getId().longValue();
            if (tmpId > maxId) {
                maxId = tmpId;
            }
        }
        return maxId;
    }

    /**
     * @return TmpChannelScope集合
     * @description 获取全量所有数据
     */
    private List<TmpChannelScope> getFullSyncData() {
        logger("全量同步获取所有渠道开始");
        List<String> usefulChannel = cacheServiceImpl.getAllUsefulChannelForCache();//fullChannelGroupService.getUsefulChannel();
        List<TmpChannelScope> tmpChannelScopeList = new ArrayList<>();
        for (String channelCode : usefulChannel) {
            TmpChannelScope tmpChannelScope = new TmpChannelScope();
            tmpChannelScope.setChannelCode(channelCode);
            tmpChannelScopeList.add(tmpChannelScope);
        }
        stockLog.debug("全量同步获取的所有渠道为：" + usefulChannel.toString());
        logger("全量同步获取所有渠道结束");
        return tmpChannelScopeList;
    }

    /**
     * @param scopeChannelMap
     *            最终可用仓，渠道Map，map的key,value都是List
     * @description 渠道可用仓变化处理流程
     */
    private void process(Map<List<String>, List<String>> scopeChannelMap) {
        logger("渠道可用仓变化处理数据开始");
        for (Map.Entry<List<String>, List<String>> entry : scopeChannelMap.entrySet()) {
            List<String> channelList = new ArrayList<>(entry.getValue());
            doPrepare(entry);
            insertToTmpStockChannelProd();
            insertToChannelProd(channelList);
        }
        logger("渠道可用仓变化数据处理结束");
    }

    /**
     * @description 同时处理 1、 仓获取数据插入tmp_stock_table_sum; 2、预留独占量数据处理
     */
    private void doPrepare(Map.Entry<List<String>, List<String>> entry) {
        List<String> usefulWarehList = new ArrayList<>(entry.getKey());
        usefulWarehList.retainAll(cacheServiceImpl.getB2BWarehFromCache());
        List<String> channelList = new ArrayList<>(entry.getValue());
        //线程通信计数器,开启两个线程
        CountDownLatch countDownLatch = new CountDownLatch(3);
        threadPoolTaskExecutor.execute(new InsertTmpStockTableSum(entry, countDownLatch));
        threadPoolTaskExecutor.execute(new InsertToTmpStockBatchReserved(channelList, usefulWarehList, countDownLatch));
        threadPoolTaskExecutor.execute(new InsertToTmpStockBatchGroupShopReserved(channelList, usefulWarehList, countDownLatch));
        try {
            //等两个线程结束
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description 数据从tmp_stock_table_sum临时表汇总插入渠道商品明细表
     */
    private void insertToTmpStockChannelProd() {
        logger("数据从tmp_stock_table_sum临时表汇总后插入渠道商品明细临时表开始");
        tmpTableService.truncateCoreTmpTable(Constants.TmpDataTable.TMP_STOCK_CHANNEL_PROD);
        usefulWarehChangeCoreMapper.insertToTmpStockChannelProd();
        logger("数据从tmp_stock_table_sum临时表汇总后插入渠道商品明细临时表结束");
    }

    /**
     * @description 数据汇总插入到渠道商品明细表和渠道商品明细表子表
     * @param channelList
     *            渠道
     */
    void insertToChannelProd(List<String> channelList) {
        logger("数据插入渠道商品明细表和渠道商品明细表子表开始");
        final ThreadConfig tmpconfig = ThreadConfigFactory.getThreadConfig(Constants.THREAD_CONFIG_BIZNAME_CHANNELTMP);
        for (String channelCode : channelList) {
            while (true) {
                if (tmpconfig.isThreadPoolNotEmpty()) {
                    tmpconfig.threadUp();
                    threadPoolTaskExecutor.submit(new InsertToChannelProd(channelCode, tmpconfig));
                    break;
                }
            }
        }
        tmpconfig.waitAllThreadDown();
        logger("数据插入渠道商品明细表和渠道商品明细表子表结束");
    }

    /**
     * @description 处理渠道商品明细表，和渠道商品明细子表的数据内部类
     */
    class InsertToChannelProd implements Runnable {
        String       channelCode;

        ThreadConfig tmpconfig;

        public InsertToChannelProd(String channelCode, ThreadConfig tmpconfig) {
            this.channelCode = channelCode;
            this.tmpconfig = tmpconfig;
        }

        @Override
        public void run() {
            try {
                String channelTableName = Constants.STOCK_CHANNEL_PROD_PREFIX + channelCode.toLowerCase();
                String channelSubTableName = Constants.STOCK_CHANNEL_PROD_SUB_PREFIX + channelCode.toLowerCase();
                fullChannelGroupService.setChannelProdUpdateFlag(channelCode, true);
                updateDecreaceSku(channelTableName);
                replaceIntoChannelProdTable(channelTableName, channelCode);
                insertToStockChannelProdSub(channelSubTableName, channelCode);
                mqSendService.sendSendToLineMqFlag(channelCode);
            } finally {
                tmpconfig.threadDown();
                fullChannelGroupService.setChannelProdUpdateFlag(channelCode, false);
            }
        }
    }

    /**
     * 店群预留量数据整理
     */
    class InsertToTmpStockBatchGroupShopReserved implements Runnable {

        private final List<String> channelCodeList;

        private final List<String> usefulWarehList;

        private CountDownLatch     countDownLath;

        public InsertToTmpStockBatchGroupShopReserved(List<String> channelCodeList, List<String> usefulWarehList, CountDownLatch countDownLath) {
            this.channelCodeList = channelCodeList;
            this.usefulWarehList = usefulWarehList;
            this.countDownLath = countDownLath;
        }

        @Override
        public void run() {
            try {
                logger("处理店群预留数据开始");
                tmpTableService.truncateCoreTmpTable(Constants.TmpDataTable.TMP_STOCK_BATCH_SHOP_GROUP_RESERVED);
                tmpTableService.truncateCoreTmpTable(Constants.TmpDataTable.TMP_SHOP_GROUP_RESERVED_SUM);
                if (usefulWarehList == null || usefulWarehList.size() == 0 || channelCodeList == null || channelCodeList.size() == 0) {
                    logger("无启用b2b的仓");
                    return;
                }
                //获得groupId集合
                List<String> groupIdList = new ArrayList<>();
                for (String channelCode : channelCodeList) {
                    groupIdList.add(cacheServiceImpl.getShopGroupFromCache(channelCode));
                }
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put(Constants.ParamMapKey.CHANNEL_CODE_LIST, groupIdList);
                paramMap.put(Constants.ParamMapKey.USEFUL_WAREH_LIST, usefulWarehList);
                logger("从同步库捞取店群预留量数据开始");
                List<ChannelReservedBean> reservedBeanList = usefulWarehChangeSyncMapper.getChannelReservedData(paramMap);
                logger("从同步库捞取店群预留量数据结束");
                if (reservedBeanList.size() > 0) {
                    paramMap.put("reservedBeanList", reservedBeanList);
                    logger("店群预留量数据录入tmp_stock_batch_shop_group_reserved开始");
                    usefulWarehChangeCoreMapper.insertToTmpStockBatchShopGroupReserved(paramMap);
                    logger("店群预留量数据录入tmp_stock_batch_shop_group_reserved结束");
                }
                logger("店群预留量数据录入tmp_shop_group_reserved_sum开始");
                usefulWarehChangeCoreMapper.insertIntoTmpShopGroupReservedSum();
                logger("店群预留量数据录入tmp_shop_group_reserved_sum结束");
                logger("处理店群预留数据结束");
            } finally {
                countDownLath.countDown();
            }
        }
    }

    /**
     * 仓表数据汇总
     */
    class InsertTmpStockTableSum implements Runnable {
        private final Map.Entry<List<String>, List<String>> entry;

        private CountDownLatch                              countDownLatch;

        public InsertTmpStockTableSum(Map.Entry<List<String>, List<String>> entry, CountDownLatch countDownLatch) {
            this.entry = entry;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                logger("数据插入tmp_stock_table_sum按【表】循环开始时间");
                //1、从st_active_wareh 表获取所有的仓插入表tmp_stock_wareh
                List<TmpStockWareh> allWarehList = usefulWarehChangeSyncMapper.getAllWareh();
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("allWarehList", allWarehList);
                tmpTableService.truncateCoreTmpTable(Constants.TmpDataTable.TMP_STOCK_WAREH);
                usefulWarehChangeCoreMapper.insertToTmpStockWareh(paramMap);
                List<String> tmpWarehList = usefulWarehChangeCoreMapper.getTmpStockWareh();
                //可用仓,切记不能改变entry的值，只能使用
                List<String> usefulWarehShopList = entry.getKey();
                //仓List
                List<String> warehList = new ArrayList<>(usefulWarehShopList);
                warehList.retainAll(tmpWarehList);
                //店List
                List<String> shopList = new ArrayList<>(usefulWarehShopList);
                shopList.removeAll(tmpWarehList);
                tmpTableService.truncateCoreTmpTable(Constants.TmpDataTable.TMP_STOCK_TABLE_SUM);
                if (warehList.size() > 0) {
                    paramMap.put("warehOrShopList", warehList);
                    List<String> tableNumListWareh = usefulWarehChangeCoreMapper.getTableNoList(paramMap);
                    for (String tableNo : tableNumListWareh) {
                        Map<String, Object> paramMaps = new HashMap<>();
                        String tableSuffix = tableNo.length() == 1 ? 0 + tableNo : tableNo;
                        paramMaps.put(Constants.ParamMapKey.TABLE_NAME, Constants.STOCK_WAREH_PROD_PREFIX + tableSuffix);
                        paramMaps.put("warehList", warehList);
                        usefulWarehChangeCoreMapper.insertWarehToTmpStockTableSum(paramMaps);
                    }
                }

                if (shopList.size() > 0) {
                    paramMap.put("warehOrShopList", shopList);
                    List<String> tableNumListShop = usefulWarehChangeCoreMapper.getTableNoList(paramMap);
                    for (String tableNo : tableNumListShop) {
                        Map<String, Object> paramMaps = new HashMap<>();
                        String tableSuffix = tableNo.length() == 1 ? 0 + tableNo : tableNo;
                        paramMaps.put(Constants.ParamMapKey.TABLE_NAME, Constants.STOCK_WAREH_PROD_PREFIX + tableSuffix);
                        paramMaps.put("shopList", shopList);
                        usefulWarehChangeCoreMapper.insertShopToTmpStockTableSum(paramMaps);
                    }
                }
                logger("数据插入tmp_stock_table_sum按【表】循环结束");
            } finally {
                countDownLatch.countDown();
            }
        }
    }

    /**
     * @param channelSubTableName
     *            渠道商品明细表子表的名称
     * @description 将可用仓变化渠道中新增的sku插入渠道商品明细表子表
     */
    private void insertToStockChannelProdSub(String channelSubTableName, String channelCode) {
        logger("数据插入到渠道商品明细子表" + channelSubTableName + "开始");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(Constants.ParamMapKey.TABLE_NAME, channelSubTableName);
        paramMap.put(Constants.ParamMapKey.CHANNEL_CODE, channelCode);
        usefulWarehChangeCoreMapper.insertToStockChannelProdSub(paramMap);
        logger("数据插入到渠道商品明细子表" + channelSubTableName + "结束");
    }

    /**
     * @param channelTableName
     *            渠道商品明细表分表名称
     * @param channelCode
     *            渠道号
     * @description 将临时表的数据插入或者更新渠道商品明细表
     */
    private void replaceIntoChannelProdTable(String channelTableName, String channelCode) {
        logger("数据更新或者插入到渠道表" + channelTableName + "开始");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(Constants.ParamMapKey.TABLE_NAME, channelTableName);
        paramMap.put(Constants.ParamMapKey.CHANNEL_CODE, channelCode);
        paramMap.put(Constants.ParamMapKey.SHOP_GROUP_ID, cacheServiceImpl.getShopGroupFromCache(channelCode));
        //注意： 将replace into 拆成两个sql是由于效率问题
        usefulWarehChangeCoreMapper.insertIntoChannelProdTable(paramMap);
        usefulWarehChangeCoreMapper.updateChannelProdTable(paramMap);
        logger("数据更新或者插入到渠道表" + channelTableName + "结束");
    }

    /**
     * @param channelTableName
     *            渠道+sku表
     * @description 更新由于可用仓变动减少的sku的相关数据
     */
    private void updateDecreaceSku(String channelTableName) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(Constants.ParamMapKey.TABLE_NAME, channelTableName);
        usefulWarehChangeCoreMapper.updateDecreaceSku(paramMap);
    }

    /**
     * 预留量数据整理
     */
    class InsertToTmpStockBatchReserved implements Runnable {

        private final List<String> channelCodeList;

        private final List<String> usefulWarehList;

        private CountDownLatch     countDownLath;

        public InsertToTmpStockBatchReserved(List<String> channelCodeList, List<String> usefulWarehList, CountDownLatch countDownLath) {
            this.channelCodeList = channelCodeList;
            this.usefulWarehList = usefulWarehList;
            this.countDownLath = countDownLath;
        }

        @Override
        public void run() {
            try {
                logger("处理预留数据开始");
                tmpTableService.truncateCoreTmpTable(Constants.TmpDataTable.TMP_STOCK_BATCH_RESERVED);
                tmpTableService.truncateCoreTmpTable(Constants.TmpDataTable.TMP_RESERVED_SUM);
                if (usefulWarehList == null || usefulWarehList.size() == 0 || channelCodeList == null || channelCodeList.size() == 0) {
                    logger("无启用b2b的仓");
                    return;
                }
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put(Constants.ParamMapKey.CHANNEL_CODE_LIST, channelCodeList);
                paramMap.put(Constants.ParamMapKey.USEFUL_WAREH_LIST, usefulWarehList);
                logger("从同步库捞取预留量数据开始");
                List<ChannelReservedBean> reservedBeanList = usefulWarehChangeSyncMapper.getChannelReservedData(paramMap);
                logger("从同步库捞取预留量数据结束");
                if (reservedBeanList != null && reservedBeanList.size() > 0) {
                    paramMap.put("reservedBeanList", reservedBeanList);
                    logger("预留量数据录入tmp_stock_batch_reserved开始");
                    usefulWarehChangeCoreMapper.insertToTmpStockBatchReserved(paramMap);
                    logger("预留量数据录入tmp_stock_batch_reserved结束");
                }
                logger("预留量数据录入tmp_reserved_sum开始");
                usefulWarehChangeCoreMapper.insertIntoTmpReservedSum();
                logger("预留量数据录入tmp_reserved_sum结束");
                logger("处理预留数据结束");
                return;
            } finally {
                countDownLath.countDown();
            }
        }
    }

    /**
     * @return List TmpChannelScope的集合
     * @description 获取tmp_channel_scope表的数据
     */
    private List<TmpChannelScope> getTmpData() {
        logger("获取tmp_channel_scope数据开始");
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put(Constants.ParamMapKey.TABLE_NAME, Constants.TmpDataTable.TMP_CHANNEL_SCOPE);
        paramMap.put(Constants.ParamMapKey.PARTITION_STRING, Constants.Dereplication.PARTITION_BY_WAREHID_CHANNEL_SCOPECHANGE);
        List<Map<String, Object>> tempDataMap = tmpTableService.getSyncTmpData(paramMap);
        List<TmpChannelScope> beanList = new ArrayList<>();
        for (Map<String, Object> dataMap : tempDataMap) {
            TmpChannelScope TmpChannelScope = new TmpChannelScope();
            CommonUtil.transMap2Bean(dataMap, TmpChannelScope);
            beanList.add(TmpChannelScope);
        }
        logger("获取tmp_channel_scope数据结束");
        return beanList;
    }

    /**
     * @return Map key为渠道号，value为临时表对应的javaBeanList
     * @description 按渠道汇总变化的仓
     */
    private Map<String, List<TmpChannelScope>> getChannelWarehMap(List<TmpChannelScope> TmpChannelScopeList) {
        logger("按渠道汇总变化仓开始");
        Map<String, List<TmpChannelScope>> channelWarehMap = new HashMap<>();
        for (TmpChannelScope TmpChannelScope : TmpChannelScopeList) {
            String channelCode = TmpChannelScope.getChannelCode();
            if (channelWarehMap.get(channelCode) == null) {
                List<TmpChannelScope> tmpList = new ArrayList<>();
                tmpList.add(TmpChannelScope);
                channelWarehMap.put(channelCode, tmpList);
            } else {
                channelWarehMap.get(channelCode).add(TmpChannelScope);
            }
        }
        logger("按渠道汇总变化仓结束");
        return channelWarehMap;
    }

    /**
     * @return Map key为配发范围List，value为渠道List
     * @description 根据渠道可用仓分组渠道，相同可用仓的渠道未一组
     */
    private Map<List<String>, List<String>> getScopeChannelMap(Map<String, List<TmpChannelScope>> channelWarehMap) {
        logger("按渠道可用仓分组渠道开始");
        Map<List<String>, List<String>> scopeChannelMap = new HashMap<>();
        for (Map.Entry<String, List<TmpChannelScope>> entry : channelWarehMap.entrySet()) {
            try {
                List<String> usefulWareh = cacheServiceImpl.getChannelUsefulWarehFromCache(entry.getKey());
                List<String> channelScope = cacheServiceImpl.getChannelScopeFromCache(entry.getKey());
                List<String> channelList = new ArrayList<>();
                boolean needCalFlg = false;//是否需要计算
                for (TmpChannelScope tmpChannelScope : entry.getValue()) {
                    //不是配发范围变化
                    if ("0".equals(tmpChannelScope.getScopeChange())) {
                        //配发范围是否包含开关仓的仓
                        if (channelScope.contains(tmpChannelScope.getWarehId())) {
                            needCalFlg = true;
                            if ("0".equals(tmpChannelScope.getWarehState())) {
                                usefulWareh.remove(tmpChannelScope.getWarehId());
                            }
                        }
                    } else {
                        needCalFlg = true;
                    }
                }
                if (!needCalFlg) {
                    continue;
                }
                if (scopeChannelMap.containsKey(usefulWareh)) {
                    //去重配发范围内重复的渠道
                    if (!scopeChannelMap.get(usefulWareh).contains(entry.getKey())) {
                        scopeChannelMap.get(usefulWareh).add(entry.getKey());
                    }
                } else {
                    channelList.add(entry.getKey());
                    scopeChannelMap.put(usefulWareh, channelList);
                }
            } catch (Exception e) {
                stockLog.debug("按可用仓分组渠道，渠道：" + entry.getKey() + "错误", e);
            }
        }
        stockLog.debug("按最终可用仓分组渠道后的Map为：" + scopeChannelMap.toString());
        logger("按渠道可用仓分组渠道结束");
        return scopeChannelMap;
    }

    private static void logger(String msg) {
        stockLog.debug("==========" + msg + ":" + new Date() + "==========");
    }
}
