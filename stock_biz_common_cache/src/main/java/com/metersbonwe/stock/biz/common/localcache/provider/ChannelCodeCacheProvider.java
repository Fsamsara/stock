package com.metersbonwe.stock.biz.common.localcache.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.metersbonwe.oms.api.bean.ChannelShop;
import com.metersbonwe.oms.channel.bean.ChannelApiResult;
import com.metersbonwe.oms.channel.service.ChannelService;
import com.metersbonwe.stock.biz.common.localcache.CacheName;
import com.metersbonwe.stock.biz.common.localcache.LocalCacheProvider;

@Service public class ChannelCodeCacheProvider extends LocalCacheProvider<String, List<String>> {

    @Resource ChannelService channelService;

    @Override
    public String getCacheName() {
        return CacheName.CHANNEL.getCacheName();
    }

    @Override
    public Map<String, List<String>> getAllCacheData() {
        List<String> item = getAllUsefulChannel();
        Map<String, List<String>> map = Maps.newHashMap();
        map.put(getCacheName(), item);
        return map;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<String> getAllUsefulChannel() {
        List<String> channels = new ArrayList<>();
        ChannelApiResult result = channelService.getAllSynStockChannelShop();
        if (result == null) {
            throw new RuntimeException("获取渠道列表出错！");
        }
        List<ChannelShop> channelShops = result.getChannelShopList();
        if (CollectionUtils.isNotEmpty(channelShops)) {
            for (ChannelShop channelShop : channelShops) {
                channels.add(channelShop.getShopCode());
            }
        }
        return channels;
    }

    @Override
    public List<String> get(String key) {
        return getAllCacheData().get(key);
    }

}
