package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.TmpStockTableSum;
import com.metersbonwe.stock.po.core.TmpStockTableSumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpStockTableSumMapper {
    int countByExample(TmpStockTableSumExample example);

    int deleteByExample(TmpStockTableSumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmpStockTableSum record);

    int insertSelective(TmpStockTableSum record);

    List<TmpStockTableSum> selectByExample(TmpStockTableSumExample example);

    TmpStockTableSum selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmpStockTableSum record, @Param("example") TmpStockTableSumExample example);

    int updateByExample(@Param("record") TmpStockTableSum record, @Param("example") TmpStockTableSumExample example);

    int updateByPrimaryKeySelective(TmpStockTableSum record);

    int updateByPrimaryKey(TmpStockTableSum record);
}