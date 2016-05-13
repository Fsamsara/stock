package com.metersbonwe.stock.biz.common.localcache.task;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import com.metersbonwe.stock.biz.common.localcache.CacheProvider;
import com.metersbonwe.stock.biz.common.localcache.LocalCache;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;

/**
 * 缓存更新定时任务
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-21 下午3:53:22
 */
@SuppressWarnings({ "unchecked", "rawtypes" }) public class CacheTask implements Runnable {

    private CacheProvider<?, ?> provider;

    private AtomicBoolean       isStart = new AtomicBoolean(false);

    private LocalCache<?, ?>    cache;

    private String              name;

    public CacheTask(CacheProvider<?, ?> provider, LocalCache<?, ?> cache) {
        super();
        this.provider = provider;
        this.name = provider.getCacheName();
        this.cache = cache;
    }

    StockLog log = StockLogFactory.getLogger(CacheTask.class);

    @Override
    public void run() {
        while (isStart.get() && provider.isStartCacheTask()) {
            try {
                log.debug("CacheTask : " + provider.getCacheName() + " start");
                syncOnce();
                log.debug("CacheTask : " + provider.getCacheName() + " end");
                sleep(provider.getRefreshInterval());
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        isStart.set(false);
    }

    public synchronized void syncOnce() {
        try {
            Map item = provider.getAllCacheData();
            if (!provider.isForceUpdateCache()) {
                //如果不需要强制更新 保留原缓存
                if (item == null || item.isEmpty()) {
                    log.error("获取缓存数据失败", new Exception("获取缓存数据失败"));
                    return;
                }
            }
            cache.clear();
            cache.putAll(item);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private void sleep(int refreshInterval) {
        try {
            Thread.sleep(refreshInterval);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean IsStart() {
        return isStart.get();
    }

    public void setStart(boolean isStart) {
        this.isStart.set(isStart);
    }
}
