package com.metersbonwe.stock.biz.common.service;

import java.util.List;

import com.metersbonwe.stock.po.core.TmpStockWms;

/**
 * 正数锁定临时表
 * 
 * @author zhangjf
 */
public interface WmsLockedStockService {

    /**
     * 获取配置的临时表表名
     * 
     * @return
     */
    String getTmpTableNameFromStockCommonConfig();

    /**
     * 获取当前正数锁定数据
     * 
     * @return
     */
    List<TmpStockWms> selectTmpStockWmsList();

    /**
     * 更新配置表的value为新的表名
     * 
     * @param tableName
     */
    void updCommonConfigNewTableName(String tableName);

    /**
     * 清空表名
     * 
     * @param tableName
     */
    void truncateTable(String tableName);
    
    /**
     * 获取正数锁定量
     * @param warehId
     * @param prodId
     * @return
     */
    TmpStockWms selectTmpStockWms(String warehId,String prodId);
    
    /**
     * 获取另外一个临时表表名
     * @param tableName
     * @return
     */
    String getOtherTableName(String tableName);
    
    /**
     * 获取当前使用的WMS正数锁定量的表名
     * @return
     */
    String getCurrentWmsLockedStockTableName();
}
