package com.metersbonwe.stock.dal.define.sync.mapper;

import com.metersbonwe.stock.dal.auto.sync.mapper.SfWarehLockedLstMapper;
import com.metersbonwe.stock.po.sync.define.SfWarehLockedLstDefine;

import java.util.List;
import java.util.Map;

public interface SfWarehLockedLstDefineMapper extends SfWarehLockedLstMapper {

    /**
     * 
     * TODO 锁定量查询
     * TODO 根据预留类型集合、仓库编码集合、商品编码集合查询锁定量
     * @param map{reservedTypeList:['',...],warehList:['',...],skuList:['',...]}
     * @return
     */
    List<SfWarehLockedLstDefine> selectLockStockByOthers(Map<String,Object> map);
    
    /**
     * 
     * TODO 锁定量查询
     * TODO 根据预留类型集合、仓库编码集合、商品编码集合查询锁定量
     * @param map{warehList:['',...],skuList:['',...]}
     * @return
     */
    List<SfWarehLockedLstDefine> selectLockStockByOthersNoInLockedType(Map<String,Object> map);
    
}