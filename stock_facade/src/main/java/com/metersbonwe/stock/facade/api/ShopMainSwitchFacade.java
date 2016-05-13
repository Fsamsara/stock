package com.metersbonwe.stock.facade.api;

import com.metersbonwe.stock.facade.api.bean.Message;

/**
 * @author 张洪琴
 *  门店总开关变化写入接口
 *
 */
public interface ShopMainSwitchFacade {
	
	/**
	 * 门店总开关变化接收接口:
	 * @param warehState (0:关闭，1：打开)
	 * @return 写入成功：true，写入失败：false
	 */
	public Message shopMainSwitch(String warehState);
	
}
