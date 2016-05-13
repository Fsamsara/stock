package com.metersbonwe.stock.biz.log.resolver;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.metersbonwe.stock.biz.log.LogSystemConfig;
import com.metersbonwe.stock.biz.log.bean.MethodArgsLogs;
import com.metersbonwe.stock.biz.log.bean.PointcutBean;

@Service public class JmsTextMessageArgsResolver extends AbstractArgsResolver {
    @Resource LogSystemConfig logSystemConfig;

    @Override
    public List<MethodArgsLogs> resolver(PointcutBean pointcutBean, Object obj) {
        if (obj instanceof TextMessage) {
            TextMessage message = (TextMessage) obj;
            try {
                List<MethodArgsLogs> mals = Lists.newArrayList();

                String msg = message.getText();
                JSONObject json = JSON.parseObject(msg);
                MethodArgsLogs logs = new MethodArgsLogs();
                logs.setServicename(getServiceName(pointcutBean));
                logs.setClassname(pointcutBean.getClazz().getName());
                logs.setMethodname(pointcutBean.getMethodName());
                logs.setLogtime(new Date());
                logs.setChannelcode(getChannelCode1(json));
                logs.setContent(msg);
                logs.setIp(getIp());
                logs.setProdid(getProdId1(json));
                logs.setWarehid(getWarehId1(json));
                mals.add(logs);
                return mals;
            } catch (JMSException e) {
            }
        }
        return null;
    }

    private String getWarehId1(JSONObject json) {
        return json.getString("warehId");
    }

    private String getProdId1(JSONObject json) {
        return (String) json.getString("prodId");
    }

    private String getChannelCode1(JSONObject json) {
        return (String) json.get("channelCode");
    }

    @Override
    protected LogSystemConfig getLogSystemConfig() {
        return logSystemConfig;
    }

}
