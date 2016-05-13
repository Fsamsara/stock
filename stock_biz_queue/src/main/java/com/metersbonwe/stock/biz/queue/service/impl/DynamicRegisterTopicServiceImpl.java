package com.metersbonwe.stock.biz.queue.service.impl;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.MqTopicCommonService;
import com.metersbonwe.stock.biz.common.service.iocutils.SpringApplicationContextAware;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.MqMessagePojo;

@Service("dynamicRegisterTopicListenter") public class DynamicRegisterTopicServiceImpl implements MessageListener {

    private static StockLog LOOGER = StockLogFactory.getLogger(DynamicRegisterTopicServiceImpl.class);

    @Resource MqSendService mqSendServiceImpl;

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            MqMessagePojo pojo = JSON.parseObject(msg.getText(), MqMessagePojo.class);
            Class<?> clazz = Class.forName(pojo.getProxyClass());
            String name = clazz.getSimpleName();
            name = name.substring(0, 1).toLowerCase() + name.substring(1);
            MqTopicCommonService service = (MqTopicCommonService) SpringApplicationContextAware.getBean(name, clazz);
            service.proccessTopicMessage(pojo);
        } catch (Exception e) {
            LOOGER.error(e.getMessage(), e);
            throw new RuntimeException("解析并处理TOPIC消息时出错,message:" + message);
        }
    }
}
