package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.WsStock;


/**
 * @author 张洪琴
 * 仓ws安全库存写入接口
 */
public interface WsStockFacade {
	
	/**
	 * ws仓库安全库存写入接口(单个仓ws安全库存数据写入)
	 * @param tmpWsStock
	 * @return 写入成功：true，写入失败：false
	 */
	public Message setWsStockMessage(WsStock wsStock);
	
	/**
	 * ws仓库安全库存写入接口(多个仓ws安全库存数据写入)
	 * @param tmpWsStockList
	 * @return 写入成功：true，写入失败：false
	 */
	public Message setWsStockMessageList(List<WsStock> wsStockList);
}
