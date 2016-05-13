package com.metersbonwe.stock.biz.manager.service;

import java.util.List;

import com.metersbonwe.stock.po.core.LogStockDetail;

public interface StockSyncLogDetailService {

    List<LogStockDetail> selectLogStockDetail(LogStockDetail detail);

}
