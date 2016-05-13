package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.StockChannelStatusBean;

/**
 * @author 张洪琴 渠道+款进货(渠道+款上下架是否同步)接口
 */
public interface StockChannelStatusFacade {

    /**
     * @param StockChannelStatusFacade
     *            渠道+款进货(渠道+款上下架是否同步)接口：单数据写入
     * @return 写入成功：true,写入失败：false
     */
    public Message setStockChannelStatus(StockChannelStatusBean stockChannelStatus);

    /**
     * @param StockChannelStatusFacade
     *            渠道+款进货(渠道+款上下架是否同步)接口：多数据写入
     * @return 写入成功：true,写入失败：false
     */
    public Message setStockChannelStatusList(List<StockChannelStatusBean> stockChannelStatusList);
}
