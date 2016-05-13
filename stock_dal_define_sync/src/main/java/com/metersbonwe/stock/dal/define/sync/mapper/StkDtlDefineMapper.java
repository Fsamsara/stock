package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.dal.auto.sync.mapper.StkDtlMapper;
import com.metersbonwe.stock.po.sync.StkDtl;

public interface StkDtlDefineMapper extends StkDtlMapper {
    
    /**
     * 
     * TODO 查询门店货位库存(根据货位查询)
     * TODO 根据门店编码、货位编码集合、商品编码集合查询门店货位库存
     * @param map  【warehId:'',locList:['',...],skuList:['',...]】
     * @return
     */
    List<StkDtl> selectStkDtlByOthers(Map<String, Object> map);
    
    /**
     * 
     * TODO 查询门店货位库存(不根据货位查询)
     * TODO 根据门店编码、商品编码集合查询门店货位库存
     * @param map  【warehId:'',skuList:['',...]】
     * @return
     */
    List<StkDtl> selectStkDtlByOthersAndNoLoc(Map<String, Object> map);
    
}
