package com.metersbonwe.stock.biz.schedule.service.impl;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.ChangeFinalFreeShareStockService;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.schedule.thread.TmpShopSafeStockConsumerRunnable;
import com.metersbonwe.stock.configuration.ThreadConfig;
import com.metersbonwe.stock.configuration.ThreadConfigFactory;
import com.metersbonwe.stock.dal.auto.core.mapper.StockShopSafeMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockShopSafeTranMapper;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpShopSafeStockMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpShopSafeStockDefineMapper;
import com.metersbonwe.stock.facade.schedule.TmpShopSafeStockService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpShopSafeStock;
import com.metersbonwe.stock.pojo.TmpShopSafeGlobalBean;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;

@Service public class TmpShopSafeStockServiceImpl implements TmpShopSafeStockService {
    private static StockLog                                                stockLog               = StockLogFactory
                                                                                                          .getLogger(TmpShopSafeStockServiceImpl.class);

    private final String                                                   SERVICE_NAME           = "门店安全库存处理调度";

    @Autowired TmpShopSafeStockDefineMapper                                tmpShopSafeStockDefineMapper;

    @Autowired StockShopSafeMapper                                         stockShopSafeMapper;

    @Autowired StockShopSafeTranMapper                                     stockShopSafeTranMapper;

    @Autowired ChangeFinalFreeShareStockService                            changeFinalFreeShareStockService;

    @Autowired MqSendService                                               mqSendService;

    @Autowired TmpShopSafeStockMapper                                      tmpShopSafeStockMapper;

    @Resource(name = "stockCommonExecutor") private ThreadPoolTaskExecutor stockCommonExecutor;

    @Override
    public void doService() {
        stockLog.info(SERVICE_NAME + "开始运行");
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        try {
            lock.lock();
            TmpShopSafeGlobalBean tmpShopSafeGlobalBean = new TmpShopSafeGlobalBean();
            ThreadConfig threadConfig = ThreadConfigFactory.getThreadConfig(Constants.THREAD_CONFIG_BIZNAME_SHOPSAFE);
            tmpShopSafeGlobalBean.setMaxDataCount(threadConfig.getSize());

            while (true) {
                Long time1 = System.currentTimeMillis();
                List<TmpShopSafeStock> safelist = tmpShopSafeStockDefineMapper.selectAllDeleteRepeat(tmpShopSafeGlobalBean);
                Long time2 = System.currentTimeMillis();
                stockLog.info("获取门店安全库存信息" + safelist.size() + "条，耗时：" + (time2 - time1) + "ms");

                if (safelist.size() == 0) {
                    break;
                } else {
                    time1 = System.currentTimeMillis();
                    for (TmpShopSafeStock tmpShopSafeStock : safelist) {
                        threadConfig.waitThreadPoolNotEmpty();
                        threadConfig.threadUp();
                        
                        TmpShopSafeStockConsumerRunnable r=new TmpShopSafeStockConsumerRunnable();
                        r.setChangeFinalFreeShareStockService(changeFinalFreeShareStockService);
                        r.setMqSendService(mqSendService);
                        r.setStockShopSafeMapper(stockShopSafeMapper);
                        r.setStockShopSafeTranMapper(stockShopSafeTranMapper);
                        r.setThreadConfig(threadConfig);
                        r.setTmpShopSafeStock(tmpShopSafeStock);
                        r.setTmpShopSafeStockMapper(tmpShopSafeStockMapper);
                        stockCommonExecutor.execute(r);
                    }
                    threadConfig.waitAllThreadDown();
                    time2 = System.currentTimeMillis();
                    stockLog.info("处理门店安全库存信息耗时：" + (time2 - time1) + "ms");
                }
            }

        } catch (Exception e) {
            stockLog.error(SERVICE_NAME + "出错", e);
        } finally {
            lock.unlock();
            stockLog.info(SERVICE_NAME + "结束运行");
        }
    }

}
