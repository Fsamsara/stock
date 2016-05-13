package com.metersbonwe.stock.biz.common.service;

import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.po.core.StockChannelScope;
import com.metersbonwe.stock.pojo.AllotScopeParamBean;
import com.metersbonwe.stock.pojo.AllotScopeStockBean;
import com.mtsbw.soa.udb.common.model.AllotScopeBean;

/**
 * 配发范围相关公用业务
 * 
 * @author 张瑞雨
 */
public interface AllocationRangeService {
    /**
     * @description 获取平台可用仓
     * @return List 平台可用仓List
     */
    List<String> getUsefulWareH();

    /**
     * @description 获取所有渠道列表（渠道号）
     * @return List 所有渠道列表
     */
    List<String> getAllUsefulChannel();

    /**
     * @description 获取所有渠道列表（渠道BEAN）
     * @return List 所有渠道列表
     */
    List<StockChannelScope> getAllUsefulChannelForBean();

    /**
     * TODO 获取配发范围 TODO 查询库存需要获取配发范围
     * 
     * @param paramBean
     * @return
     */
    List<AllotScopeStockBean> getAllotScope(AllotScopeParamBean paramBean);

    /**
     * TODO 获取单仓|店的渠道配发范围
     * 
     * @param warehId
     * @return
     */
    List<String> getOnlineAllotScopeByWarehId(String warehId);

    /**
     * TODO 获取单渠道线上配发范围
     * 
     * @param channelCode
     * @return
     */
    List<String> getOnlineAllotScopeByChannel(String channelCode);

    /**
     * TODO 获取单渠道线上配发范围(BEAN形式)
     * 
     * @param channelCode
     * @return
     */
    List<AllotScopeBean> getOnlineAllotScopeByChannelForBean(String channelCode);

    /**
     * TODO 获取所有线上渠道配发范围
     * 
     * @return 渠道 - 仓|店集合
     */
    Map<String, List<String>> getAllOnlineAllotScopes();

    /**
     * TODO 获取所有线上渠道配发范围(bean)
     * 
     * @return 渠道 - 仓|店集合
     */
    Map<StockChannelScope, List<AllotScopeBean>> getAllOnlineAllotScopesForBean();

    /**
     * TODO 获取渠道+单仓|店的线上渠道配发范围
     * 
     * @param channelCode
     *            ,warehId
     * @return
     */
    StockChannelScope getOnlineAllotScopeByChannelWarehId(String channelCode, String warehId);

}
