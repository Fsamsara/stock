package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

import com.metersbonwe.stock.po.sync.TmpRemailedStock;

/**
 * @author zhangjf
 */
public interface TmpRemailedStockDefineMapper {

    /**
     * TMP_REMAILED_STOCK 门店日结临时表,根据店仓ID去重
     * @return
     */
    List<TmpRemailedStock> selectAllDeleteRepeat();
    
    /**
     * @param list 批量插入数据到TMP_REMAILED_STOCK
     * @return
     */
    public int insertList(List<TmpRemailedStock> list);
}
