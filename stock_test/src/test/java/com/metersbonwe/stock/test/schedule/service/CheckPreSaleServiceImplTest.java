package com.metersbonwe.stock.test.schedule.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.service.CheckPreSaleService;
import com.metersbonwe.stock.test.TestBase;

/**
 * @author zhq 轮询检查预售开启、关闭定时任务测试
 */
public class CheckPreSaleServiceImplTest extends TestBase {

    @Resource CheckPreSaleService checkPreSaleServiceImpl;

    /**
     * 轮询检查预售开启接口测试
     */
    @Test
    public void testCheckPreSaleOpen() {
        checkPreSaleServiceImpl.checkPreSaleOpen();
    }

    /**
     * 轮询检查预售关闭接口测试
     */
    @Test
    public void testCheckPreSaleClose() {
        checkPreSaleServiceImpl.checkPreSaleClose();
    }

}
