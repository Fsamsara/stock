package com.metersbonwe.stock.test.biz.schedule;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.schedule.StockPreSaleFacadeService;
import com.metersbonwe.stock.test.TestBase;

public class StockPreSaleFacadeServiceImplTest extends TestBase {
    @Resource private StockPreSaleFacadeService stockPreSaleFacadeServiceImpl;

    /**
     * TODO 测试预售、预售调整传递给B2B做预留
     */
    @Test
    public void processStockPreSalePassToReservedTest() {
        try {
            System.out.println("开始执行轮询");
            stockPreSaleFacadeServiceImpl.processStockPreSalePassToReserved();
            System.out.println("结束执行轮询");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
