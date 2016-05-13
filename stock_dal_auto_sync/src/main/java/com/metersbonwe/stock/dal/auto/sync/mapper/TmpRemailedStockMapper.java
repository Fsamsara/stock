package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpRemailedStock;
import com.metersbonwe.stock.po.sync.TmpRemailedStockExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpRemailedStockMapper {
    int countByExample(TmpRemailedStockExample example);

    int deleteByExample(TmpRemailedStockExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpRemailedStock record);

    int insertSelective(TmpRemailedStock record);

    List<TmpRemailedStock> selectByExample(TmpRemailedStockExample example);

    TmpRemailedStock selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpRemailedStock record, @Param("example") TmpRemailedStockExample example);

    int updateByExample(@Param("record") TmpRemailedStock record, @Param("example") TmpRemailedStockExample example);

    int updateByPrimaryKeySelective(TmpRemailedStock record);

    int updateByPrimaryKey(TmpRemailedStock record);
}