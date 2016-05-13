package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpTpStock;
import com.metersbonwe.stock.po.sync.TmpTpStockExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpTpStockMapper {
    int countByExample(TmpTpStockExample example);

    int deleteByExample(TmpTpStockExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpTpStock record);

    int insertSelective(TmpTpStock record);

    List<TmpTpStock> selectByExample(TmpTpStockExample example);

    TmpTpStock selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpTpStock record, @Param("example") TmpTpStockExample example);

    int updateByExample(@Param("record") TmpTpStock record, @Param("example") TmpTpStockExample example);

    int updateByPrimaryKeySelective(TmpTpStock record);

    int updateByPrimaryKey(TmpTpStock record);
}