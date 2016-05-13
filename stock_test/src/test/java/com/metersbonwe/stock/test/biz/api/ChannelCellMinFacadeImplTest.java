package com.metersbonwe.stock.test.biz.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.ChannelCellMinFacade;
import com.metersbonwe.stock.facade.api.bean.ChannelCellMin;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.test.TestBase;

/**
 * @author 张洪琴
 * 渠道单元最小值变化接收接口实现类测试
 */
public class ChannelCellMinFacadeImplTest extends TestBase{
	
	@Resource
	ChannelCellMinFacade channelCellMinFacadeImpl;
	
	@Test
	public void testSetChannelCellMin(){
		//测试数据：
		ChannelCellMin cc = new ChannelCellMin();
		cc.setChannelCellMin(20);
		cc.setChannelCode("HQ01S112");
		cc.setProdId("12345678901");
		cc.setUpdateTime(new Date());
		
		//单条数据插入测试：
		Message m1 = this.channelCellMinFacadeImpl.setChannelCellMin(cc);
		
		//多条数据插入测试：
		List<ChannelCellMin> list =  new ArrayList<ChannelCellMin>();
		list.add(cc);
		Message m2 = this.channelCellMinFacadeImpl.setChannelCellMinList(list);
		
		//测试结果输出：
		System.out.println("单条数据插入测试结果："+m1);
		System.out.println("\n多条数据插入测试结果："+m2);

	}
	
}
