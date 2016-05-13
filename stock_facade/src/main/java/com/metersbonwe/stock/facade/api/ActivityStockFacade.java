package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.ActivityStock;
import com.metersbonwe.stock.facade.api.bean.Message;

/**
 * @author 张洪琴
 * 活动期间渠道商品推送独占量接收接口
 */
public interface ActivityStockFacade {
	
	/**
	 * @param activityStock 活动期间渠道商品推送独占量接收接口：单个数据写入
	 * @return
	 */
	public Message setActivityStock(ActivityStock activityStock);
	
	/**
	 * @param activityStock 活动期间渠道商品推送独占量接收接口：单个数据写入
	 * @return
	 */
	public Message setActivityStockList(List<ActivityStock> activityStockList);
}
