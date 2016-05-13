package com.metersbonwe.stock.test.schedule;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.dal.auto.sync.mapper.TmpWpStockMapper;
import com.metersbonwe.stock.facade.schedule.TmpWpStockService;
import com.metersbonwe.stock.po.sync.TmpWpStock;
import com.metersbonwe.stock.test.TestBase;

public class TmpWpStockServiceImplTest extends TestBase {

    @Resource
    TmpWpStockService tmpWpStockService;

    @Resource
    TmpWpStockMapper  tmpWpStockMapper;

    @Test
    public void doService() {
        //准备数据
        try {
            for (int i = 0; i < 3; i++) {
                TmpWpStock tmpWpStock = new TmpWpStock();
                tmpWpStock.setWarehId("HQ01W850");
                tmpWpStock.setProdId("55651101124");
                tmpWpStock.setWpStock(new BigDecimal(i));
                tmpWpStock.setUpdateTime(new Date());
                int ibak = tmpWpStockMapper.insert(tmpWpStock);
                if (ibak == 0) {
                    System.out.println("nothring to do");
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("数据准备OK,开始测试");
        //执行服务
        tmpWpStockService.doService();
    }
}
