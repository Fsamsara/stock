package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockPreSale;
import com.metersbonwe.stock.po.core.StockPreSaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockPreSaleMapper {
    int countByExample(StockPreSaleExample example);

    int deleteByExample(StockPreSaleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StockPreSale record);

    int insertSelective(StockPreSale record);

    List<StockPreSale> selectByExample(StockPreSaleExample example);

    StockPreSale selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StockPreSale record, @Param("example") StockPreSaleExample example);

    int updateByExample(@Param("record") StockPreSale record, @Param("example") StockPreSaleExample example);

    int updateByPrimaryKeySelective(StockPreSale record);

    int updateByPrimaryKey(StockPreSale record);
}