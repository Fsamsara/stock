package com.metersbonwe.stock.biz.schedule.service.impl;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.localcache.CacheManager;
import com.metersbonwe.stock.biz.common.localcache.CacheName;
import com.metersbonwe.stock.biz.common.localcache.LocalCache;
import com.metersbonwe.stock.biz.common.service.ChangeFinalFreeShareStockService;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.biz.schedule.service.ChangeQtyHandleSerivce;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelProdDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockShopDameDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockShopDameTranDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockShopRemailDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockShopRemailTranDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockWarehProdDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.ChangeQtyMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockShopDame;
import com.metersbonwe.stock.po.core.StockShopRemail;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.po.core.TmpQueueChannelgroupReserved;
import com.metersbonwe.stock.po.core.TmpQueueFreeLock;
import com.metersbonwe.stock.po.core.TmpQueueReserved;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.pojo.ChangeQtyGlobalBean;
import com.metersbonwe.stock.pojo.ChangeQtyInfoBean;
import com.metersbonwe.stock.utils.CollectionUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

/**
 * @author TanYibin
 */

@Service("changeQtyHandleSerivce") public class ChangeQtyHandleSerivceImpl implements ChangeQtyHandleSerivce {

    private static StockLog                            stockLog = StockLogFactory.getLogger(ChangeQtyHandleSerivceImpl.class);

    @Autowired private ChangeQtyMapper                 changeQtyMapper;

    @Autowired private StockShopDameDefineMapper       stockShopDameDefineMapper;
    
    @Autowired private StockShopDameTranDefineMapper   stockShopDameTranDefineMapper;
    
    @Autowired private StockShopRemailDefineMapper     stockShopRemailDefineMapper;
    
    @Autowired private StockShopRemailTranDefineMapper stockShopRemailTranDefineMapper;

    @Autowired private StockChannelProdDefineMapper    stockChannelProdDefineMapper;
    
    @Autowired private StockWarehProdDefineMapper      stockWarehProdDefineMapper;

    @Resource private ChangeFinalFreeShareStockService ChangeFinalFreeShareStockService;

    @Resource private MultiTableService                multiTableService;

    @Resource private MqSendService                    mqSendService;

    @Resource private CacheManager                     cacheManagerImpl;


    @Override
    public List<ChangeQtyInfoBean> selectChangeQtyInfos(ChangeQtyGlobalBean changeQtyGlobalBean) throws Exception {

        List<ChangeQtyInfoBean> changeQtyInfos = null;
        // 变化类型：自由量 = 1，锁定量 = 2，预留量 = 3，第三方自由量 = 4(自由量MQ)，门店未日结量 = 5((自由量MQ))，门店污损值 = 6(自由量MQ)，门店安全库存 = 7(自由量MQ)，活动期间渠道商品推送独占量 = 8
        switch (changeQtyGlobalBean.getChangeType()) {
        case Constants.STOCK_CHANGE_TYPE_FREE_QTY:
            changeQtyInfos = changeQtyMapper.selectTmpFreeQtyInfo(changeQtyGlobalBean);
            break;
        case Constants.STOCK_CHANGE_TYPE_LOCKED_QTY:
            changeQtyInfos = changeQtyMapper.selectTmpLockedQtyInfo(changeQtyGlobalBean);
            break;
        case Constants.STOCK_CHANGE_TYPE_RESERVED_QTY:
            changeQtyInfos = changeQtyMapper.selectTmpReservedQtyInfo(changeQtyGlobalBean);
            break;
        case Constants.STOCK_CHANGE_TYPE_TP_FREE_QTY:
            changeQtyInfos = changeQtyMapper.selectTmpTpQtyInfo(changeQtyGlobalBean);
            break;
        case Constants.STOCK_CHANGE_TYPE_REMAIL_QTY:
            changeQtyInfos = changeQtyMapper.selectTmpRemailQtyInfo(changeQtyGlobalBean);
            break;
        case Constants.STOCK_CHANGE_TYPE_DAME_QTY:
            changeQtyInfos = changeQtyMapper.selectTmpDameQtyInfo(changeQtyGlobalBean);
            break;
        case Constants.STOCK_CHANGE_TYPE_CHANNEL_PORD:
            changeQtyInfos = changeQtyMapper.selectTmpChannelPordInfo(changeQtyGlobalBean);
            break;
        default:
            break;
        }
        
        return changeQtyInfos;
    }

