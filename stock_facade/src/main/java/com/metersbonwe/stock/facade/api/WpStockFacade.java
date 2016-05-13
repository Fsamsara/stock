package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.WpStock;

/**
 * @author 张洪琴
 * 仓WP安全库存接受写入接口
 */
public interface WpStockFacade {
	
	/**
	 * @param WpStock 单条数据对象的插入
	 * @return 数据插入成功：true,失败：false
	 */
	public Message setWpStock(WpStock wpStock);
	
	/**
	 * @param WpStock 多条数据对象的插入
	 * @return 数据插入成功：true,失败：false
	 */
	public Message setWpStockList(List<WpStock> wpStockList);
	
}
