package com.metersbonwe.stock.biz.common.localcache.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.metersbonwe.stock.biz.common.localcache.CacheName;
import com.metersbonwe.stock.biz.common.localcache.LocalCacheProvider;
import com.mtsbw.soa.udb.common.model.AllotScopeBean;
import com.mtsbw.soa.udb.dubboservice.AllotScopeCashDubboService;

@Service /* 配发范围缓存提供者 */
public class ChannelScopeCacheProvider extends LocalCacheProvider<String, List<String>> {

    @Resource ChannelCodeCacheProvider   channelCodeCacheProvider;

    @Resource AllotScopeCashDubboService allotScopeCashDubboService;

    @Override
    public String getCacheName() {
        return CacheName.CHANNELSCOPE.getCacheName();
    }

    @Override
    public Map<String, List<String>> getAllCacheData() {
        Map<String, List<String>> cache = Maps.newHashMap();
        List<String> channelList = getAllUsefulChannel();
        for (String channelCode : channelList) {
            cache.put(channelCode, getOnlineAllotScopeByChannel(channelCode));
        }
        return cache;
    }

    public List<String> getAllUsefulChannel() {
        return channelCodeCacheProvider.getAllUsefulChannel();
    }

    public List<String> getOnlineAllotScopeByChannel(String channelCode) {
        List<String> channels = new ArrayList<>();
        //        0是线上  1是线下
        List<AllotScopeBean> allotScopeBeans = getOnlineAllotScopeByChannelForBean(channelCode);
        if (CollectionUtils.isNotEmpty(allotScopeBeans)) {
            for (AllotScopeBean allotScopeBean : allotScopeBeans) {
                channels.add(allotScopeBean.getCode());
            }
        }
        return channels;
    }

    public List<AllotScopeBean> getOnlineAllotScopeByChannelForBean(String channelCode) {
        return allotScopeCashDubboService.getAllotScopeBeanByChannel(channelCode, AllotScopeBean.IsOOS_ONLINE);
    }

    @Override
    public List<String> get(String key) {
        return getAllCacheData().get(key);
    }

}
