package com.metersbonwe.stock.biz.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.metersbonwe.oms.api.bean.ChannelShop;
import com.metersbonwe.oms.channel.bean.ChannelApiResult;
import com.metersbonwe.oms.channel.service.ChannelService;
import com.metersbonwe.stock.biz.common.localcache.provider.ChannelCodeCacheProvider;
import com.metersbonwe.stock.biz.common.localcache.provider.ChannelScopeCacheProvider;
import com.metersbonwe.stock.biz.common.service.ActivityWarehService;
import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.dal.define.sync.mapper.AllocationRangeSyncMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelScope;
import com.metersbonwe.stock.pojo.AllotScopeParamBean;
import com.metersbonwe.stock.pojo.AllotScopeStockBean;
import com.mtsbw.soa.udb.common.model.AllotScopeBean;
import com.mtsbw.soa.udb.common.model.AllotScopeParam;
import com.mtsbw.soa.udb.dubboservice.AllotScopeCashDubboService;
import com.mtsbw.soa.udb.dubboservice.AllotScopeDubboService;

@Service public class AllocationRangeServiceImpl implements AllocationRangeService {

    private static StockLog              LOGGER = StockLogFactory.getLogger(AllocationRangeServiceImpl.class);

    @Autowired AllocationRangeSyncMapper allocationRangeSyncMapper;

    @Resource AllotScopeCashDubboService allotScopeCashDubboService;

    @Resource ChannelScopeCacheProvider  channelScopeCacheProvider;

    @Resource ChannelService             channelService;

    @Resource AllotScopeDubboService     allotScopeDubboService;

    @Resource ActivityWarehService       activityWarehServiceImpl;

    @Resource ChannelCodeCacheProvider   channelCodeCacheProvider;

    @Override
    public List<String> getUsefulWareH() {
        return allocationRangeSyncMapper.getUsefulWareH();
    }

    @Override
    public List<AllotScopeStockBean> getAllotScope(AllotScopeParamBean paramBean) {
        List<AllotScopeStockBean> scopeBeanList = new ArrayList<AllotScopeStockBean>();
        //组装查询配发范围参数
        AllotScopeParam allotScopeParam = new AllotScopeParam();
        allotScopeParam.setChannel(paramBean.getChannelCode());
        if (activityWarehServiceImpl.isChannelSourceOnLine(paramBean.getChannelSource())) { //线上
            allotScopeParam.setIsOOS("0");
            allotScopeParam.setDocSource("03");
        } else { //线下
            allotScopeParam.setIsOOS("1");
            allotScopeParam.setDocSource("01");
        }
        allotScopeParam.setProvince(paramBean.getProvince());
        allotScopeParam.setCity(paramBean.getCity());
        allotScopeParam.setDistrict(paramBean.getDistrict());

        //获取配发范围
        List<AllotScopeBean> allotScopeList = allotScopeDubboService.getAllotScopeBean(allotScopeParam);
        if (allotScopeList != null && allotScopeList.size() > 0) {
            for (AllotScopeBean allotScopeBean : allotScopeList) {
                AllotScopeStockBean allotScopeStockBean = new AllotScopeStockBean();
                allotScopeStockBean.setWarehShopId(allotScopeBean.getCode());
                allotScopeStockBean.setWarehShopType(allotScopeBean.getWhType());

                scopeBeanList.add(allotScopeStockBean);
            }
        }
        return scopeBeanList;
    }

    /**
     * TODO 获取所有线上渠道的配发范围
     * 
     * @return
     */
    @Override
    public Map<String, List<String>> getAllOnlineAllotScopes() {
        Map<String, List<String>> reMap = Maps.newHashMap();
        List<String> channels = getAllUsefulChannel();
        if (CollectionUtils.isNotEmpty(channels)) {
            for (String channel : channels) {
                reMap.put(channel, getOnlineAllotScopeByChannel(channel));
            }
        }
        return reMap;
    }

