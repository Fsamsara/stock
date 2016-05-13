package com.metersbonwe.stock.biz.queue.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.metersbonwe.stock.biz.common.service.OnlineChannelStockService;
import com.metersbonwe.stock.biz.log.LogService;
import com.metersbonwe.stock.biz.queue.service.OnlineChannelStockQueueService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;

/**
 * TODO 推送线上MQ监听实现
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年3月26日 下午2:12:45
 * @since V1.0
 * @version V1.0
 */
@Service public class OnlineChannelStockQueueServiceImpl implements OnlineChannelStockQueueService {

    private static StockLog             LOGGER = StockLogFactory.getLogger(OnlineChannelStockQueueServiceImpl.class);

    @Resource OnlineChannelStockService onlineChannelStockServiceImpl;

    @Override
    public void processReservedChangeList(List<ChannelProdBean> channelProdBeans) throws Exception {
        if (CollectionUtils.isNotEmpty(channelProdBeans)) {
            onlineChannelStockServiceImpl.proccessToOnlineList(channelProdBeans);
        }
    }

    @Override
    public void processReservedChange(ChannelProdBean channelProdBean) throws Exception {
        List<ChannelProdBean> beans = new ArrayList<>();
        beans.add(channelProdBean);
        processReservedChangeList(beans);
    }
    
    //@LogService(value = "推送线上队列", resolverType = "jmsTextMessageArgsResolver")
    @Override
    public void onMessage(Message message) {
        String meString = null;
        TextMessage msg = (TextMessage) message;
        try {
            meString = msg.getText();
            List<ChannelProdBean> channelProdBeans = JSON.parseArray(meString, ChannelProdBean.class);
            onlineChannelStockServiceImpl.proccessToOnlineList(channelProdBeans);
        } catch (Exception e) {
            ChannelProdBean channelProdBean = JSON.parseObject(meString, ChannelProdBean.class);
            try {
                List<ChannelProdBean> channelProdBeans = Lists.newArrayList();
                channelProdBeans.add(channelProdBean);
                onlineChannelStockServiceImpl.proccessToOnlineList(channelProdBeans);
            } catch (Exception e1) {
                LOGGER.error("推送线上MQ消费时出错,参数:" + meString + "," + e.getMessage(), e);
                LOGGER.error(e1.getMessage(), e1);
            }
        }
    }
}
