package com.metersbonwe.stock.biz.common.service;

import java.util.List;
import java.util.Map;

public interface ChannelOmsApiService {

    /**
     * TODO 获取线上库存（渠道） 查询单渠道 当前页数数据
     *
     * @param channelCode
     *            渠道
     * @param pageNo
     *            页码
     * @param pageSize
     *            每页多少条数据
     * @return
     * @throws Exception
     */
    Map<String, Integer> selectOnlineChannelStock(String channelCode, Integer pageNo) throws Exception;

    /**
     * TODO 获取线下库存（渠道）
     *
     * @param channelCode
     * @param prodIds
     * @return
     * @throws Exception
     */
    Map<String, Integer> selectOfflineChannelStocks(String channelCode, List<String> prodIds) throws Exception;

    /**
     * TODO 获取线上库存（渠道） 查询单渠道全部数据
     *
     * @param channelCode
     *            渠道
     * @param pageSize
     *            每页多少条数据
     * @return
     * @throws Exception
     */
    Map<String, Integer> selectOnlineChannelStock(String channelCode) throws Exception;
}
