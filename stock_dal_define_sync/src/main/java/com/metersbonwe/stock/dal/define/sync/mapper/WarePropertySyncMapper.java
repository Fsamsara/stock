package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

public interface WarePropertySyncMapper {

    /**
     * @description 获取所有启用了B2B的仓
     */
    List<String> getB2Bwareh();

}
