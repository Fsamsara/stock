package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;

import com.metersbonwe.stock.po.core.StockChannelOrderDetailHis;
import com.metersbonwe.stock.pojo.StockChannelOrderDetailHisBean;

public interface StockChannelOrderDetailHisDefineMapper {
    
    public List<StockChannelOrderDetailHis> selectForChannelAndProds(StockChannelOrderDetailHisBean bean);

}
