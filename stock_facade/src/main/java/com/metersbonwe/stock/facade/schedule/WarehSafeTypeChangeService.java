package com.metersbonwe.stock.facade.schedule;

/**
 * @author huangbiao
 * @version V1.0
 * @description 定时任务拉取tmp_safe_type_stock定时任务调度接口
 * @date 2016/3/26
 */
public interface WarehSafeTypeChangeService {
    /**
     * @description 定时任务调用用于处理tmp_safe_type_stock表数据的方法
     */
    void processTmpSafeTypeStockData();
}
