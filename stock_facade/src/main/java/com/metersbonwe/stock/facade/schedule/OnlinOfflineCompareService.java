package com.metersbonwe.stock.facade.schedule;

import java.util.Map;

/**
 * TODO 平台线上和线下库存对比
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年3月26日 下午5:06:55
 * @since V1.0
 * @version V1.0
 */
public interface OnlinOfflineCompareService {
    /**
     * TODO 平台线上和线下库存对比
     * 
     * @throws Exception
     */
    void compareService(Map<String, String> paraMap) throws Exception;

}
