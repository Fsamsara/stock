package com.metersbonwe.stock.biz.common.service;

import com.metersbonwe.stock.pojo.StockChannelBean;

/**
 * TODO 订单释放服务
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年3月26日 下午2:12:45
 * @since V1.0
 * @version V1.0
 */
public interface OrderReleaseStockService {

    /**
     * TODO 订单释放处理过程
     *
     * @param channelProdBean
     * @throws Exception
     */
    void processOrderReleaseStock() throws Exception;

    /**
     * TODO 订单释放更新延迟标识
     *
     * @param channelProdBean
     * @throws Exception
     */
    int updateOrderReleaseStock(StockChannelBean stockChannelBean) throws Exception;

    /**
     * TODO 处理预售关闭动作
     *
     * @param channelProdBean
     * @throws Exception
     */
    void processForCloseProOrder(StockChannelBean stockChannelBean) throws Exception;

}
