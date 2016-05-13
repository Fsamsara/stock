package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.DrInterfacePro;
import com.metersbonwe.stock.po.sync.DrInterfaceProExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DrInterfaceProMapper {
    int countByExample(DrInterfaceProExample example);

    int deleteByExample(DrInterfaceProExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(DrInterfacePro record);

    int insertSelective(DrInterfacePro record);

    List<DrInterfacePro> selectByExample(DrInterfaceProExample example);

    DrInterfacePro selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") DrInterfacePro record, @Param("example") DrInterfaceProExample example);

    int updateByExample(@Param("record") DrInterfacePro record, @Param("example") DrInterfaceProExample example);

    int updateByPrimaryKeySelective(DrInterfacePro record);

    int updateByPrimaryKey(DrInterfacePro record);
}