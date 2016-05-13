package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.metersbonwe.stock.po.core.StockChannelStatus;
import com.metersbonwe.stock.po.core.TmpStockChannelStatus;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.po.core.define.StockPreSaleResultDefine;
import com.metersbonwe.stock.po.sync.TmpChannelCellMin;

/**
 * @author 张洪琴
 */
@Repository public interface StockChannelProdDetailDefineMapper {

    /**
     * @description 查询渠道+SKU明细信息：查询条件渠道+SKU的id包含在渠道商品状态明细表中，且sale_status!='下架'的数据
     * @param stockChannelStatus
     * @return
     */
    public List<ChannelProdBean> selectByChannelStatus(StockChannelStatus stockChannelStatus);

    /**
     * @description 根据传入的临时表tmp_stock_channel_status数据，关联stock_channel_status表、与渠道+SKU的两张表关联查询渠道+SKU明细数据
     * @param tmp
     * @return
     */
    public List<ChannelProdBean> selectByStatusCompareToTmp(TmpStockChannelStatus tmp);

    /**
     * @param list
     *            根据预售结果列表查询渠道+SKU明细
     * @return
     */
    public List<ChannelProdBean> selectByPreSaleResult(List<StockPreSaleResultDefine> list);

    /**
     * @param channelProdBean
     *            根据渠道+SKU信息更新渠道+SKU的两张表:private_stock/is_pre/pre_private_stock/pre_order_total_stock字段
     * @return
     */
    public int updateChannelByBeanList(ChannelProdBean channelProdBean);

    /**
     * 根据渠道号，查询该渠道的所有商品
     * 
     * @param tableSuffix
     * @return
     */
    public List<ChannelProdBean> selectByChannelCode(@Param("tableSuffix") String tableSuffix);

    /**
     * 根据渠道号、商品号查询渠道+SKU信息
     * 
     * @param tableSuffix
     * @param prodId
     * @return
     */
    public ChannelProdBean selectByChannelCodeAndSku(@Param("tableSuffix") String tableSuffix, @Param("prodId") String prodId);

    /**
     * 根据渠道号、商品号查询渠道+SKU信息 批量
     * 
     * @param tableSuffix
     * @param prodId
     * @return
     */
    public List<ChannelProdBean> selectByChannelCodeAndSkus(@Param("tableSuffix") String tableSuffix,
            @Param("prodIds") List<TmpChannelCellMin> prodIds);
}
