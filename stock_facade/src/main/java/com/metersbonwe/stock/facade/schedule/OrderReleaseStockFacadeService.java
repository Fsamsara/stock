package com.metersbonwe.stock.facade.schedule;

/**
 * TODO 定时调度订单释放服务
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年4月23日 下午3:10:18
 * @since V1.0
 * @version V1.0
 */
public interface OrderReleaseStockFacadeService {
    /**
     * TODO 定时调度订单释放服务
     * 
     * @throws Exception
     */
    void processOrderReleaseStock() throws Exception;
}
