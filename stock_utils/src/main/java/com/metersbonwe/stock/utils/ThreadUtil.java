package com.metersbonwe.stock.utils;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 多线程处理
 * 
 * @author TanYibin
 * @version
 * @see
 * @since 2015年7月28日
 */
public class ThreadUtil {
    private int THREAD_POOL_SIZE = 0; //线程池大小

    private ExecutorService exeService;

    public ExecutorService getExeService() {
        return exeService;
    }

    public ThreadUtil(int count) {
        this.THREAD_POOL_SIZE = count;
        this.exeService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    //无参数返回的异步调用
    public void executeRunnable(Runnable runnable) {
        this.exeService.execute(runnable);
    }

    //有返回参数的异步调用
    public List<Future<Integer>> executeCallables(List<Callable<Integer>> list) {
        try {
            return this.exeService.invokeAll(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 连接池关闭 TODO 功能详细描述
     * 
     * @since 2015年8月5日
     */
    public void shutdown() {
        this.exeService.shutdown();
    }

}
