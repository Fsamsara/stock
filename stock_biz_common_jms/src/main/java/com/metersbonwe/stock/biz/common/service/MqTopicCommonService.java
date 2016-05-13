package com.metersbonwe.stock.biz.common.service;

import com.metersbonwe.stock.pojo.MqMessagePojo;

/**
 * TODO 消费TOPIC消息的通用服务
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年4月25日 下午1:24:40
 * @since V1.0
 * @version V1.0
 */
public interface MqTopicCommonService {
    /**
     * TODO 处理TOPIC消息
     * 
     * @param object
     *            入参 实现时需要判断是否为空
     * @throws Exception
     */
    void proccessTopicMessage(MqMessagePojo pojo) throws Exception;
}
