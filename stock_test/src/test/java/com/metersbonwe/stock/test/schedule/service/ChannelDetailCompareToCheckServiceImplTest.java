package com.metersbonwe.stock.test.schedule.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.service.ChannelDetailCompareToCheckService;
import com.metersbonwe.stock.test.TestBase;

/**
 * @author zhq
 * 预占明细和渠道信息表总量对比校验定时任务 测试
 */
public class ChannelDetailCompareToCheckServiceImplTest extends TestBase {
	
	@Resource
	ChannelDetailCompareToCheckService channelDetailCompareToCheckServiceImpl;
	
	@Test
	public void testCheckChannelAndDetail(){
		channelDetailCompareToCheckServiceImpl.checkChannelAndDetail();
	}
}
