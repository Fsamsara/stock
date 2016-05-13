package com.metersbonwe.stock.biz.schedule.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.biz.common.service.WmsLockedStockService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockCommonConfigMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockWarehProdMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockWarehProdDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.TmpStockWmsBakDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.TmpStockWmsDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.UdWarehParamDefineMapper;
import com.metersbonwe.stock.dal.define.wms.mapper.WmsStockProdQtyDefineMapper;
import com.metersbonwe.stock.facade.schedule.WmsStockChangesComparService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.po.core.StockWarehProdExample;
import com.metersbonwe.stock.po.core.TmpQueueFreeLock;
import com.metersbonwe.stock.po.core.TmpStockWms;
import com.metersbonwe.stock.po.core.TmpStockWmsBak;
import com.metersbonwe.stock.po.sync.define.UdWarehParamDefine;
import com.metersbonwe.stock.po.wms.WmsStockProdQty;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;

@Service public class WmsStockChangesComparServiceImpl implements WmsStockChangesComparService {

    private static StockLog                       stockLog                          = StockLogFactory
                                                                                            .getLogger(WmsStockChangesComparServiceImpl.class);

    private final String                          SERVICE_NAME                      = "WMS库存变化定时对比服务";

    private final String                          STOCK_COMMON_CONFIG_DEFAULT_VALUE = "tmp_stock_wms";

    @Autowired StockCommonConfigMapper            stockCommonConfigMapper;

    @Autowired UdWarehParamDefineMapper           udWarehParamDefineMapper;

    @Autowired TmpStockWmsDefineMapper            tmpStockWmsDefineMapper;

    @Autowired TmpStockWmsBakDefineMapper         tmpStockWmsBakDefineMapper;

    @Autowired WmsStockProdQtyDefineMapper        wmsStockProdQtyDefineMapper;

    @Autowired MqSendService                      mqSendService;

    @Autowired WmsLockedStockService              wmsLockedStockService;

    @Autowired StockWarehProdMapper               stockWarehProdMapper;

    @Autowired MultiTableService                  multiTableService;

    @Autowired private StockWarehProdDefineMapper stockWarehProdDefineMapper;

    @Override
    public void doService() {
        stockLog.info(SERVICE_NAME + "开始运行");
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        try {
            lock.lock();
            //获取核心库获取配置表配置的表名
            String configtableName = getTmpTableNameFromStockCommonConfig();
            stockLog.debug("获取核心库配置配置表里设置的正数锁定临时表是：" + configtableName);

            //获取正数锁定量的另外一个表的临时表
            String otherTableName = getOtherTableName(configtableName);
            stockLog.debug("获取正数锁定量另外一个临时表:" + otherTableName);

            //清空之前取出的临时表
            truncateTable(configtableName);
            stockLog.debug("清空核心库表" + configtableName);

            //获取使用ma的仓库记录
            List<UdWarehParamDefine> useMaWarehs = getUseMaWareh();
            StringBuffer sb = new StringBuffer();
            sb.append("获取使用MA正数锁定量的仓库有:");
            for (UdWarehParamDefine udWarehParamDefine : useMaWarehs) {
                sb.append(udWarehParamDefine.getCode());
                sb.append(",");
            }
            stockLog.debug(sb.toString());

            //获取wms正数锁定量
            List<WmsStockProdQty> wmsStockProdQtys = getWmsStockProdQtys();
            stockLog.debug("获取WMS正数锁定量List,size是" + wmsStockProdQtys.size());
            //插入之前取出的临时表
            saveToTmpTable(configtableName, useMaWarehs, wmsStockProdQtys);
            stockLog.debug("插入临时表");

            //删除另外一张表里不使用usema仓的数据
            deleteWmsNoAttribute(otherTableName, useMaWarehs);
            stockLog.debug("删除表里" + otherTableName + "仓库不是" + sb.toString() + "的数据");

            //比较差异数据
            List<TmpStockWms> diffData = getDiffData();
            stockLog.debug("比较wms正数锁定量差异List,size有:" + diffData.size());

            //推送差异到库存变化队列
            sendQueue(diffData);
            stockLog.debug("推送差异到库存锁定变化队列");

            //清空临时表
            truncateTable(otherTableName);
            stockLog.debug("清空表" + otherTableName);
            //更新配置表的表名记录为另外一个表
            updCommonConfigNewTableName(otherTableName);
            stockLog.debug("更新配置表配置的正数锁定临时表为：" + otherTableName);
        } catch (Exception e) {
            stockLog.error(SERVICE_NAME + "出错", e);
        } finally {
            lock.unlock();
            stockLog.info(SERVICE_NAME + "结束运行");
        }
    }

    /**
     * 获取配置的临时表表名
     * 
     * @return
     */
    private String getTmpTableNameFromStockCommonConfig() {
        return wmsLockedStockService.getTmpTableNameFromStockCommonConfig();
    }

    /**
     * 更新配置表的表名记录
     * 
     * @param tableName
     */
    private void updCommonConfigNewTableName(String tableName) {
        wmsLockedStockService.updCommonConfigNewTableName(tableName);
    }

