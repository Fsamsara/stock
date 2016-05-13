package com.metersbonwe.stock.test.biz.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.WsStockFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.WsStock;
import com.metersbonwe.stock.test.TestBase;

/**
 * @author 张洪琴
 * 仓ws安全库存写入接口测试
 */
public class WsStockFacadeImplTest extends TestBase {
	
	@Resource
	WsStockFacade wsStockFacadeImpl;
	
	@Test
	public void testSetWsStockMessage() throws ParseException{
		//测试数据：
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		WsStock ws = new WsStock();
		ws.setWarehId("A00011S022");
		ws.setWsStock(100);
		ws.setUpdateTime(sdf.parse("2015-04-01 13:10:10"));
		
		WsStock ws1 = new WsStock();
		ws1.setWarehId("A00011S023");
		ws1.setWsStock(100);
		ws1.setUpdateTime(sdf.parse("2015-04-01 13:10:10"));
		
		WsStock ws2 = new WsStock();
		ws2.setWarehId("A00011S024");
		ws2.setWsStock(100);
		ws2.setUpdateTime(sdf.parse("2015-04-01 13:10:10"));
		WsStock ws3 = new WsStock();
		
		//单条数据插入测试：
		Message m1 = this.wsStockFacadeImpl.setWsStockMessage(ws);
		//多条数据插入测试：
		List<WsStock> list = new ArrayList<WsStock>();
		list.add(ws1);
		list.add(ws2);
		list.add(ws3);
		Message m2 = this.wsStockFacadeImpl.setWsStockMessageList(list);
		
		//
		System.out.println("单条数据插入测试："+m1);
		System.out.println("多条数据插入测试："+m2);
		
	}
	
}
