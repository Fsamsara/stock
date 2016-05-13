package com.metersbonwe.stock.biz.common.service;

import com.metersbonwe.stock.po.core.StockWarehProd;

/**
 * MySql核心库STOCK_WAREH_PORD表最终自由量计算Service
 * @author TanYibin
 *
 */
public interface ChangeFinalFreeShareStockService {

    /**
     * 更新MySql核心库STOCK_WAREH_PORD表变化量,最终自由量
     * @param stockWarehProd
     * @return
     * @throws Exception
     */
    public int updateStockWarehProd(StockWarehProd stockWarehProd) throws Exception;

}
