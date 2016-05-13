package com.metersbonwe.stock.test.biz.common;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.junit.Test;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.metersbonwe.stock.test.TestBase;

public class SendJmsMessageTest extends TestBase {
    @Resource(name = "springJmsTemplate") JmsTemplate jmsTemplate;

    @Test
    public void testSendMsg() {
        int i = 10000;
        while (i-- > 0) {
            final int j = i;
            jmsTemplate.send("tonyruiyu", new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage("dasdasd" + j);
                }
            });
        }
    }

}
