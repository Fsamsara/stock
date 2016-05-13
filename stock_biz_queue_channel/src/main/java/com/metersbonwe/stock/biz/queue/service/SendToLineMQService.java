package com.metersbonwe.stock.biz.queue.service;

/**
 * @author huangbiao
 * @version V1.0
 * @description 渠道可用仓变化（包含全量同步），数据落入渠道商品明细表后发送给MQ一个标志， 告诉这个渠道需要往线上推送数据了
 * @date 2016/4/5
 */
public interface SendToLineMQService {
    void processSendToLineMQ(String channelCode);
}
