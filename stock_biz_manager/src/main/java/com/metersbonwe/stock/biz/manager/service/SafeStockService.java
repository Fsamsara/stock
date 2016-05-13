package com.metersbonwe.stock.biz.manager.service;

import java.util.List;

import com.metersbonwe.stock.po.core.StockWpSafe;

public interface SafeStockService {

    /**
     * TODO 按分页查询单仓、多sku或没有sku获取仓+sku安全库存量
     * 
     * @param page
     * @param warehId
     * @param skuList
     * @return
     */
    List<StockWpSafe> getErpWarehSafeStock(List<String> warehList, List<String> skuList);

}
