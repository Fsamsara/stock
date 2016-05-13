package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.manager.service.StockChannelProdService;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelProdDefineMapper;
import com.metersbonwe.stock.pojo.StockChannelProdBean;

@Service("stockChannelProdService")
public class StockChannelProdServiceImpl implements StockChannelProdService {

    @Autowired
    StockChannelProdDefineMapper stockChannelProdDefineMapper;

    @Override
    public List<StockChannelProdBean> selectForChannelsAndProds(Map<String, List<String>> paramListMap) {
        

        if (paramListMap != null && paramListMap.size() > 0) {
            List<String> channelCodes = paramListMap.get("channelCode");
            
            if(channelCodes != null && channelCodes.size() > 0) {
                StockChannelProdBean stockChannelProdBean = new StockChannelProdBean();
                stockChannelProdBean.setChannelCodes(paramListMap.get("channelCode"));
                stockChannelProdBean.setProdIds(paramListMap.get("prodId"));
                return stockChannelProdDefineMapper.selectForChannelsAndProds(stockChannelProdBean);
            }
        }

        return null;
    }
}
