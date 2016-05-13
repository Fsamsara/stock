package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * TODO 动态创建由于新增渠道新增仓店商品数据导致的表
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年4月15日 下午2:17:20
 * @since V1.0
 * @version V1.0
 */
public interface CreateTablesWarehChannelDefineMapper {
    /**
     * TODO 获取指定表的 schema
     *
     * @return
     */
    List<String> selectTableSchemas(@Param("tableName") String tableName);

    /**
     * TODO 根据传过来的表名创建新表
     *
     * @return
     */
    void createTable(@Param("orgTableName") String orgTableName, @Param("desTableName") String desTableName);
}
