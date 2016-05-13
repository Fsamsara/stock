package com.metersbonwe.stock.biz.queue.dynamic.listener;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.biz.common.service.OnlineChannelStockService;
import com.metersbonwe.stock.biz.common.service.mq.MqDynamicRegisteService;
import com.metersbonwe.stock.biz.queue.service.OnlineChannelStockQueueService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;

/**
 * 动态JMS队列注册监听工具
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-13 下午7:15:34
 */
@Service @Lazy(false) public class DynamicListenerManager implements InitializingBean, Lifecycle {

    private final StockLog                                                LOGGER = StockLogFactory.getLogger(DynamicListenerManager.class);

    @Resource(name = "allocationRangeServiceImpl") AllocationRangeService allocationRangeService;

    @Resource MqDynamicRegisteService                                     mqDynamicRegisteService;

    @Resource OnlineChannelStockService                                   onlineChannelStockServiceImpl;

    @Resource OnlineChannelStockQueueService                              onlineChannelStockQueueServiceImpl;

    @Override
    public void afterPropertiesSet() throws Exception {
        //         获取渠道列表
        List<String> channels = allocationRangeService.getAllUsefulChannel();
        // 循环按渠道注册MQ监听
        if (CollectionUtils.isNotEmpty(channels)) {
            for (String channel : channels) {
                try {
                    String queueName = mqDynamicRegisteService.registeDefaultQueueLintener(channel, onlineChannelStockQueueServiceImpl);
                    LOGGER.debug("注册MQ监听成功,队列名:" + queueName);
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }

    @Override
    public void start() {
        mqDynamicRegisteService.start(onlineChannelStockQueueServiceImpl);

    }

    @Override
    public void stop() {
        mqDynamicRegisteService.stop();
    }

    @Override
    public boolean isRunning() {
        return mqDynamicRegisteService.isRunning();
    }

}
