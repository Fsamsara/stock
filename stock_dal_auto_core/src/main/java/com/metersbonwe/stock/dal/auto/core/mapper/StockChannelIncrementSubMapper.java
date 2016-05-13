package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockChannelIncrementSub;
import com.metersbonwe.stock.po.core.StockChannelIncrementSubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockChannelIncrementSubMapper {
    int countByExample(StockChannelIncrementSubExample example);

    int deleteByExample(StockChannelIncrementSubExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockChannelIncrementSub record);

    int insertSelective(StockChannelIncrementSub record);

    List<StockChannelIncrementSub> selectByExample(StockChannelIncrementSubExample example);

    StockChannelIncrementSub selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockChannelIncrementSub record, @Param("example") StockChannelIncrementSubExample example);

    int updateByExample(@Param("record") StockChannelIncrementSub record, @Param("example") StockChannelIncrementSubExample example);

    int updateByPrimaryKeySelective(StockChannelIncrementSub record);

    int updateByPrimaryKey(StockChannelIncrementSub record);
}