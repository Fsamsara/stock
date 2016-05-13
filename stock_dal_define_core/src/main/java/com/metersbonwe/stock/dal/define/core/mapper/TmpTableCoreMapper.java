package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TmpTableCoreMapper {
    /**
     * @description 根据仓库ID，找到仓所在的分表
     */
    String getTableNameByWarehId();

    /**
     * @description 删除临时表中小于等于指定ID的所有记录
     * @param paramMap paramMap： 两个对象： key1) 临时表名称  kye2) maxId
     */
    void delTmpData(Map<String, Object> paramMap);

    /**
     * @description 获取临时表数据
     * @param paramMap 参数
     * @return 表数据的结果集合
     */
    List<Map<String, Object>> getTmpData(Map<String, String> paramMap);
    
    /**
     * 
     * 清除临时表的数据
     * @param tmpTableName 表
     */
    void truncateCoreTable(@Param("tableName")String tableName);
}
