package com.metersbonwe.stock.facade.service;

/**
 * @author zhq
 * @decription 无效污次少洗历史数据删除/无效的门店安全库存删除/无效的仓库安全库存删除定时任务
 * @version V1.0
 * @date 2016/03/28
 */
public interface HandleInvalidHistoryDataService {
	
	/**
	 * 无效污次少洗历史数据删除定时任务
	 */
	public void deleteInvalidShopDame();
	
	/**
	 * 无效的门店安全库存删除定时任务
	 */
	public void deleteInvalidShopSafe();
	
	/**
	 * 无效的仓库安全库存删除定时任务
	 */
	public void deleteInvalidWarehSafe();
}
