package com.metersbonwe.stock.test.biz.queue;

import com.metersbonwe.stock.biz.queue.service.impl.FreeLockReservedBaseService;
import com.metersbonwe.stock.test.TestBase;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/4/27
 */
public class FreeLockReservedBaseServiceTest extends TestBase{

    @Resource FreeLockReservedBaseService freeLockReservedBaseService;

    @Test public void testMain() {
        //freeLockReservedBaseService.calFreeLockData("HQ01S115", "10101890030");
    }
}
