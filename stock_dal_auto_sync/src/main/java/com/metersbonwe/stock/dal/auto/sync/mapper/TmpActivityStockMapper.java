package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpActivityStock;
import com.metersbonwe.stock.po.sync.TmpActivityStockExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpActivityStockMapper {
    int countByExample(TmpActivityStockExample example);

    int deleteByExample(TmpActivityStockExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpActivityStock record);

    int insertSelective(TmpActivityStock record);

    List<TmpActivityStock> selectByExample(TmpActivityStockExample example);

    TmpActivityStock selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpActivityStock record, @Param("example") TmpActivityStockExample example);

    int updateByExample(@Param("record") TmpActivityStock record, @Param("example") TmpActivityStockExample example);

    int updateByPrimaryKeySelective(TmpActivityStock record);

    int updateByPrimaryKey(TmpActivityStock record);
}