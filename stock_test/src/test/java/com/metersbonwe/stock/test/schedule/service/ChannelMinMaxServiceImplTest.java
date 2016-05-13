package com.metersbonwe.stock.test.schedule.service;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.google.common.collect.Maps;
import com.metersbonwe.stock.facade.service.ChannelMinMaxService;
import com.metersbonwe.stock.test.TestBase;

/**
 * @author zhq 渠道全局最大值、最小值变化定时任务测试
 */
public class ChannelMinMaxServiceImplTest extends TestBase {

    @Resource ChannelMinMaxService channelMinMaxServiceImpl;

    @Test
    public void testHandleChannelMinMaxChange() {
        Map<String, String> map = Maps.newConcurrentMap();
        channelMinMaxServiceImpl.handleChannelMinMaxChange(map);
    }
}
