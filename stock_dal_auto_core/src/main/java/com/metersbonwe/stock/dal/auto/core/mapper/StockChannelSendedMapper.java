package com.metersbonwe.stock.dal.auto.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.metersbonwe.stock.po.core.StockChannelSended;
import com.metersbonwe.stock.po.core.StockChannelSendedExample;

public interface StockChannelSendedMapper {
    int countByExample(@Param("record") StockChannelSended record, @Param("example") StockChannelSendedExample example);

    int deleteByExample(@Param("record") StockChannelSended record, @Param("example") StockChannelSendedExample example);

    int deleteByPrimaryKey(StockChannelSended record);

    int insert(StockChannelSended record);

    int insertSelective(StockChannelSended record);

    List<StockChannelSended> selectByExample(@Param("record") StockChannelSended record, @Param("example") StockChannelSendedExample example);

    StockChannelSended selectByPrimaryKey(StockChannelSended record);

    int updateByExampleSelective(@Param("record") StockChannelSended record, @Param("example") StockChannelSendedExample example);

    int updateByExample(@Param("record") StockChannelSended record, @Param("example") StockChannelSendedExample example);

    int updateByPrimaryKeySelective(StockChannelSended record);

    int updateByPrimaryKey(StockChannelSended record);
}
