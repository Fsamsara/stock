package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

/**
 * @description 配发范围公用方法
 */
public interface AllocationRangeSyncMapper {
    /**
     * @description 获取平台可用仓
     * @return 可用仓集合List
     */
    List<String> getUsefulWareH();
}
