package com.metersbonwe.stock.biz.common.service;

import java.util.List;
import java.util.Map;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/4/25
 */

public interface CacheService {
    List<String> getChannelScopeFromCache(String channelCode);

    /**
     * @description 获取渠道最终可以那个仓，剔除关店，门店总开关等情况的最终可用仓
     * @param channelCode 渠道编码
     * @return 最终可用仓List
     */
    List<String> getChannelUsefulWarehFromCache(String channelCode);

    /**
     * @description 获取系统所有有效渠道
     * @return 有效渠道列表
     */
    List<String> getAllUsefulChannelForCache();

    /**
     * @description 获取启用了B2B的仓
     * @return 启用了b2b仓List
     */
    List<String> getB2BWarehFromCache();

    /**
     * @description 获取店群关系缓存
     * @return 店群号对应的店铺
     */
    String getShopGroupFromCache(String channelCode);

    /**
     * @description 获取店群关系映射
     * @return 店群号对应的店铺
     */
    Map<String, List<String>> getShopGroupMapFromCache();
}
