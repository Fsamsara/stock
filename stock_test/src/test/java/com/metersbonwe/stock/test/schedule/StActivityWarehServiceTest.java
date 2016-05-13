package com.metersbonwe.stock.test.schedule;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.metersbonwe.stock.facade.schedule.StActivityWarehService;
import com.metersbonwe.stock.test.TestBase;

public class StActivityWarehServiceTest extends TestBase {
    
    @Autowired
    StActivityWarehService stActivityWarehService;

    @Test
    public void doService() {
        //准备数据
        System.out.println("准备数据，开始测试");
        //开始测试
        stActivityWarehService.doService();
    }
}
