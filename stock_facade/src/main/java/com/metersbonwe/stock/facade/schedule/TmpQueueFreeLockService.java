package com.metersbonwe.stock.facade.schedule;

/**
 * @author huangbiao
 * @version V1.0
 * @description 定时任务拉取tmp_queue_free_lock表中的数据，推送队列接口
 * @date 2016/3/25
 */
public interface TmpQueueFreeLockService {
    /**
     * @description 定时任务调用用于处理tmp_queue_free_lock表数据的方法
     */
    void processTmpQueueFreeLockData();
}
