package com.metersbonwe.stock.facade.service;

/**
 * @author 张洪琴
 * @version V1.0
 * @description 轮询检查预售开启、关闭定时任务
 * @date 2016/03/28
 */
public interface CheckPreSaleService {
	
	/**
	 * @description 轮询检查预售开启接口
	 */
	public void checkPreSaleOpen();
	
	/**
	 * @description 轮询检查预售关闭接口
	 */
	public void checkPreSaleClose();
	
}