    @Override
    public Integer updateChangeQtyInfo(ChangeQtyInfoBean changeQtyInfoBean, Integer changeType) throws Exception {

        int changeCount = 0;

        StockWarehProd stockWarehProd = new StockWarehProd();
        stockWarehProd.setWarehId(changeQtyInfoBean.getWarehCode());
        stockWarehProd.setProdId(changeQtyInfoBean.getProdCode());

        // 变化类型：自由量 = 1，锁定量 = 2，预留量 = 3，第三方自由量 = 4(自由量MQ)，门店未日结量 = 5(自由量MQ)，门店污损值 = 6(自由量MQ)，门店安全库存 = 7(自由量MQ)，活动期间渠道商品推送独占量 = 8
        switch (changeType) {
        case Constants.STOCK_CHANGE_TYPE_FREE_QTY:
            stockWarehProd.setFreeShareStock(changeQtyInfoBean.getFreeStock());
            stockWarehProd.setStkOnHand(changeQtyInfoBean.getStkOnHand());
            stockWarehProd.setQtyCommitted(changeQtyInfoBean.getQtyCommitted());
            changeCount = ChangeFinalFreeShareStockService.updateStockWarehProd(stockWarehProd);
            break;
        case Constants.STOCK_CHANGE_TYPE_LOCKED_QTY:
            stockWarehProd.setLockStock(changeQtyInfoBean.getLockedStock());
            changeCount = ChangeFinalFreeShareStockService.updateStockWarehProd(stockWarehProd);
            break;
        case Constants.STOCK_CHANGE_TYPE_RESERVED_QTY:
            changeCount = 1;
            break;
        case Constants.STOCK_CHANGE_TYPE_TP_FREE_QTY:
            stockWarehProd.setFreeShareStock(changeQtyInfoBean.getFreeStock());
            changeCount = ChangeFinalFreeShareStockService.updateStockWarehProd(stockWarehProd);
            break;
        case Constants.STOCK_CHANGE_TYPE_REMAIL_QTY:
            
            StockShopRemail stockShopRemail = new StockShopRemail();
            stockShopRemail.setWarehId(changeQtyInfoBean.getWarehCode());
            stockShopRemail.setProdId(changeQtyInfoBean.getProdCode());
            stockShopRemail.setLocId(changeQtyInfoBean.getLocId());
            stockShopRemail.setRemailStock(changeQtyInfoBean.getRemailStock());
            stockShopRemail.setRllNum(changeQtyInfoBean.getRllNum());
            stockShopRemail.setUpdateTime(changeQtyInfoBean.getUpdateTime());
            changeCount = stockShopRemailDefineMapper.insertShopRemail(stockShopRemail);
            if (changeCount > 0) {
                stockShopRemailTranDefineMapper.insertData(stockShopRemail);//更新日志信息
                stockWarehProd.setShopRemail(this.getRemailStock(changeQtyInfoBean.getWarehCode(),changeQtyInfoBean.getProdCode()));
                changeCount = ChangeFinalFreeShareStockService.updateStockWarehProd(stockWarehProd);
            }
            break;
        case Constants.STOCK_CHANGE_TYPE_DAME_QTY:
            StockShopDame damePo = new StockShopDame();
            damePo.setWarehId(changeQtyInfoBean.getWarehCode());
            damePo.setProdId(changeQtyInfoBean.getProdCode());
            damePo.setDameStock(changeQtyInfoBean.getDameStock());
            damePo.setUpdateTime(changeQtyInfoBean.getUpdateTime());
            damePo.setUpdateBy(changeQtyInfoBean.getUpdateBy());
            damePo.setCreateTime(changeQtyInfoBean.getCreateTime());
            damePo.setCreateBy(changeQtyInfoBean.getCreateBy());
            changeCount = stockShopDameDefineMapper.updateDameStock(damePo);
            if (changeCount == 0) {
                changeCount = stockShopDameDefineMapper.insertDameStock(damePo);
            }
            if (changeCount > 0) {
                stockShopDameTranDefineMapper.insertData(damePo);
                stockWarehProd.setShopDame(changeQtyInfoBean.getDameStock());
                changeCount = ChangeFinalFreeShareStockService.updateStockWarehProd(stockWarehProd);
            }
            break;
        case Constants.STOCK_CHANGE_TYPE_CHANNEL_PORD:

            break;
        default:
            break;
        }

        if (changeCount <= 0) {
            stockLog.error("更新MySql核心库临时表数据失败，ChangeType:" + changeType + " ChangeQtyInfoBean:" + JSON.toJSONString(changeQtyInfoBean));
        }

        return changeCount;
    }

