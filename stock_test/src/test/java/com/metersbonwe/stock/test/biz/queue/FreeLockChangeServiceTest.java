package com.metersbonwe.stock.test.biz.queue;

import com.metersbonwe.stock.biz.queue.service.FreeLockChangeService;
import com.metersbonwe.stock.biz.schedule.service.impl.WarehSafeTypeChangeServiceImpl;
import com.metersbonwe.stock.po.core.TmpQueueFreeLock;
import com.metersbonwe.stock.test.TestBase;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/4/7
 */
public class FreeLockChangeServiceTest extends TestBase {

    @Resource
    FreeLockChangeService freeLockChangeServiceImpl;
    @Resource
    WarehSafeTypeChangeServiceImpl warehSafeTypeChangeServiceImpl;

    @Test
    public void testMain(){
       //warehSafeTypeChangeServiceImpl.processTmpSafeTypeStockData();
        TmpQueueFreeLock tmpQueueFreeLock = new TmpQueueFreeLock();
        tmpQueueFreeLock.setWarehId("HQ01W500");
        tmpQueueFreeLock.setProdId("23889920144");
        freeLockChangeServiceImpl.processFreeLockChange(tmpQueueFreeLock);
    }
}
