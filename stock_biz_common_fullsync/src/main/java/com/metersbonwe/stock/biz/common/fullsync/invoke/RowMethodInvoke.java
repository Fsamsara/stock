package com.metersbonwe.stock.biz.common.fullsync.invoke;

import java.sql.ResultSet;
import java.util.Map;

/**
 * 
 * JDBC行方法
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-1 上午11:17:06
 */
public interface RowMethodInvoke {

    /**
     * 
     * RS循环每一行需要处理的逻辑
     * @param warehInserSqlMap insertsql 按表分组
     * @param insertAll insert sql 起始数据   如： insert into tableName (xx,xx1,xx2) values 信息
     * @param rs 
     */
    void rowMethod(Map<String, StringBuilder> warehInserSqlMap, String insertAll, ResultSet rs);

}
