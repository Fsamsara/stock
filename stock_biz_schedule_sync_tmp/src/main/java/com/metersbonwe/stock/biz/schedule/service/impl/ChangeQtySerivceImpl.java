package com.metersbonwe.stock.biz.schedule.service.impl;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import javax.annotation.Resource;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.schedule.service.ChangeQtyHandleSerivce;
import com.metersbonwe.stock.biz.schedule.service.ChangeQtySerivce;
import com.metersbonwe.stock.biz.schedule.thread.ChangeQtyConsumerRunnable;
import com.metersbonwe.stock.biz.schedule.thread.ChangeQtyProducerRunnable;
import com.metersbonwe.stock.configuration.ThreadConfig;
import com.metersbonwe.stock.configuration.ThreadConfigFactory;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.ChangeQtyGlobalBean;
import com.metersbonwe.stock.pojo.ChangeQtyInfoBean;
import com.metersbonwe.stock.pojo.sync.PageBean;
import com.metersbonwe.stock.pojo.sync.PageIndexBean;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;

@Service("changeQtySerivce")
public class ChangeQtySerivceImpl implements ChangeQtySerivce {

    private static StockLog stockLog = StockLogFactory.getLogger(ChangeQtySerivceImpl.class);

    @Resource
    private ChangeQtyHandleSerivce changeQtyHandleSerivce;
    
    @Resource(name = "stockCommonExecutor")
    private ThreadPoolTaskExecutor stockCommonExecutor;

    @Override
    public void doService(ChangeQtyGlobalBean changeQtyGlobalBean) throws Exception {
        stockLog.info("库存变化调度服务 Service开始 ChangeType:" + changeQtyGlobalBean.getChangeType());
        //获取全局同步状态
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        Long time1 = System.currentTimeMillis();
        try {
            lock.lock();

            if (StringUtils.isEmpty(changeQtyGlobalBean.getChangeType())) {
                stockLog.error("库存变化调度服务 Service处理结束 ChangeType is null");
                return;
            }
            
            ThreadConfig threadConfig = ThreadConfigFactory.getThreadConfig(Constants.THREAD_CONFIG_BIZNAME_CHANGEQTY);
            
            //创建生产者一个阻塞队列（容量为2）
            LinkedBlockingQueue<List<ChangeQtyInfoBean>> queue = createProducer(changeQtyGlobalBean, threadConfig);
            
            //运行消费者
            runningConsumer(changeQtyGlobalBean, threadConfig, queue);

            stockLog.info("库存变化调度服务 Service处理结束");

        } catch (InterruptedException e) {
            stockLog.info("库存变化调度服务 InterruptedException", e);
        } catch (Exception e) {
            stockLog.error("库存变化调度服务 Service 处理失败", e);
            throw e;
        } finally {
            Long time2 = System.currentTimeMillis();
            stockLog.info("库存变化调度服务总耗时：" + (time2 - time1) + "ms，ChangeType：" + changeQtyGlobalBean.getChangeType());
            lock.unlock();
        }
    }

    private void runningConsumer(ChangeQtyGlobalBean changeQtyGlobalBean, ThreadConfig threadConfig,
            LinkedBlockingQueue<List<ChangeQtyInfoBean>> queue) throws InterruptedException, Exception {
        while (true) {
            //获取阻塞队列里的数据 10秒内未返回时 获取失败 返回null
            List<ChangeQtyInfoBean> dealChangeQtyInfos = queue.poll(10,  TimeUnit.SECONDS);
            if(dealChangeQtyInfos != null && dealChangeQtyInfos.size() > 0) {
                PageBean pageBean = new PageBean(dealChangeQtyInfos.size() / threadConfig.getMaxThreadCount() + 1, dealChangeQtyInfos.size());

                while (pageBean.hasNext()) {
                    threadConfig.waitThreadPoolNotEmpty();
                    threadConfig.threadUp();
                    PageIndexBean indexBean = pageBean.next();
                    ChangeQtyConsumerRunnable consumerRunnable = new ChangeQtyConsumerRunnable();
                    
                    consumerRunnable.setThreadConfig(threadConfig);
                    consumerRunnable.setPageIndexBean(indexBean);
                    consumerRunnable.setChangeQtyInfos(dealChangeQtyInfos);
                    consumerRunnable.setChangeType(changeQtyGlobalBean.getChangeType());
                    consumerRunnable.setchangeQtyHandleSerivce(changeQtyHandleSerivce);
                    
                    stockCommonExecutor.execute(consumerRunnable);
                }
                threadConfig.waitAllThreadDown();
            } else {
                stockLog.info("库存变化调度服务 Service处理结束 删除无用数据");
                ChangeQtyInfoBean changeQtyInfoBean = new ChangeQtyInfoBean();
                changeQtyInfoBean.setDeleteAll('Y');//删除无用数据
                changeQtyHandleSerivce.deleteChangeQtyInfo(changeQtyInfoBean, changeQtyGlobalBean.getChangeType());
                break;
            }
        }
    }

    /**
     * 创建一个阻塞队列（容量为2）
     * @param changeQtyGlobalBean
     * @param threadConfig
     * @return
     * @throws InterruptedException
     */
    private LinkedBlockingQueue<List<ChangeQtyInfoBean>> createProducer(ChangeQtyGlobalBean changeQtyGlobalBean, ThreadConfig threadConfig)
            throws InterruptedException {
        LinkedBlockingQueue<List<ChangeQtyInfoBean>> queue = new LinkedBlockingQueue<List<ChangeQtyInfoBean>>(2);
        
        CountDownLatch countDownLatch = new CountDownLatch(1);
        
        changeQtyGlobalBean.setMaxDataCount(threadConfig.getSize());
        //创建队列生产者
        ChangeQtyProducerRunnable producerRunnable = new ChangeQtyProducerRunnable();
        
        producerRunnable.setCountDownLatch(countDownLatch);
        producerRunnable.setGlobalBean(changeQtyGlobalBean);
        producerRunnable.setChangeQtyHandleSerivce(changeQtyHandleSerivce);
        producerRunnable.setQueue(queue);
        
        stockCommonExecutor.execute(producerRunnable);
        
        countDownLatch.await();
        
        return queue;
    }

}
