package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockChannelOrderDetailHis;
import com.metersbonwe.stock.po.core.StockChannelOrderDetailHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockChannelOrderDetailHisMapper {
    int countByExample(StockChannelOrderDetailHisExample example);

    int deleteByExample(StockChannelOrderDetailHisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockChannelOrderDetailHis record);

    int insertSelective(StockChannelOrderDetailHis record);

    List<StockChannelOrderDetailHis> selectByExample(StockChannelOrderDetailHisExample example);

    StockChannelOrderDetailHis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockChannelOrderDetailHis record, @Param("example") StockChannelOrderDetailHisExample example);

    int updateByExample(@Param("record") StockChannelOrderDetailHis record, @Param("example") StockChannelOrderDetailHisExample example);

    int updateByPrimaryKeySelective(StockChannelOrderDetailHis record);

    int updateByPrimaryKey(StockChannelOrderDetailHis record);
}