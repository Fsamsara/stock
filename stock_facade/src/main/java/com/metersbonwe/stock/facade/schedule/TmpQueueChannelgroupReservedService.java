package com.metersbonwe.stock.facade.schedule;

/**
 * @author huangbiao
 * @version V1.0
 * @description 定时任务拉取tmp_queue_channelgroup_reserved表中的数据，推送队列接口
 * @date 2016/05/09
 */
public interface TmpQueueChannelgroupReservedService {
    /**
     * @description 定时任务调用用于处理tmp_queue_channelgroup_reserved表数据的方法
     */
    void processTmpQueueChannelgroupReservedData();
}
