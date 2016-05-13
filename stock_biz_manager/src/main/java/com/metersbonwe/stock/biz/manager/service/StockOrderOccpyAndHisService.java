package com.metersbonwe.stock.biz.manager.service;

import java.util.List;

import com.metersbonwe.stock.po.core.StockChannelOrderDetail;
import com.metersbonwe.stock.po.core.StockChannelOrderDetailHis;

public interface StockOrderOccpyAndHisService {

    List<StockChannelOrderDetail> selectOrderOccupy(StockChannelOrderDetail detail);

    List<StockChannelOrderDetailHis> selectOrderOccupyHis(StockChannelOrderDetailHis detail);

}
