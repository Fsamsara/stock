package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockPreSaleModifyDetail;
import com.metersbonwe.stock.po.core.StockPreSaleModifyDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockPreSaleModifyDetailMapper {
    int countByExample(StockPreSaleModifyDetailExample example);

    int deleteByExample(StockPreSaleModifyDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockPreSaleModifyDetail record);

    int insertSelective(StockPreSaleModifyDetail record);

    List<StockPreSaleModifyDetail> selectByExample(StockPreSaleModifyDetailExample example);

    StockPreSaleModifyDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockPreSaleModifyDetail record, @Param("example") StockPreSaleModifyDetailExample example);

    int updateByExample(@Param("record") StockPreSaleModifyDetail record, @Param("example") StockPreSaleModifyDetailExample example);

    int updateByPrimaryKeySelective(StockPreSaleModifyDetail record);

    int updateByPrimaryKey(StockPreSaleModifyDetail record);
}