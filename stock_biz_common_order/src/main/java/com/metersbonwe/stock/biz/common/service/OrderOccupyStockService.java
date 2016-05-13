package com.metersbonwe.stock.biz.common.service;


import com.metersbonwe.stock.pojo.StockChannelBean;

/**
 * TODO 订单占用服务
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年3月26日 下午2:12:45
 * @since V1.0
 * @version V1.0
 */
public interface OrderOccupyStockService {

    /**
     * TODO 订单占用
     *
     * @param channelProdBean
     * @throws Exception
     */
    void processOrderOccupyStock(StockChannelBean stockChannelBean) throws Exception;

}
