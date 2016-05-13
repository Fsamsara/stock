package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockPreSaleModifiedDetail;
import com.metersbonwe.stock.po.core.StockPreSaleModifiedDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockPreSaleModifiedDetailMapper {
    int countByExample(StockPreSaleModifiedDetailExample example);

    int deleteByExample(StockPreSaleModifiedDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockPreSaleModifiedDetail record);

    int insertSelective(StockPreSaleModifiedDetail record);

    List<StockPreSaleModifiedDetail> selectByExample(StockPreSaleModifiedDetailExample example);

    StockPreSaleModifiedDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockPreSaleModifiedDetail record, @Param("example") StockPreSaleModifiedDetailExample example);

    int updateByExample(@Param("record") StockPreSaleModifiedDetail record, @Param("example") StockPreSaleModifiedDetailExample example);

    int updateByPrimaryKeySelective(StockPreSaleModifiedDetail record);

    int updateByPrimaryKey(StockPreSaleModifiedDetail record);
}