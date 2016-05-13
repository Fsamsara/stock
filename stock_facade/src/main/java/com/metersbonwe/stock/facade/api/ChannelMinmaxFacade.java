package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.ChannelMinmax;
import com.metersbonwe.stock.facade.api.bean.Message;

/**
 * @author 张洪琴
 * 渠道最大、最小值值变化接收接口
 */
public interface ChannelMinmaxFacade {
	
	/**
	 * @param channelMinmax 渠道最大、最小值值变化接收接口：单个数据写入
	 * @return
	 */
	public Message setChannelMinmax(ChannelMinmax channelMinmax);
	
	/**
	 * @param channelMinmax 渠道最大、最小值值变化接收接口：多个数据写入
	 * @return
	 */
	public Message setChannelMinmaxList(List<ChannelMinmax> channelMinmaxList);
}
