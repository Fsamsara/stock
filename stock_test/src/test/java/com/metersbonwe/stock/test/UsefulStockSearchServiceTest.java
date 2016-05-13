package com.metersbonwe.stock.test;

import com.metersbonwe.stock.facade.api.UsefulStockSearchService;
import com.metersbonwe.stock.facade.api.bean.SkuStock;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/3/28
 */
@SuppressWarnings("unused") public class UsefulStockSearchServiceTest extends TestBase {
    @Resource UsefulStockSearchService usefulStockSearchService;

    @Test
    public void testMain() {
        //接口1、单11位sku查询
        //getStockTest();
        //接口2、批量11为sku查询
        getBatchStock();
        //接口3:、传入一个6位码
        //getBatchStockBySn();
    }

    private void getBatchStock() {
        List<String> skuList = new ArrayList<>();
        skuList.add("88888888888");
        skuList.add("99999999999");
        skuList.add("ccccc");

        String channelCode = "HQ01S116";
        List<SkuStock> skuStocks = usefulStockSearchService.getBatchStock(skuList, channelCode);
        for (SkuStock skuStock : skuStocks) {
            System.out.println("结果为sku： " + skuStock.getSku() + "可用库存：" + skuStock.getAllStock());
        }
    }

    private void getStockTest() {
        String prodId = "99999999999";
        String channelCode = "HQ01S116";
        int usefulStock = usefulStockSearchService.getStock(prodId, channelCode);
        System.out.println("sku:" + prodId + "渠道:" + channelCode + "的可用库存为库存为" + usefulStock);
    }

    private void getBatchStockBySn() {
        String prodId = "201512";
        String channelCode = "HQ01S116";
        List<SkuStock> skuStockList = usefulStockSearchService.getBatchStockBySn(prodId, channelCode);
        for (SkuStock skuStock : skuStockList) {
            System.out.println("结果为sku： " + skuStock.getSku() + "可用库存：" + skuStock.getAllStock());
        }
    }
}
