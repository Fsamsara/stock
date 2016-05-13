package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.metersbonwe.stock.po.sync.TmpChannelMinmax;

/**
 * @author 张洪琴
 *
 */
@Repository
public interface TmpChannelMinmaxDefineMapper {
    
	/**
	 * @param list 多条数据插入
	 * @return
	 */
	public int insertList(List<TmpChannelMinmax> list);
	
	/**
	 * 查询根据渠道去重后的 tmp_channel_minmax临时表数据 (已转化为小写)
	 * @return
	 */
	public List<TmpChannelMinmax> select();
	
	/**
	 * 根据提供的最大Id，删除小于等于当前ID的值
	 * @param maxId
	 * @return
	 */
	public int deleteByMaxId(@Param("maxId")int maxId);
}