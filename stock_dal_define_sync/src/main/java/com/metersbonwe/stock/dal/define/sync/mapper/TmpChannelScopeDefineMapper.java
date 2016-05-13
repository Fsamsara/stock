package com.metersbonwe.stock.dal.define.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpChannelScope;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @author 张洪琴
 *
 */
@Repository
public interface TmpChannelScopeDefineMapper {
	
	/**
	 *  
	 * @param tmpChannelScopeList 多条tmpChannelScope数据的插入
	 * @return
	 */
	public int insertList(List<TmpChannelScope> tmpChannelScopeList);
}