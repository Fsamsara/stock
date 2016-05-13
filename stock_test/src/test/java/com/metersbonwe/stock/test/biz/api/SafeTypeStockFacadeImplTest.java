package com.metersbonwe.stock.test.biz.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.SafeTypeStockFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.SafeTypeStock;
import com.metersbonwe.stock.test.TestBase;

/**
 * @author 张洪琴
 * 仓安全类型变化写入接口实现类测试
 */
public class SafeTypeStockFacadeImplTest extends TestBase{
	
	@Resource
	SafeTypeStockFacade safeTypeStockFacadeImpl;
	
	@Test
	public void testSetSafeTypeStock(){
		//测试数据：
		SafeTypeStock sts = new SafeTypeStock();
		sts.setSafeType("ws");
		sts.setUpdateTime(new Date());
		sts.setWarehId("A00012S024");
		
		SafeTypeStock sts1 = new SafeTypeStock();
		sts1.setSafeType("ws");
		sts1.setUpdateTime(new Date());
		sts1.setWarehId("A00011S022");
		
		SafeTypeStock sts2 = new SafeTypeStock();
		sts2.setSafeType("ws");
		sts2.setUpdateTime(new Date());
		sts2.setWarehId("A00011S023");
		
		//单条数据插入测试：
		Message m1 = this.safeTypeStockFacadeImpl.setSafeTypeStock(sts);
		//多条数据插入测试：
		List<SafeTypeStock> list = new ArrayList<SafeTypeStock>();
		list.add(sts1);
		list.add(sts2);
		Message m2 = this.safeTypeStockFacadeImpl.setSafeTypeStockList(list);
		
		//测试结果输出：
		System.out.println("单条数据插入测试："+m1);
		System.out.println("多条数据插入测试："+m2);
	}
}
