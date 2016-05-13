package com.metersbonwe.stock.dal.define.core.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author zhq
 *
 */
public interface StockShopSafeDefineMapper {
    
	/**
	 * 删除无效门店安全库存
	 * @param suffix
	 * @param configValue
	 * @return
	 */
	int deleteInvalid(@Param("warehId")String warehId,@Param("prodId") String prodId );
}