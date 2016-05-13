package com.metersbonwe.stock.test.biz.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.ShopQueryStockFacade;
import com.metersbonwe.stock.facade.api.bean.ShopQueryLocStockReq;
import com.metersbonwe.stock.facade.api.bean.ShopQueryLocStockRes;
import com.metersbonwe.stock.facade.api.bean.ShopQueryStockReq;
import com.metersbonwe.stock.facade.api.bean.ShopQueryStockRes;
import com.metersbonwe.stock.test.TestBase;

public class ShopQueryStockFacadeImplTest extends TestBase {

    @Resource private ShopQueryStockFacade shopQueryStockFacadeImpl;

    private ShopQueryLocStockReq getShopQueryLocStockReq(String warehId, List<String> locList) {
        ShopQueryLocStockReq req = new ShopQueryLocStockReq();
        req.setWarehId(warehId);
        req.setLocList(locList);
        List<String> skuList = new ArrayList<String>();
        skuList.add("72207790150");
        skuList.add("24504090154");
        skuList.add("22346800148");
        req.setSkuList(skuList);

        return req;
    }

    @Test
    public void shopQueryLocStockTest() {
        try {
            ShopQueryLocStockReq req = null;
            List<String> locList = new ArrayList<String>();
            locList.add("104");
            locList.add("999");
            req = getShopQueryLocStockReq("A00021S003", locList); //老ERP门店有货位
            ShopQueryLocStockRes res = shopQueryStockFacadeImpl.shopQueryLocStock(req);
            System.out.println("shopQueryLocStockTest OldErp have loc：" + res.toString());

            req = getShopQueryLocStockReq("A00021S003", null); //老ERP门店无货位
            res = shopQueryStockFacadeImpl.shopQueryLocStock(req);
            System.out.println("shopQueryLocStockTest OldErp no loc：" + res.toString());

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    @Test
    public void shopQueryStockTest() {
        try {
            ShopQueryStockReq req = new ShopQueryStockReq();
            req.setWarehId("A00021S003");
            List<String> skuList = new ArrayList<String>();
            skuList.add("72207790150");
            skuList.add("24504090154");
            skuList.add("22346800148");
            req.setSkuList(skuList);
            ShopQueryStockRes res = shopQueryStockFacadeImpl.shopQueryStock(req);
            System.out.println("shopQueryStockTest：" + res.toString());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
