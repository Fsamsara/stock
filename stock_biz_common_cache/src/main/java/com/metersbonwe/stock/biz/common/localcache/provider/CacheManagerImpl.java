package com.metersbonwe.stock.biz.common.localcache.provider;

import com.google.common.collect.Maps;
import com.metersbonwe.stock.biz.common.localcache.CacheManager;
import com.metersbonwe.stock.biz.common.localcache.CacheProvider;
import com.metersbonwe.stock.biz.common.localcache.LocalCache;
import com.metersbonwe.stock.biz.common.localcache.task.CacheTask;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressWarnings({ "unchecked", "rawtypes" }) public class CacheManagerImpl implements CacheManager, InitializingBean, Lifecycle {

    private Map<String, CacheProvider> providers = Maps.newHashMap();

    private Map<String, LocalCache>    caches    = Maps.newHashMap();

    private Map<String, CacheTask>     tasks     = Maps.newHashMap();

    private ThreadPoolTaskExecutor     stockCommonExecutor;

    private List<CacheProvider>        providerList;

    private volatile boolean           isStart   = false;

    private StockLog                   log       = StockLogFactory.getLogger(CacheManagerImpl.class);

    @Override
    public synchronized void registeCacheProvider(CacheProvider<?, ?> provider) {
        Assert.notNull(provider, "服务提供者为Null");
        Assert.notNull(provider.getCacheName(), "缓存名称为null");
        String cacheName = provider.getCacheName();
        if (providers.containsKey(cacheName)) {
            return;
        }
        if (caches.containsKey(cacheName)) {
            return;
        }
        if (tasks.containsKey(cacheName)) {
            return;
        }
        providers.put(cacheName, provider);
        caches.put(cacheName, new LocalCacheImpl(provider));
        tasks.put(cacheName, new CacheTask(provider, caches.get(cacheName)));
        CacheTask task = tasks.get(cacheName);
        task.setStart(true);
        stockCommonExecutor.execute(task);
        task.syncOnce();

    }

    public ThreadPoolTaskExecutor getStockCommonExecutor() {
        return stockCommonExecutor;
    }

    public void setStockCommonExecutor(ThreadPoolTaskExecutor stockCommonExecutor) {
        this.stockCommonExecutor = stockCommonExecutor;
    }

    @Override
    public <Key, Value> LocalCache<Key, Value> getCache(String cacheName) {
        return caches.get(cacheName);
    }

    @Override
    public void stopCacheTask(String cacheName) {
        CacheTask task = getCacheTask(cacheName);
        if (task == null)
            return;
        task.setStart(false);
    }

    private CacheTask getCacheTask(String cacheName) {
        return tasks.get(cacheName);
    }

    @Override
    public void syncOnce(String cacheName) {
        CacheTask task = getCacheTask(cacheName);
        if (task == null)
            return;
        task.syncOnce();
    }

    @Override
    public void start() {
        isStart = true;
    }

    @Override
    public void stop() {
        isStart = false;
        for (Iterator iterator = tasks.keySet().iterator(); iterator.hasNext();) {
            try {
                String key = (String) iterator.next();
                CacheTask task = tasks.get(key);
                if (task == null)
                    continue;
                task.setStart(false);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    @Override
    public boolean isRunning() {
        return isStart;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (providerList == null || providerList.isEmpty())
            return;
        for (CacheProvider aProviderList : providerList) {
            try {
                registeCacheProvider(aProviderList);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    public List<CacheProvider> getProviderList() {
        return providerList;
    }

    public void setProviderList(List<CacheProvider> providerList) {
        this.providerList = providerList;
    }
    
    
}
