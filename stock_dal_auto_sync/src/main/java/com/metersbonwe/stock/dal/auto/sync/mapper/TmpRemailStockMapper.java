package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpRemailStock;
import com.metersbonwe.stock.po.sync.TmpRemailStockExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpRemailStockMapper {
    int countByExample(TmpRemailStockExample example);

    int deleteByExample(TmpRemailStockExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpRemailStock record);

    int insertSelective(TmpRemailStock record);

    List<TmpRemailStock> selectByExample(TmpRemailStockExample example);

    TmpRemailStock selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpRemailStock record, @Param("example") TmpRemailStockExample example);

    int updateByExample(@Param("record") TmpRemailStock record, @Param("example") TmpRemailStockExample example);

    int updateByPrimaryKeySelective(TmpRemailStock record);

    int updateByPrimaryKey(TmpRemailStock record);
}