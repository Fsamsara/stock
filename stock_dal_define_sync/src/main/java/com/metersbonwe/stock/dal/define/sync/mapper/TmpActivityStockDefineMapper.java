package com.metersbonwe.stock.dal.define.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpActivityStock;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @author 张洪琴
 * TmpActivityStockDefineMapper 继承 TmpActivityStockMapper
 */
@Repository
public interface TmpActivityStockDefineMapper {
    
	/**
	 * @param tmpActivityStockList 多条数据批量插入
	 * @return 插入的数量 
	 */
	public int insertList(List<TmpActivityStock> tmpActivityStockList);
	
}