package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.BfOrg;
import com.metersbonwe.stock.po.sync.BfOrgExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BfOrgMapper {
    int countByExample(BfOrgExample example);

    int deleteByExample(BfOrgExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(BfOrg record);

    int insertSelective(BfOrg record);

    List<BfOrg> selectByExample(BfOrgExample example);

    BfOrg selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") BfOrg record, @Param("example") BfOrgExample example);

    int updateByExample(@Param("record") BfOrg record, @Param("example") BfOrgExample example);

    int updateByPrimaryKeySelective(BfOrg record);

    int updateByPrimaryKey(BfOrg record);
}