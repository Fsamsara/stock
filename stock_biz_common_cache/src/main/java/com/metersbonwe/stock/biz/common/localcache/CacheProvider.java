package com.metersbonwe.stock.biz.common.localcache;

import java.util.Map;

/**
 * 缓存提供者
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-21 下午2:31:25
 */
public interface CacheProvider<Key, Value> {

    /**
     * 获取缓存名称
     * 
     * @return 缓存名称
     */
    String getCacheName();

    /**
     * 获取所有缓存数据
     * 
     * @return
     */
    Map<Key, Value> getAllCacheData();

    /**
     * 获取单条数据
     * 
     * @param key
     *            key
     * @return value
     */
    Value get(Key key);

    /**
     * 获取刷新间隔
     * 
     * @return 时间 毫秒数
     */
    int getRefreshInterval();

    /**
     * 是否需要启动缓存对比定时任务
     * 
     * @return
     */
    boolean isStartCacheTask();

    /**
     * 是否强制更新缓存
     * 
     * @return
     */
    boolean isForceUpdateCache();

}
