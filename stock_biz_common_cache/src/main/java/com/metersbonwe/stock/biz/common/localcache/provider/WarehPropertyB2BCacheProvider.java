package com.metersbonwe.stock.biz.common.localcache.provider;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.metersbonwe.stock.biz.common.localcache.CacheName;
import com.metersbonwe.stock.biz.common.localcache.LocalCacheProvider;
import com.metersbonwe.stock.dal.define.sync.mapper.WarePropertySyncMapper;

@Service public class WarehPropertyB2BCacheProvider extends LocalCacheProvider<String, List<String>> {

    @Resource WarePropertySyncMapper warePropertySyncMapper;

    @Override
    public String getCacheName() {
        return CacheName.WAREHB2B.getCacheName();
    }

    @Override
    public Map<String, List<String>> getAllCacheData() {
        Map<String, List<String>> cache = Maps.newHashMap();
        cache.put(getCacheName(), getB2Bwareh());
        return cache;
    }
    
    public List<String> getB2Bwareh() {
        return warePropertySyncMapper.getB2Bwareh();
    }

    @Override
    public List<String> get(String key) {
        return getAllCacheData().get(getCacheName());
    }

}