    @Override
    public Map<StockChannelScope, List<AllotScopeBean>> getAllOnlineAllotScopesForBean() {
        Map<StockChannelScope, List<AllotScopeBean>> reMap = Maps.newHashMap();
        List<StockChannelScope> channels = getAllUsefulChannelForBean();
        if (CollectionUtils.isNotEmpty(channels)) {
            LOGGER.debug("所有渠道列表:" + JSON.toJSONString(channels));
            for (StockChannelScope channel : channels) {
                reMap.put(channel, getOnlineAllotScopeByChannelForBean(channel.getChannelCode()));
            }
        }
        return reMap;
    }

    /**
     * TODO 获取单渠道的线上配发范围
     * 
     * @param channelCode
     * @return
     */
    @Override
    public List<String> getOnlineAllotScopeByChannel(String channelCode) {
        return channelScopeCacheProvider.getOnlineAllotScopeByChannel(channelCode);
    }

    @Override
    public List<AllotScopeBean> getOnlineAllotScopeByChannelForBean(String channelCode) {
        return channelScopeCacheProvider.getOnlineAllotScopeByChannelForBean(channelCode);
    }

    /**
     * TODO 获取单仓|店的线上渠道配发范围
     * 
     * @param warehId
     * @return
     */
    @Override
    public List<String> getOnlineAllotScopeByWarehId(String warehId) {
        Map<String, List<String>> scopeMap = getAllOnlineAllotScopes();
        List<String> channels = new ArrayList<>();
        for (Entry<String, List<String>> entry : scopeMap.entrySet()) {
            String channelCode = entry.getKey();
            List<String> codes = entry.getValue();
            for (String code : codes) {
                if (code.equals(warehId)) {
                    channels.add(channelCode);
                    break;
                }
            }
        }
        return channels;
    }

    /**
     * TODO 获取渠道+单仓|店的线上渠道配发范围
     * 
     * @param warehId
     * @return
     */
    @Override
    public StockChannelScope getOnlineAllotScopeByChannelWarehId(String channelCode, String warehId) {
        StockChannelScope stockChannelScope = new StockChannelScope();
        Map<StockChannelScope, List<AllotScopeBean>> scopeMap = getAllOnlineAllotScopesForBean();
        if (MapUtils.isNotEmpty(scopeMap)) {
            for (Entry<StockChannelScope, List<AllotScopeBean>> entry : scopeMap.entrySet()) {
                if (channelCode.equals(entry.getKey().getChannelCode())) {
                    List<AllotScopeBean> beans = entry.getValue();
                    for (AllotScopeBean allotScopeBean : beans) {
                        if (warehId.equals(allotScopeBean.getCode())) {
                            stockChannelScope.setChannelCode(channelCode);
                            stockChannelScope.setChannelName(entry.getKey().getChannelName());
                            stockChannelScope.setWarehId(warehId);
                            stockChannelScope.setWarehName(allotScopeBean.getName());
                            break;
                        }
                    }
                }
            }
        }
        return stockChannelScope;
    }

    @Override
    public List<String> getAllUsefulChannel() {
        return channelCodeCacheProvider.getAllUsefulChannel();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<StockChannelScope> getAllUsefulChannelForBean() {
        List<StockChannelScope> channels = new ArrayList<>();
        ChannelApiResult result = channelService.getAllSynStockChannelShop();
        if (result == null) {
            throw new RuntimeException("获取渠道列表出错！");
        }
        List<ChannelShop> channelShops = result.getChannelShopList();
        if (CollectionUtils.isNotEmpty(channelShops)) {
            for (ChannelShop channelShop : channelShops) {
                StockChannelScope scope = new StockChannelScope();
                scope.setChannelCode(channelShop.getShopCode());
                scope.setChannelName(channelShop.getShopTitle());
                channels.add(scope);
            }
        }
        return channels;
    }

}
