package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.StockChannelSendedBean;

/**
 * @author zhq
 * 推送线上回写接口
 */
public interface StockChannelSendedFacade {
	
	/**
	 * TODO 设置推送线上回写的消息
	 * @param stockChannelSendedBean
	 * @return
	 */
	public Message setStockChannelSended(StockChannelSendedBean stockChannelSendedBean);
	
	/**
	 * TODO 设置推送线上回写的消息
	 * @param stockChannelSended
	 * @return
	 */
	public Message setStockChannelSendedList(List<StockChannelSendedBean> stockChannelSendedList);
}
