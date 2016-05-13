package com.metersbonwe.stock.biz.queue.service.impl;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.biz.common.service.OrderOccupyStockService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.StockChannelBean;

@Service public class OrderOccupyStockQueueServiceImpl implements MessageListener {
    private static StockLog           LOOGER = StockLogFactory.getLogger(OrderOccupyStockQueueServiceImpl.class);

    @Resource OrderOccupyStockService orderOccupyStockServiceImpl;

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            StockChannelBean stockChannelBean = JSON.parseObject(msg.getText(), StockChannelBean.class);
            orderOccupyStockServiceImpl.processOrderOccupyStock(stockChannelBean);
        } catch (Exception e) {
            LOOGER.error("获取订单占用消息出错," + e.getMessage(), e);
        }
    }
}
