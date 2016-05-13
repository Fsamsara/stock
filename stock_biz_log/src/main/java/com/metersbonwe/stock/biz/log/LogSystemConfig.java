package com.metersbonwe.stock.biz.log;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.log.bean.PointcutBean;

@Service public class LogSystemConfig {

    public String getServiceName(PointcutBean pointcutBean) {
        LogService logService = pointcutBean.getLogService();
        if (logService != null) {
            return logService.value();
        }
        return null;
    }

    public String getResolver(PointcutBean pointcutBean, int argsIdx) {
        LogService logService = pointcutBean.getLogService();
        if (logService != null) {
            try {
                return logService.resolverType();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "defaultArgsResolver";
    }

}
