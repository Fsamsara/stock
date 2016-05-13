package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.LogStockDetail;
import com.metersbonwe.stock.po.core.LogStockDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogStockDetailMapper {
    int countByExample(LogStockDetailExample example);

    int deleteByExample(LogStockDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LogStockDetail record);

    int insertSelective(LogStockDetail record);

    List<LogStockDetail> selectByExample(LogStockDetailExample example);

    LogStockDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LogStockDetail record, @Param("example") LogStockDetailExample example);

    int updateByExample(@Param("record") LogStockDetail record, @Param("example") LogStockDetailExample example);

    int updateByPrimaryKeySelective(LogStockDetail record);

    int updateByPrimaryKey(LogStockDetail record);
}