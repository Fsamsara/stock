package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.RemailedStock;

/**
 * @author 张洪琴
 * 门店日结接口
 */
public interface RemailedStockFacade {
	
	/**
	 * @param remailedStock 门店日结接口：单个数据写入
	 * @return 写入成功：true，写入失败：false
	 */
	public Message setRemailedStock(RemailedStock remailedStock);
	
	/**
	 * @param remailedStock 门店日结接口：多个数据写入
	 * @return 写入成功：true，写入失败：false
	 */
	public Message setRemailedStockList(List<RemailedStock> remailedStockList);
}
