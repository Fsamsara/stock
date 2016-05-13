package com.metersbonwe.stock.test.biz.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.WarehIsSyncOsFacade;
import com.metersbonwe.stock.facade.api.bean.ChannelScope;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.test.TestBase;

public class WarehIsSyncOsFacadeImplTest extends TestBase {
	
	@Resource
	WarehIsSyncOsFacade warehIsSyncOsFacadeImpl;
	
	@Test
	public void testSarehIsSynchronousOs() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//测试数据：
		ChannelScope cs = new ChannelScope();
		cs.setChannelCode("HQ01S113");
		cs.setScopeChange("1");
		cs.setUpdateTime(sdf.parse("2013-12-12 12:12:12"));
		cs.setWarehId("A00011S023");
		cs.setWarehState("1");
		
		ChannelScope cs1 = new ChannelScope();
		cs1.setChannelCode("HQ01S114");
		cs1.setScopeChange("1");
		cs1.setUpdateTime(sdf.parse("2013-12-12 12:12:12"));
		cs1.setWarehId("A00011S023");
		cs1.setWarehState("1");
		
		ChannelScope cs2 = new ChannelScope();
		
		//单条数据插入测试：
		Message m1 = warehIsSyncOsFacadeImpl.warehIsSynchronousOs(cs);
		//多条数据插入测试：
		List<ChannelScope> list = new ArrayList<ChannelScope>();
		list.add(cs1);
		list.add(cs2);
		Message m2 = warehIsSyncOsFacadeImpl.warehIsSynchronousOsList(list);
		
		//测试结果输出：
		System.out.println("单条数据插入测试："+m1);
		System.out.println("多条数据插入测试："+m2);
	}
}