    /**
     * 获取使用MA的仓库列表信息
     * 
     * @return
     */
    private List<UdWarehParamDefine> getUseMaWareh() {
        List<UdWarehParamDefine> bak = new ArrayList<UdWarehParamDefine>();
        List<UdWarehParamDefine> udWarehParamDefines = udWarehParamDefineMapper.selectAllForB2C();
        for (UdWarehParamDefine udWarehParamDefine : udWarehParamDefines) {
            if ("1".equals(udWarehParamDefine.getUsedMa())) {
                bak.add(udWarehParamDefine);
            }
        }
        return bak;
    }

    /**
     * 清空表
     * 
     * @param tableName
     */
    private void truncateTable(String tableName) {
        wmsLockedStockService.truncateTable(tableName);
    }

    /**
     * 获取WMS正数锁定量
     * 
     * @return
     */
    private List<WmsStockProdQty> getWmsStockProdQtys() {
        Map<String, Object> map = new HashMap<String, Object>();
        return wmsStockProdQtyDefineMapper.selectAll(map);
    }

    /**
     * 保存临时表数据
     * 
     * @param tmptableName
     * @param useMaWarehs
     * @param wmsStockProdQtys
     */
    private void saveToTmpTable(String tmptableName, List<UdWarehParamDefine> useMaWarehs, List<WmsStockProdQty> wmsStockProdQtys) {
        if (STOCK_COMMON_CONFIG_DEFAULT_VALUE.equals(tmptableName)) {
            List<TmpStockWms> tmpRecodes = genTmpStockWmsList(useMaWarehs, wmsStockProdQtys);
            //过滤并获取仓库+sku表里有数据的正数锁定量
            Set<String> existWarhProd = getWmsLocedProdExistInStockWarehProd(useMaWarehs, wmsStockProdQtys);
            stockLog.debug("存在的库存的正数锁定量有" + existWarhProd.size());
            List<TmpStockWms> insertTmpRecodes = filterTmpStockWms(tmpRecodes, existWarhProd);
            if (insertTmpRecodes != null && insertTmpRecodes.size() > 0) {
                //插入保存
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("tmpStockWmsList", insertTmpRecodes);
                tmpStockWmsDefineMapper.insertToTmpStockWms(map);
            }
        } else {
            List<TmpStockWmsBak> tmpRecodes = genTmpStockWmsBakList(useMaWarehs, wmsStockProdQtys);
            //过滤并获取仓库+sku表里有数据的正数锁定量
            Set<String> existWarhProd = getWmsLocedProdExistInStockWarehProd(useMaWarehs, wmsStockProdQtys);
            stockLog.debug("存在的库存的正数锁定量有" + existWarhProd.size());
            List<TmpStockWmsBak> insertTmpRecodes = filterTmpStockWmsbak(tmpRecodes, existWarhProd);
            if (insertTmpRecodes != null && insertTmpRecodes.size() > 0) {
                //插入保存
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("tmpStockWmsList", insertTmpRecodes);
                tmpStockWmsBakDefineMapper.insertToTmpStockWms(map);
            }
        }
    }

    /**
     * 删选有库存的正数锁定量
     * 
     * @param tmpRecodes
     * @param existWarhProd
     * @return
     */
    private List<TmpStockWms> filterTmpStockWms(List<TmpStockWms> tmpRecodes, Set<String> existWarhProd) {
        List<TmpStockWms> insertTmpRecodes = new ArrayList<TmpStockWms>();
        for (TmpStockWms tmpStockWms : tmpRecodes) {
            String key = tmpStockWms.getWarehId() + "_" + tmpStockWms.getProdId();
            if (existWarhProd.contains(key)) {
                insertTmpRecodes.add(tmpStockWms);
            }
        }
        return insertTmpRecodes;
    }

    /**
     * 删选有库存的正数锁定量_bak
     * 
     * @param tmpRecodes
     * @param existWarhProd
     * @return
     */
    private List<TmpStockWmsBak> filterTmpStockWmsbak(List<TmpStockWmsBak> tmpRecodes, Set<String> existWarhProd) {
        List<TmpStockWmsBak> insertTmpRecodes = new ArrayList<TmpStockWmsBak>();
        for (TmpStockWmsBak tmpStockWms : tmpRecodes) {
            String key = tmpStockWms.getWarehId() + "_" + tmpStockWms.getProdId();
            if (existWarhProd.contains(key)) {
                insertTmpRecodes.add(tmpStockWms);
            }
        }
        return insertTmpRecodes;
    }

