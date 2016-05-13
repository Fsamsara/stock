package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpWsStock;
import com.metersbonwe.stock.po.sync.TmpWsStockExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpWsStockMapper {
    int countByExample(TmpWsStockExample example);

    int deleteByExample(TmpWsStockExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpWsStock record);

    int insertSelective(TmpWsStock record);

    List<TmpWsStock> selectByExample(TmpWsStockExample example);

    TmpWsStock selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpWsStock record, @Param("example") TmpWsStockExample example);

    int updateByExample(@Param("record") TmpWsStock record, @Param("example") TmpWsStockExample example);

    int updateByPrimaryKeySelective(TmpWsStock record);

    int updateByPrimaryKey(TmpWsStock record);
}