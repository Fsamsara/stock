package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.Map;

/**
 * @author zhangjf
 */
public interface TmpStockWmsBakDefineMapper {
    /**
     * 清空表tmp_stock_wms_bak
     */
    void truncateTable();

    /**
     * 插入临时表数据
     * 
     * @param map
     * @return
     */
    int insertToTmpStockWms(Map<String, Object> map);
}
