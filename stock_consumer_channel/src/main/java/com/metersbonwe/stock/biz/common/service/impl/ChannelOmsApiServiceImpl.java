package com.metersbonwe.stock.biz.common.service.impl;

import com.metersbonwe.oms.channel.bean.ChannelApiResult;
import com.metersbonwe.oms.channel.service.ChannelService;
import com.metersbonwe.stock.biz.common.service.ChannelOmsApiService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelSendedMapper;
import com.metersbonwe.stock.po.core.StockChannelSended;
import com.metersbonwe.stock.po.core.StockChannelSendedExample;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service public class ChannelOmsApiServiceImpl implements ChannelOmsApiService {

    @Resource StockChannelSendedMapper stockChannelSendedMapper;

    @Resource ChannelService           channelService;

    @Override
    public Map<String, Integer> selectOfflineChannelStocks(String channelCode, List<String> prodIds) throws Exception {
        StockChannelSendedExample example = new StockChannelSendedExample();
        example.createCriteria().andProdIdIn(prodIds);
        StockChannelSended beanParam = new StockChannelSended();
        beanParam.setChannelCode(channelCode);
        List<StockChannelSended> sendeds = stockChannelSendedMapper.selectByExample(beanParam, example);
        Map<String, Integer> offlineMap = new ConcurrentHashMap<>();
        if (CollectionUtils.isNotEmpty(sendeds)) {
            for (StockChannelSended stockChannelSended : sendeds) {
                offlineMap.put(stockChannelSended.getChannelCode() + "#" + stockChannelSended.getProdId(), stockChannelSended.getStockSended());
            }
        }
        return offlineMap;
    }

    @Override
    public Map<String, Integer> selectOnlineChannelStock(String channelCode, Integer pageNo) throws Exception {
        Map<String, Integer> reMap = new HashMap<>();
        ChannelApiResult result = channelService.onSellList(channelCode, null, pageNo, 0);
        List<Map<String, String>> maps = result.getShellList();
        if (CollectionUtils.isNotEmpty(maps)) {
            for (Map<String, String> map : maps) {
                reMap.put(channelCode + "#" + map.get("sku"), Integer.valueOf(map.get("channelStock")));
            }
        }
        return reMap;
    }

    @Override
    public Map<String, Integer> selectOnlineChannelStock(String channelCode) throws Exception {
        Map<String, Integer> reMap = new HashMap<>();
        ChannelApiResult result = channelService.onSellList(channelCode, null, 1, 0);
        int page = result.getNumIid();
        for (int i = 1; i <= page; i++) {
            result = channelService.onSellList(channelCode, null, i, 0);
            List<Map<String, String>> maps = result.getShellList();
            if (CollectionUtils.isNotEmpty(maps)) {
                for (Map<String, String> map : maps) {
                    reMap.put(channelCode + "#" + map.get("sku"), Integer.valueOf(map.get("channelStock")));
                }
            }
        }
        return reMap;
    }

}
