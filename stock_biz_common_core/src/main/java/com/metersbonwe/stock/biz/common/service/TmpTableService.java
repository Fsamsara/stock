package com.metersbonwe.stock.biz.common.service;

import java.util.List;
import java.util.Map;

/**
 * @description 临时表相关Service
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/3/23
 */
public interface TmpTableService {

    /**
     * @description 获取同步库临时表数据
     * @param paramMap key1: tableName 临时表名， key2: partitionStr 去重分组字段
     * @return 表数据的结果集合
     */
    List<Map<String, Object>> getSyncTmpData(Map<String, String> paramMap);

    /**
     * @description 删除同步库临时表中id小于maxId的数据
     * @param tmpTableName 临时表名
     * @param maxId 获取临时表数据的最大ID
     */
    void delSyncTmpData(String tmpTableName, long maxId);

    /**
     * @description 获取核心库临时表数据
     * @param paramMap 查询参数
     * @return 表数据的结果集合
     */
    List<Map<String,Object>> getCoreTmpData(Map<String, String> paramMap);

    /**
     * @description 删除核心库临时表中id小于maxId的数据
     * @param tmpTableName 临时表名
     * @param maxId 获取临时表数据的最大ID
     */
    void delCoreTmpData(String tmpTableName, long maxId);
    
    /**
     * 
     * 清除核心库表的数据   
     * @param tmpTableName 临时表名称
     */
    void truncateCoreTmpTable(String tmpTableName);
}
