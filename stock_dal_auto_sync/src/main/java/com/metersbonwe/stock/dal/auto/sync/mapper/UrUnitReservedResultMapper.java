package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.UrUnitReservedResult;
import com.metersbonwe.stock.po.sync.UrUnitReservedResultExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UrUnitReservedResultMapper {
    int countByExample(UrUnitReservedResultExample example);

    int deleteByExample(UrUnitReservedResultExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(UrUnitReservedResult record);

    int insertSelective(UrUnitReservedResult record);

    List<UrUnitReservedResult> selectByExample(UrUnitReservedResultExample example);

    UrUnitReservedResult selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") UrUnitReservedResult record, @Param("example") UrUnitReservedResultExample example);

    int updateByExample(@Param("record") UrUnitReservedResult record, @Param("example") UrUnitReservedResultExample example);

    int updateByPrimaryKeySelective(UrUnitReservedResult record);

    int updateByPrimaryKey(UrUnitReservedResult record);
}