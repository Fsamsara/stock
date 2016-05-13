package com.metersbonwe.stock.biz.schedule.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.metersbonwe.oms.channel.bean.ChannelApiResult;
import com.metersbonwe.oms.channel.service.ChannelService;
import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.ChannelOmsApiService;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.OnlineChannelStockService;
import com.metersbonwe.stock.facade.schedule.OnlinOfflineCompareService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;

@Service public class OnlinOfflineCompareServiceImpl implements OnlinOfflineCompareService {

    private static StockLog             LOGGER = StockLogFactory.getLogger(OnlinOfflineCompareServiceImpl.class);

    @Resource MqSendService             mqSendService;

    @Resource OnlineChannelStockService onlineChannelStockServiceImpl;

    @Resource ChannelOmsApiService      channelOmsApiServiceImpl;

    @Resource ChannelService            channelService;

    @Override
    public void compareService(Map<String, String> paraMap) throws Exception {
        // 获取调度中心参数
        String channelCode = paraMap.get(Constants.CHANNEL_CODE);
        ChannelApiResult result = channelService.onSellList(channelCode, null, 1, 1);
        int page = result.getNumIid();
        for (int i = 1; i <= page; i++) {
            // 根据参数查询线上库存
            Map<String, Integer> onlineStocks = channelOmsApiServiceImpl.selectOnlineChannelStock(channelCode, i);
            if (onlineStocks == null)
                continue;
            List<String> prodIds = Lists.newArrayList();
            for (String key : onlineStocks.keySet()) {
                String prodId = key.split("#")[1];
                if (!prodIds.contains(prodId)) {
                    prodIds.add(prodId);
                }
            }
            // 根据参数查询线下库存
            Map<String, Integer> offlineStocks = channelOmsApiServiceImpl.selectOfflineChannelStocks(channelCode, prodIds);
            // 比较线上和线下库存差别,线上大于线下的商品,需要推送当前线下库存到线上
            comareAndSendDatas(onlineStocks, offlineStocks);
            LOGGER.info("线上线下对比完成进度: " + i + "/" + page + " ,当前渠道:" + channelCode);
        }
    }

    private void comareAndSendDatas(Map<String, Integer> onlineStocks, Map<String, Integer> offlineStocks) throws Exception {
        List<ChannelProdBean> beans = new ArrayList<>();
        for (Entry<String, Integer> entry : onlineStocks.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (offlineStocks.containsKey(key) && value > offlineStocks.get(key)) {
                Integer offineValue = offlineStocks.get(key);
                String[] codeProd = key.split("#");
                ChannelProdBean channelProdBean = new ChannelProdBean();
                channelProdBean.setChannelCode(codeProd[0]);
                channelProdBean.setProdId(codeProd[1]);
                channelProdBean.setOnlineStock(offineValue);
                channelProdBean.setOperType("2"); // 2表示是线上线下对比造成的推送
                beans.add(channelProdBean);
            }
        }
        onlineChannelStockServiceImpl.getOmsApiAndSendDatas(beans);
    }

}
