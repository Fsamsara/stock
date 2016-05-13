package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

import com.metersbonwe.stock.po.sync.TmpRemailStock;

/**
 * @author 张洪琴
 *
 */
public interface TmpRemailStockDefineMapper {
	
	/**
	 * @param list 批量插入数据
	 * @return
	 */
	public int insertList(List<TmpRemailStock> list);
  
}