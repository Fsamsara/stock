package com.metersbonwe.stock.test.biz.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.api.UniformQueryStockFacade;
import com.metersbonwe.stock.facade.api.bean.QryFreeShareStockReq;
import com.metersbonwe.stock.facade.api.bean.QryFreeShareStockRes;
import com.metersbonwe.stock.facade.api.bean.QryProdSumStockRes;
import com.metersbonwe.stock.facade.api.bean.QryReservedStockReq;
import com.metersbonwe.stock.facade.api.bean.QryReservedStockRes;
import com.metersbonwe.stock.facade.api.bean.QryStockReq;
import com.metersbonwe.stock.facade.api.bean.QryUsefulStkStockReq;
import com.metersbonwe.stock.facade.api.bean.QryUsefulStkStockRes;
import com.metersbonwe.stock.test.TestBase;

public class UniformQueryStockFacadeImplTest extends TestBase {

    @Resource private UniformQueryStockFacade uniformQueryStockFacadeImpl;

    private QryUsefulStkStockReq getQryUsefulStkStockReq(String channelSource, int queryModule) {
        QryUsefulStkStockReq req = new QryUsefulStkStockReq();
        req.setChannelSource(channelSource); //ONLINE、OFFLINE
        if (queryModule != 3) {
            req.setChannelCode("HQ01S116");
            req.setCounty("中国");
            req.setProvince("上海");
            req.setCity("上海市");
            req.setDistrict("浦东新区");

            List<String> extWarehShopList = new ArrayList<String>();
            extWarehShopList.add("HQ01W500");
            req.setExtWarehShopList(extWarehShopList);
        }
        List<String> skuList = new ArrayList<String>();
        skuList.add("24822921130");
        skuList.add("24820730131");
        skuList.add("25737141136");
        skuList.add("25737440136");
        skuList.add("28635292139");
        skuList.add("22299270144");
        req.setSkuList(skuList);

        return req;
    }

    @Test
    public void posQueryStockTest() {
        try {
            QryUsefulStkStockReq req = null;
            QryProdSumStockRes res = null;
            req = getQryUsefulStkStockReq("ONLINE", 1);
            res = this.uniformQueryStockFacadeImpl.posQueryStock(req);
            System.out.println("posQueryStockTest ONLINE：" + res.toString());

            req = getQryUsefulStkStockReq("OFFLINE", 1);
            res = this.uniformQueryStockFacadeImpl.posQueryStock(req);
            System.out.println("posQueryStockTest OFFLINE：" + res.toString());

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    @Test
    public void alloctQueryStockTest() {
        try {
            QryUsefulStkStockReq req = null;
            QryUsefulStkStockRes res = null;
            req = getQryUsefulStkStockReq("ONLINE", 2);
            res = this.uniformQueryStockFacadeImpl.alloctQueryStock(req);
            System.out.println("alloctQueryStockTest ONLINE：" + res.toString());

            req = getQryUsefulStkStockReq("OFFLINE", 2);
            res = this.uniformQueryStockFacadeImpl.alloctQueryStock(req);
            System.out.println("alloctQueryStockTest OFFLINE：" + res.toString());

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    @Test
    public void sumQueryStockTest() {
        try {
            QryStockReq req = null;
            QryUsefulStkStockRes res = null;
            req = getQryUsefulStkStockReq("ONLINE", 3);
            res = this.uniformQueryStockFacadeImpl.sumQueryStock(req);
            System.out.println("sumQueryStockTest ONLINE：" + res.toString());

            req = getQryUsefulStkStockReq("OFFLINE", 3);
            res = this.uniformQueryStockFacadeImpl.sumQueryStock(req);
            System.out.println("sumQueryStockTest OFFLINE：" + res.toString());

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    @Test
    public void queryFreeShareStockTest() {
        try {
            QryFreeShareStockReq req = new QryFreeShareStockReq();
            req.setChannelSource("OFFLINE"); //ONLINE    OFFLINE
            List<String> warehList = new ArrayList<String>();
            warehList.add("A00018S036");
            warehList.add("A00298S473");
            warehList.add("A01281S001");
            req.setWarehList(warehList);
            List<String> skuList = new ArrayList<String>();
            skuList.add("91000023650");
            skuList.add("20003826130");
            skuList.add("10106001030");
            req.setSkuList(skuList);
            QryFreeShareStockRes res = this.uniformQueryStockFacadeImpl.queryFreeShareStock(req);
            System.out.println("queryFreeShareStockTest OFFLINE：" + res.toString());

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    @Test
    public void queryReservedStockTest() {
        try {
            QryReservedStockReq req = new QryReservedStockReq();
            List<String> warehList = new ArrayList<String>();
            warehList.add("HQ01W550");
            warehList.add("HQ01W700");
            List<String> skuList = new ArrayList<String>();
            skuList.add("57088398135");
            skuList.add("57088398138");
            skuList.add("57088308139");
            List<String> channelCodeList = new ArrayList<String>();
            channelCodeList.add("A01339");
            List<String> reservedTypeList = new ArrayList<String>();
            reservedTypeList.add("07");
            req.setChannelCodeList(channelCodeList);//A00561
            req.setReservedTypeList(reservedTypeList);
            req.setWarehList(warehList);
            req.setSkuList(skuList);
            QryReservedStockRes res = this.uniformQueryStockFacadeImpl.queryReservedStock(req);
            System.out.println("queryReservedStockTest ：" + res.toString());

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
