package com.metersbonwe.stock.pojo;

import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;

/**
 * 基础的任务线程父类
 * @author TanYibin
 * @version
 * @see
 * @since
 */
public abstract class BaseTaskThread implements Runnable {

    static Logger logger = Logger.getLogger(BaseTaskThread.class);

    public BaseTaskThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    private CountDownLatch countDownLatch;

    /**
     * TODO 一句话功能简述 TODO 功能详细描述
     * 
     * @throws Exception
     */
    public abstract void doBusiness() throws Exception;

    @Override
    public final void run() {
        try {
            doBusiness();
        } catch (Exception ex) {
            logger.error(ex);
        } finally {
            this.countDownLatch.countDown();
        }
    }

    public static void await(CountDownLatch countDownLatch) {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
