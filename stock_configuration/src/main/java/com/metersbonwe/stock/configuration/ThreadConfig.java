package com.metersbonwe.stock.configuration;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;

/**
 * TODO 从配置文件中读取配置 全量同步相关配置参数
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-3-26 下午7:25:36
 */
public final class ThreadConfig implements Serializable {

    private StockLog                      log                = StockLogFactory.getLogger(ThreadConfig.class);

    /** 业务名称 */
    private String                        bizName            = "";

    /** 一页最大查询行数 */
    private int                           size               = 300000;

    /** 最大线程数 */
    private int                           maxThreadCount     = 25;

    /** 当前线程数 */
    private transient final AtomicInteger currentThreadCount = new AtomicInteger(0);

    public ThreadConfig() {}

    public ThreadConfig(int size) {
        super();
        this.size = size;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxThreadCount() {
        return maxThreadCount;
    }

    public void setMaxThreadCount(int maxThreadCount) {
        this.maxThreadCount = maxThreadCount;
    }

    public AtomicInteger getCurrentThreadCount() {
        return currentThreadCount;
    }

    private static final long serialVersionUID = 2481868352171659492L;

    public void waitThreadPoolNotEmpty() {
        while (!isThreadPoolNotEmpty())
            ;
    }

    public boolean isThreadPoolNotEmpty() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return currentThreadCount.get() < maxThreadCount;
    }

    public void threadUp() {
        int i = getCurrentThreadCount().addAndGet(1);
        log.debug(bizName + "创建线程 ,当前线程数量:" + i);
    }

    public void threadDown() {
        int i = getCurrentThreadCount().addAndGet(-1);
        log.debug(bizName + "线程结束 ,当前线程数量:" + i);
    }

    public void waitAllThreadDown() {
        while (this.currentThreadCount.get() > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "ThreadConfig [bizName=" + bizName + ", size=" + size + ", maxThreadCount=" + maxThreadCount + "]";
    }

}
