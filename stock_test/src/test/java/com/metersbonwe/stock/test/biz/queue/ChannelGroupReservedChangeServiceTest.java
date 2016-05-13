package com.metersbonwe.stock.test.biz.queue;

import com.metersbonwe.stock.biz.queue.service.ChannelGroupReservedChangeService;
import com.metersbonwe.stock.po.core.TmpQueueChannelgroupReserved;
import com.metersbonwe.stock.test.TestBase;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/3/24
 */
public class ChannelGroupReservedChangeServiceTest extends TestBase {

    @Resource ChannelGroupReservedChangeService channelGroupReservedChangeServiceImpl;

    @Test public void test() {
        TmpQueueChannelgroupReserved tmpQueueChannelGroupReserved = new TmpQueueChannelgroupReserved();
        tmpQueueChannelGroupReserved.setProdId("23889920144");
        tmpQueueChannelGroupReserved.setChannelGroupId("8888");
        try {
            channelGroupReservedChangeServiceImpl.processReservedChange(tmpQueueChannelGroupReserved);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
