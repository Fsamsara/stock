package com.metersbonwe.stock.test.biz.manager;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.biz.manager.service.StockPreSaleService;
import com.metersbonwe.stock.po.core.StockPreSale;
import com.metersbonwe.stock.pojo.StockPreSaleResultBean;
import com.metersbonwe.stock.test.TestBase;

public class StockPreSaleServiceImplTest extends TestBase {

    @Resource private StockPreSaleService stockPreSaleServiceImpl;

    @Test
    public void doCancelFlowStockPreSale() {
        try {
            long id = 1459412316602l;
            StockPreSale masterBean = this.stockPreSaleServiceImpl.getStockPreSale(id);
            masterBean.setId(id);
            masterBean.setUpdateBy("0001");
            masterBean.setUpdateTime(new Date());
            StockPreSaleResultBean resultBean = this.stockPreSaleServiceImpl.cancelFlowStockPreSale(masterBean);
            System.out.println(resultBean.getMsg());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
