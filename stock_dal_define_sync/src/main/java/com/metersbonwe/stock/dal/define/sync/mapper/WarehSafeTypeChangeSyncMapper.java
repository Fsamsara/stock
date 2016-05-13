package com.metersbonwe.stock.dal.define.sync.mapper;

/* *
 * @description 仓安全库存类型变化专用mapper
 * @author huangbiao
 * @date 2016/03/26
 * @version V1.0
 */
public interface WarehSafeTypeChangeSyncMapper {

    /**
     * @description
     * @param warehId 仓库ID
     * @return WS类型仓ID对应的仓的安全库存值
     */
    int getWSSafeValue(String warehId);
}
