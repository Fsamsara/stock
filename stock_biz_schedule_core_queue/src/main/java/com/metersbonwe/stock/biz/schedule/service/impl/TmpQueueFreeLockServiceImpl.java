package com.metersbonwe.stock.biz.schedule.service.impl;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.TmpTableService;
import com.metersbonwe.stock.facade.schedule.TmpQueueFreeLockService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.TmpQueueFreeLock;
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
public class TmpQueueFreeLockServiceImpl implements TmpQueueFreeLockService {
    private static StockLog   stockLog = StockLogFactory.getLogger(TmpQueueFreeLockServiceImpl.class);

    @Resource TmpTableService tmpTableService;

    @Resource MqSendService   mqSendService;

    @Override
    public void processTmpQueueFreeLockData() {
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        try {
            lock.lock();
            processFreeLockQueue();
        } catch (Exception e) {
            stockLog.error("定时任务拉取tmp_queue_free_lock数据出错：" + e.getMessage(), e);
        } finally {
            lock.unlock();
        }
    }

    /**
     * @description 处理逻辑
     */
    private void processFreeLockQueue() {
        List<TmpQueueFreeLock> tmpQueueFreeLockList = getFreeLockTmpData();
        long maxId = getTmpQuequeFreeLockMaxId(tmpQueueFreeLockList);
        sendToFreeLockMq(tmpQueueFreeLockList);
        tmpTableService.delCoreTmpData(Constants.TmpDataTable.TMP_QUEUE_FREE_LOCK, maxId);
    }

    /**
     * @description 发送自由量锁定量
     * @param tmpQuequeFreeLockList
     *            临时表数据bean list
     */
    private void sendToFreeLockMq(List<TmpQueueFreeLock> tmpQuequeFreeLockList) {
        for (TmpQueueFreeLock tmpQueueFreeLock : tmpQuequeFreeLockList) {
            mqSendService.sendToChannelWarehProdFreeLock(tmpQueueFreeLock);
        }
    }

    /**
     * @description 获取tmp_queue_free_lock表的数据
     * @return List TmpChannelScope的集合
     */
    private List<TmpQueueFreeLock> getFreeLockTmpData() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put(Constants.ParamMapKey.TABLE_NAME, Constants.TmpDataTable.TMP_QUEUE_FREE_LOCK);
        List<Map<String, Object>> tmpDataMapList = tmpTableService.getCoreTmpData(paramMap);
        List<TmpQueueFreeLock> beanList = new ArrayList<>();
        for (Map<String, Object> dataMap : tmpDataMapList) {
            TmpQueueFreeLock TmpQueueFreeLock = new TmpQueueFreeLock();
            CommonUtil.transMap2Bean(dataMap, TmpQueueFreeLock);
            beanList.add(TmpQueueFreeLock);
        }
        return beanList;
    }

    /**
     * @description 获取临时表的最大ID
     * @param tmpQueueFreeLockList
     *            临时表获取的所有数据
     * @return 当前获取临时表的最大ID
     */
    private long getTmpQuequeFreeLockMaxId(List<TmpQueueFreeLock> tmpQueueFreeLockList) {
        long maxId = 0l;
        for (TmpQueueFreeLock TmpQueueFreeLock : tmpQueueFreeLockList) {
            long tmpId = TmpQueueFreeLock.getId();
            if (tmpId > maxId) {
                maxId = tmpId;
            }
        }
        return maxId;
    }
}
