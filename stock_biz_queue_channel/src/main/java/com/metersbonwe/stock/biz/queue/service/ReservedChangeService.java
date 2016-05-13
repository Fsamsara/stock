package com.metersbonwe.stock.biz.queue.service;

import com.metersbonwe.stock.po.core.TmpQueueReserved;

/**
 * @author huangbiao
 * @version V1.0
 * @description 预留独占量变化队列
 * @date 2016/3/23
 */
public interface ReservedChangeService {
    void processReservedChange(TmpQueueReserved tmpQueueReserved);
}
