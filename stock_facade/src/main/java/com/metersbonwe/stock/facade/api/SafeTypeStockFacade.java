package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.SafeTypeStock;

/**
 * @author 张洪琴
 * 仓安全类型变化写入接口
 */
public interface SafeTypeStockFacade {
 
	/**
	 * 单个的仓安全类型变化写入接口：
	 * @param safeTypeStock
	 * @return
	 */
	public Message setSafeTypeStock(SafeTypeStock safeTypeStock);
	
	/**
	 * 多个的仓安全类型变化写入接口：
	 * @param safeTypeStock
	 * @return
	 */
	public Message setSafeTypeStockList(List<SafeTypeStock> safeTypeStockList);
	
	
}
