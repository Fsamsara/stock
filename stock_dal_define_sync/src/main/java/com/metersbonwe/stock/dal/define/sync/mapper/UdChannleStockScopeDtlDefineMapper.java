package com.metersbonwe.stock.dal.define.sync.mapper;

import com.metersbonwe.stock.dal.auto.sync.mapper.UdChannleStockScopeDtlMapper;
import com.metersbonwe.stock.po.sync.UdChannleStockScopeDtl;

import java.util.List;

public interface UdChannleStockScopeDtlDefineMapper extends UdChannleStockScopeDtlMapper {
    
    /**
     * 
     * TODO 查询线上独占的预留类型
     * TODO 查询线上独占的预留类型
     * @return
     */
    List<UdChannleStockScopeDtl> selectLockTypeByOnlineAndMonopolize();

}