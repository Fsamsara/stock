package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;

import com.metersbonwe.stock.po.core.StockChannelSended;
import com.metersbonwe.stock.pojo.StockChannelSendedBean;

/**
 * 渠道真实推操作 STOCK_CHANNEL_SENDED
 * @author TanYibin
 *
 */
public interface StockChannelSendedDefineMapper {
    
    /**
     * 根据渠道列表+商品列表查询MySql核心库STOCK_CHANNEL_SENDED表信息
     * @param stockChannelSendedBean
     * @return
     */
    public List<StockChannelSended> selectForChannelsAndProds(StockChannelSendedBean stockChannelSendedBean);
    
    /**
     * 更新数据
     * @param stockChannelSended
     * @return
     */
    public int update(StockChannelSended stockChannelSended);

}
