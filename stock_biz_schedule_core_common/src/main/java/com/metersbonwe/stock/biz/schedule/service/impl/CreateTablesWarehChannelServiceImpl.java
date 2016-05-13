package com.metersbonwe.stock.biz.schedule.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.CreateTablesWarehChannelCommonService;
import com.metersbonwe.stock.facade.schedule.CreateTablesWarehChannelService;

@Service public class CreateTablesWarehChannelServiceImpl implements CreateTablesWarehChannelService {

    @Resource CreateTablesWarehChannelCommonService createTablesWarehChannelCommonServiceImpl;

    @Override
    public void createChannelTable() {
        createTablesWarehChannelCommonServiceImpl.createChannelTable();
    }

    @Override
    public void createWarehTable() {
        createTablesWarehChannelCommonServiceImpl.createWarehTable();
    }
}
