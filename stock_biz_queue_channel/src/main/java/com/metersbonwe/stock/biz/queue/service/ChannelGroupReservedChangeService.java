package com.metersbonwe.stock.biz.queue.service;

import com.metersbonwe.stock.po.core.TmpQueueChannelgroupReserved;

/**
 * @author huangbiao
 * @version V1.0
 * @description 店群预留独占量变化队列
 * @date 2016/04/25
 */
public interface ChannelGroupReservedChangeService {
    void processReservedChange(TmpQueueChannelgroupReserved tmpQueueChannelGroupReserved);
}
