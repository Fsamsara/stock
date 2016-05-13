package com.metersbonwe.stock.dal.define.core.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author zhq
 *
 */
public interface StockWpSafeDefineMapper {
	
	/**
	 * 删除无效仓安全库存（根据仓id、SKU id删除）
	 */
    int deleteInvalid(@Param("warehId")String warehId,@Param("prodId")String prodId);
}