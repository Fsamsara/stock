package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;

import com.metersbonwe.stock.po.core.StockChannelOrderDetail;

/**
 * @author zhq
 *
 */
public interface StockChannelOrderDetailDefineMapper {
   
	/**
	 * 查询去重复后的关联渠道(已经自动转换为小写)
	 * @return
	 */
	List<StockChannelOrderDetail> selectRelationChannel();
}