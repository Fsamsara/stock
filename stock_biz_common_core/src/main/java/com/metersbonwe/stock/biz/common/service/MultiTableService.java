package com.metersbonwe.stock.biz.common.service;

import java.util.Map;
import java.util.Set;

/**
 * 仓+SKU表分表规则
 * @author 张瑞雨
 *
 */
public interface MultiTableService {
	
	/**
	 * 根据仓库ID获取仓库所在表
	 * @param warehId
	 * @return
	 */
    String getTableSuffixByWarehId(String warehId);

    /**
     * @description 根据仓库ID，找到仓所在的分表表名
     * @param warehId
     */
    String getTableNameByWarehId(String warehId);
    
    /**
     * 根据仓库ID数据找到一组对应的表后缀
     * @param warehIds 仓库ID集合
     * @return 表集合
     */
    Set<String> getTableSuffixsByWarehIds(String... warehIds);
    
    /**
     * 根据仓库ID数据找到的表后缀的对应关系
     * @param warehIds 仓库ID集合
     * @return 表和仓的映射关系
     */
    Map<String,Set<String>> getTableSuffByWarehsMap(String... warehIds);
    
    /**
     * 获取最大表序列
     *
     * @return 
     */
    int getMaxTableSeq();
    
    /**
     * 
     * 获取表后缀
     * @param hash 
     * @return
     */
    public String getMappingSuffix(int hash);
}
