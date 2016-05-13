package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.ShopProperty;

/**
 * @author zhq
 *  门店属性变化接收接口（是否同步）
 */
public interface ShopPropertyFacade {
	
	/**
	 * 单个门店属性的变化
	 * @param shopProperty
	 * @return
	 */
	public Message setShopProperty(ShopProperty shopProperty);
	
	/**
	 * 多个门店属性的变化
	 * @param shopProperty
	 * @return
	 */
	public Message setShopPropertyList(List<ShopProperty> shopPropertyList);
}
