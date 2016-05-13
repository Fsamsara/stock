package com.metersbonwe.stock.test.biz.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.RemailedStockFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.RemailedStock;
import com.metersbonwe.stock.test.TestBase;

/**
 * @author 张洪琴
 * 门店日结接口实现类测试
 */
public class RemailedStockFacadeImplTest extends TestBase{
	
	@Resource
	RemailedStockFacade remailedStockFacadeImpl;
	
	@Test
	public void testSetRemailedStock(){
		
		//测试数据：
		RemailedStock rs = new RemailedStock();
		rs.setRemailDate(new Date());
		rs.setUpdateTime(new Date());
		rs.setWarehId("A00012S024");
		
		RemailedStock rs1 = new RemailedStock();
		rs1.setRemailDate(new Date());
		rs1.setUpdateTime(new Date());
		rs1.setWarehId("A00012S024");
		
		//单条数据插入测试：
		Message m1 = this.remailedStockFacadeImpl.setRemailedStock(rs);		
		//单条数据插入测试：
		List<RemailedStock> list = new ArrayList<RemailedStock>();
		list.add(rs1);
		list.add(rs);
		Message m2 = this.remailedStockFacadeImpl.setRemailedStockList(list);
		
		//
		System.out.println("单条数据插入测试："+m1);
		System.out.println("多条数据插入测试："+m2);
	}
}
