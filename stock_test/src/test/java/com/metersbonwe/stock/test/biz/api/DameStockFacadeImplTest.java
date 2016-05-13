package com.metersbonwe.stock.test.biz.api;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.DameStockFacade;
import com.metersbonwe.stock.facade.api.bean.DameStock;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.test.TestBase;

public class DameStockFacadeImplTest extends TestBase{
	
	@Resource
	DameStockFacade dameStockFacadeImpl;
	
	@Test
	public void testSetDameStock(){
		
		//表的权限问题：测试失败
		
		
		//测试数据
		DameStock ds = new DameStock();
		ds.setProdId("20151457136");
		ds.setUpdateTime(new Date());
		ds.setDameStock(100);
		ds.setWarehId("A00012S024");
		ds.setCreateBy("zjf_cr");
		ds.setUpdateTime(new Date());
		ds.setUpdateBy("zjf_up");
		//单条数据插入测试
		Message m1 = this.dameStockFacadeImpl.setDameStock(ds);
		//多条数据插入测试
		/*List<DameStock> list = new ArrayList<DameStock>();
		list.add(ds);
		Message m2 = this.dameStockFacadeImpl.setDameStock(list);*/
		
		//输出结果
		System.out.println("单条数据插入测试:"+m1);
		//System.out.println("多条数据插入测试:"+m2);
	}
}
