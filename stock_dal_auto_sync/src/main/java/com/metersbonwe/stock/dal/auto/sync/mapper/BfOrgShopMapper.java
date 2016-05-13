package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.BfOrgShop;
import com.metersbonwe.stock.po.sync.BfOrgShopExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BfOrgShopMapper {
    int countByExample(BfOrgShopExample example);

    int deleteByExample(BfOrgShopExample example);

    int deleteByPrimaryKey(BigDecimal bfOrgId);

    int insert(BfOrgShop record);

    int insertSelective(BfOrgShop record);

    List<BfOrgShop> selectByExample(BfOrgShopExample example);

    BfOrgShop selectByPrimaryKey(BigDecimal bfOrgId);

    int updateByExampleSelective(@Param("record") BfOrgShop record, @Param("example") BfOrgShopExample example);

    int updateByExample(@Param("record") BfOrgShop record, @Param("example") BfOrgShopExample example);

    int updateByPrimaryKeySelective(BfOrgShop record);

    int updateByPrimaryKey(BfOrgShop record);
}