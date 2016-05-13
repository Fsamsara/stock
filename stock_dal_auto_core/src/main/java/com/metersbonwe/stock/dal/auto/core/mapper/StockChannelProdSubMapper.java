package com.metersbonwe.stock.dal.auto.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.metersbonwe.stock.po.core.StockChannelProdSub;
import com.metersbonwe.stock.po.core.StockChannelProdSubExample;

public interface StockChannelProdSubMapper {
    int countByExample(@Param("record") StockChannelProdSub record, @Param("example") StockChannelProdSubExample example);

    int deleteByExample(@Param("record") StockChannelProdSub record, @Param("example") StockChannelProdSubExample example);

    int deleteByPrimaryKey(StockChannelProdSub record);

    int insert(StockChannelProdSub record);

    int insertSelective(StockChannelProdSub record);

    List<StockChannelProdSub> selectByExample(@Param("record") StockChannelProdSub record, @Param("example") StockChannelProdSubExample example);

    StockChannelProdSub selectByPrimaryKey(StockChannelProdSub record);

    int updateByExampleSelective(@Param("record") StockChannelProdSub record, @Param("example") StockChannelProdSubExample example);

    int updateByExample(@Param("record") StockChannelProdSub record, @Param("example") StockChannelProdSubExample example);

    int updateByPrimaryKeySelective(StockChannelProdSub record);

    int updateByPrimaryKey(StockChannelProdSub record);
}
