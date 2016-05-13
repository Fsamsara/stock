package com.metersbonwe.stock.test.biz.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.StockChannelStatusFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.StockChannelStatusBean;
import com.metersbonwe.stock.test.TestBase;

/**
 * @author zhq
 * 渠道+款进货(渠道+款上下架是否同步)接口
 */
public class StockChannelStatusFacadeImplTest extends TestBase {
	
	@Resource
	StockChannelStatusFacade stockChannelStatusFacadeImpl;
	
	@Test
	public void testSetStockChannelStatus(){
		//测试数据：
		StockChannelStatusBean s = new StockChannelStatusBean();
		s.setChannelCode("HQ01S112");
		s.setCreateBy("XL");
		s.setCreateTime(new Date());
		s.setIsSync( new Byte("1") );
		s.setSaleStatus("1");
		s.setSixProdId("123456");
		s.setUpdateBy("ALEN");
		s.setUpdateTime(new Date());
		
		StockChannelStatusBean s1 = new StockChannelStatusBean();
		s1.setChannelCode("HQ01S113");
		s1.setCreateBy("XL");
		s1.setCreateTime(new Date());
		s1.setIsSync( new Byte("1") );
		s1.setSaleStatus("1");
		s1.setSixProdId("123456");
		s1.setUpdateBy("ALEN");
		s1.setUpdateTime(new Date());
		
		StockChannelStatusBean s2 = new StockChannelStatusBean();
		
		
		List<StockChannelStatusBean> list = new ArrayList<StockChannelStatusBean>();
		list.add(s);
		list.add(s1);
		list.add(s2);
		
		//单条数据测试：
	//	Message m1 = this.stockChannelStatusFacadeImpl.setStockChannelStatus(s);	
		
		Message m2 = this.stockChannelStatusFacadeImpl.setStockChannelStatusList(list);	
		//
	//	System.out.println("单条数据测试："+m1);
		System.out.println("单条数据测试："+m2);
	}

}
