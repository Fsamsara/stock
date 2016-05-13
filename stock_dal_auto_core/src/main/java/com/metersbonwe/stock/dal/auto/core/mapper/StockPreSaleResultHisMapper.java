package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockPreSaleResultHis;
import com.metersbonwe.stock.po.core.StockPreSaleResultHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockPreSaleResultHisMapper {
    int countByExample(StockPreSaleResultHisExample example);

    int deleteByExample(StockPreSaleResultHisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockPreSaleResultHis record);

    int insertSelective(StockPreSaleResultHis record);

    List<StockPreSaleResultHis> selectByExample(StockPreSaleResultHisExample example);

    StockPreSaleResultHis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockPreSaleResultHis record, @Param("example") StockPreSaleResultHisExample example);

    int updateByExample(@Param("record") StockPreSaleResultHis record, @Param("example") StockPreSaleResultHisExample example);

    int updateByPrimaryKeySelective(StockPreSaleResultHis record);

    int updateByPrimaryKey(StockPreSaleResultHis record);
}