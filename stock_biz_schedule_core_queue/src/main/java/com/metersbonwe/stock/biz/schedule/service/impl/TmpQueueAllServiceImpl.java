package com.metersbonwe.stock.biz.schedule.service.impl;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.TmpTableService;
import com.metersbonwe.stock.facade.schedule.TmpQueueAllService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.TmpQueueAll;
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
 * @description 定时任务拉取tmp_queue_all数据，推送MQ实现类
 * @date 2016/5/9
 */
@Service
public class TmpQueueAllServiceImpl implements TmpQueueAllService {
    private static StockLog stockLog = StockLogFactory.getLogger(TmpQueueAllServiceImpl.class);

    @Resource TmpTableService tmpTableService;

    @Resource MqSendService mqSendService;

    @Override public void processTmpQueueAllData() {
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        try {
            lock.lock();
            processQueue();
        } catch (Exception e) {
            stockLog.error("定时任务拉取tmp_queue_all数据出错：" + e.getMessage(), e);
        } finally {
            lock.unlock();
        }
    }

    /**
     * @description 处理逻辑
     */
    private void processQueue() {
        List<TmpQueueAll> tmpQueueAllList = getTmpData();
        long maxId = getMaxId(tmpQueueAllList);
        sendToMq(tmpQueueAllList);
        tmpTableService.delCoreTmpData(Constants.TmpDataTable.TMP_QUEUE_ALL, maxId);
    }

    /**
     * @description 发送channelAll队列
     * @param tmpQueueAllList
     *            临时表数据bean list
     */
    private void sendToMq(List<TmpQueueAll> tmpQueueAllList) {
        for (TmpQueueAll tmpQueueAll : tmpQueueAllList) {
            mqSendService.sendToChannelAll(tmpQueueAll);
        }
    }

    /**
     * @description 获取tmp_queue_all表的数据
     * @return List TmpChannelScope的集合
     */
    private List<TmpQueueAll> getTmpData() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put(Constants.ParamMapKey.TABLE_NAME, Constants.TmpDataTable.TMP_QUEUE_ALL);
        List<Map<String, Object>> tmpDataMapList = tmpTableService.getCoreTmpData(paramMap);
        List<TmpQueueAll> beanList = new ArrayList<>();
        for (Map<String, Object> dataMap : tmpDataMapList) {
            TmpQueueAll tmpQueueAll = new TmpQueueAll();
            CommonUtil.transMap2Bean(dataMap, tmpQueueAll);
            beanList.add(tmpQueueAll);
        }
        return beanList;
    }

    /**
     * @description 获取临时表的最大ID
     * @param tmpQueueAllList
     *            临时表获取的所有数据
     * @return 当前获取临时表的最大ID
     */
    private long getMaxId(List<TmpQueueAll> tmpQueueAllList) {
        long maxId = 0l;
        for (TmpQueueAll tmpQueueAll : tmpQueueAllList) {
            long tmpId = tmpQueueAll.getId();
            if (tmpId > maxId) {
                maxId = tmpId;
            }
        }
        return maxId;
    }
}
