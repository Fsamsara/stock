package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.BfPartnerShop;
import com.metersbonwe.stock.po.sync.BfPartnerShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BfPartnerShopMapper {
    int countByExample(BfPartnerShopExample example);

    int deleteByExample(BfPartnerShopExample example);

    int insert(BfPartnerShop record);

    int insertSelective(BfPartnerShop record);

    List<BfPartnerShop> selectByExample(BfPartnerShopExample example);

    int updateByExampleSelective(@Param("record") BfPartnerShop record, @Param("example") BfPartnerShopExample example);

    int updateByExample(@Param("record") BfPartnerShop record, @Param("example") BfPartnerShopExample example);
}