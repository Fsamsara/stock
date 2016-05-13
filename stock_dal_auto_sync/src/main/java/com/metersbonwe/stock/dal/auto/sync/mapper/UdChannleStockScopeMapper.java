package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.UdChannleStockScope;
import com.metersbonwe.stock.po.sync.UdChannleStockScopeExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UdChannleStockScopeMapper {
    int countByExample(UdChannleStockScopeExample example);

    int deleteByExample(UdChannleStockScopeExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(UdChannleStockScope record);

    int insertSelective(UdChannleStockScope record);

    List<UdChannleStockScope> selectByExample(UdChannleStockScopeExample example);

    UdChannleStockScope selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") UdChannleStockScope record, @Param("example") UdChannleStockScopeExample example);

    int updateByExample(@Param("record") UdChannleStockScope record, @Param("example") UdChannleStockScopeExample example);

    int updateByPrimaryKeySelective(UdChannleStockScope record);

    int updateByPrimaryKey(UdChannleStockScope record);
}