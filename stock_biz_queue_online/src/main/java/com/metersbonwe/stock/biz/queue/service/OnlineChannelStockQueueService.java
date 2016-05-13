package com.metersbonwe.stock.biz.queue.service;

import java.util.List;

import javax.jms.MessageListener;

import com.metersbonwe.stock.po.core.define.ChannelProdBean;

/**
 * TODO 推送线上MQ监听
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年3月26日 下午2:12:45
 * @since V1.0
 * @version V1.0
 */
public interface OnlineChannelStockQueueService extends MessageListener {
    /**
     * TODO 推送线上
     * 
     * @param channelProdBean
     * @throws Exception
     */
    void processReservedChange(ChannelProdBean channelProdBean) throws Exception;

    /**
     * TODO 推送线上 （批量）
     *
     * @param channelProdBeans
     * @throws Exception
     */
    void processReservedChangeList(List<ChannelProdBean> channelProdBeans) throws Exception;
}
