package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;

import com.metersbonwe.stock.po.core.StockChannelProd;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.pojo.StockChannelProdBean;

/**
 * 渠道商品操作 STOCK_CHANNEL_PROD 
 * @author TanYibin
 *
 */
public interface StockChannelProdDefineMapper {

    /**
     * 根据渠道号+商品编号查询MySql核心库STOCK_CHANNEL_PROD表信息
     * @param stockChannelProd
     * @return
     */
    public ChannelProdBean selectForChannelAndProd(ChannelProdBean channelProdBean);
    
    
    /**
     * 根据渠道列表+商品列表查询MySql核心库STOCK_CHANNEL_PROD表信息
     * @param stockChannelProd
     * @return
     */
    public List<StockChannelProdBean> selectForChannelsAndProds(StockChannelProdBean stockChannelProdBean);
    
    /**
     * 批量插入数据到STOCK_CHANNEL_PROD表
     * @param StockChannelProd
     * @return
     */
    public int insert(StockChannelProd stockChannelProd);
}
