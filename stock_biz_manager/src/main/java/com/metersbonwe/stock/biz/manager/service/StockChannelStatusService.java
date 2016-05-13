package com.metersbonwe.stock.biz.manager.service;

import java.util.List;

import com.metersbonwe.stock.po.core.StockChannelStatus;
import com.metersbonwe.stock.pojo.PageStockChannelStatusBean;

public interface StockChannelStatusService {

    /**
     * 页面查询
     * @param stockChannelStatus
     * @return
     */
    List<StockChannelStatus> selectPageStockChannelStatus(PageStockChannelStatusBean stockChannelStatusBean);

}
