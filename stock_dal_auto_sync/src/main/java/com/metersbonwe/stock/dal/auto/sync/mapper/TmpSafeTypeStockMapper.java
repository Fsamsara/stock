package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpSafeTypeStock;
import com.metersbonwe.stock.po.sync.TmpSafeTypeStockExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpSafeTypeStockMapper {
    int countByExample(TmpSafeTypeStockExample example);

    int deleteByExample(TmpSafeTypeStockExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpSafeTypeStock record);

    int insertSelective(TmpSafeTypeStock record);

    List<TmpSafeTypeStock> selectByExample(TmpSafeTypeStockExample example);

    TmpSafeTypeStock selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpSafeTypeStock record, @Param("example") TmpSafeTypeStockExample example);

    int updateByExample(@Param("record") TmpSafeTypeStock record, @Param("example") TmpSafeTypeStockExample example);

    int updateByPrimaryKeySelective(TmpSafeTypeStock record);

    int updateByPrimaryKey(TmpSafeTypeStock record);
}