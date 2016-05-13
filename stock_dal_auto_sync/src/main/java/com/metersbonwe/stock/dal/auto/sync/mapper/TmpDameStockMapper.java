package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpDameStock;
import com.metersbonwe.stock.po.sync.TmpDameStockExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpDameStockMapper {
    int countByExample(TmpDameStockExample example);

    int deleteByExample(TmpDameStockExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpDameStock record);

    int insertSelective(TmpDameStock record);

    List<TmpDameStock> selectByExample(TmpDameStockExample example);

    TmpDameStock selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpDameStock record, @Param("example") TmpDameStockExample example);

    int updateByExample(@Param("record") TmpDameStock record, @Param("example") TmpDameStockExample example);

    int updateByPrimaryKeySelective(TmpDameStock record);

    int updateByPrimaryKey(TmpDameStock record);
}