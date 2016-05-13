package com.metersbonwe.stock.biz.schedule.service.impl;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.TmpTableService;
import com.metersbonwe.stock.facade.schedule.TmpQueueReservedService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.TmpQueueReserved;
import com.metersbonwe.stock.utils.CommonUtil;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author huangbiao
 * @version V1.0
 * @description 定时任务拉取tmp_queue_free_lock数据，推送MQ实现类
 * @date 2016/3/25
 */
@Service
public class TmpQueueReservedServiceImpl implements TmpQueueReservedService {
    private static StockLog   stockLog = StockLogFactory.getLogger(TmpQueueReservedServiceImpl.class);

    @Resource TmpTableService tmpTableService;

    @Resource MqSendService   mqSendService;

    @Override
    public void processTmpQueueReservedData() {
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        try {
            lock.lock();
            processReservedQueue();
        } catch (Exception e) {
            stockLog.error("定时任务拉取tmp_queue_reserved数据出错：" + e.getMessage(), e);
        } finally {
            lock.unlock();
        }
    }

    /**
     * @description 处理逻辑
     */
    private void processReservedQueue() {
        List<TmpQueueReserved> tmpQueueReservedList = getReserveTmpData();
        long maxId = geTmpQuequeReservedMaxId(tmpQueueReservedList);
        sendToReservedMq(tmpQueueReservedList);
        tmpTableService.delCoreTmpData(Constants.TmpDataTable.TMP_QUEUE_RESERVED, maxId);
    }

    /**
     * @description 发送预留量队列
     * @param tmpQuequeReservedList
     *            临时表数据bean list
     */
    private void sendToReservedMq(List<TmpQueueReserved> tmpQuequeReservedList) {
        for (TmpQueueReserved TmpQueueReserved : tmpQuequeReservedList) {
            mqSendService.sendToChannelWarehProdReserved(TmpQueueReserved);
        }
    }

    /**
     * @description 获取tmp_queue_reserved表的数据
     * @return List TmpQuequeReserved的集合
     */
    private List<TmpQueueReserved> getReserveTmpData() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put(Constants.ParamMapKey.TABLE_NAME, Constants.TmpDataTable.TMP_QUEUE_RESERVED);
        List<Map<String, Object>> tmpDataMapList = tmpTableService.getCoreTmpData(paramMap);
        List<TmpQueueReserved> beanList = new ArrayList<>();
        for (Map<String, Object> dataMap : tmpDataMapList) {
            TmpQueueReserved TmpQueueReserved = new TmpQueueReserved();
            CommonUtil.transMap2Bean(dataMap, TmpQueueReserved);
            beanList.add(TmpQueueReserved);
        }
        return beanList;
    }

    /**
     * @description 获取临时表的最大ID
     * @param tmpQueueReservedList
     *            临时表获取的所有数据
     * @return 当前获取临时表的最大ID
     */
    private long geTmpQuequeReservedMaxId(List<TmpQueueReserved> tmpQueueReservedList) {
        long maxId = 0l;
        for (TmpQueueReserved tmpQueueReserved : tmpQueueReservedList) {
            long tmpId = tmpQueueReserved.getId();
            if (tmpId > maxId) {
                maxId = tmpId;
            }
        }
        return maxId;
    }
}
