package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.ChannelCellMin;
import com.metersbonwe.stock.facade.api.bean.Message;

/**
 * @author 张洪琴
 * 渠道单元最小值变化接收接口
 */
public interface ChannelCellMinFacade {
	
	/**
	 * @param channelCellMin 渠道单元最小值变化接收接口：单个数据写入
	 * @return
	 */
	public Message setChannelCellMin(ChannelCellMin channelCellMin);
	
	/**
	 * @param channelCellMin 渠道单元最小值变化接收接口：单个数据写入
	 * @return
	 */
	public Message setChannelCellMinList(List<ChannelCellMin> channelCellMinList);
}
