package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

import com.metersbonwe.stock.po.sync.TmpWmsProperty;

/**
 * @author zhangjf
 */
public interface TmpWmsPropertyDefineMapper {
    /**
     * 获取仓库USED_MA属性变化临时表，按仓库，去重，取日期最大的那条记录
     * 
     * @return
     */
    List<TmpWmsProperty> selectAllDeleteRepeat();
    
    /**
     * @param list 批量插入数据
     * @return
     */
    public int insertList(List<TmpWmsProperty> list);
}
