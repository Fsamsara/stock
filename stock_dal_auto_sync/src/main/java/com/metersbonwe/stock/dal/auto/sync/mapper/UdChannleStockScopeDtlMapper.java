package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.UdChannleStockScopeDtl;
import com.metersbonwe.stock.po.sync.UdChannleStockScopeDtlExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UdChannleStockScopeDtlMapper {
    int countByExample(UdChannleStockScopeDtlExample example);

    int deleteByExample(UdChannleStockScopeDtlExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(UdChannleStockScopeDtl record);

    int insertSelective(UdChannleStockScopeDtl record);

    List<UdChannleStockScopeDtl> selectByExample(UdChannleStockScopeDtlExample example);

    UdChannleStockScopeDtl selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") UdChannleStockScopeDtl record, @Param("example") UdChannleStockScopeDtlExample example);

    int updateByExample(@Param("record") UdChannleStockScopeDtl record, @Param("example") UdChannleStockScopeDtlExample example);

    int updateByPrimaryKeySelective(UdChannleStockScopeDtl record);

    int updateByPrimaryKey(UdChannleStockScopeDtl record);
}