package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpWpStock;
import com.metersbonwe.stock.po.sync.TmpWpStockExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpWpStockMapper {
    int countByExample(TmpWpStockExample example);

    int deleteByExample(TmpWpStockExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpWpStock record);

    int insertSelective(TmpWpStock record);

    List<TmpWpStock> selectByExample(TmpWpStockExample example);

    TmpWpStock selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpWpStock record, @Param("example") TmpWpStockExample example);

    int updateByExample(@Param("record") TmpWpStock record, @Param("example") TmpWpStockExample example);

    int updateByPrimaryKeySelective(TmpWpStock record);

    int updateByPrimaryKey(TmpWpStock record);
}