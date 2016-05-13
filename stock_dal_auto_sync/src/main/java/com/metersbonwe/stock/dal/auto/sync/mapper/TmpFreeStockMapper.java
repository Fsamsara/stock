package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpFreeStock;
import com.metersbonwe.stock.po.sync.TmpFreeStockExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpFreeStockMapper {
    int countByExample(TmpFreeStockExample example);

    int deleteByExample(TmpFreeStockExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpFreeStock record);

    int insertSelective(TmpFreeStock record);

    List<TmpFreeStock> selectByExample(TmpFreeStockExample example);

    TmpFreeStock selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpFreeStock record, @Param("example") TmpFreeStockExample example);

    int updateByExample(@Param("record") TmpFreeStock record, @Param("example") TmpFreeStockExample example);

    int updateByPrimaryKeySelective(TmpFreeStock record);

    int updateByPrimaryKey(TmpFreeStock record);
}