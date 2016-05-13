package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.manager.service.StockChannelSendedService;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelSendedDefineMapper;
import com.metersbonwe.stock.po.core.StockChannelSended;
import com.metersbonwe.stock.pojo.StockChannelSendedBean;

@Service public class StockChannelSendedServiceImpl implements StockChannelSendedService {

    @Autowired private StockChannelSendedDefineMapper stockChannelSendedDefineMapper;

    @Override
    public List<StockChannelSended> selectForChannelsAndProds(StockChannelSendedBean stockChannelSendedBean) {

        if (stockChannelSendedBean != null) {
            return stockChannelSendedDefineMapper.selectForChannelsAndProds(stockChannelSendedBean);
        }
        return null;
    }
}
