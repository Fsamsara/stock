package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.ShopSafeStock;

/**
 * @author 张洪琴
 * 门店安全库存接受写入接口
 */
public interface ShopSafeStockFacade {
	
	/**
	 * @param shopSafeStock 门店安全库存接受写入接口：单条数据的写入
	 * @return
	 */
	public Message setShopSafeStock(ShopSafeStock shopSafeStock);
	
	/**
	 * @param shopSafeStock 门店安全库存接受写入接口：多条数据的写入
	 * @return
	 */
	public Message setShopSafeStockList(List<ShopSafeStock> shopSafeStockList);
	
}
