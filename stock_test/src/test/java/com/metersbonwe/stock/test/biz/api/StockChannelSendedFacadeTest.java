package com.metersbonwe.stock.test.biz.api;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.StockChannelSendedFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.StockChannelSendedBean;
import com.metersbonwe.stock.test.TestBase;

public class StockChannelSendedFacadeTest extends TestBase {
	
	@Resource
	StockChannelSendedFacade stockChannelSendedFacadeImpl;
	
	@Test
	public void testSetStockChannelSended(){
		StockChannelSendedBean s = new StockChannelSendedBean();
		s.setAccTime(new Date());
		s.setChannelCode("HQ01S112");
		s.setErrorDetail("mmmmmmm");
		s.setProdId("12345678901");
		s.setStatus("0");
		Message m1 = stockChannelSendedFacadeImpl.setStockChannelSended(s);
		System.out.println("message:"+m1);
	}
}