    @Override
    public void sendChangeQtyInfoToMQ(ChangeQtyInfoBean changeQtyInfoBean, Integer changeType) throws Exception {
        // 变化类型：自由量 = 1，锁定量 = 2，预留量 = 3，第三方自由量 = 4，门店未日结量 = 5，门店污损值 = 6，门店安全库存 = 7，活动期间渠道商品推送独占量 = 8
        TmpQueueFreeLock tmpQueueFreeLock = null;
        TmpQueueReserved tmpQueueReserved = null;
        TmpQueueChannelgroupReserved tmpQueueChannelGroupReserved = null;
        
        switch (changeType) {
        case Constants.STOCK_CHANGE_TYPE_FREE_QTY:
            // 写入渠道MQ（CHANNEL_WAREH_PROD_FREE_LOCK队列）
            if (changeQtyInfoBean.getFreeChangedCount() > 0) {
                
                StockWarehProd freeStockWarehProdBean = new StockWarehProd();
                freeStockWarehProdBean.setWarehId(changeQtyInfoBean.getWarehCode());
                freeStockWarehProdBean.setProdId(changeQtyInfoBean.getProdCode());
                freeStockWarehProdBean.setTableNum(multiTableService.getTableSuffixByWarehId(changeQtyInfoBean.getWarehId()));
                
                StockWarehProd freeStockWarehProd  = stockWarehProdDefineMapper.selectStockWarehProd(freeStockWarehProdBean);
                
                if(freeStockWarehProd != null && freeStockWarehProd.getOnlineSafeStock() != -1) {
                    tmpQueueFreeLock = new TmpQueueFreeLock();
                    tmpQueueFreeLock.setWarehId(changeQtyInfoBean.getWarehCode());
                    tmpQueueFreeLock.setProdId(changeQtyInfoBean.getProdCode());
                    mqSendService.sendToChannelWarehProdFreeLock(tmpQueueFreeLock);
                }
            }
            break;
        case Constants.STOCK_CHANGE_TYPE_LOCKED_QTY:
            // 写入渠道MQ（CHANNEL_WAREH_PROD_LOCKED队列）
            StockWarehProd lockedStockWarehProdBean = new StockWarehProd();
            lockedStockWarehProdBean.setWarehId(changeQtyInfoBean.getWarehCode());
            lockedStockWarehProdBean.setProdId(changeQtyInfoBean.getProdCode());
            lockedStockWarehProdBean.setTableNum(multiTableService.getTableSuffixByWarehId(changeQtyInfoBean.getWarehId()));
            
            StockWarehProd lockedStockWarehProd  = stockWarehProdDefineMapper.selectStockWarehProd(lockedStockWarehProdBean);
            
            if(lockedStockWarehProd != null && lockedStockWarehProd.getOnlineSafeStock() != -1) {
                tmpQueueFreeLock = new TmpQueueFreeLock();
                tmpQueueFreeLock.setWarehId(changeQtyInfoBean.getWarehCode());
                tmpQueueFreeLock.setProdId(changeQtyInfoBean.getProdCode());
                mqSendService.sendToChannelWarehProdFreeLock(tmpQueueFreeLock);
            }
            break;
        case Constants.STOCK_CHANGE_TYPE_RESERVED_QTY:
            // 写入渠道MQ（CHANNEL_WAREH_PROD_RESERVED队列）
            
            LocalCache<String, String> shopGroupCache = this.cacheManagerImpl.getCache(CacheName.SHOPGROUP.getCacheName());
            
            LocalCache<String, List<String>> channelCache = this.cacheManagerImpl.getCache(CacheName.CHANNEL.getCacheName());
            
            stockLog.debug("ChannelCode:" + changeQtyInfoBean.getChannelCode() + " shopGroupCache:" + JSON.toJSONString(shopGroupCache));
            stockLog.debug("ChannelCode:" + changeQtyInfoBean.getChannelCode() + " channelCache:" + JSON.toJSONString(channelCache.getSingle()));
            
            if (shopGroupCache != null && shopGroupCache.containsValue(changeQtyInfoBean.getChannelCode())) {
                //发送店群MQ
                stockLog.debug("发送店群MQ，ChannelCode:" + changeQtyInfoBean.getChannelCode());
                tmpQueueChannelGroupReserved = new TmpQueueChannelgroupReserved();
                tmpQueueChannelGroupReserved.setChannelGroupId(changeQtyInfoBean.getChannelCode());
                tmpQueueChannelGroupReserved.setProdId(changeQtyInfoBean.getProdCode());
                mqSendService.sendToChannelGroupReserved(tmpQueueChannelGroupReserved);
            }
            
            if (channelCache != null && channelCache.getSingle().contains(changeQtyInfoBean.getChannelCode())) {
                //发送渠道MQ
                stockLog.debug("发送渠道MQ，ChannelCode:" + changeQtyInfoBean.getChannelCode());
                tmpQueueReserved = new TmpQueueReserved();
                tmpQueueReserved.setChannelCode(changeQtyInfoBean.getChannelCode());
                tmpQueueReserved.setProdId(changeQtyInfoBean.getProdCode());
                mqSendService.sendToChannelWarehProdReserved(tmpQueueReserved);
            }
            break;
        case Constants.STOCK_CHANGE_TYPE_TP_FREE_QTY:
            // 写入渠道MQ（CHANNEL_WAREH_PROD_FREE_LOCK队列）
            StockWarehProd tpFreeStockWarehProdBean = new StockWarehProd();
            tpFreeStockWarehProdBean.setWarehId(changeQtyInfoBean.getWarehCode());
            tpFreeStockWarehProdBean.setProdId(changeQtyInfoBean.getProdCode());
            tpFreeStockWarehProdBean.setTableNum(multiTableService.getTableSuffixByWarehId(changeQtyInfoBean.getWarehId()));
            
            StockWarehProd tpFreeStockWarehProd  = stockWarehProdDefineMapper.selectStockWarehProd(tpFreeStockWarehProdBean);
            
            if(tpFreeStockWarehProd != null && tpFreeStockWarehProd.getOnlineSafeStock() != -1) {
                tmpQueueFreeLock = new TmpQueueFreeLock();
                tmpQueueFreeLock.setWarehId(changeQtyInfoBean.getWarehCode());
                tmpQueueFreeLock.setProdId(changeQtyInfoBean.getProdCode());
                mqSendService.sendToChannelWarehProdFreeLock(tmpQueueFreeLock);
            }
            break;
        case Constants.STOCK_CHANGE_TYPE_REMAIL_QTY:
            // 写入渠道MQ（CHANNEL_WAREH_PROD_FREE_LOCK队列）
            StockWarehProd remailStockWarehProdBean = new StockWarehProd();
            remailStockWarehProdBean.setWarehId(changeQtyInfoBean.getWarehCode());
            remailStockWarehProdBean.setProdId(changeQtyInfoBean.getProdCode());
            remailStockWarehProdBean.setTableNum(multiTableService.getTableSuffixByWarehId(changeQtyInfoBean.getWarehId()));
            
            StockWarehProd remailStockWarehProd  = stockWarehProdDefineMapper.selectStockWarehProd(remailStockWarehProdBean);
            
            if(remailStockWarehProd != null && remailStockWarehProd.getOnlineSafeStock() != -1) {
                tmpQueueFreeLock = new TmpQueueFreeLock();
                tmpQueueFreeLock.setWarehId(changeQtyInfoBean.getWarehCode());
                tmpQueueFreeLock.setProdId(changeQtyInfoBean.getProdCode());
                mqSendService.sendToChannelWarehProdFreeLock(tmpQueueFreeLock);
            }
            break;
        case Constants.STOCK_CHANGE_TYPE_DAME_QTY:
            // 写入渠道MQ（CHANNEL_WAREH_PROD_FREE_LOCK队列）
            StockWarehProd dameStockWarehProdBean = new StockWarehProd();
            dameStockWarehProdBean.setWarehId(changeQtyInfoBean.getWarehCode());
            dameStockWarehProdBean.setProdId(changeQtyInfoBean.getProdCode());
            dameStockWarehProdBean.setTableNum(multiTableService.getTableSuffixByWarehId(changeQtyInfoBean.getWarehId()));
            
            StockWarehProd dameStockWarehProd  = stockWarehProdDefineMapper.selectStockWarehProd(dameStockWarehProdBean);
            
            if(dameStockWarehProd != null && dameStockWarehProd.getOnlineSafeStock() != -1) {
                tmpQueueFreeLock = new TmpQueueFreeLock();
                tmpQueueFreeLock.setWarehId(changeQtyInfoBean.getWarehCode());
                tmpQueueFreeLock.setProdId(changeQtyInfoBean.getProdCode());
                mqSendService.sendToChannelWarehProdFreeLock(tmpQueueFreeLock);
            }
            break;
        case Constants.STOCK_CHANGE_TYPE_CHANNEL_PORD:
            ChannelProdBean channelProdBean = new ChannelProdBean();
            channelProdBean.setChannelCode(changeQtyInfoBean.getWarehId());
            channelProdBean.setProdId(changeQtyInfoBean.getProdId());
            channelProdBean = stockChannelProdDefineMapper.selectForChannelAndProd(channelProdBean);
            // 写入线上MQ（ONLINE_WAREH_SYNC_CONFIG队列）
            mqSendService.sendToOnLineChannelStock(channelProdBean, channelProdBean.getChannelCode());
            break;
        default:
            break;
        }
    }

