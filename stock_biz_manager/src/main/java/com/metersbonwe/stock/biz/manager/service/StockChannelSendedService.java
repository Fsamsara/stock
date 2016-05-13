package com.metersbonwe.stock.biz.manager.service;

import java.util.List;

import com.metersbonwe.stock.po.core.StockChannelSended;
import com.metersbonwe.stock.pojo.StockChannelSendedBean;

/**
 * 渠道真实推送操作 STOCK_CHANNEL_SENDED
 * @author TanYibin
 *
 */
public interface StockChannelSendedService {
    
    /**
     * 根据渠道列表+商品列表查询MySql核心库STOCK_CHANNEL_SENDED表信息
     * @param stockChannelSended
     * @return
     */
    public List<StockChannelSended> selectForChannelsAndProds(StockChannelSendedBean stockChannelSendedBean);

}
