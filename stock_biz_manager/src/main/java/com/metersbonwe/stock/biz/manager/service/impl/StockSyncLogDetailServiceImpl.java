package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.manager.service.StockSyncLogDetailService;
import com.metersbonwe.stock.dal.auto.core.mapper.LogStockDetailMapper;
import com.metersbonwe.stock.po.core.LogStockDetail;
import com.metersbonwe.stock.po.core.LogStockDetailExample;

@Service public class StockSyncLogDetailServiceImpl implements StockSyncLogDetailService {

    @Resource LogStockDetailMapper logStockDetailMapper;

    @Override
    public List<LogStockDetail> selectLogStockDetail(LogStockDetail detail) {
        LogStockDetailExample example = new LogStockDetailExample();
        LogStockDetailExample.Criteria criteria = example.createCriteria();
        criteria.andChannelCodeEqualTo(detail.getChannelCode()).andProdIdEqualTo(detail.getProdId())
                .andUpdateTimeBetween(detail.getStartTime(), detail.getEndTime());
        return logStockDetailMapper.selectByExample(example);
    }

}
