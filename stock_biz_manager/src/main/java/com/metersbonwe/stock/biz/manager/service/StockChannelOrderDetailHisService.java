package com.metersbonwe.stock.biz.manager.service;

import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.po.core.StockChannelOrderDetailHis;

/**
 * 渠道实物库存 Service
 * 
 * @author TanYibin
 */
public interface StockChannelOrderDetailHisService {

    /**
     * 渠道实物库存查询 MySql核心库STOCK_CHANNEL_ORDER_DETAIL_HIS表信息
     * 
     * @param stockChannelOrderDetailBean
     * @return
     */
    public List<StockChannelOrderDetailHis> selectByChannelAndProds(Map<String, List<String>> paraListMap);

}
