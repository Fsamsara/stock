package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

import com.metersbonwe.stock.po.sync.TmpSafetyStock;

/**
 * @author zhangjf
 */
public interface TmpSafetyStockDefineMapper {
    /**
     * 获取门店安全库存,去重(不用了)
     * 
     * @return
     */
    List<TmpSafetyStock> selectAllDeleteRepeat();
        
}
