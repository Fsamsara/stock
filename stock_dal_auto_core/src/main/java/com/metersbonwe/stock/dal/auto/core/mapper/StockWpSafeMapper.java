package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockWpSafe;
import com.metersbonwe.stock.po.core.StockWpSafeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockWpSafeMapper {
    int countByExample(StockWpSafeExample example);

    int deleteByExample(StockWpSafeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockWpSafe record);

    int insertSelective(StockWpSafe record);

    List<StockWpSafe> selectByExample(StockWpSafeExample example);

    StockWpSafe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockWpSafe record, @Param("example") StockWpSafeExample example);

    int updateByExample(@Param("record") StockWpSafe record, @Param("example") StockWpSafeExample example);

    int updateByPrimaryKeySelective(StockWpSafe record);

    int updateByPrimaryKey(StockWpSafe record);
}