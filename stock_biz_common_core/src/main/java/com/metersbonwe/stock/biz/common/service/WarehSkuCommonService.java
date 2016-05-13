package com.metersbonwe.stock.biz.common.service;

/**
 * 
 * 仓库+SKU表公用方法
 * 
 * @author 张瑞雨
 * 
 */
public interface WarehSkuCommonService {

	/**
	 * 当更新仓库SKU表的数据发现数据不存在的时候
	 * 重新插入SKU数据
	 * @param warehId 仓库ID
	 * @param sku 11位码
	 * @return 
	 */
	int insertWarehSkuWithout(String warehId, String sku);

}
