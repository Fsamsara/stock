package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.metersbonwe.stock.po.core.StockWarehProd;

/**
 * @author zhq
 *
 */
public interface ErpWarehProdDefineMapper {
	
	/**
	 * 查询新ERP中仓或者门店的ID和SKUID：查询实际库存为0，且（最后操作时间+有效时间小于当前时间的 、或最后操作时间为空的）
	 * @param isShop
	 * @param configValue
	 * @return
	 */
	List<StockWarehProd> selectNewErpWarehIdAndSku(@Param("isShop") String isShop,@Param("configValue") int configValue);
	
	/**
	 * 查询老ERP中 仓或者门店的ID和SKUID：查询实际库存为0，且（最后操作时间+有效时间小于当前时间的 、或最后操作时间为空的）
	 * @param isShop
	 * @param configValue
	 * @return
	 */
	List<StockWarehProd> selectOldErpWarehIdAndSku(@Param("isShop") String isShop,@Param("configValue") int configValue);
}
