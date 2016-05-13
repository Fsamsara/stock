package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockPreSaleModify;
import com.metersbonwe.stock.po.core.StockPreSaleModifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockPreSaleModifyMapper {
    int countByExample(StockPreSaleModifyExample example);

    int deleteByExample(StockPreSaleModifyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StockPreSaleModify record);

    int insertSelective(StockPreSaleModify record);

    List<StockPreSaleModify> selectByExample(StockPreSaleModifyExample example);

    StockPreSaleModify selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StockPreSaleModify record, @Param("example") StockPreSaleModifyExample example);

    int updateByExample(@Param("record") StockPreSaleModify record, @Param("example") StockPreSaleModifyExample example);

    int updateByPrimaryKeySelective(StockPreSaleModify record);

    int updateByPrimaryKey(StockPreSaleModify record);
}