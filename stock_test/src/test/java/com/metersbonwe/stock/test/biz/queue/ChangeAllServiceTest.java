package com.metersbonwe.stock.test.biz.queue;

import com.metersbonwe.stock.biz.queue.service.ChannelChangeAllService;
import com.metersbonwe.stock.po.core.TmpQueueAll;
import com.metersbonwe.stock.test.TestBase;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/4/7
 */
public class ChangeAllServiceTest extends TestBase {

    @Resource ChannelChangeAllService channelChangeAllServiceImpl;

    @Test public void testMain() {
        TmpQueueAll tmpQueueAll = new TmpQueueAll();
        tmpQueueAll.setWarehId("HQ01W500");
        tmpQueueAll.setProdId("23889920144");
        channelChangeAllServiceImpl.processAllChange(tmpQueueAll);
    }
}
