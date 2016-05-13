package com.metersbonwe.stock.biz.common.localcache;

/**
 * 缓存名称
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-22 上午11:19:56
 */
public enum CacheName {
    /**
     * 可用渠道缓存
     */
    CHANNEL {
        public String getCacheName() {
            return name();
        }
    },
    /**
     * 是否启用B2B仓库配置
     */
    WAREHB2B {
        @Override
        public String getCacheName() {
            return name();
        }
    },
    /**
     * 渠道可用仓库缓存配置
     */
    CHANNELUSEFULWAREH {
        @Override
        public String getCacheName() {
            return name();
        }
    },
    /**
     * 配发范围
     */
    CHANNELSCOPE {
        @Override
        public String getCacheName() {
            return name();
        }
    },
    /**
     * 店群配置
     */
    SHOPGROUP {
        @Override
        public String getCacheName() {
            return name();
        }
    };

    /**
     * 获取缓存名称
     * 
     * @return 缓存名称
     */
    public abstract String getCacheName();
}
