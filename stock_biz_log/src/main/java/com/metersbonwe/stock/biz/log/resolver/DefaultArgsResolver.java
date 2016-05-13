package com.metersbonwe.stock.biz.log.resolver;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.metersbonwe.stock.biz.log.LogSystemConfig;
import com.metersbonwe.stock.biz.log.bean.MethodArgsLogs;
import com.metersbonwe.stock.biz.log.bean.PointcutBean;

@Service public class DefaultArgsResolver extends AbstractArgsResolver implements ArgsResolver {
    @Resource LogSystemConfig logSystemConfig;

    @Override
    public List<MethodArgsLogs> resolver(PointcutBean pointcutBean, Object argsObj) {
        if (argsObj == null)
            return null;
        if (argsObj instanceof List) {
            List<?> item = (List<?>) argsObj;
            return resolverList(pointcutBean, item);
        }
        List<MethodArgsLogs> mals = Lists.newArrayList();
        String channelCode = getChannelCode(argsObj);
        String warehId = getWarehId(argsObj);
        String prodId = getProdId(argsObj);
        MethodArgsLogs logs = new MethodArgsLogs();
        logs.setChannelcode(channelCode);
        logs.setClassname(pointcutBean.getClazz().getName());
        logs.setMethodname(pointcutBean.getMethodName());
        logs.setWarehid(warehId);
        logs.setProdid(prodId);
        logs.setContent(JSON.toJSONString(argsObj));
        logs.setLogtime(new Date());
        logs.setServicename(getServiceName(pointcutBean));
        logs.setIp(getIp());
        mals.add(logs);
        return mals;
    }

    private List<MethodArgsLogs> resolverList(PointcutBean pointcutBean, List<?> item) {
        List<MethodArgsLogs> mal = Lists.newArrayList();
        for (int i = 0; i < item.size(); i++) {
            if (item != null) {
                List<MethodArgsLogs> res = resolver(pointcutBean, item.get(i));
                if (res != null && !res.isEmpty()) {
                    mal.addAll(res);
                }
            }
        }
        return mal;
    }

    @Override
    protected LogSystemConfig getLogSystemConfig() {
        return logSystemConfig;
    }

}
