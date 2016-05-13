package com.metersbonwe.stock.biz.manager.service;

import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.po.core.StockShopRemail;

public interface StockShopRemailService {
    /**
     * TODO 条件查询门店未日结
     *
     * @param dameVo
     * @return
     * @throws Exception
     */
    List<StockShopRemail> selectStockShopRemail(Map<String, List<String>> paraListMap) throws Exception;

}
