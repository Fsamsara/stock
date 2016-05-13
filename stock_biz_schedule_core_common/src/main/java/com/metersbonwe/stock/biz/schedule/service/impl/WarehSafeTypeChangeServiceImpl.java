package com.metersbonwe.stock.biz.schedule.service.impl;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.*;
import com.metersbonwe.stock.dal.auto.core.mapper.StockWarehProdMapper;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpChannelScopeMapper;
import com.metersbonwe.stock.dal.define.core.mapper.WarehSafeTypeChangeCoreMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.WarehSafeTypeChangeSyncMapper;
import com.metersbonwe.stock.facade.schedule.WarehSafeTypeChangeService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.po.core.TmpQueueFreeLock;
import com.metersbonwe.stock.po.sync.TmpChannelScope;
import com.metersbonwe.stock.po.sync.TmpSafeTypeStock;
import com.metersbonwe.stock.utils.CommonUtil;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/3/26
 */
@Service public class WarehSafeTypeChangeServiceImpl implements WarehSafeTypeChangeService {

    private static StockLog logger = StockLogFactory.getLogger(WarehSafeTypeChangeServiceImpl.class);

    @Resource TmpTableService tmpTableService;

    @Resource MqSendService mqSendService;

    @Resource MultiTableService multiTableService;

    @Resource ChangeFinalFreeShareStockService changeFinalFreeShareStockService;

    @Resource WarehSafeTypeChangeCoreMapper warehSafeTypeChangeCoreMapper;

    @Resource WarehSafeTypeChangeSyncMapper warehSafeTypeChangeSyncMapper;

    @Resource StockWarehProdMapper stockWarehProdMapper;

    @Resource TmpChannelScopeMapper tmpChannelScopeMapper;

    @Resource AllocationRangeService allocationRangeService;

    @Override public void processTmpSafeTypeStockData() {
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        try {
            lock.lock();
            process();
        } catch (Exception e) {
            logger.error("定时任务拉取tmp_safe_type_stock数据并处理出错：" + e.getMessage(), e);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 实际处理方法
     */
    private void process() throws Exception {
        List<TmpSafeTypeStock> tmpSafeTypeStockList = getTmpData();
        if (tmpSafeTypeStockList.size() == 0) {
            logger.debug("仓库安全库存类型变化临时表无数据");
            return;
        }
        updateWarehProd(tmpSafeTypeStockList);
        long maxId = getMaxId(tmpSafeTypeStockList);
        tmpTableService.delSyncTmpData(Constants.TmpDataTable.TMP_SAFE_TYPE_STOCK, maxId);
    }

    /**
     * @description 获取变化仓的所有数据
     * @param wareId 仓ID
     * @return javaBean集合
     */
    private List<TmpQueueFreeLock> getChangeData(String wareId, String tableName) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(Constants.ParamMapKey.WAREH_ID, wareId);
        paramMap.put(Constants.ParamMapKey.TABLE_NAME, tableName);
        return warehSafeTypeChangeCoreMapper.selectSafeTypeChangedData(paramMap);
    }

    private void sendToMq(List<TmpQueueFreeLock> tmpQueueFreeLockList) {
        for (TmpQueueFreeLock tmpQueueFreeLock : tmpQueueFreeLockList) {
            mqSendService.sendToChannelWarehProdFreeLock(tmpQueueFreeLock);
        }
    }

    /**
     * @description 获取安全库存值
     * @param tmpSafeTypeStockList 临时表数据
     */
    private void updateWarehProd(List<TmpSafeTypeStock> tmpSafeTypeStockList) throws Exception {
        for (TmpSafeTypeStock tmpSafeTypeStock : tmpSafeTypeStockList) {
            String safeType = tmpSafeTypeStock.getSafeType();
            String warehId = tmpSafeTypeStock.getWarehId();
            String warehTableName = multiTableService.getTableNameByWarehId(warehId);
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put(Constants.ParamMapKey.WAREH_ID, warehId);
            paramMap.put(Constants.ParamMapKey.TABLE_NAME, warehTableName);
            if (Constants.WP_SAFETY_STOCK_TYPE.equalsIgnoreCase(safeType)) {
                warehSafeTypeChangeCoreMapper.updateWPWarehProdOnlineSafeStock(paramMap);
            } else if (Constants.WS_SAFETY_STOCK_TYPE.equalsIgnoreCase(safeType)) {
                paramMap.put("safeValue", getWSSafeValue(warehId));
                warehSafeTypeChangeCoreMapper.updateWSOrNOWarehProdOnlineSafeStock(paramMap);
            } else {
                paramMap.put("safeValue", 0);
                warehSafeTypeChangeCoreMapper.updateWSOrNOWarehProdOnlineSafeStock(paramMap);
            }
            //重新计算最终自由量（一斌那边的方法）
            StockWarehProd stockWarehProd = new StockWarehProd();
            stockWarehProd.setWarehId(warehId);
            changeFinalFreeShareStockService.updateStockWarehProd(stockWarehProd);
            //获取变化的sku推送自由量锁定量队列
//            List<TmpQueueFreeLock> tmpQueueFreeLockList = getChangeData(warehId, warehTableName);
//            sendToMq(tmpQueueFreeLockList);
            //将数据写入tmp_channel_scope表
            List<String> channelCodeList = allocationRangeService.getOnlineAllotScopeByWarehId(warehId);
            for(String channelCode : channelCodeList){
                TmpChannelScope tmpChannelScope = new TmpChannelScope();
                tmpChannelScope.setWarehId(warehId);
                tmpChannelScope.setChannelCode(channelCode);
                tmpChannelScope.setScopeChange("0");
                tmpChannelScope.setWarehState("2");//告诉仓到渠道层要计算
                tmpChannelScope.setUpdateTime(new Date());
                tmpChannelScopeMapper.insert(tmpChannelScope);
            }
        }
    }

    private long getMaxId(List<TmpSafeTypeStock> tmpSafeTypeStockList) {
        long maxId = 0l;
        for (TmpSafeTypeStock tmpSafeTypeStock : tmpSafeTypeStockList) {
            long tmpId = tmpSafeTypeStock.getId().longValue();
            if (tmpId > maxId) {
                maxId = tmpId;
            }
        }
        return maxId;
    }

    /**
     * @description 获取WS类型仓库的安全库存值
     * @return WS类型的安全库存类型值
     */
    private int getWSSafeValue(String warehId) {
        return warehSafeTypeChangeSyncMapper.getWSSafeValue(warehId);
    }

    /**
     * @description 获取临时表数据，转化成对应的javaBean
     * @return javaBean集合
     */
    private List<TmpSafeTypeStock> getTmpData() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put(Constants.ParamMapKey.TABLE_NAME, Constants.TmpDataTable.TMP_SAFE_TYPE_STOCK);
        paramMap.put(Constants.ParamMapKey.PARTITION_STRING, Constants.Dereplication.PARTITION_BY_WAREHID);
        List<Map<String, Object>> tmpDataMapList = tmpTableService.getSyncTmpData(paramMap);
        List<TmpSafeTypeStock> tmpSafeTypeStockList = new ArrayList<>();
        for (Map<String, Object> tempDataMap : tmpDataMapList) {
            TmpSafeTypeStock tmpSafeTypeStock = new TmpSafeTypeStock();
            CommonUtil.transMap2Bean(tempDataMap, tmpSafeTypeStock);
            tmpSafeTypeStockList.add(tmpSafeTypeStock);
        }
        return tmpSafeTypeStockList;
    }
}
