package com.metersbonwe.stock.test.biz.common;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.biz.common.fullsync.ThirdPartyStockSyncService;
import com.metersbonwe.stock.test.TestBase;

public class ThirdPartyStockSyncServiceTest extends TestBase {
    
    
    @Resource ThirdPartyStockSyncService thirdPartyStockSyncServiceImpl;
    
    @Test
    public void testSyncTpStock() {
        thirdPartyStockSyncServiceImpl.syncTpStock();
    }
    
}
