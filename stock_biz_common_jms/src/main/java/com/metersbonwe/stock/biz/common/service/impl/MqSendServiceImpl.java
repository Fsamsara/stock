package com.metersbonwe.stock.biz.common.service.impl;

import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.mq.MqSendUtils;
import com.metersbonwe.stock.configuration.PropertiesManager;
import com.metersbonwe.stock.po.core.TmpQueueAll;
import com.metersbonwe.stock.po.core.TmpQueueChannelgroupReserved;
import com.metersbonwe.stock.po.core.TmpQueueFreeLock;
import com.metersbonwe.stock.po.core.TmpQueueReserved;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.pojo.MqMessagePojo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huangbiao
 * @version V1.0
 * @description 发送Mq实现类
 * @date 2016/3/24
 */
@Service public class MqSendServiceImpl implements MqSendService {

    @Resource MqSendUtils mqSendUtils;

    @Override
    public void sendToOnLineChannelStock(ChannelProdBean channelProdBean, String channelCode) {
        mqSendUtils.sendMqMessage(
                channelProdBean,
                PropertiesManager.getPropertiesManager().getProperty("ONLINE_CHANNEL_STOCK") + channelCode.toLowerCase());
    }

    @Override
    public void sendToOnLineChannelStock(List<ChannelProdBean> channelProdBeanList, String channelCode) {
        mqSendUtils.sendMqMessage(
                channelProdBeanList,
                PropertiesManager.getPropertiesManager().getProperty("ONLINE_CHANNEL_STOCK") + channelCode.toLowerCase());
    }

    @Override
    public void sendToChannelWarehProdReserved(TmpQueueReserved tmpQuequeReserved) {
        mqSendUtils.sendMqMessage(tmpQuequeReserved, PropertiesManager.getPropertiesManager().getProperty("CHANNEL_WAREH_PROD_RESERVED"));
    }

    @Override
    public void sendToChannelWarehProdFreeLock(TmpQueueFreeLock tmpQueueFreeLock) {
        mqSendUtils.sendMqMessage(tmpQueueFreeLock, PropertiesManager.getPropertiesManager().getProperty("CHANNEL_WAREH_PROD_FREE_LOCK"));
    }

    @Override
    public void sendSendToLineMqFlag(String channelCode) {
        mqSendUtils.sendMqMessage(channelCode, PropertiesManager.getPropertiesManager().getProperty("SEND_TO_LINE_FLAG"));
    }

    @Override
    public void sendToChannelGroupReserved(TmpQueueChannelgroupReserved tmpQueueChannelGroupReserved) {
        mqSendUtils.sendMqMessage(tmpQueueChannelGroupReserved, PropertiesManager.getPropertiesManager().getProperty("CHANNEL_GROUP_RESERVED"));
    }

    @Override
    public void sendTopicMessage(MqMessagePojo messagePojo) {
        mqSendUtils.sendMqTopicMessage(messagePojo, PropertiesManager.getPropertiesManager().getProperty("DYNAMIC_REGISTER_TOPIC"));
    }

    @Override public void sendToChannelAll(TmpQueueAll tmpQueueAll) {
        mqSendUtils.sendMqMessage(tmpQueueAll, PropertiesManager.getPropertiesManager().getProperty("CHANNEL_ALL"));
    }
}
