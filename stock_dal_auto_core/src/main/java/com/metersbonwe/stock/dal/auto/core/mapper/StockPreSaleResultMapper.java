package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockPreSaleResult;
import com.metersbonwe.stock.po.core.StockPreSaleResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockPreSaleResultMapper {
    int countByExample(StockPreSaleResultExample example);

    int deleteByExample(StockPreSaleResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockPreSaleResult record);

    int insertSelective(StockPreSaleResult record);

    List<StockPreSaleResult> selectByExample(StockPreSaleResultExample example);

    StockPreSaleResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockPreSaleResult record, @Param("example") StockPreSaleResultExample example);

    int updateByExample(@Param("record") StockPreSaleResult record, @Param("example") StockPreSaleResultExample example);

    int updateByPrimaryKeySelective(StockPreSaleResult record);

    int updateByPrimaryKey(StockPreSaleResult record);
}