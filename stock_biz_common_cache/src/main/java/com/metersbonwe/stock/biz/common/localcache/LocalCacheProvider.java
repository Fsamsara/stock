package com.metersbonwe.stock.biz.common.localcache;

import com.metersbonwe.stock.configuration.PropertiesManager;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;

/**
 * 本地缓存提供者
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-21 下午3:03:17
 */
public abstract class LocalCacheProvider<Key, Value> implements CacheProvider<Key, Value> {

    PropertiesManager          propertiesManager      = PropertiesManager.getPropertiesManager();

    StockLog                   log                    = StockLogFactory.getLogger(LocalCacheProvider.class);

    /** 默认刷新时间 5分钟 */
    protected static final int defaultRefreshInterval = 5 * 60 * 1000;

    public static final String LOCAL_CACHE_CONFIG     = "local.cache.";

    protected int              refreshInterval        = -1;

    protected boolean          startCacheTask         = true;

    @Override
    public int getRefreshInterval() {
        if (refreshInterval == -1) {
            String val = propertiesManager.getProperty(getRefreshIntervalConfigName(), defaultRefreshInterval + "");
            try {
                return Integer.parseInt(val.trim());
            } catch (Exception e) {
                log.warn("get Refresh Interval NumberFormatException. Cache Name : " + getCacheName(), e);
            }
            return defaultRefreshInterval;
        }
        return refreshInterval;
    }

    protected String getRefreshIntervalConfigName() {
        return LOCAL_CACHE_CONFIG + getCacheName() + ".interval";
    }

    @Override
    public boolean isStartCacheTask() {
        String start = propertiesManager.getProperty(getStartCacheTaskConfigName(), "true");
        try {
            return Boolean.valueOf(start.trim());
        } catch (Exception e) {
            log.warn(" isStartCacheTask BooleanFormatException. Cache Name : " + getCacheName(), e);
        }
        return false;
    }

    protected String getStartCacheTaskConfigName() {
        return LOCAL_CACHE_CONFIG + getCacheName() + ".isstart";
    }

    @Override
    public boolean isForceUpdateCache() {
        String start = propertiesManager.getProperty(getForceCacheTaskConfigName(), "false");
        try {
            return Boolean.valueOf(start.trim());
        } catch (Exception e) {
            log.warn(" isForceUpdateCache BooleanFormatException. Cache Name : " + getCacheName(), e);
        }
        return false;
    }

    private String getForceCacheTaskConfigName() {
        return LOCAL_CACHE_CONFIG + getCacheName() + ".isforce";
    }

}
