package com.metersbonwe.stock.test.biz.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.WmsPropertyFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.WmsProperty;
import com.metersbonwe.stock.test.TestBase;

public class WmsPropertyFacadeImplTest extends TestBase {
	
	@Resource
	WmsPropertyFacade wmsPropertyFacadeImpl;
	
	@Test
	public void testSetWmsPropert() throws ParseException{
		//测试数据：
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		WmsProperty wms = new WmsProperty();
		wms.setUpdateTime(sdf.parse("2014-01-01 19:12:12"));
		wms.setUsedMa("1");
		wms.setWarehId("A00011S022");
		
		WmsProperty wms1 = new WmsProperty();
		wms1.setUpdateTime(sdf.parse("2014-01-01 19:12:12"));
		wms1.setUsedMa("1");
		wms1.setWarehId("A00011S023");
		
		WmsProperty wms2 = new WmsProperty();
		wms2.setUpdateTime(sdf.parse("2014-01-01 19:12:12"));
		wms2.setUsedMa("1");
		wms2.setWarehId("A00011S024");
		
		WmsProperty wms3 = new WmsProperty();
		//单条数据插入测试：
		Message m1 = this.wmsPropertyFacadeImpl.setWmsPropert(wms);
		//
		List<WmsProperty> list = new ArrayList<WmsProperty>();
		list.add(wms1);
		list.add(wms2);
		list.add(wms3);
		Message m2 = this.wmsPropertyFacadeImpl.setWmsPropertList(list);
		
		//
		System.out.println("单条数据插入测试："+m1);
		System.out.println("多条数据插入测试："+m2);
	}
}
