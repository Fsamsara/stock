package com.metersbonwe.stock.test.biz.queue;

import com.metersbonwe.stock.biz.queue.service.ReservedChangeService;
import com.metersbonwe.stock.po.core.TmpQueueReserved;
import com.metersbonwe.stock.test.TestBase;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author huangbiao
 * @version V1.0
 * @description 预留量变化测试类
 * @date 2016/4/7
 */
public class ReservedChangeServiceTest extends TestBase {

    @Resource ReservedChangeService reservedChangeServiceImpl;

    @Test public void testMain() {
        TmpQueueReserved tmpQueueReserved = new TmpQueueReserved();
        tmpQueueReserved.setChannelCode("HQ01S233");
        tmpQueueReserved.setProdId("71378270140");
        reservedChangeServiceImpl.processReservedChange(tmpQueueReserved);
    }
}
