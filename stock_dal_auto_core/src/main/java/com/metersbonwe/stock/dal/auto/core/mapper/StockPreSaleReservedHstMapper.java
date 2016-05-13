package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockPreSaleReservedHst;
import com.metersbonwe.stock.po.core.StockPreSaleReservedHstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockPreSaleReservedHstMapper {
    int countByExample(StockPreSaleReservedHstExample example);

    int deleteByExample(StockPreSaleReservedHstExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockPreSaleReservedHst record);

    int insertSelective(StockPreSaleReservedHst record);

    List<StockPreSaleReservedHst> selectByExample(StockPreSaleReservedHstExample example);

    StockPreSaleReservedHst selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockPreSaleReservedHst record, @Param("example") StockPreSaleReservedHstExample example);

    int updateByExample(@Param("record") StockPreSaleReservedHst record, @Param("example") StockPreSaleReservedHstExample example);

    int updateByPrimaryKeySelective(StockPreSaleReservedHst record);

    int updateByPrimaryKey(StockPreSaleReservedHst record);
}