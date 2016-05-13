package com.metersbonwe.stock.test.biz.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.dal.auto.sync.mapper.TmpChannelScopeMapper;
import com.metersbonwe.stock.facade.api.ChannelScopeFacade;
import com.metersbonwe.stock.facade.api.bean.ChannelScope;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.test.TestBase;

public class ChannelScopeFacadeImplTest extends TestBase {
	
	@Resource
	ChannelScopeFacade channelScopeFacadeImpl;
	@Resource
	TmpChannelScopeMapper tmpChannelScopeMapper;
	
	@Test
	public void testChannelScopeChange(){
		
		//测试数据
		ChannelScope cs = new ChannelScope();
		cs.setChannelCode("HQ01S112");
		cs.setScopeChange("1");
		cs.setUpdateTime(new Date());
		cs.setWarehId("A00012S024");
		cs.setWarehState("1");
		
		ChannelScope cs1 = new ChannelScope();
		cs1.setChannelCode("HQ01S113");
		cs1.setScopeChange("1");
		cs1.setUpdateTime(new Date());
		cs1.setWarehId("A00012S024");
		cs1.setWarehState("1");
		
		
		//单条数据插入测试：
		Message m1 = this.channelScopeFacadeImpl.channelScopeChange(cs);
		//多条数据插入：
		List<ChannelScope> list = new ArrayList<ChannelScope>();
		list.add(cs1);
		Message m2 = this.channelScopeFacadeImpl.channelScopeChangeList(list);
		
		//测试结果输出：
		System.out.println("单条数据插入测试:"+m1);
		System.out.println("多条数据插入测试:"+m2);
		
	}
	
}
