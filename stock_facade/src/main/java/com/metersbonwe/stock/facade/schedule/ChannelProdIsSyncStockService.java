package com.metersbonwe.stock.facade.schedule;

/**
 * @author 张洪琴
 * @version V1.0
 * @description 渠道+款上下架是否同步进货与否定时对比调度任务接口
 * @date 2016/03/28
 */
public interface ChannelProdIsSyncStockService {
	
	/**
	 * @description 渠道+款上下架是否同步进货与否定时对比  将查询到的渠道+SKU明细信息推送到线上MQ队列
	 */
	public void timedTaskChannelProdIsSyncStock();
}
