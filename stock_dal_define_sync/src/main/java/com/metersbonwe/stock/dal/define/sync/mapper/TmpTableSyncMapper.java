package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;
import java.util.Map;

public interface TmpTableSyncMapper {

    /**
     * @description 获取临时表数据
     * @param paramMap 包含两个值： key1: tableName 临时表名， key2: partitionStr 去重分组字段
     * @return 表数据的结果集合
     */
    List<Map<String, Object>> getTmpData(Map<String, String> paramMap);

    /**
     * @description 删除临时表中小于等于指定ID的所有记录
     * @param paramMap paramMap： 两个对象： key1) 临时表名称  kye2) maxId
     */
    void delTmpData(Map<String, Object> paramMap);
}
