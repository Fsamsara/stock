package com.metersbonwe.stock.biz.queue.service.impl;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.queue.service.SendToLineMQService;
import com.metersbonwe.stock.configuration.PropertiesManager;
import com.metersbonwe.stock.dal.define.core.mapper.UsefulWarehChangeCoreMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/4/5
 */
public class SendToLineMQServiceImpl implements SendToLineMQService, MessageListener {
    private static StockLog                LOGGER        = StockLogFactory.getLogger(SendToLineMQServiceImpl.class);

    private static PropertiesManager       properManager = PropertiesManager.getPropertiesManager();

    @Autowired UsefulWarehChangeCoreMapper usefulWarehChangeCoreMapper;

    @Autowired MqSendService               mqSendService;

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            String channelCode = msg.getText();
            processSendToLineMQ(channelCode);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public void processSendToLineMQ(String channelCode) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("tableName", Constants.STOCK_CHANNEL_PROD_PREFIX + channelCode.toLowerCase());
        paramMap.put("subTableName", Constants.STOCK_CHANNEL_PROD_SUB_PREFIX + channelCode.toLowerCase());
        List<ChannelProdBean> channelProdBeanList = usefulWarehChangeCoreMapper.getNeedSendData(paramMap);
        String sendToLineListSize = properManager.getProperty("send.toline.list.size", "5000");
        int listSize = Integer.parseInt(sendToLineListSize);
        List<List<ChannelProdBean>> list = CommonUtil.splitList(channelProdBeanList, listSize);
        for (List<ChannelProdBean> channelProdBeans : list) {
            mqSendService.sendToOnLineChannelStock(channelProdBeans, channelCode);
        }
    }
}
