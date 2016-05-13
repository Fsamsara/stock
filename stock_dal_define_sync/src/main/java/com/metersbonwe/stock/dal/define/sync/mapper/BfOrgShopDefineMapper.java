package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

import com.metersbonwe.stock.po.sync.define.BfOrgShopDefine;



/**
 * @author zhangjf
 */
public interface BfOrgShopDefineMapper {
    /**
     * 获取参与B2C配发的门店信息
     * 
     * @return
     */
    List<BfOrgShopDefine> selectAllForB2C();
}
