package com.metersbonwe.stock.test.schedule;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.facade.schedule.CreateTablesWarehChannelService;
import com.metersbonwe.stock.test.TestBase;

public class CreateTablesWarehChannelServiceTest extends TestBase {
    @Resource CreateTablesWarehChannelService CreateTablesWarehChannelServiceImpl;

    @Test
    public void doService() {
        //        CreateTablesWarehChannelServiceImpl.createChannelTable();
        CreateTablesWarehChannelServiceImpl.createWarehTable();
    }
}
