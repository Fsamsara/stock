package com.metersbonwe.stock.biz.common.localcache.provider;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.metersbonwe.stock.biz.common.localcache.CacheName;
import com.metersbonwe.stock.biz.common.localcache.LocalCacheProvider;
import com.metersbonwe.stock.dal.define.sync.mapper.BfOrgShopGroupDefineMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;

/**
 * 店群缓存提供者 KEY是渠道号，VALUE是店群号
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-23 下午4:27:42
 */
@Service public class ShopGroupCacheProvider extends LocalCacheProvider<String, String> {

    @Resource BfOrgShopGroupDefineMapper bfOrgShopGroupDefineMapper;

    @Resource ChannelCodeCacheProvider   channelCodeCacheProvider;

    StockLog                             log = StockLogFactory.getLogger(ShopGroupCacheProvider.class);

    @Override
    public String getCacheName() {
        return CacheName.SHOPGROUP.getCacheName();
    }

    @Override
    public Map<String, String> getAllCacheData() {
        List<String> channels = channelCodeCacheProvider.getAllUsefulChannel();

        if (CollectionUtils.isEmpty(channels)) {
            log.error("获取可用渠道为空", new Exception());
            return null;
        }
        List<Map<String, String>> shopGroupDtls = bfOrgShopGroupDefineMapper.selectShopGroup(channels);
        if (CollectionUtils.isEmpty(shopGroupDtls)) {
            log.error("获取店群数据为空", new Exception());
            return null;
        }
        Map<String, String> cache = Maps.newHashMap();
        for (Map<String, String> beanMap : shopGroupDtls) {
            if (beanMap == null || beanMap.isEmpty()) {
                continue;
            }
            String channelCode = beanMap.get("CHANNEL_CODE");
            String groupCode = beanMap.get("GROUP_CODE");
            if (StringUtils.isEmpty(channelCode) || StringUtils.isEmpty(groupCode)) {
                continue;
            }
            cache.put(channelCode, groupCode);
        }
        return cache;
    }

    @Override
    public String get(String key) {
        if (null != getAllCacheData()) {
            return getAllCacheData().get(key);
        } else {
            return "";
        }
    }

}
