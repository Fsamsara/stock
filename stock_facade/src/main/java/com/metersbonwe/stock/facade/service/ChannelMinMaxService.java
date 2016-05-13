package com.metersbonwe.stock.facade.service;

import java.util.Map;

/**
 * @author zhq
 * @description 渠道全局最大值、最小值变化定时任务
 * @version V1.0
 */
public interface ChannelMinMaxService {

    /**
     * @description 渠道全局最大值、最小值变化处理
     */
    public void handleChannelMinMaxChange(Map<String, String> parm);
}
