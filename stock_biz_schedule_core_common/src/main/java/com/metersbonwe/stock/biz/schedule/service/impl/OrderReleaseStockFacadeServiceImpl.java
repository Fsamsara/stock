package com.metersbonwe.stock.biz.schedule.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.OrderReleaseStockService;
import com.metersbonwe.stock.facade.schedule.OrderReleaseStockFacadeService;

@Service public class OrderReleaseStockFacadeServiceImpl implements OrderReleaseStockFacadeService {

    @Resource OrderReleaseStockService OrderReleaseStockServiceImpl;

    @Override
    public void processOrderReleaseStock() throws Exception {
        OrderReleaseStockServiceImpl.processOrderReleaseStock();
    }
}
