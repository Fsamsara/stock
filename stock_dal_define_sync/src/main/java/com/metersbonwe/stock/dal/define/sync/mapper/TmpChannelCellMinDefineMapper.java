package com.metersbonwe.stock.dal.define.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpChannelCellMin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @author 张洪琴
 * TmpChannelCellMinDefineMapper 继承接口 TmpChannelCellMinMapper
 */
@Repository
public interface TmpChannelCellMinDefineMapper {
   
	/**
	 * @param tmpChannelCellMinList 多条数据批量插入数据库
	 * @return 
	 */
	public int insertList(List<TmpChannelCellMin> tmpChannelCellMinList);
	
	/**
	 * 根据渠道、SKU去重查询id、渠道号、商品号
	 * @return
	 */
	public List<TmpChannelCellMin> select();
	
	/**
	 * 删除小于等于当前id的数据
	 * @param maxId
	 * @return
	 */
	public int deleteByMaxId(@Param("maxId")int maxId);
}