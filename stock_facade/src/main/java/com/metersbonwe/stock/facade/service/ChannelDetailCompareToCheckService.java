package com.metersbonwe.stock.facade.service;

/**
 * @author zhq
 * @description 预占明细和渠道信息表总量对比校验定时任务
 * @version V1.0
 * @date 2016/03/28
 */
public interface ChannelDetailCompareToCheckService {

    /**
     * @description 预占明细信息表数据stock_channel_order_detail 与 stock_channel_prod_sub数据对比校验
     */
    public void checkChannelAndDetail();
}
