package com.metersbonwe.stock.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.dal.define.core.mapper.StockChannelProdDetailDefineMapper;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;

public class StockChannelProdDetailDefineMapperTest extends TestBase {
	
	@Resource
	StockChannelProdDetailDefineMapper stockChannelProdDetailDefineMapper;
	
	@Test
	public void test(){
		List<ChannelProdBean> list = stockChannelProdDetailDefineMapper.selectByChannelCode("hq01s113");
		System.out.println("\nlist:"+list.size()+"\n");
	}
}
