package com.metersbonwe.stock.biz.common.service.mq;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;

public class MqSendUtils {

    final static StockLog    LOGGER       = StockLogFactory.getLogger(MqSendUtils.class);

    Map<String, JmsTemplate> jmsChooseMap = new HashMap<>();

    public Map<String, JmsTemplate> getJmsChooseMap() {
        return jmsChooseMap;
    }

    public void setJmsChooseMap(Map<String, JmsTemplate> jmsChooseMap) {
        this.jmsChooseMap = jmsChooseMap;
    }

    public void sendMqMessage(final String message, final String queueName) {
        JmsTemplate jmsTemplate = null;
        try {
            for (String key : jmsChooseMap.keySet()) {
                if (queueName.startsWith(key)) {
                    jmsTemplate = jmsChooseMap.get(key);
                    break;
                }
            }
            jmsTemplate.send(queueName, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(message);
                }
            });
        } catch (Exception e) {
            LOGGER.error("ACTIVEMQ 错误参数:" + message, e);
        }
    }

    public void sendMqTopicMessage(final String message, final String queueName) {
        JmsTemplate jmsTemplate = null;
        try {
            for (String key : jmsChooseMap.keySet()) {
                if (queueName.startsWith(key)) {
                    jmsTemplate = jmsChooseMap.get(key);
                    break;
                }
            }
            jmsTemplate.send(new ActiveMQTopic(queueName), new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(message);
                }
            });
        } catch (Exception e) {
            LOGGER.error("ACTIVEMQ TOPIC 错误参数:" + message, e);
        }
    }

    public void sendMqMessage(Object obj, String queueName) {
        sendMqMessage(JSON.toJSONString(obj), queueName);
    }

    public void sendMqTopicMessage(Object obj, String queueName) {
        sendMqTopicMessage(JSON.toJSONString(obj), queueName);
    }

}
