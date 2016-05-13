package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockChannelOrderDetail;
import com.metersbonwe.stock.po.core.StockChannelOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockChannelOrderDetailMapper {
    int countByExample(StockChannelOrderDetailExample example);

    int deleteByExample(StockChannelOrderDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockChannelOrderDetail record);

    int insertSelective(StockChannelOrderDetail record);

    List<StockChannelOrderDetail> selectByExample(StockChannelOrderDetailExample example);

    StockChannelOrderDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockChannelOrderDetail record, @Param("example") StockChannelOrderDetailExample example);

    int updateByExample(@Param("record") StockChannelOrderDetail record, @Param("example") StockChannelOrderDetailExample example);

    int updateByPrimaryKeySelective(StockChannelOrderDetail record);

    int updateByPrimaryKey(StockChannelOrderDetail record);
}