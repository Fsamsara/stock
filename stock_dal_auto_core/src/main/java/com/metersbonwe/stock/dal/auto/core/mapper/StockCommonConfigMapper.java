package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockCommonConfig;
import com.metersbonwe.stock.po.core.StockCommonConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockCommonConfigMapper {
    int countByExample(StockCommonConfigExample example);

    int deleteByExample(StockCommonConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockCommonConfig record);

    int insertSelective(StockCommonConfig record);

    List<StockCommonConfig> selectByExample(StockCommonConfigExample example);

    StockCommonConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockCommonConfig record, @Param("example") StockCommonConfigExample example);

    int updateByExample(@Param("record") StockCommonConfig record, @Param("example") StockCommonConfigExample example);

    int updateByPrimaryKeySelective(StockCommonConfig record);

    int updateByPrimaryKey(StockCommonConfig record);
}