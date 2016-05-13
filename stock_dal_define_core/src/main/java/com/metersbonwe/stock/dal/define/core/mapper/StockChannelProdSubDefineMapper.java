package com.metersbonwe.stock.dal.define.core.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.metersbonwe.stock.po.core.StockChannelProdSub;
import com.metersbonwe.stock.po.core.define.StockPreSaleResultDefine;

/**
 * @author zhq
 */
@Repository public interface StockChannelProdSubDefineMapper {

    /**
     * @param list
     *            根据预售结果表更新渠道+SKU子表明细
     * @return
     */
    public int updateByPreSaleResult(StockPreSaleResultDefine stockPreSaleResult);

    /**
     * 针对预售的channel、SKU，更新 预占明细和渠道信息表总量对比后，需要更改的pre_order_total_stock
     * 
     * @param suffix
     * @return
     */
    int updateByChannelDetailWhenIsPre(@Param("suffix") String suffix);

    /**
     * 针对不是预售的channel、SKU， 更新对应stock_channel_prod_sub表中的order_private_total_stock（实物独占预占量总量） order_share_total_stock（实物共享预占量总量）的字段
     * 
     * @param suffix
     * @return
     */
    int updateByChannelDetailWhenIsNotPre(@Param("suffix") String suffix);

    /**
     * 批量插入数据到stock_channel_prod_sub表
     * 
     * @param stockChannelProdSub
     * @return
     */
    public int insert(StockChannelProdSub stockChannelProdSub);

    /**
     * TODO 更新渠道SUB表的预售预占总量为0，并把预售预占总量累加到 实物独占预占总量
     * 
     * @param channelCode
     * @param prodId
     * @param prodId2
     */
    public void updateAndSumPreOrderStock(@Param("suffix") String suffix, @Param("channelCode") String channelCode, @Param("prodId") String prodId);
}
