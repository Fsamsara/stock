package com.metersbonwe.stock.biz.queue.service.impl;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.biz.common.service.CacheService;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelProdMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelProdSubMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockWpSafeMapper;
import com.metersbonwe.stock.dal.define.core.mapper.FreeLockChangeCoreMapper;
import com.metersbonwe.stock.dal.define.core.mapper.UsefulWarehChangeCoreMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.UsefulWarehChangeSyncMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.*;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.po.sync.define.ChannelReservedBean;
import com.metersbonwe.stock.utils.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/4/27
 */
@Service
public class FreeLockReservedBaseService {
    private static StockLog logger = StockLogFactory.getLogger(FreeLockChangeServiceImpl.class);

    @Resource StockChannelProdMapper stockChannelProdMapper;

    @Resource StockChannelProdSubMapper stockChannelProdSubMapper;

    @Resource CacheService cacheServiceImpl;

    @Resource UsefulWarehChangeSyncMapper usefulWarehChangeSyncMapper;

    @Resource StockWpSafeMapper stockWpSafeMapper;

    @Resource MultiTableService multiTableService;

    @Resource FreeLockChangeCoreMapper freeLockChangeCoreMapper;

    @Resource MqSendService mqSendServiceImpl;

    @Resource UsefulWarehChangeCoreMapper usefulWarehChangeCoreMapper;

    @Resource AllocationRangeService allocationRangeService;

    /**
     *  @description 更新渠道表
     *  @param stockChannelProd 渠道表对象
     *  @return 被更新记录条数
     */
    protected int updateChannelProd(StockChannelProd stockChannelProd) {
        stockChannelProd.setUpdateTime(new Date());
        stockChannelProd.setTableSuffix(stockChannelProd.getChannelCode().toLowerCase());
        StockChannelProdExample stockChannelProdExample = new StockChannelProdExample();
        stockChannelProdExample.createCriteria().andProdIdEqualTo(stockChannelProd.getProdId());
        return stockChannelProdMapper.updateByExampleSelective(stockChannelProd, stockChannelProdExample);
    }

    /**
     *  @description 插入渠道表
     *  @param stockChannelProd 渠道表对象
     *  @return int 插入记录条数
     */
    protected int insertToStockChannelProd(StockChannelProd stockChannelProd) {
        stockChannelProd.setUpdateTime(new Date());
        stockChannelProd.setTableSuffix(stockChannelProd.getChannelCode().toLowerCase());
        return stockChannelProdMapper.insertSelective(stockChannelProd);
    }

    /**
     *  @description 插入渠道明细表
     *  @param channelCode 渠道Id
     *  @param prodId 产品Id
     *  @return int 插入记录条数
     */
    protected int insertToStockChannelProdSub(String channelCode, String prodId) {
        StockChannelProdSub stockChannelProdSub = new StockChannelProdSub();
        stockChannelProdSub.setProdId(prodId);
        stockChannelProdSub.setChannelCode(channelCode);
        stockChannelProdSub.setSixProdId(prodId.substring(0, 6));
        stockChannelProdSub.setEightProdId(prodId.substring(0, 8));
        stockChannelProdSub.setUpdateTime(new Date());
        stockChannelProdSub.setTableSuffix(channelCode.toLowerCase());
        return stockChannelProdSubMapper.insert(stockChannelProdSub);
    }

