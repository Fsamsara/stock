package com.metersbonwe.stock.biz.common.service;


import com.metersbonwe.stock.po.core.TmpQueueAll;
import com.metersbonwe.stock.po.core.TmpQueueChannelgroupReserved;
import com.metersbonwe.stock.po.core.TmpQueueFreeLock;
import com.metersbonwe.stock.po.core.TmpQueueReserved;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.pojo.MqMessagePojo;

import java.util.List;

/**
 * @author huangbiao
 * @version V1.0
 * @description 发送mq接口
 * @date 2016/3/24
 */
public interface MqSendService {

    /**
     * @description 发送线上MQ
     * @param channelProdBean
     *            javaBean对象
     */
    void sendToOnLineChannelStock(ChannelProdBean channelProdBean, String channelCode);

    /**
     * @description 发送线上MQ
     * @param channelProdBeanList
     *            javaBean对象集合
     */
    void sendToOnLineChannelStock(List<ChannelProdBean> channelProdBeanList, String channelCode);

    /**
     * @description 发送到渠道预留量队列
     * @param tmpQueueReserved
     *            javaBean对象
     */
    void sendToChannelWarehProdReserved(TmpQueueReserved tmpQueueReserved);

    /**
     * @description 发送到自由量锁定量队列
     * @param tmpQueueFreeLock
     *            javaBean对象
     */
    void sendToChannelWarehProdFreeLock(TmpQueueFreeLock tmpQueueFreeLock);

    /**
     * @description 发送通知，通知线上Mq我这个渠道已经完成了从仓商品明细表，到渠道商品明细表的数据收集，可以发送线上MQ了
     * @param channelCode
     *            渠道编码
     */
    void sendSendToLineMqFlag(String channelCode);

    /**
     * @description 发送到店群预留量队列
     * @param tmpQueueChannelGroupReserved
     *            javaBean对象
     */
    void sendToChannelGroupReserved(TmpQueueChannelgroupReserved tmpQueueChannelGroupReserved);

    /**
     * @description 推送TOPIC消息队列（方便多台服务器同时接受到消息，同时处理数据）
     * @param messagePojo
     *            渠道编码
     */
    void sendTopicMessage(MqMessagePojo messagePojo);

    /**
     * @description 发送到渠道表，更新渠道表所有的量
     * @param tmpQueueAll
     *            javaBean对象
     */
    void sendToChannelAll(TmpQueueAll tmpQueueAll);

}
