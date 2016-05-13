package com.metersbonwe.stock.test.biz.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.WpStockFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.WpStock;
import com.metersbonwe.stock.test.TestBase;

public class WpStockFacadeImplTest extends TestBase{
	
	@Resource
	WpStockFacade wpStockFacadeImpl;
	
	@Test
	public void testSetWpStock() throws ParseException{
		//
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		WpStock wp = new WpStock();
		wp.setWarehId("A00012S024");
		wp.setProdId("20152603135");
		wp.setUpdateTime(sdf.parse("2015-11-11 11:11:11"));
		wp.setWpStock(100);
		
		WpStock wp1 = new WpStock();
		wp1.setWarehId("A00012S024");
		wp1.setProdId("20152603136");
		wp1.setUpdateTime(sdf.parse("2015-11-11 11:11:11"));
		wp1.setWpStock(100);
		
		WpStock wp2 = new WpStock();
		wp2.setWarehId("A00012S024");
		wp2.setProdId("20152603137");
		wp2.setUpdateTime(sdf.parse("2015-11-11 11:11:11"));
		wp2.setWpStock(100);
		
		WpStock wp3 = new WpStock();
		//单条数据测试：
		Message m1 = this.wpStockFacadeImpl.setWpStock(wp);
		//多条数据测试：
		List<WpStock> list = new ArrayList<WpStock>();
		list.add(wp1);
		list.add(wp2);
		list.add(wp3);
		
		Message m2 = this.wpStockFacadeImpl.setWpStockList(list);
		
		//
		System.out.println("单条数据测试："+m1);
		System.out.println("多条数据测试："+m2);
		
	}
}
