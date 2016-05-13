package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.DameStock;
import com.metersbonwe.stock.facade.api.bean.Message;

/**
 * @author 张洪琴
 * 污损值接受写入接口
 */
public interface DameStockFacade {
	
	/**
	 * @param DameStock 污损值接受写入接口：单个数据写入
	 * @return
	 */
	public Message setDameStock(DameStock dameStock);
	
	/**
	 * @param DameStock 污损值接受写入接口：多个数据写入
	 * @return
	 */
	public Message setDameStockList(List<DameStock> dameStockList);
}