    /**
     * @description 计算自由量，锁定量
     * @param prodId 商品11位码
     * @param usefulWarehList 渠道最终可用仓
     */
    protected Map<String, BigDecimal> calFreeLockData(List<String> usefulWarehList , String prodId) {
        Map<String, BigDecimal> resMap = new HashMap<>();
        resMap.put(Constants.ParamMapKey.FREE_STOCK, BigDecimal.valueOf(0));
        resMap.put(Constants.ParamMapKey.LOCK_STOCK, BigDecimal.valueOf(0));
        if(usefulWarehList.size() == 0){
            return resMap;
        }
        Date sDate = new Date();
        String tempTableSql = createSqlString(usefulWarehList, prodId);
        Date eDate = new Date();
        logger.debug("拼sql耗时" + CommonUtil.timeInterval(sDate, eDate));
        //logger.debug("计算自由量，锁定量拼写成的SQL： " + tempTableSql);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("tempTable", tempTableSql);
        resMap = freeLockChangeCoreMapper.getFreeLockData(paramMap);
        if(resMap == null) {
            resMap = new HashMap<>();
            resMap.put(Constants.ParamMapKey.FREE_STOCK, BigDecimal.valueOf(0));
            resMap.put(Constants.ParamMapKey.LOCK_STOCK, BigDecimal.valueOf(0));
        }
        return resMap;
    }

    /**
     * @description 计算预留量,店群预留量
     * @param channelCode 渠道编码
     * @param prodId 产品ID
     * @return 预留量
     */
    public int calReservedData(String channelCode, List<String> usefulWareh, String prodId) {
        int reservedQty = 0;
        if(usefulWareh == null || usefulWareh.size() == 0){
            return reservedQty;
        }
        Map<String, Object> paramMap = new HashMap<>();
        List<String> channelCodeList = new ArrayList<>();
        channelCodeList.add(channelCode);
        paramMap.put(Constants.ParamMapKey.CHANNEL_CODE_LIST, channelCodeList);
        paramMap.put(Constants.ParamMapKey.USEFUL_WAREH_LIST, usefulWareh);
        paramMap.put(Constants.ParamMapKey.PROD_ID, prodId);
        List<ChannelReservedBean> channelReservedBeanList = usefulWarehChangeSyncMapper.getChannelReservedData(paramMap);
        List<String> haveWpSafeValueWarehList = getHaveWpSafeValueWarehIdByProdId(prodId);
        for (ChannelReservedBean channelReservedBean : channelReservedBeanList) {
            String warhId = channelReservedBean.getWarehId();
            String safeType = channelReservedBean.getSafeType();
            if ("NO".equalsIgnoreCase(safeType) || "WS".equalsIgnoreCase(safeType)) {
                reservedQty = reservedQty + channelReservedBean.getReservedStock();
            } else {
                //WP类型无安全库存的则不计算预留量
                if (haveWpSafeValueWarehList != null && haveWpSafeValueWarehList.contains(warhId)) {
                    reservedQty = reservedQty + channelReservedBean.getReservedStock();
                }
            }
        }
        return reservedQty;
    }

    /**
     * @description 获取prod_id在哪几个wp类型的仓有安全库存
     * @param prodId
     *            商品11位码
     * @return 仓List
     */
    private List<String> getHaveWpSafeValueWarehIdByProdId(String prodId) {
        StockWpSafeExample stockWpSafeExample = new StockWpSafeExample();
        stockWpSafeExample.createCriteria().andProdIdEqualTo(prodId);
        List<String> haveReservedWarehList = new ArrayList<>();
        List<StockWpSafe> stockWpSafeList = stockWpSafeMapper.selectByExample(stockWpSafeExample);
        for (StockWpSafe stockWpSafe : stockWpSafeList) {
            haveReservedWarehList.add(stockWpSafe.getWarehId());
        }
        return haveReservedWarehList;
    }

