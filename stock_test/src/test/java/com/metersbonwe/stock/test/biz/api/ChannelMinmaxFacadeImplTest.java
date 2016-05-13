package com.metersbonwe.stock.test.biz.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.ChannelMinmaxFacade;
import com.metersbonwe.stock.facade.api.bean.ChannelMinmax;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.test.TestBase;

/**
 * @author 张洪琴
 * 渠道最大、最小值值变化接收接口实现类测试
 */
public class ChannelMinmaxFacadeImplTest extends TestBase {
	
	@Resource
	ChannelMinmaxFacade channelMinmaxFacadeImpl;
	
	
	@Test
	public void testSetChannelMinmax(){
		//测试数据：
		ChannelMinmax cm = new ChannelMinmax();
		cm.setChannelCode("HQ01S112");
		cm.setUpdateTime(new Date());
		
		ChannelMinmax cm1 = new ChannelMinmax();
		cm1.setChannelCode("HQ01S113");
		cm1.setUpdateTime(new Date());
		
		ChannelMinmax cm2 = new ChannelMinmax();
		cm2.setChannelCode("HQ01S114");
		cm2.setUpdateTime(new Date());
		
		//单条数据插入测试：
		Message m1 = this.channelMinmaxFacadeImpl.setChannelMinmax(cm);
		//多条数据插入测试：
		List<ChannelMinmax> list = new ArrayList<ChannelMinmax>();
		list.add(cm1);
		list.add(cm2);
		Message m2 = this.channelMinmaxFacadeImpl.setChannelMinmaxList(list);
		
		//输出结果
		System.out.println("单条数据插入测试结果："+m1);
		System.out.println("多条数据插入测试结果："+m2);
		
		
		
	}
	
}
