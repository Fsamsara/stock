package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockTpStock;
import com.metersbonwe.stock.po.core.StockTpStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockTpStockMapper {
    int countByExample(StockTpStockExample example);

    int deleteByExample(StockTpStockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockTpStock record);

    int insertSelective(StockTpStock record);

    List<StockTpStock> selectByExample(StockTpStockExample example);

    StockTpStock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockTpStock record, @Param("example") StockTpStockExample example);

    int updateByExample(@Param("record") StockTpStock record, @Param("example") StockTpStockExample example);

    int updateByPrimaryKeySelective(StockTpStock record);

    int updateByPrimaryKey(StockTpStock record);
}