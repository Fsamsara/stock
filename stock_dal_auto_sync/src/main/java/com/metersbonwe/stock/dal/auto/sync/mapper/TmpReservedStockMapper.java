package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpReservedStock;
import com.metersbonwe.stock.po.sync.TmpReservedStockExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpReservedStockMapper {
    int countByExample(TmpReservedStockExample example);

    int deleteByExample(TmpReservedStockExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpReservedStock record);

    int insertSelective(TmpReservedStock record);

    List<TmpReservedStock> selectByExample(TmpReservedStockExample example);

    TmpReservedStock selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpReservedStock record, @Param("example") TmpReservedStockExample example);

    int updateByExample(@Param("record") TmpReservedStock record, @Param("example") TmpReservedStockExample example);

    int updateByPrimaryKeySelective(TmpReservedStock record);

    int updateByPrimaryKey(TmpReservedStock record);
}