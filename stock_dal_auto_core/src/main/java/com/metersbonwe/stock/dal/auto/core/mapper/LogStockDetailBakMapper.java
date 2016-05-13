package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.LogStockDetailBak;
import com.metersbonwe.stock.po.core.LogStockDetailBakExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogStockDetailBakMapper {
    int countByExample(LogStockDetailBakExample example);

    int deleteByExample(LogStockDetailBakExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LogStockDetailBak record);

    int insertSelective(LogStockDetailBak record);

    List<LogStockDetailBak> selectByExample(LogStockDetailBakExample example);

    LogStockDetailBak selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LogStockDetailBak record, @Param("example") LogStockDetailBakExample example);

    int updateByExample(@Param("record") LogStockDetailBak record, @Param("example") LogStockDetailBakExample example);

    int updateByPrimaryKeySelective(LogStockDetailBak record);

    int updateByPrimaryKey(LogStockDetailBak record);
}