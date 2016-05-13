package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockPreSaleReserved;
import com.metersbonwe.stock.po.core.StockPreSaleReservedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockPreSaleReservedMapper {
    int countByExample(StockPreSaleReservedExample example);

    int deleteByExample(StockPreSaleReservedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockPreSaleReserved record);

    int insertSelective(StockPreSaleReserved record);

    List<StockPreSaleReserved> selectByExample(StockPreSaleReservedExample example);

    StockPreSaleReserved selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockPreSaleReserved record, @Param("example") StockPreSaleReservedExample example);

    int updateByExample(@Param("record") StockPreSaleReserved record, @Param("example") StockPreSaleReservedExample example);

    int updateByPrimaryKeySelective(StockPreSaleReserved record);

    int updateByPrimaryKey(StockPreSaleReserved record);
}