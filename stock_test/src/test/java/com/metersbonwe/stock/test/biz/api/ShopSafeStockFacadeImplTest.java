package com.metersbonwe.stock.test.biz.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.ShopSafeStockFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.ShopSafeStock;
import com.metersbonwe.stock.test.TestBase;

/**
 * @author 张洪琴
 *  门店安全库存接受写入接口测试
 */
public class ShopSafeStockFacadeImplTest extends TestBase{
	
	@Resource
	ShopSafeStockFacade shopSafeStockFacadeImpl;
	
	@Test
	public void testSetShopSafeStock() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//测试数据：
		ShopSafeStock s = new ShopSafeStock();
		s.setProdId("20557900144");
		s.setShopSafeStock(100);
		s.setUpdateTime(sdf.parse("2015-03-03 18:18:18"));
		s.setWarehId("A00011S023");
		
		ShopSafeStock s1 = new ShopSafeStock();
		s1.setProdId("20557900144");
		s1.setShopSafeStock(100);
		s1.setUpdateTime(sdf.parse("2016-03-03 18:18:18"));
		s1.setWarehId("A00011S022");
		
		ShopSafeStock s2 = new ShopSafeStock();
		s2.setProdId("20557900144");
		s2.setShopSafeStock(100);
		s2.setUpdateTime(sdf.parse("2016-04-03 18:18:18"));
		s2.setWarehId("A00011S024");
		
		//单个数据插入测试
		Message m1 = this.shopSafeStockFacadeImpl.setShopSafeStock(s);
		//多个数据插入测试
		List<ShopSafeStock> list = new ArrayList<ShopSafeStock>();
		list.add(s1);
		list.add(s2);
		Message m2 = this.shopSafeStockFacadeImpl.setShopSafeStockList(list);
		
		//
		System.out.println("单个数据插入测试:"+m1);
		System.out.println("多个数据插入测试:"+m2);
		
	}
}
