package com.metersbonwe.stock.biz.common.localcache.provider;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.metersbonwe.stock.biz.common.localcache.CacheName;
import com.metersbonwe.stock.biz.common.localcache.LocalCacheProvider;
import com.metersbonwe.stock.dal.define.sync.mapper.AllocationRangeSyncMapper;

/**
 * 渠道最终可用仓 key: 渠道； value: 渠道最终可用仓
 */
@Service
public class ChannelUsefulWarehCacheProvider extends LocalCacheProvider<String, List<String>> {
//    @Resource AllocationRangeService allocationRangeServiceImpl;

    @Resource ChannelCodeCacheProvider channelCodeCacheProvider;
    
    @Resource AllocationRangeSyncMapper allocationRangeSyncMapper;
    
    @Resource ChannelScopeCacheProvider channelScopeCacheProvider;
    
    @Override public String getCacheName() {
        return CacheName.CHANNELUSEFULWAREH.getCacheName();
    }

    @Override public Map<String, List<String>> getAllCacheData() {
        List<String> allUsefulChannels = channelCodeCacheProvider.getAllUsefulChannel();
        List<String> usefulWareH = getUsefulWareH();
        Map<String, List<String>> cache = Maps.newHashMap();
        for(String channelCode : allUsefulChannels){
            List<String> channelScope = channelScopeCacheProvider.getOnlineAllotScopeByChannel(channelCode);
            channelScope.retainAll(usefulWareH);
            cache.put(channelCode, channelScope);
        }
        return cache;
    }
    
    public List<String> getUsefulWareH() {
        return allocationRangeSyncMapper.getUsefulWareH();
    }


    @Override public List<String> get(String key) {
        return getAllCacheData().get(key);
    }

}
