package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.Map;

import com.metersbonwe.stock.po.core.StockShopRemail;

/**
 * 
 * @author zhangjf
 *
 */
public interface StockShopRemailTranDefineMapper {

    /**
     * 根据仓库ID，日结时间插入事务
     * @param map
     * @return
     */
    int insertDataByWarehIdRemailTime(Map<String,Object> map);
    
    /**
     * 新增记录
     * @param stockShopRemailTran
     * @return
     */
    int insertData (StockShopRemail stockShopRemail);
}
