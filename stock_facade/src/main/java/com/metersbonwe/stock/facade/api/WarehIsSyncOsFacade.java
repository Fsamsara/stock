package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.ChannelScope;
import com.metersbonwe.stock.facade.api.bean.Message;

/**
 * @author 张洪琴
 *  仓是否同步OS变化接口
 *
 */
public interface WarehIsSyncOsFacade {
	
	/**
	 * 仓是否同步os变化接口:【单】数据变化的写入
	 * @param channelScope
	 * @return 写入成功：true，写入失败：false
	 */
	public Message warehIsSynchronousOs(ChannelScope channelScope);
	
	/**
	 * 仓是否同步os变化接口:【多】数据变化的写入
	 * @param channelScope
	 * @return 写入成功：true，写入失败：false
	 */
	public Message warehIsSynchronousOsList(List<ChannelScope> channelScopeList);
	
}
