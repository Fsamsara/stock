package com.metersbonwe.stock.dal.define.sync.mapper;

import com.metersbonwe.stock.po.sync.UrUnitReservedResult;

import java.util.List;
import java.util.Map;


public interface UrUnitReservedResultDefineMapper {

    /**
     * 
     * TODO 预留量查询
     * TODO 根据渠道编码、预留类型、仓库编码集合、商品编码集合
     * @param map{unit_id:'',reserved_Type:'',warehList:['',...],skuList:['',...]}
     * @return
     */
    List<UrUnitReservedResult> selectReservedStockByOthers(Map<String,Object> map);

}