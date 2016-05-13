package com.metersbonwe.stock.test.schedule.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.dal.define.core.mapper.StockChannelOrderDetailDefineMapper;
import com.metersbonwe.stock.po.core.StockChannelOrderDetail;
import com.metersbonwe.stock.test.TestBase;

public class StockChannelOrderDetailDefineMapperTest extends TestBase {
	
	@Resource
	StockChannelOrderDetailDefineMapper stockChannelOrderDetailDefineMapper;
	
	@Test
	public void test(){
		List<StockChannelOrderDetail> list =  stockChannelOrderDetailDefineMapper.selectRelationChannel();
		for (StockChannelOrderDetail d : list) {
			System.out.println(d.getRelationChannel()+"..");
		}
	}
}
