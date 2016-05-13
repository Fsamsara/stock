package com.metersbonwe.stock.biz.manager.service;

import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.pojo.StockChannelProdBean;

/**
 * 渠道商品 Service
 * @author TanYibin
 *
 */
public interface StockChannelProdService {
    
    /**
     * 根据渠道列表+商品列表查询MySql核心库STOCK_CHANNEL_PROD表信息
     * @param stockChannelProdBean
     * @return
     */
    public List<StockChannelProdBean> selectForChannelsAndProds(Map<String, List<String>> paraListMap);

}
