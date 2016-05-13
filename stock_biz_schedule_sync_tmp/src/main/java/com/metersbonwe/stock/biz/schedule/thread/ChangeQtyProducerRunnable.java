package com.metersbonwe.stock.biz.schedule.thread;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

import com.metersbonwe.stock.biz.schedule.service.ChangeQtyHandleSerivce;
import com.metersbonwe.stock.biz.schedule.service.impl.ChangeQtySerivceImpl;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.ChangeQtyGlobalBean;
import com.metersbonwe.stock.pojo.ChangeQtyInfoBean;

/**
 * 库存变化生产者
 * @author TanYibin
 */
public class ChangeQtyProducerRunnable implements Runnable {

    private static StockLog stockLog = StockLogFactory.getLogger(ChangeQtySerivceImpl.class);
    
    private ChangeQtyHandleSerivce changeQtyHandleSerivce;
    
    /** 阻塞队列*/
    private LinkedBlockingQueue<List<ChangeQtyInfoBean>> queue;
    
    private ChangeQtyGlobalBean globalBean;
    
    private CountDownLatch countDownLatch;

    @Override
    public void run() {
        
        List<ChangeQtyInfoBean> changeQtyList = null;

        stockLog.info("启动库存变化生产者线程！");

        try {
            while (true) {
                
                Long time1 = System.currentTimeMillis();
                //获取库存变化数据
                changeQtyList = changeQtyHandleSerivce.selectChangeQtyInfos(globalBean);
                Long time2 = System.currentTimeMillis();

                stockLog.info("获取同步库临时表变化信息" + changeQtyList.size() + "条，耗时：" + (time2 - time1) + "ms，ChangeType："
                        + globalBean.getChangeType());

                countDownLatch.countDown();
                
                //放入队列，没有空间获取数据时阻塞队列
                queue.put(changeQtyList);
                
                if (changeQtyList.size() == 0) {
                    break;
                } else {
                    globalBean.setStartId(changeQtyList.get(changeQtyList.size() - 1).getId().intValue());
                }
            }
        } catch (InterruptedException e) {
            stockLog.info("退出库存变化生产者线程!");
            Thread.currentThread().interrupt();
        }  catch (Exception e) {
            stockLog.error("库存变化生产者线程异常:",e);
            Thread.currentThread().interrupt();
        } finally {
            stockLog.info("退出库存变化生产者线程");
        }
    }

    public ChangeQtyHandleSerivce getChangeQtyHandleSerivce() {
        return changeQtyHandleSerivce;
    }

    public void setChangeQtyHandleSerivce(ChangeQtyHandleSerivce changeQtyHandleSerivce) {
        this.changeQtyHandleSerivce = changeQtyHandleSerivce;
    }

    public ChangeQtyGlobalBean getGlobalBean() {
        return globalBean;
    }

    public void setGlobalBean(ChangeQtyGlobalBean globalBean) {
        this.globalBean = globalBean;
    }

    public LinkedBlockingQueue<List<ChangeQtyInfoBean>> getQueue() {
        return queue;
    }

    public void setQueue(LinkedBlockingQueue<List<ChangeQtyInfoBean>> queue) {
        this.queue = queue;
    }
    
    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

}
