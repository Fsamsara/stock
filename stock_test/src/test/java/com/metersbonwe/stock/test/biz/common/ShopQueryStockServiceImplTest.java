package com.metersbonwe.stock.test.biz.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.biz.common.service.ShopQueryStockService;
import com.metersbonwe.stock.pojo.ShopQueryLocStockParamBean;
import com.metersbonwe.stock.pojo.ShopQueryLocStockResultBean;
import com.metersbonwe.stock.pojo.ShopQueryStockParamBean;
import com.metersbonwe.stock.pojo.ShopQueryStockResultBean;
import com.metersbonwe.stock.test.TestBase;

public class ShopQueryStockServiceImplTest extends TestBase {

    @Resource private ShopQueryStockService shopQueryStockServiceImpl;

    private ShopQueryLocStockParamBean getShopQueryLocStockParamBean(String warehId, List<String> locList) {
        ShopQueryLocStockParamBean req = new ShopQueryLocStockParamBean();
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
            ShopQueryLocStockParamBean req = null;
            List<ShopQueryLocStockResultBean> resultList = null;
            List<String> locList = new ArrayList<String>();
            locList.add("104");
            locList.add("999");
            req = getShopQueryLocStockParamBean("A00021S003", locList); //老ERP门店有货位
            resultList = shopQueryStockServiceImpl.shopQueryLocStock(req);
            System.out.println("shopQueryLocStockTest OldErp have loc：" + resultList.toString());

            req = getShopQueryLocStockParamBean("A00021S003", null); //老ERP门店无货位
            resultList = shopQueryStockServiceImpl.shopQueryLocStock(req);
            System.out.println("shopQueryLocStockTest OldErp no loc：" + resultList.toString());

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    @Test
    public void shopQueryStockTest() {
        try {
            List<ShopQueryStockResultBean> resultList = null;
            ShopQueryStockParamBean req = new ShopQueryStockParamBean();
            req.setWarehId("A03794S006");
            List<String> skuList = new ArrayList<String>();
            skuList.add("28635292139");
            skuList.add("22299270144");
            req.setSkuList(skuList);
            resultList = shopQueryStockServiceImpl.shopQueryStock(req);
            System.out.println("shopQueryStockTest：" + resultList.toString());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
