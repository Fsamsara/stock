package com.metersbonwe.stock.biz.manager.service.impl;

import com.metersbonwe.oms.channel.bean.ChannelApiResult;
import com.metersbonwe.oms.channel.service.ChannelService;
import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.ChannelOmsApiService;
import com.metersbonwe.stock.biz.manager.service.StockDiffBetweenOnlineAndSendedService;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.PageThreadLocal;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/5/6
 */
@Service public class StockDiffBetweenOnlineAndSendedServiceImpl implements StockDiffBetweenOnlineAndSendedService {

    @Resource ChannelOmsApiService channelOmsApiServiceImpl;

    @Resource ChannelService       channelService;

    @SuppressWarnings("rawtypes")
    @Override
    public List<ChannelProdBean> selectStockDiffBetweenOnlineAndSended(Map<String, String> paramMap, Page<?> page) throws Exception {
        String channelCode = paramMap.get(Constants.ParamMapKey.CHANNEL_CODE);
        int pageNo = page.getPageNo();
        Map<String, Integer> onlineChannelStockMap = channelOmsApiServiceImpl.selectOnlineChannelStock(channelCode, pageNo);
        List<String> prodIdList = new ArrayList<>();
        for (Map.Entry entry : onlineChannelStockMap.entrySet()) {
            prodIdList.add(String.valueOf(entry.getKey()).split("#")[1]);
        }
        //取消分页，否则同一方法里面有两个查询的话，无法查询到数据
        PageThreadLocal.setThreadLocalPage(null);
        Map<String, Integer> offlineChannelStocks = channelOmsApiServiceImpl.selectOfflineChannelStocks(channelCode, prodIdList);
        List<ChannelProdBean> channelProdBeanList = new ArrayList<>();
        for (Map.Entry entry : onlineChannelStockMap.entrySet()) {
            int onlineStock = entry.getValue() == null ? 0 : (int) entry.getValue();
            for (Map.Entry entryO : offlineChannelStocks.entrySet()) {
                int offlineStock = entryO.getValue() == null ? 0 : (int) entryO.getValue();
                if (entryO.getKey().equals(entry.getKey()) && offlineStock != onlineStock) {
                    ChannelProdBean channelProdBean = new ChannelProdBean();
                    channelProdBean.setFinalFreeStock(offlineStock);
                    channelProdBean.setChannelCode(channelCode);
                    channelProdBean.setProdId(entry.getKey().toString().split("#")[1]);
                    channelProdBean.setOnlineStock(onlineStock);
                    channelProdBeanList.add(channelProdBean);
                    break;
                }
            }
        }
        ChannelApiResult result = channelService.onSellList(channelCode, null, 1, 0);
        int total = channelProdBeanList.size(); //Integer.valueOf(result.getTotal());
        page.setTotalRecord(total);
        page.setTotalPage(result.getNumIid());
        return channelProdBeanList;
    }

}
