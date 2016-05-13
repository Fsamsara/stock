package com.metersbonwe.stock.test.biz.common;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.biz.common.service.ChangeFinalFreeShareStockService;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.test.TestBase;

public class ChangeFinalFreeShareStockServiceTest extends TestBase {
    
    @Resource
    ChangeFinalFreeShareStockService changeFinalFreeShareStockService;
    
    @Test
    public void test(){
        
        StockWarehProd stockWarehProd = new StockWarehProd();
        
        stockWarehProd.setWarehId("HQ01W710");
        stockWarehProd.setTableNum("00");
        stockWarehProd.setProdId("12345678901");
        stockWarehProd.setOnlineSafeStock(80);
        stockWarehProd.setId(1);
        
        try {
            changeFinalFreeShareStockService.updateStockWarehProd(stockWarehProd);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
