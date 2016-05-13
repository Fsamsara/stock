package com.metersbonwe.stock.biz.common.localcache;

/**
 * 缓存管理中心
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-21 下午3:15:38
 */
public interface CacheManager {

    /**
     * 注册缓存提供者
     * 
     * @param provider
     *            缓存提供者
     */
    void registeCacheProvider(CacheProvider<?, ?> provider);

    /**
     * 获取缓存
     * 
     * @param cacheName
     *            缓存名称
     * @return 缓存
     */
    <Key, Value> LocalCache<Key, Value> getCache(String cacheName);

    /**
     * 停止缓存同步定时任务
     * 
     * @param cacheName
     *            缓存名称
     */
    void stopCacheTask(String cacheName);

    /**
     * 执行一次缓存同步
     * 
     * @param cacheName
     *            缓存名称
     */
    void syncOnce(String cacheName);
}
