package com.metersbonwe.stock.test.biz.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.biz.common.service.WarehSkuCommonService;
import com.metersbonwe.stock.dal.define.core.mapper.FullStockCoreDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockShopRemailDefineMapper;
import com.metersbonwe.stock.po.core.TmpStockWarehProdFree;
import com.metersbonwe.stock.test.TestBase;

public class WarehSkuCommonServiceTest extends TestBase {
	@Resource
	WarehSkuCommonService warehSkuCommonServiceImpl;
	@Resource
	StockShopRemailDefineMapper stockShopRemailDefineMapper;
	@Resource
	FullStockCoreDefineMapper fullStockCoreDefineMapper;
	@Test
	public void testinsertWarehSkuWithout(){
		int i = warehSkuCommonServiceImpl.insertWarehSkuWithout("HQ01W850", "55351301126");
		System.out.println(i);
	}
	@Test
	public void testSelectStockShopRemailMapper(){
		List<Map<String,Object>> item = stockShopRemailDefineMapper.selectShopRemail("HQ01W850", "55351301126");
		System.out.println(item);
	}
	@Test
	public void testBatchInsertFreeTmp(){
	    List<TmpStockWarehProdFree> item = new ArrayList<TmpStockWarehProdFree>();
	    for (int i = 0; i < 10; i++) {
	        TmpStockWarehProdFree tmp = new TmpStockWarehProdFree();
	        tmp.setWarehId("das" + i);
	        tmp.setProdId("prod" + i);
	        tmp.setFreeShareStock(i);
	        tmp.setIsShop(0);
	        tmp.setQtyCommitted(i);
	        tmp.setSafeStock(i);
	        tmp.setSafeType("type" + i);
	        item.add(tmp);
        }
	   
	   int i= fullStockCoreDefineMapper.insertFreeStockTmp(item, "01");
	   System.out.println(i);
	}
	
}
