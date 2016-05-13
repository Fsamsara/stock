package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockPreSaleDetail;
import com.metersbonwe.stock.po.core.StockPreSaleDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockPreSaleDetailMapper {
    int countByExample(StockPreSaleDetailExample example);

    int deleteByExample(StockPreSaleDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockPreSaleDetail record);

    int insertSelective(StockPreSaleDetail record);

    List<StockPreSaleDetail> selectByExample(StockPreSaleDetailExample example);

    StockPreSaleDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockPreSaleDetail record, @Param("example") StockPreSaleDetailExample example);

    int updateByExample(@Param("record") StockPreSaleDetail record, @Param("example") StockPreSaleDetailExample example);

    int updateByPrimaryKeySelective(StockPreSaleDetail record);

    int updateByPrimaryKey(StockPreSaleDetail record);
}