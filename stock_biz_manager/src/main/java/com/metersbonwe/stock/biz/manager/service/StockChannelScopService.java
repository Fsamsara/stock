package com.metersbonwe.stock.biz.manager.service;

import java.util.List;

import com.metersbonwe.stock.po.core.StockChannelScope;

/**
 * TODO 渠道配发范围服务
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年3月30日 上午10:24:17
 * @since V1.0
 * @version V1.0
 */
public interface StockChannelScopService {

    /**
     * TODO 根据条件查询渠道配发范围
     *
     * @param scopeVo
     * @return
     * @throws Exception
     */
    List<StockChannelScope> selectStockChannelScope(StockChannelScope scope) throws Exception;

}
