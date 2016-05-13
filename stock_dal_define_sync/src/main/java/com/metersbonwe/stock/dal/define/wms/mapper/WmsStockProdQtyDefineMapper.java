package com.metersbonwe.stock.dal.define.wms.mapper;

import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.po.wms.WmsStockProdQty;

/**
 * 
 * @author zhangjf
 *
 */
public interface WmsStockProdQtyDefineMapper {

    /**
     * 获取WMS正数锁定量
     * @param map
     * @return
     */
    List<WmsStockProdQty> selectAll(Map<String,Object> map);
}
