package com.metersbonwe.stock.test.schedule;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.metersbonwe.stock.facade.schedule.WmsStockChangesComparService;
import com.metersbonwe.stock.test.TestBase;

public class WmsStockChangesComparServiceTest extends TestBase {
    
    @Autowired
    WmsStockChangesComparService wmsStockChangesComparService;
    
    @Test
    public void doService() {
        //准备数据
        System.out.println("数据OK，开始测试");
        //开始测试
        wmsStockChangesComparService.doService();
    }
}
