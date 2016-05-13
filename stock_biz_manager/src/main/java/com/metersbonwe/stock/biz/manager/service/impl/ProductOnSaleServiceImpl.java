package com.metersbonwe.stock.biz.manager.service.impl;

import com.metersbonwe.oms.channel.bean.ChannelApiResult;
import com.metersbonwe.oms.channel.service.ChannelService;
import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.ChannelOmsApiService;
import com.metersbonwe.stock.biz.manager.service.ProductOnSaleService;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.pojo.Page;
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
@Service public class ProductOnSaleServiceImpl implements ProductOnSaleService {

    @Resource ChannelOmsApiService channelOmsApiServiceImpl;

    @Resource ChannelService       channelService;

    @SuppressWarnings("rawtypes")
    @Override
    public List<ChannelProdBean> selectOnlineChannelStock(Map<String, String> paramMap, Page<?> page) throws Exception {
        String channelCode = paramMap.get(Constants.ParamMapKey.CHANNEL_CODE);
        int pageNo = page.getPageNo();
        Map<String, Integer> onlineChannelStockMap = channelOmsApiServiceImpl.selectOnlineChannelStock(channelCode, pageNo);
        List<ChannelProdBean> channelProdBeanList = new ArrayList<>();
        for (Map.Entry entry : onlineChannelStockMap.entrySet()) {
            int onlineStock = entry.getValue() == null ? 0 : (int) entry.getValue();
            ChannelProdBean channelProdBean = new ChannelProdBean();
            channelProdBean.setChannelCode(channelCode);
            channelProdBean.setProdId(entry.getKey().toString().split("#")[1]);
            channelProdBean.setOnlineStock(onlineStock);
            channelProdBeanList.add(channelProdBean);
        }
        ChannelApiResult result = channelService.onSellList(channelCode, null, 1, 0);
        int total = Integer.valueOf(result.getTotal());
        int pageSize = result.getShellList().size();
        page.setTotalRecord(total);
        page.setPageSize(pageSize);
        page.setTotalPage(result.getNumIid());
        return channelProdBeanList;
    }
}
