package com.metersbonwe.stock.test.biz.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.dal.auto.sync.mapper.TmpActivityStockMapper;
import com.metersbonwe.stock.facade.api.ActivityStockFacade;
import com.metersbonwe.stock.facade.api.bean.ActivityStock;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.test.TestBase;

/**
 * @author 张洪琴 活动期间渠道商品推送独占量接收接口实现类测试
 */
public class ActivityStockFacadeImplTest extends TestBase {
	
	@Resource
	ActivityStockFacade activityStockFacadeImpl;
	@Resource 
	TmpActivityStockMapper tmpActivityStockMapper;
	
	@Test
	public void testSetActivityStock() {
		// 测试数据
		ActivityStock activityStock = new ActivityStock();

		activityStock.setChannelCode("HQ01S224");
		activityStock.setProdId("10104668030");
		activityStock.setUpdateTime(new Date());

		//
		List<ActivityStock> list = new ArrayList<ActivityStock>();
		activityStock.setChannelCode("HQ01S113");
		list.add(activityStock);
		// 单个数据插入测试
//		Message m1 = this.activityStockFacadeImpl.setActivityStock(activityStock);
		//多个数据插入的测试：
		Message m2 = this.activityStockFacadeImpl.setActivityStockList(list);
		
//		System.out.println("单个数据插入测试:"+m1);
		System.out.println("多个数据插入测试:"+m2);

	}
	
}
