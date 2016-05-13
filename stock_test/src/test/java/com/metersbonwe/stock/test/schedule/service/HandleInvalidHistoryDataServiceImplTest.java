package com.metersbonwe.stock.test.schedule.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.facade.service.HandleInvalidHistoryDataService;
import com.metersbonwe.stock.test.TestBase;

public class HandleInvalidHistoryDataServiceImplTest extends TestBase {

	@Resource
	HandleInvalidHistoryDataService handleInvalidHistoryDataServiceImpl;
	@Resource
	MultiTableService multiTableServiceImpl;
	@Test
	public void testDeleteInvalidShopDame() {
		/*String suffix = multiTableServiceImpl.getTableSuffixByWarehId("HQ01W570");
		System.out.println("\n\n\nsuffix------------------------->"+suffix);//01
*/		
	    
	    
	    handleInvalidHistoryDataServiceImpl.deleteInvalidShopDame();
	    handleInvalidHistoryDataServiceImpl.deleteInvalidShopSafe();
	    handleInvalidHistoryDataServiceImpl.deleteInvalidWarehSafe();
		
	}
}
