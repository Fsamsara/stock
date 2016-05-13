package com.metersbonwe.stock.biz.queue.service;

import com.metersbonwe.stock.po.core.TmpQueueFreeLock;

/**
 * @author huangbiao
 * @version V1.0
 * @description 自由量锁定量变化队列处理
 * @date 2016/3/24
 */
public interface FreeLockChangeService {
    void processFreeLockChange(TmpQueueFreeLock tmpQueueFreeLock);
}
