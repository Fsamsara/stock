package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.manager.service.StockChannelOrderDetailHisService;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelOrderDetailHisDefineMapper;
import com.metersbonwe.stock.po.core.StockChannelOrderDetailHis;
import com.metersbonwe.stock.pojo.StockChannelOrderDetailHisBean;

@Service("stockChannelOrderDetailHisService")
public class StockChannelOrderDetailHisServiceImpl implements StockChannelOrderDetailHisService {

    @Autowired
    private StockChannelOrderDetailHisDefineMapper stockChannelOrderDetailHisDefineMapper;

    @Override
    public List<StockChannelOrderDetailHis> selectByChannelAndProds(Map<String, List<String>> paraListMap) {
        
        if (paraListMap != null  && paraListMap.size() > 0 ) {
            StockChannelOrderDetailHisBean stockChannelOrderDetailHisBean = new StockChannelOrderDetailHisBean();
            stockChannelOrderDetailHisBean.setchannelCodes(paraListMap.get("channelCode"));
            stockChannelOrderDetailHisBean.setprodIds(paraListMap.get("prodId"));
            return stockChannelOrderDetailHisDefineMapper.selectForChannelAndProds(stockChannelOrderDetailHisBean);
        }
        
        return null;
    }
}
