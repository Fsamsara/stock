package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

import com.metersbonwe.stock.po.sync.TmpSafeTypeStock;

/**
 * @author 张洪琴
 *
 */
public interface TmpSafeTypeStockDefineMapper {
	
    /**
     * @param tmpSafeTypeStockList 批量插入数据到 STOCK_USER.TMP_SAFE_TYPE_STOCK表
     * @return
     */
    int insertList(List<TmpSafeTypeStock> tmpSafeTypeStockList);
}