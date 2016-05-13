package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.metersbonwe.stock.po.sync.TmpTpStock;

/**
 * @author 张洪琴
 * 
 */
@Repository
public interface TmpTpStockDefineMapper {
    
	/**
	 * @param list 批量插入数据到Tmp_Tp_Stock
	 * @return
	 */
	public int insertList(List<TmpTpStock> list);
}