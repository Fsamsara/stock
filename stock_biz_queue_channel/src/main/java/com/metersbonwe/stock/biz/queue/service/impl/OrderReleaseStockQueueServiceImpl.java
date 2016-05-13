package com.metersbonwe.stock.biz.queue.service.impl;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.biz.common.service.OrderReleaseStockService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.StockChannelBean;

@Service public class OrderReleaseStockQueueServiceImpl implements MessageListener {

    private static StockLog            LOGGER = StockLogFactory.getLogger(OrderReleaseStockQueueServiceImpl.class);

    @Resource OrderReleaseStockService orderReleaseStockServiceImpl;

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            StockChannelBean stockChannelBean = JSON.parseObject(msg.getText(), StockChannelBean.class);
            orderReleaseStockServiceImpl.updateOrderReleaseStock(stockChannelBean);
        } catch (Exception e) {
            LOGGER.error("获取订单释放消息出错," + e.getMessage(), e);
        }
    }
}
