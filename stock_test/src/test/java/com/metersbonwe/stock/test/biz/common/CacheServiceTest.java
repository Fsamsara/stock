package com.metersbonwe.stock.test.biz.common;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.biz.common.fullsync.invoke.StockFullSyncExector;
import com.metersbonwe.stock.biz.common.localcache.CacheManager;
import com.metersbonwe.stock.biz.common.localcache.CacheName;
import com.metersbonwe.stock.biz.common.localcache.LocalCache;
import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.configuration.ThreadConfig;
import com.metersbonwe.stock.test.TestBase;

public class CacheServiceTest extends TestBase {

    @Resource AllocationRangeService allocationRangeServiceImpl; ;

    @Resource CacheManager           cacheManagerImpl;

    //@Resource CacheService cacheServiceImpl;
    @Resource StockFullSyncExector   stockFullSyncExector;

    @Test
    public void testChannelCache() throws SQLException, IOException {
        //        List<String> s = cacheServiceImpl.getAllUsefulChannelForCache();
        //        System.out.println(s);
        stockFullSyncExector.preform(new ThreadConfig());

    }

    @Test
    public void testShopGroupCache() {
        LocalCache<String, String> cache = cacheManagerImpl.getCache(CacheName.SHOPGROUP.getCacheName());
        System.out.println(cache.getMap());
    }

    @Test
    public void testUserfulCache() {
        LocalCache<String, String> cache = cacheManagerImpl.getCache(CacheName.CHANNELUSEFULWAREH.getCacheName());
        System.out.println(cache.getMap());
    }

}
