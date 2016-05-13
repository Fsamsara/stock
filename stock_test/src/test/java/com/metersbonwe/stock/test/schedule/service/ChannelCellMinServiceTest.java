package com.metersbonwe.stock.test.schedule.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.service.ChannelCellMinService;
import com.metersbonwe.stock.test.TestBase;

public class ChannelCellMinServiceTest extends TestBase {
	
	@Resource
	ChannelCellMinService channelCellMinServiceImpl;
	
	@Test
	public void testHandleChannelCellMinChange(){
		channelCellMinServiceImpl.handleChannelCellMinChange();
	}
}
