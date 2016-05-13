package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
@SuppressWarnings("rawtypes")
public interface FreeAndLockStockDefineMapper {

	/**
	 * 新erp查询自由量和锁定量
	 * 
	 * @param warehId
	 *            仓库ID
	 * @param sku
	 *            SKU
	 * @return
	 */
	
	List<Map> selectFreeAndLockedStockNewErp(
			@Param("warehId") String warehId, @Param("sku") String sku);

	/**
	 * 老erp查询自由量和锁定量
	 * 
	 * @param warehId
	 *            仓库ID
	 * @param sku
	 *            SKU
	 * @return
	 */
	List<Map> selectFreeAndLockedStockOldErp(
			@Param("warehId") String warehId, @Param("sku") String sku);

}
