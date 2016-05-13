package com.metersbonwe.stock.test.biz.queue;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.junit.Test;

import com.metersbonwe.stock.biz.common.service.mq.MqDynamicRegisteService;
import com.metersbonwe.stock.biz.common.service.mq.MqSendUtils;
import com.metersbonwe.stock.test.TestBase;

public class SendMessageToMqTest extends TestBase {

    @Resource MqSendUtils             mqSendUtils;

    @Resource MqDynamicRegisteService mqDynamicRegisteService;

    @Test
    public void testSendMessage() {
        long a = System.currentTimeMillis();
        for (int i = 0; i < 100 * 10000; i++) {
            mqSendUtils.sendMqMessage("dasdashdjhaskjdhaskjhdjkahsdjkahsjkdhajkshdjkahksjdhajkshdkjahsjdkh" + i, "zry-test");
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    @Test
    public void testDynamicListenerManager() {
        mqDynamicRegisteService.registeQueueLintener("zry-test", new MessageListener() {
            @Override
            public void onMessage(Message msg) {
                try {
                    System.out.println(((TextMessage) msg).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }, "1-100");
        waitThread(100000);
    }

}
