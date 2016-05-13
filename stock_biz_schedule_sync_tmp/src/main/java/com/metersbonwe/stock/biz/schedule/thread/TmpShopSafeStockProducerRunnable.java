package com.metersbonwe.stock.biz.schedule.thread;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

import com.metersbonwe.stock.dal.define.sync.mapper.TmpShopSafeStockDefineMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpShopSafeStock;
import com.metersbonwe.stock.pojo.TmpShopSafeGlobalBean;

/**
 * 门店安全库存生产者
 * 
 * @author zhangjf
 */
public class TmpShopSafeStockProducerRunnable implements Runnable {
    private static StockLog                             stockLog = StockLogFactory.getLogger(TmpShopSafeStockProducerRunnable.class);

    private TmpShopSafeStockDefineMapper                tmpShopSafeStockDefineMapper;

    /** 阻塞队列 */
    private LinkedBlockingQueue<List<TmpShopSafeStock>> queue;

    private TmpShopSafeGlobalBean                       tmpShopSafeGlobalBean;

    private CountDownLatch                              countDownLatch;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        List<TmpShopSafeStock> safelist = null;
        stockLog.info("启动门店安全库存生产者线程！");
        try {
            while (true) {

                Long time1 = System.currentTimeMillis();
                safelist = tmpShopSafeStockDefineMapper.selectAllDeleteRepeat(tmpShopSafeGlobalBean);
                Long time2 = System.currentTimeMillis();
                stockLog.info("获取门店安全库存信息" + safelist.size() + "条，耗时：" + (time2 - time1) + "ms");
                
                countDownLatch.countDown();
                
                //放入队列，没有空间获取数据时阻塞队列
                queue.put(safelist);
                
                if (safelist.size() == 0) {
                    break;
                } else {
                    tmpShopSafeGlobalBean.setStartId(safelist.get(safelist.size() - 1).getId().intValue());
                }
            }
        } catch (InterruptedException e) {
            stockLog.info("退出门店安全库存生产者线程!");
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            stockLog.error("门店安全库存生产者线程异常:", e);
            Thread.currentThread().interrupt();
        } finally {
            stockLog.info("退出门店安全库存生产者线程");
        }
    }

    public TmpShopSafeStockDefineMapper getTmpShopSafeStockDefineMapper() {
        return tmpShopSafeStockDefineMapper;
    }

    public void setTmpShopSafeStockDefineMapper(TmpShopSafeStockDefineMapper tmpShopSafeStockDefineMapper) {
        this.tmpShopSafeStockDefineMapper = tmpShopSafeStockDefineMapper;
    }

    public LinkedBlockingQueue<List<TmpShopSafeStock>> getQueue() {
        return queue;
    }

    public void setQueue(LinkedBlockingQueue<List<TmpShopSafeStock>> queue) {
        this.queue = queue;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public TmpShopSafeGlobalBean getTmpShopSafeGlobalBean() {
        return tmpShopSafeGlobalBean;
    }

    public void setTmpShopSafeGlobalBean(TmpShopSafeGlobalBean tmpShopSafeGlobalBean) {
        this.tmpShopSafeGlobalBean = tmpShopSafeGlobalBean;
    }

}
