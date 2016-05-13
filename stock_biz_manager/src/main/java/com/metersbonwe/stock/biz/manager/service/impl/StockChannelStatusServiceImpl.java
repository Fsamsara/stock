package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.manager.service.StockChannelStatusService;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelStatusDefineMapper;
import com.metersbonwe.stock.po.core.StockChannelStatus;
import com.metersbonwe.stock.pojo.PageStockChannelStatusBean;

@Service
public class StockChannelStatusServiceImpl implements StockChannelStatusService {
    
    @Autowired private StockChannelStatusDefineMapper stockChannelStatusDefineMapper;
    
    @Override
    public List<StockChannelStatus> selectPageStockChannelStatus(PageStockChannelStatusBean pageBean) {
        if (pageBean != null) {
            return stockChannelStatusDefineMapper.selectStockChannelStatus(pageBean);
        }return null;
    }

}
