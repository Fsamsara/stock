package com.metersbonwe.stock.biz.schedule.service.impl;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.ChannelCalService;
import com.metersbonwe.stock.facade.schedule.UsefulWarehChangeService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/3/24
 */
@Service public class UsefulWarehChangeServiceImpl implements UsefulWarehChangeService {
    private static StockLog     logger = StockLogFactory.getLogger(UsefulWarehChangeServiceImpl.class);

    @Resource ChannelCalService channelCalService;

    @Override
    public void processChannelUsefulWarehChange() {
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        try {
            lock.lock();
            channelCalService.processChannelUsefulWarehChange(false);
        } catch (Exception e) {
            logger.error("定时任务拉取tmp_channel_scope数据并处理出错：" + e.getMessage(), e);
        } finally {
            lock.unlock();
        }
    }
}
