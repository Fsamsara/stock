package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockChannelStatus;
import com.metersbonwe.stock.po.core.StockChannelStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockChannelStatusMapper {
    int countByExample(StockChannelStatusExample example);

    int deleteByExample(StockChannelStatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockChannelStatus record);

    int insertSelective(StockChannelStatus record);

    List<StockChannelStatus> selectByExample(StockChannelStatusExample example);

    StockChannelStatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockChannelStatus record, @Param("example") StockChannelStatusExample example);

    int updateByExample(@Param("record") StockChannelStatus record, @Param("example") StockChannelStatusExample example);

    int updateByPrimaryKeySelective(StockChannelStatus record);

    int updateByPrimaryKey(StockChannelStatus record);
}