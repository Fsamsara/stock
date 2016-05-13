package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockChannelIncrement;
import com.metersbonwe.stock.po.core.StockChannelIncrementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockChannelIncrementMapper {
    int countByExample(StockChannelIncrementExample example);

    int deleteByExample(StockChannelIncrementExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockChannelIncrement record);

    int insertSelective(StockChannelIncrement record);

    List<StockChannelIncrement> selectByExample(StockChannelIncrementExample example);

    StockChannelIncrement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockChannelIncrement record, @Param("example") StockChannelIncrementExample example);

    int updateByExample(@Param("record") StockChannelIncrement record, @Param("example") StockChannelIncrementExample example);

    int updateByPrimaryKeySelective(StockChannelIncrement record);

    int updateByPrimaryKey(StockChannelIncrement record);
}