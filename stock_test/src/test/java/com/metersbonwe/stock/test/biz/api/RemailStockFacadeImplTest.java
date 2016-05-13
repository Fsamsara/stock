package com.metersbonwe.stock.test.biz.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.RemailStockFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.RemailStock;
import com.metersbonwe.stock.test.TestBase;

/**
 * @author 张洪琴
 * 未日结接受写入接口测试
 */
public class RemailStockFacadeImplTest extends TestBase {
	
	@Resource
	RemailStockFacade remailStockFacadeImpl;
	
	@Test
	public void testSetRemailStock(){
		//测试数据：
		RemailStock rs = new RemailStock();
		rs.setProdId("20151499136");
		rs.setRemailStock(11);
		rs.setUpdateTime(new Date());
		rs.setWarehId("A00012S024");
		rs.setLocId("l1");
		rs.setRllNum("rlnum");
		//单条数据插入测试：
		Message m1 = this.remailStockFacadeImpl.setRemailStock(rs);
		//多条数据插入测试：
		List<RemailStock> list = new ArrayList<RemailStock>();
		list.add(rs);
		Message m2 = this.remailStockFacadeImpl.setRemailStock(rs);
		
		//
		System.out.println("单条数据插入测试："+m1);
		System.out.println("多条数据插入测试："+m2);
		
	}
}