    @Override
    public void deleteChangeQtyInfo(ChangeQtyInfoBean changeQtyInfoBean, Integer changeType) throws Exception {

        int changeCount = 0;

        // 变化类型：自由量 = 1，锁定量 = 2，预留量 = 3，第三方自由量 = 4，门店未日结量 = 5，门店污损值 = 6，门店安全库存 = 7，活动期间渠道商品推送独占量 = 8
        switch (changeType) {
        case Constants.STOCK_CHANGE_TYPE_FREE_QTY:
            //删除Oracle同步库临时表 自由量 变化信息
            changeCount = changeQtyMapper.deleteTmpFreeQtyInfo(changeQtyInfoBean);
            break;
        case Constants.STOCK_CHANGE_TYPE_LOCKED_QTY:
            //删除Oracle同步库临时表 锁定量 变化信息
            changeCount = changeQtyMapper.deleteTmpLockedQtyInfo(changeQtyInfoBean);
            break;
        case Constants.STOCK_CHANGE_TYPE_RESERVED_QTY:
            //删除Oracle同步库临时表 预留量 变化信息
            changeCount = changeQtyMapper.deleteTmpReservedQtyInfo(changeQtyInfoBean);
            break;
        case Constants.STOCK_CHANGE_TYPE_TP_FREE_QTY:
            //删除Oracle同步库临时表 第三方自由量 变化信息
            changeCount = changeQtyMapper.deleteTmpTpQtyInfo(changeQtyInfoBean);
            break;
        case Constants.STOCK_CHANGE_TYPE_REMAIL_QTY:
            //删除Oracle同步库临时表 门店未日结 变化信息
            changeCount = changeQtyMapper.deleteTmpRemailQtyInfo(changeQtyInfoBean);
            break;
        case Constants.STOCK_CHANGE_TYPE_DAME_QTY:
            //删除Oracle同步库临时表 门店无损值 变化信息
            changeCount = changeQtyMapper.deleteTmpDameQtyInfo(changeQtyInfoBean);
            break;
        case Constants.STOCK_CHANGE_TYPE_CHANNEL_PORD:
            //删除Oracle同步库临时表 活动期间渠道商品推送独占量 变化信息
            changeCount = changeQtyMapper.deleteTmpChannelPordInfo(changeQtyInfoBean);
            break;
        default:
            break;
        }
        
        if (changeCount < 0) {
            stockLog.error("删除Oracle同步库临时表 数据失败，ChangeType:" + changeType + " ChangeQtyInfoBean:" + JSON.toJSONString(changeQtyInfoBean));
        }
    }
    
    /**
     * 门店未日结
     * 
     * @param warehId 仓库
     * @param prodId 11位码
     * @return
     */
    private int getRemailStock(String warehId, String prodId) {
        List<Map<String, Object>> item = stockShopRemailDefineMapper.selectShopRemail(warehId, prodId);
        if (CollectionUtil.isEmpty(item)) {
            return 0;
        }
        try {
            return Integer.parseInt(item.get(0).get("remailStock").toString());
        } catch (Exception e) {
            stockLog.error("获取门店未日结数量时出错warehId:" + warehId + ",prodId:" + prodId + ",remailStock:" + item.get(0).get("remailStock"), e);
        }
        return 0;
    }

}
