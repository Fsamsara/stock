package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpLockedStock;
import com.metersbonwe.stock.po.sync.TmpLockedStockExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpLockedStockMapper {
    int countByExample(TmpLockedStockExample example);

    int deleteByExample(TmpLockedStockExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpLockedStock record);

    int insertSelective(TmpLockedStock record);

    List<TmpLockedStock> selectByExample(TmpLockedStockExample example);

    TmpLockedStock selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpLockedStock record, @Param("example") TmpLockedStockExample example);

    int updateByExample(@Param("record") TmpLockedStock record, @Param("example") TmpLockedStockExample example);

    int updateByPrimaryKeySelective(TmpLockedStock record);

    int updateByPrimaryKey(TmpLockedStock record);
}