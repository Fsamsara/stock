package com.metersbonwe.stock.biz.queue.service;

import com.metersbonwe.stock.po.core.TmpQueueAll;

/**
 * @author huangbiao
 * @version V1.0
 * @description 重新计算渠道表所有的库存值
 * @date 2016/4/28
 */
public interface ChannelChangeAllService {
    void processAllChange(TmpQueueAll tmpQueueAll);
}
