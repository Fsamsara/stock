package com.metersbonwe.stock.facade.sync.api;

/**
 * 全量同步相关业务 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-3-26 下午2:02:35
 */
public interface FullStockSyncService {
    
    /**
     * 全量同步主方法
     */
    void performFullStockSync();
    
    
}
