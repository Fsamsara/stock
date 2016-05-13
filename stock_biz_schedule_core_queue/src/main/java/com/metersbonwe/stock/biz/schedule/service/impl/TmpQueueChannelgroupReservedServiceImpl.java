package com.metersbonwe.stock.biz.schedule.service.impl;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.TmpTableService;
import com.metersbonwe.stock.facade.schedule.TmpQueueChannelgroupReservedService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.TmpQueueChannelgroupReserved;
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
 * @description 定时任务拉取tmp_queue_channelgroup_reserved数据，推送MQ实现类
 * @date 2016/5/13
 */
@Service
public class TmpQueueChannelgroupReservedServiceImpl implements TmpQueueChannelgroupReservedService {
    private static StockLog stockLog = StockLogFactory.getLogger(TmpQueueChannelgroupReservedServiceImpl.class);

    @Resource TmpTableService tmpTableService;

    @Resource MqSendService mqSendService;

    @Override public void processTmpQueueChannelgroupReservedData() {
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        try {
            lock.lock();
            processQueue();
        } catch (Exception e) {
            stockLog.error("定时任务拉取tmp_queue_channelgroup_reserved数据出错：" + e.getMessage(), e);
        } finally {
            lock.unlock();
        }
    }

    /**
     * @description 处理逻辑
     */
    private void processQueue() {
        List<TmpQueueChannelgroupReserved> tmpQueueChannelgroupReservedList = getTmpData();
        long maxId = getMaxId(tmpQueueChannelgroupReservedList);
        sendToMq(tmpQueueChannelgroupReservedList);
        tmpTableService.delCoreTmpData(Constants.TmpDataTable.TMP_QUEUE_CHANNELGROUP_RESERVED, maxId);
    }

    /**
     * @description 发送channelAll队列
     * @param tmpQueueChannelgroupReservedList
     *            临时表数据bean list
     */
    private void sendToMq(List<TmpQueueChannelgroupReserved> tmpQueueChannelgroupReservedList) {
        for (TmpQueueChannelgroupReserved tmpQueueChannelgroupReserved : tmpQueueChannelgroupReservedList) {
            mqSendService.sendToChannelGroupReserved(tmpQueueChannelgroupReserved);
        }
    }

    /**
     * @description 获取tmp_queue_channelgroup_reserved表的数据
     * @return List TmpQueueChannelgroupReserved的集合
     */
    private List<TmpQueueChannelgroupReserved> getTmpData() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put(Constants.ParamMapKey.TABLE_NAME, Constants.TmpDataTable.TMP_QUEUE_CHANNELGROUP_RESERVED);
        List<Map<String, Object>> tmpDataMapList = tmpTableService.getCoreTmpData(paramMap);
        List<TmpQueueChannelgroupReserved> beanList = new ArrayList<>();
        for (Map<String, Object> dataMap : tmpDataMapList) {
            TmpQueueChannelgroupReserved tmpQueueChannelgroupReserved = new TmpQueueChannelgroupReserved();
            CommonUtil.transMap2Bean(dataMap, tmpQueueChannelgroupReserved);
            beanList.add(tmpQueueChannelgroupReserved);
        }
        return beanList;
    }

    /**
     * @description 获取临时表的最大ID
     * @param tmpQueueChannelgroupReservedList
     *            临时表获取的所有数据
     * @return 当前获取临时表的最大ID
     */
    private long getMaxId(List<TmpQueueChannelgroupReserved> tmpQueueChannelgroupReservedList) {
        long maxId = 0l;
        for (TmpQueueChannelgroupReserved tmpQueueChannelgroupReserved : tmpQueueChannelgroupReservedList) {
            long tmpId = tmpQueueChannelgroupReserved.getId();
            if (tmpId > maxId) {
                maxId = tmpId;
            }
        }
        return maxId;
    }
}
