package com.metersbonwe.stock.facade.api;

import java.util.List;

import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.WmsProperty;


/**
 * @author 张洪琴
 * 仓WMS属性变化接口类
 */
public interface WmsPropertyFacade {
	
	/**
	 * 仓WMS属性变化接口：单个数据的写入
	 * @param tmpWmsProperty
	 * @return 写入成功：true，写入失败：false
	 */
	public Message setWmsPropert(WmsProperty wmsProperty);
	
	/**
	 * 仓WMS属性变化接口：单个数据的写入
	 * @param tmpWmsProperty
	 * @return 写入成功：true，写入失败：false
	 */
	public Message setWmsPropertList(List<WmsProperty> wmsPropertyList);
	
	
}
