package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.UdWarehParam;
import com.metersbonwe.stock.po.sync.UdWarehParamExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UdWarehParamMapper {
    int countByExample(UdWarehParamExample example);

    int deleteByExample(UdWarehParamExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(UdWarehParam record);

    int insertSelective(UdWarehParam record);

    List<UdWarehParam> selectByExample(UdWarehParamExample example);

    UdWarehParam selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") UdWarehParam record, @Param("example") UdWarehParamExample example);

    int updateByExample(@Param("record") UdWarehParam record, @Param("example") UdWarehParamExample example);

    int updateByPrimaryKeySelective(UdWarehParam record);

    int updateByPrimaryKey(UdWarehParam record);
}