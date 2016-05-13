package com.metersbonwe.stock.test.schedule;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.metersbonwe.stock.dal.auto.sync.mapper.TmpWsStockMapper;
import com.metersbonwe.stock.facade.schedule.TmpWsStockService;
import com.metersbonwe.stock.po.sync.TmpWsStock;
import com.metersbonwe.stock.test.TestBase;

public class TmpWsStockServiceTest extends TestBase {

    @Autowired
    TmpWsStockService tmpWsStockService;

    @Autowired
    TmpWsStockMapper  tmpWsStockMapper;

    @Test
    public void doService() {
        //准备数据
        try {
            for (int i = 0; i < 3; i++) {
                TmpWsStock tmpWsStock = new TmpWsStock();
                tmpWsStock.setWarehId("HQ01W700");
                tmpWsStock.setUpdateTime(new Date());
                tmpWsStock.setWsStock(new BigDecimal(i));
                tmpWsStockMapper.insert(tmpWsStock);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("数据准备OK,开始测试");
        //准备服务
        tmpWsStockService.doService();
    }
}
