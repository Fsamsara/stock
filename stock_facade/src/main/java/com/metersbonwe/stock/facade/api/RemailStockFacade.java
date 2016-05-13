package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.RemailStock;

/**
 * @author 张洪琴
 * 未日结接受写入接口
 */
public interface RemailStockFacade {
	
	/**
	 * @param remailStock 未日结接受写入接口：单个数据写入
	 * @return 写入成功：true ,写入失败：false
	 */
	public Message setRemailStock(RemailStock remailStock);
	
	/**
	 * @param remailStock 未日结接受写入接口：单个数据写入
	 * @return 写入成功：true ,写入失败：false
	 */
	public Message setRemailStockList(List<RemailStock> remailStockList);
}
