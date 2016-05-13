package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.ChannelScope;
import com.metersbonwe.stock.facade.api.bean.Message;


/**
 * @author 张洪琴
 *  渠道-仓|店配发范围变化接收接口
 */
public interface ChannelScopeFacade {
	
	/**
	 * 渠道-仓|店配发范围变化接口:【单】个数据变化写入
	 * @param channelScope
	 * @return 写入成功：true，写入失败：false
	 */
	public Message channelScopeChange(ChannelScope channelScope);
	
	/**
	 * 渠道-仓|店配发范围变化接口:【多】个数据变化写入
	 * @param channelScope
	 * @return 写入成功：true，写入失败：false
	 */
	public Message channelScopeChangeList(List<ChannelScope> channelScopeList);
}
