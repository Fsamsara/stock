package com.metersbonwe.stock.biz.common.service.impl;

import com.metersbonwe.stock.biz.common.localcache.CacheManager;
import com.metersbonwe.stock.biz.common.localcache.CacheName;
import com.metersbonwe.stock.biz.common.localcache.LocalCache;
import com.metersbonwe.stock.biz.common.localcache.provider.ChannelCodeCacheProvider;
import com.metersbonwe.stock.biz.common.localcache.provider.ChannelScopeCacheProvider;
import com.metersbonwe.stock.biz.common.localcache.provider.ChannelUsefulWarehCacheProvider;
import com.metersbonwe.stock.biz.common.localcache.provider.WarehPropertyB2BCacheProvider;
import com.metersbonwe.stock.biz.common.service.CacheService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/4/25
 */
@Service public class CacheServiceImpl implements CacheService {

    @Resource ChannelUsefulWarehCacheProvider channelUsefulWarehCacheProvider;

    @Resource ChannelScopeCacheProvider       channelScopeCacheProvider;

    @Resource ChannelCodeCacheProvider        channelCodeCacheProvider;

    @Resource WarehPropertyB2BCacheProvider   warehPropertyB2BCacheProvider;

    @Resource CacheManager                    cacheManagerImpl;

    private LocalCache<String, List<String>>  cache;

    private LocalCache<String, List<String>>  channelUsefulWarehCache;

    private LocalCache<String, List<String>>  b2bCache;

    private LocalCache<String, List<String>>  channelGroupCache;

    private LocalCache<String, List<String>>  channelScopeCache;

    @Override
    public List<String> getChannelScopeFromCache(String channelCode) {
        if (channelScopeCache == null && cacheManagerImpl != null) {
            channelScopeCache = cacheManagerImpl.getCache(CacheName.CHANNELSCOPE.getCacheName());
        }
        if (channelScopeCache == null) {
            return channelScopeCacheProvider.getOnlineAllotScopeByChannel(channelCode);
        }
        return channelScopeCache.get(channelCode);
    }

    @Override
    public List<String> getChannelUsefulWarehFromCache(String channelCode) {
        if (channelUsefulWarehCache == null && cacheManagerImpl != null) {
            channelUsefulWarehCache = cacheManagerImpl.getCache(CacheName.CHANNELUSEFULWAREH.getCacheName());
        }
        if (channelUsefulWarehCache == null) {
            List<String> usefulWareH = channelUsefulWarehCacheProvider.getUsefulWareH();
            List<String> channelScope = channelScopeCacheProvider.getOnlineAllotScopeByChannel(channelCode);
            channelScope.retainAll(usefulWareH);
            return channelScope;
        }
        return channelUsefulWarehCache.get(channelCode);
    }

    @Override
    public List<String> getAllUsefulChannelForCache() {
        if (cache == null && cacheManagerImpl != null) {
            cache = this.cacheManagerImpl.getCache(CacheName.CHANNEL.getCacheName());
        }
        if (cache == null) {
            return channelCodeCacheProvider.getAllUsefulChannel();
        }
        List<String> item = cache.getSingle();
        if (item == null || item.isEmpty()) {
            return channelCodeCacheProvider.getAllUsefulChannel();
        }
        return item;
    }

    @Override
    public List<String> getB2BWarehFromCache() {
        if (b2bCache == null && cacheManagerImpl != null) {
            b2bCache = cacheManagerImpl.getCache(CacheName.WAREHB2B.getCacheName());
        }
        if (b2bCache == null) {
            return warehPropertyB2BCacheProvider.getB2Bwareh();
        }
        return b2bCache.getSingle();
    }

    @Override
    public String getShopGroupFromCache(String channelCode) {
        if (channelGroupCache == null && cacheManagerImpl != null) {
            channelGroupCache = cacheManagerImpl.getCache(CacheName.SHOPGROUP.getCacheName());
        }
        return String.valueOf(channelGroupCache.get(channelCode));
    }

    @Override
    public Map<String, List<String>> getShopGroupMapFromCache() {
        if (channelGroupCache == null && cacheManagerImpl != null) {
            channelGroupCache = cacheManagerImpl.getCache(CacheName.SHOPGROUP.getCacheName());
        }
        return channelGroupCache.getMap();
    }

}
