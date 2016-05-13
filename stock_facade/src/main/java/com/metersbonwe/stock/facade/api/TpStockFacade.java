package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.TpStock;

/**
 * @author 张洪琴
 * 第三方自由量写入接口
 */
public interface TpStockFacade {
	
	/**
	 * 第三方自由量写入接口：【单】条数据写入
	 * @param tmpTpStock
	 * @return 写入成功：true，写入失败：false
	 */
	public Message setTpStock(TpStock tpStock);
	
	/**
	 * 第三方自由量写入接口：【多】条数据写入
	 * @param tmpTpStock
	 * @return 写入成功：true，写入失败：false
	 */
	public Message setTpStockList(List<TpStock> tStockList);
}
