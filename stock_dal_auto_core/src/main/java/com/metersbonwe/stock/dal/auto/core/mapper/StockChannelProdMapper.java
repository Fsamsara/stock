package com.metersbonwe.stock.dal.auto.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.metersbonwe.stock.po.core.StockChannelProd;
import com.metersbonwe.stock.po.core.StockChannelProdExample;

public interface StockChannelProdMapper {
    int countByExample(@Param("record") StockChannelProd record, @Param("example") StockChannelProdExample example);

    int deleteByExample(@Param("record") StockChannelProd record, @Param("example") StockChannelProdExample example);

    int deleteByPrimaryKey(StockChannelProd record);

    int insert(StockChannelProd record);

    int insertSelective(StockChannelProd record);

    List<StockChannelProd> selectByExample(@Param("record") StockChannelProd record, @Param("example") StockChannelProdExample example);

    StockChannelProd selectByPrimaryKey(StockChannelProd record);

    int updateByExampleSelective(@Param("record") StockChannelProd record, @Param("example") StockChannelProdExample example);

    int updateByExample(@Param("record") StockChannelProd record, @Param("example") StockChannelProdExample example);

    int updateByPrimaryKeySelective(StockChannelProd record);

    int updateByPrimaryKey(StockChannelProd record);
}
