package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpWmsProperty;
import com.metersbonwe.stock.po.sync.TmpWmsPropertyExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpWmsPropertyMapper {
    int countByExample(TmpWmsPropertyExample example);

    int deleteByExample(TmpWmsPropertyExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpWmsProperty record);

    int insertSelective(TmpWmsProperty record);

    List<TmpWmsProperty> selectByExample(TmpWmsPropertyExample example);

    TmpWmsProperty selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpWmsProperty record, @Param("example") TmpWmsPropertyExample example);

    int updateByExample(@Param("record") TmpWmsProperty record, @Param("example") TmpWmsPropertyExample example);

    int updateByPrimaryKeySelective(TmpWmsProperty record);

    int updateByPrimaryKey(TmpWmsProperty record);
}