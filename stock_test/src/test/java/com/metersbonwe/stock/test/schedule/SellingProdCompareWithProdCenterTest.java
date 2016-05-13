package com.metersbonwe.stock.test.schedule;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.metersbonwe.stock.facade.schedule.SellingProdCompareWithProdCenter;
import com.metersbonwe.stock.test.TestBase;

public class SellingProdCompareWithProdCenterTest extends TestBase {

    @Autowired SellingProdCompareWithProdCenter sellingProdCompareWithProdCenter;

    @Test
    public void doService() {
        //准备测试
        sellingProdCompareWithProdCenter.doService();
    }
}