    /**
     * 生成正向锁定临时表记录1
     * 
     * @param useMaWarehs
     * @param wmsStockProdQtys
     * @return
     */
    private List<TmpStockWms> genTmpStockWmsList(List<UdWarehParamDefine> useMaWarehs, List<WmsStockProdQty> wmsStockProdQtys) {
        List<TmpStockWms> tmpRecodes = new ArrayList<TmpStockWms>();//需要插入的记录
        for (UdWarehParamDefine udWarehParamDefine : useMaWarehs) {
            String warehId = udWarehParamDefine.getCode();
            for (WmsStockProdQty wmsStockProdQty : wmsStockProdQtys) {
                TmpStockWms tmpStockWms = new TmpStockWms();
                tmpStockWms.setWarehId(warehId);
                tmpStockWms.setProdId(wmsStockProdQty.getProdId());
                tmpStockWms.setWmsStock(wmsStockProdQty.getTotalQty().intValue());
                tmpRecodes.add(tmpStockWms);
            }
        }
        return tmpRecodes;
    }

    private Set<String> getWmsLocedProdExistInStockWarehProd(List<UdWarehParamDefine> useMaWarehs, List<WmsStockProdQty> wmsStockProdQtys) {
        List<String> prodList = new ArrayList<String>();
        for (WmsStockProdQty wmsStockProdQty : wmsStockProdQtys) {
            prodList.add(wmsStockProdQty.getProdId());
        }

        Set<String> set = new HashSet<String>();
        for (UdWarehParamDefine udWarehParamDefine : useMaWarehs) {
            String warehId = udWarehParamDefine.getCode();

            StockWarehProdExample stockWarehProdExample = new StockWarehProdExample();
            stockWarehProdExample.setTableNum(multiTableService.getTableSuffixByWarehId(warehId));
            stockWarehProdExample.createCriteria().andWarehIdEqualTo(warehId).andEightProdIdIn(prodList);
            List<StockWarehProd> stockWarehProdList = stockWarehProdMapper.selectByExample(stockWarehProdExample);
            for (StockWarehProd stockWarehProd : stockWarehProdList) {
                String key = stockWarehProd.getWarehId() + "_" + stockWarehProd.getProdId();
                set.add(key);
            }
        }
        return set;
    }

    /**
     * 生成正向锁定临时表bak记录
     * 
     * @param useMaWarehs
     * @param wmsStockProdQtys
     * @return
     */
    private List<TmpStockWmsBak> genTmpStockWmsBakList(List<UdWarehParamDefine> useMaWarehs, List<WmsStockProdQty> wmsStockProdQtys) {
        List<TmpStockWmsBak> tmpRecodes = new ArrayList<TmpStockWmsBak>();//需要插入的记录
        for (UdWarehParamDefine udWarehParamDefine : useMaWarehs) {
            String warehId = udWarehParamDefine.getCode();
            for (WmsStockProdQty wmsStockProdQty : wmsStockProdQtys) {
                TmpStockWmsBak tmpStockWmsBak = new TmpStockWmsBak();
                tmpStockWmsBak.setWarehId(warehId);
                tmpStockWmsBak.setProdId(wmsStockProdQty.getProdId());
                tmpStockWmsBak.setWmsStock(wmsStockProdQty.getTotalQty().intValue());
                tmpRecodes.add(tmpStockWmsBak);
            }
        }
        return tmpRecodes;
    }

    /**
     * 获取差异数据
     * 
     * @return
     */
    private List<TmpStockWms> getDiffData() {
        return tmpStockWmsDefineMapper.selectDiffData();
    }

    /**
     * 发送mq
     * 
     * @param diffData
     */
    private void sendQueue(List<TmpStockWms> diffData) {
        for (TmpStockWms tmpStockWms : diffData) {
            StockWarehProd freeStockWarehProdBean = new StockWarehProd();
            freeStockWarehProdBean.setWarehId(tmpStockWms.getWarehId());
            freeStockWarehProdBean.setProdId(tmpStockWms.getProdId());
            freeStockWarehProdBean.setTableNum(multiTableService.getTableSuffixByWarehId(tmpStockWms.getWarehId()));
            StockWarehProd dameStockWarehProd = stockWarehProdDefineMapper.selectStockWarehProd(freeStockWarehProdBean);
            
            if (dameStockWarehProd != null && dameStockWarehProd.getOnlineSafeStock() != -1) {
                TmpQueueFreeLock tmpQuequeFreeLock = new TmpQueueFreeLock();
                tmpQuequeFreeLock.setWarehId(tmpStockWms.getWarehId());
                tmpQuequeFreeLock.setProdId(tmpStockWms.getProdId());
                mqSendService.sendToChannelWarehProdFreeLock(tmpQuequeFreeLock);
            }
        }

    }

    /**
     * 获取正数锁定量的另外一个表的临时表
     * 
     * @param tableName
     * @return
     */
    private String getOtherTableName(String tableName) {
        return wmsLockedStockService.getOtherTableName(tableName);
    }

    /**
     * 删除表otherTableName不启用MA仓库的数据
     * 
     * @param tableName
     * @param useMaWarehs
     */
    private void deleteWmsNoAttribute(String tableName, List<UdWarehParamDefine> useMaWarehs) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tableName", tableName);
        map.put("warehlist", useMaWarehs);
        tmpStockWmsDefineMapper.deleteWmsNoAttribute(map);
    }
}
