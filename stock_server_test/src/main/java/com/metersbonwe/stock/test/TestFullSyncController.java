package com.metersbonwe.stock.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.metersbonwe.stock.biz.common.localcache.CacheManager;
import com.metersbonwe.stock.biz.common.localcache.CacheName;
import com.metersbonwe.stock.biz.common.localcache.LocalCache;
import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.biz.common.service.CacheService;
import com.metersbonwe.stock.biz.common.service.OrderOccupyStockService;
import com.metersbonwe.stock.biz.common.service.OrderReleaseStockService;
import com.metersbonwe.stock.biz.queue.service.impl.OrderOccupyStockQueueServiceImpl;
import com.metersbonwe.stock.dal.auto.core.mapper.StockCommonConfigMapper;
import com.metersbonwe.stock.facade.sync.api.FullStockSyncService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockCommonConfig;
import com.metersbonwe.stock.po.core.StockCommonConfigExample;
import com.metersbonwe.stock.pojo.StockChannelBean;

@Controller public class TestFullSyncController {
    @Resource AllocationRangeService           allocationRangeServiceImpl;

    @Resource FullStockSyncService             fullStockSyncServiceImpl;

    @Resource StockCommonConfigMapper          stockCommonConfigMapper;

    @Resource CacheService                     cacheServiceImpl;

    @Resource CacheManager                     cacheManagerImpl;

    @Resource OrderOccupyStockQueueServiceImpl orderOccupyStockQueueServiceImpl;

    @Resource OrderOccupyStockService          orderOccupyStockServiceImpl;

    @Resource OrderReleaseStockService         orderReleaseStockServiceImpl;

    StockLog                                   log = StockLogFactory.getLogger(TestFullSyncController.class);

    @SuppressWarnings("unchecked")
    @ResponseBody
    @RequestMapping(value = "/fullstock")
    public String ss(@RequestParam(value = "scope", required = false) String scope,
            @RequestParam(value = "isClearMock", required = false, defaultValue = "false") boolean isClearMock) {
        Map<String, List<String>> channelScope = JSONObject.parseObject(scope, Map.class);
        if (!StringUtils.isEmpty(scope)) {
            StockCommonConfig config = new StockCommonConfig();
            config.setConfigGroup("chanel_scope_mock");
            config.setConfigName("mock");
            config.setConfigValue(scope);
            config.setCreateTime(new Date());
            config.setCreateBy("zry");
            try {
                stockCommonConfigMapper.insertSelective(config);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        setChannelSocpeMock(isClearMock, channelScope);
        return "执行成功";
    }

    @ResponseBody
    @RequestMapping(value = "/initmock")
    public String initmock() {
        StockCommonConfigExample example = new StockCommonConfigExample();
        example.or().andConfigGroupEqualTo("chanel_scope_mock");
        List<StockCommonConfig> item = stockCommonConfigMapper.selectByExample(example);
        if (item != null && !item.isEmpty()) {
            for (int i = 0; i < item.size(); i++) {
                try {
                    StockCommonConfig config = item.get(i);
                    String mock = config.getConfigValue();
                    log.debug(mock);
                    @SuppressWarnings("unchecked")
                    Map<String, List<String>> channelScope = JSONObject.parseObject(mock, Map.class);
                    setChannelSocpeMock(false, channelScope);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return "加载成功";
    }

    private void setChannelSocpeMock(boolean isClearMock, Map<String, List<String>> channelScope) {}

    @ResponseBody
    @RequestMapping(value = "/scope")
    public String getChannelScope(@RequestParam("channelCode") String channelCode) {
        List<String> item = allocationRangeServiceImpl.getOnlineAllotScopeByChannel(channelCode);
        return JSON.toJSONString(item);
    }

    @ResponseBody
    @RequestMapping(value = "/runfull")
    public String runFullSync() {
        try {
            fullStockSyncServiceImpl.performFullStockSync();
        } catch (Exception e) {
            e.printStackTrace();
            return "全量同步执行失败";
        }
        return "全量同步执行完毕";
    }

    @ResponseBody
    @RequestMapping(value = "/channel")
    public String channel() {
        List<String> item = cacheServiceImpl.getAllUsefulChannelForCache();
        return JSON.toJSONString(item);
    }

    @ResponseBody
    @RequestMapping(value = "/useful")
    public String useful(@RequestParam("channelCode") String channelCode) {
        List<String> item = cacheServiceImpl.getChannelUsefulWarehFromCache(channelCode);
        return JSON.toJSONString(item);
    }

    @ResponseBody
    @RequestMapping(value = "/cachescope")
    public String socpeCache(@RequestParam("channelCode") String channelCode) {
        LocalCache<String, List<String>> cache = cacheManagerImpl.getCache(CacheName.CHANNELSCOPE.getCacheName());
        List<String> item = cache.get(channelCode);
        return JSON.toJSONString(item);
    }

    @ResponseBody
    @RequestMapping(value = "/occOrder")
    public String yuzhan(@RequestParam("param") String param) {
        List<StockChannelBean> item = JSON.parseArray(param, StockChannelBean.class);
        for (int i = 0; i < item.size(); i++) {
            StockChannelBean bean = item.get(i);
            try {
                orderOccupyStockServiceImpl.processOrderOccupyStock(bean);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        return "占用结束";
    }

    @ResponseBody
    @RequestMapping(value = "/ressOrder")
    public String ressOrder(@RequestParam("param") String param) {
        List<StockChannelBean> item = JSON.parseArray(param, StockChannelBean.class);
        for (int i = 0; i < item.size(); i++) {
            StockChannelBean bean = item.get(i);
            try {
                orderReleaseStockServiceImpl.updateOrderReleaseStock(bean);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        return "占用结束";
    }

}
