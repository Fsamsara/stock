package com.metersbonwe.stock.biz.common.localcache;

import java.util.Map;

/**
 * 缓存
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-21 下午5:12:25
 */
public interface LocalCache<Key, Value> {

    /**
     * 获取缓存
     * 
     * @param key
     *            缓存KEY
     * @return
     */
    Value get(Key key);

    /**
     * 获取KEY为缓存名称VALUE为list的数据
     * 
     * @return
     */
    Value getSingle();

    /**
     * 是否包含key
     * 
     * @param key
     * @return
     */
    boolean containsKey(Key key);

    /**
     * 是否包含value
     * 
     * @param value
     * @return
     */
    boolean containsValue(Value value);

    /**
     * 设置缓存
     * 
     * @param key
     *            key
     * @param value
     *            value
     */
    void set(Key key, Value value);

    /**
     * @param map
     */
    void putAll(Map<Key, Value> map);

    void clear();

    Map<Key, Value> getMap();

    /**
     * 获取缓存名称
     * 
     * @return
     */
    String getName();
}
