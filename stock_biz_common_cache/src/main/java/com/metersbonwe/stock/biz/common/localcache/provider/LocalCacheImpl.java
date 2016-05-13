package com.metersbonwe.stock.biz.common.localcache.provider;

import java.util.Map;

import com.google.common.collect.Maps;
import com.metersbonwe.stock.biz.common.localcache.CacheProvider;
import com.metersbonwe.stock.biz.common.localcache.LocalCache;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;

public class LocalCacheImpl<Key, Value> implements LocalCache<Key, Value> {

    private String                    name;

    private CacheProvider<Key, Value> provider;

    private final Map<Key, Value>     cache = Maps.newHashMap();

    StockLog                          log   = StockLogFactory.getLogger(LocalCacheImpl.class);

    public LocalCacheImpl(CacheProvider<Key, Value> provider) {
        super();
        this.provider = provider;
        this.name = provider.getCacheName();
    }

    @Override
    public Value get(Key key) {
        Value v = cache.get(key);
        if (v == null) {
            try {
                return provider.get(key);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return v;
            }
        }
        return v;
    }

    @Override
    public Value getSingle() {
        return  cache.get(name);
    }

    @Override
    public boolean containsKey(Key key) {
        return cache.containsKey(key);
    }

    @Override
    public boolean containsValue(Value value) {
        return cache.containsValue(value);
    }

    @Override
    public void set(Key key, Value value) {
        cache.put(key, value);
    }

    @Override
    public void putAll(Map<Key, Value> map) {
        cache.putAll(map);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    public Map<Key, Value> getMap() {
        return cache;
    }

    public String getName() {
        return name;
    }
    
    
}
