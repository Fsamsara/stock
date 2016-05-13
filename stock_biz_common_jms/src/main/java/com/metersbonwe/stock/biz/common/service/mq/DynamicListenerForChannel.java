package com.metersbonwe.stock.biz.common.service.mq;

import javax.annotation.Resource;
import javax.jms.MessageListener;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.metersbonwe.stock.biz.common.service.MqTopicCommonService;
import com.metersbonwe.stock.configuration.PropertiesManager;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.MqMessagePojo;

@Service public class DynamicListenerForChannel implements MqTopicCommonService {

    private static StockLog           LOGGER = StockLogFactory.getLogger(DynamicListenerForChannel.class);

    @Resource MqDynamicRegisteService mqDynamicRegisteService;

    @Override
    public void proccessTopicMessage(MqMessagePojo pojo) throws Exception {
        Assert.notNull(pojo, "注册MQ监听时入参不能为空！");
        mqDynamicRegisteService.registeQueueLintener(
                PropertiesManager.getPropertiesManager().getProperty("ONLINE_CHANNEL_STOCK") + pojo.getObject().toString().toLowerCase(),
                createListener(pojo),
                "1-10");
        LOGGER.info("注册MQ监听完成，参数:" + pojo.getObject().toString());
    }

    private MessageListener createListener(MqMessagePojo pojo) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (MessageListener) Class.forName(pojo.getListenerClass()).newInstance();
    }

}