    /**
     * @description 根据最终可用仓、sku，拼写查询仓+sku表的相关sql
     * @param usefulWarehList
     *            渠道最终可用仓集合
     * @param prodId
     *            商品11位码
     * @return sql字符串
     */
    protected String createSqlString(List<String> usefulWarehList, String prodId) {
        // 开通了 b2b 的仓
        List<String> b2bWarehlist = cacheServiceImpl.getB2BWarehFromCache();
        List<String> noB2BWareh = new ArrayList<>(usefulWarehList);
        noB2BWareh.removeAll(b2bWarehlist);
        List<String> b2bWareh = new ArrayList<>(usefulWarehList);
        b2bWareh.retainAll(b2bWarehlist);
        StringBuilder stringBuilder = new StringBuilder();
        if(b2bWareh.size() > 0)
            for (int i = 0; i <= multiTableService.getMaxTableSeq(); i++) {
                stringBuilder.append(" select prod_id,final_free_share_stock finalFreeShareStock, t.lock_stock from ");
                stringBuilder.append("stock_wareh_prod_").append(multiTableService.getMappingSuffix(i)).append(" t ");
                stringBuilder.append(" where t.prod_id = '").append(prodId).append("' ").append(" and online_safe_stock !=-1").append(
                        " and t.wareh_id in (");
                for (String wareh : b2bWareh) {
                    stringBuilder.append("'").append(wareh).append("',");
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1).append(")");
                if (i != multiTableService.getMaxTableSeq()) {
                    stringBuilder.append(" union all ");
                }
            }
        if (noB2BWareh.size() > 0) {
            if(b2bWareh.size() > 0) stringBuilder.append(" union all ");
            for (int i = 0; i <= multiTableService.getMaxTableSeq(); i++) {
                stringBuilder.append(" select prod_id,final_free_share_stock finalFreeShareStock, 0 lock_stock from ");
                stringBuilder.append("stock_wareh_prod_").append(multiTableService.getMappingSuffix(i)).append(" t ");
                stringBuilder.append(" where t.prod_id = '").append(prodId).append("' ").append(" and online_safe_stock !=-1").append(" and t.wareh_id in (");
                for (String wareh : noB2BWareh) {
                    stringBuilder.append("'").append(wareh).append("',");
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1).append(")");
                if (i != multiTableService.getMaxTableSeq()) {
                    stringBuilder.append(" union all ");
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * @description 发送mq信息到线上队列
     * @param changeData
     *            改变的数据
     */
    protected void sendToMq(List<ChannelProdBean> changeData) {
        for (ChannelProdBean channelProdBean : changeData) {
            mqSendServiceImpl.sendToOnLineChannelStock(channelProdBean, channelProdBean.getChannelCode());
        }
    }

    /**
     * @description 获取变化的sku
     * @param channelCode
     *            预留量变化的渠道
     * @param prodId
     *            预留量变化的sku
     * @return 变化的sku集合
     */
    protected List<ChannelProdBean> getChangeData(String channelCode, String prodId) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("tableName", Constants.STOCK_CHANNEL_PROD_PREFIX + channelCode.toLowerCase());
        paramsMap.put("subTableName", Constants.STOCK_CHANNEL_PROD_SUB_PREFIX + channelCode.toLowerCase());
        paramsMap.put("prodId", prodId);
        return usefulWarehChangeCoreMapper.getNeedSendData(paramsMap);
    }

    protected StockChannelProd createUpdateBean(String channelCode, String prodId){
        StockChannelProd stockChannelProd = new StockChannelProd();
        stockChannelProd.setProdId(prodId);
        stockChannelProd.setChannelCode(channelCode);
        return stockChannelProd;
    }

    /**
     * 通过仓库Id获取仓库影响的渠道
     * @param warehId 仓库ID
     * @return 仓库影响的渠道
     */
    protected List<String> getChannelListByWarehId(String warehId) {
        List<String> resChannelCodeList = new ArrayList<>();
        List<String> channelCodeList = cacheServiceImpl.getAllUsefulChannelForCache();
        for(String channelCode : channelCodeList) {
            List<String> usefulWarehList = cacheServiceImpl.getChannelUsefulWarehFromCache(channelCode);
            for(String warehCode : usefulWarehList) {
                if (warehId.equalsIgnoreCase(warehCode)) {
                    resChannelCodeList.add(channelCode);
                    break;
                }
            }
        }
        return resChannelCodeList.size() > 0 ? resChannelCodeList : allocationRangeService.getOnlineAllotScopeByWarehId(warehId);
    }
}
