package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpSafetyStock;
import com.metersbonwe.stock.po.sync.TmpSafetyStockExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpSafetyStockMapper {
    int countByExample(TmpSafetyStockExample example);

    int deleteByExample(TmpSafetyStockExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpSafetyStock record);

    int insertSelective(TmpSafetyStock record);

    List<TmpSafetyStock> selectByExample(TmpSafetyStockExample example);

    TmpSafetyStock selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpSafetyStock record, @Param("example") TmpSafetyStockExample example);

    int updateByExample(@Param("record") TmpSafetyStock record, @Param("example") TmpSafetyStockExample example);

    int updateByPrimaryKeySelective(TmpSafetyStock record);

    int updateByPrimaryKey(TmpSafetyStock record);
}