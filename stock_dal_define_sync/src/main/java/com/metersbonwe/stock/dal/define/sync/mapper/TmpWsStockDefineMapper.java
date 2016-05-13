package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

import com.metersbonwe.stock.po.sync.TmpWsStock;

/**
 * @author zhangjf
 */
public interface TmpWsStockDefineMapper {
    /**
     * 获取仓库WS安全库存数据,去重
     * 
     * @return
     */
    List<TmpWsStock> selectAllDeleteRepeat();
    
    /**
     * @param list 批量插入数据
     * @return
     */
    public int insertList(List<TmpWsStock> list);
}
