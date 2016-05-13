package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

import com.metersbonwe.stock.dal.auto.sync.mapper.BfPartnerShopMapper;
import com.metersbonwe.stock.po.sync.define.BfPartnerShopDefine;

public interface BfPartnerShopDefineMapper extends BfPartnerShopMapper {

    /**
     * TODO 根据门店编码查询合伙人信息
     * 
     * @param shopCode
     * @return
     */
    List<BfPartnerShopDefine> selectBfPartnerShopByShopCode(String shopCode);

}
