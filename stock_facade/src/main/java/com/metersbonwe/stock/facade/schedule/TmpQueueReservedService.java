package com.metersbonwe.stock.facade.schedule;

/**
 * @author huangbiao
 * @version V1.0
 * @description 定时任务拉取tmp_queue_reserved表中的数据，推送队列接口
 * @date 2016/3/25
 */
public interface TmpQueueReservedService {
    /**
     * @description 定时任务调用用于处理tmp_queue_reserved表数据的方法
     */
    void processTmpQueueReservedData();
}
