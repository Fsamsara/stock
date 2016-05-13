package com.metersbonwe.stock.biz.common.fullsync;

/**
 * 三方库存全量同步
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-18 下午1:30:57
 */
public interface ThirdPartyStockSyncService {

    /**
     * 全量同步第三方库存
     */
    public void syncTpStock(); 

}
