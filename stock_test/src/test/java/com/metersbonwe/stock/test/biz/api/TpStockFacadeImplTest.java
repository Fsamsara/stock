package com.metersbonwe.stock.test.biz.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.TpStockFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.TpStock;
import com.metersbonwe.stock.test.TestBase;

/**
 * @author 张洪琴
 * 第三方自由量写入接口测试
 */
public class TpStockFacadeImplTest extends TestBase{
	
	@Resource
	TpStockFacade tpStockFacadeImpl;
	
	@Test
	public void testSetTpStock() throws ParseException{
		//测试数据
		TpStock ts = new TpStock();
		ts.setProdId("27182499139");
		ts.setTpStock(100);
		ts.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-11-11 11:11:11"));
		ts.setWarehId("A00011S022");
		
		TpStock ts1 = new TpStock();
		ts1.setProdId("27182499139");
		ts1.setTpStock(100);
		ts1.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-11-11 11:11:11"));
		ts1.setWarehId("A00011S023");
		
		TpStock ts2 = new TpStock();
		ts2.setProdId("27182499139");
		ts2.setTpStock(100);
		ts2.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-11-11 11:11:11"));
		ts2.setWarehId("A00011S024");
		
		
		//
		Message m1 = this.tpStockFacadeImpl.setTpStock(ts);
		//
		List<TpStock> list = new ArrayList<TpStock>();
		list.add(ts1);
		list.add(ts2);
		Message m2 = this.tpStockFacadeImpl.setTpStockList(list);
		
		//没有错误信息时，数据插入成功
		System.out.println("m1:"+m1);
		System.out.println("m2:"+m2);
	}
}
