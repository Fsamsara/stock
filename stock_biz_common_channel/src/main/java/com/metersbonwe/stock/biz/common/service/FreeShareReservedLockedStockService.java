package com.metersbonwe.stock.biz.common.service;

import java.util.List;

import com.metersbonwe.stock.po.sync.UrUnitReservedResult;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.QryLockStockResultBean;

public interface FreeShareReservedLockedStockService {

    /**
     * TODO 获取渠道的预留量 TODO 根据渠道编码集合、预留类型集合、仓库编码集合、商品编码集合获取预留量
     * 
     * @param unitList
     * @param reservedTypeList
     * @param warehList
     * @param skuList
     * @return
     */
    List<UrUnitReservedResult> getUnitReserved(List<String> unitList, List<String> reservedTypeList, List<String> warehList, List<String> skuList);

    /**
     * TODO 获取仓库锁定量 TODO 根据预留类型集合、仓库编码集合、商品编码集合获取锁定量
     * 
     * @param reservedTypeList
     * @param warehList
     * @param skuList
     * @return
     */
    List<QryLockStockResultBean> getLockStock(List<String> reservedTypeList, List<String> warehList, List<String> skuList);

    /**
     * TODO 获取仓库分页锁定量 TODO 根据预留类型集合、仓库编码集合、商品编码集合获取锁定量
     * 
     * @param page
     * @param reservedTypeList
     * @param warehList
     * @param skuList
     * @return
     */
    List<QryLockStockResultBean> getLockStock_Page(Page<?> page, List<String> reservedTypeList, List<String> warehList, List<String> skuList);

}
