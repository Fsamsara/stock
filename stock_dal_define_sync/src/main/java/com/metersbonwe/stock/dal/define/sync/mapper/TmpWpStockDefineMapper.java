package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;

import com.metersbonwe.stock.po.sync.TmpWpStock;
import com.metersbonwe.stock.pojo.TmpWpStockGlobalBean;

/**
 * @author zhangjf
 */
public interface TmpWpStockDefineMapper {
    /**
     * 获取仓库WP安全库存数据,去重
     * 
     * @return
     */
    List<TmpWpStock> selectAllDeleteRepeat(TmpWpStockGlobalBean tmpWpStockGlobalBean);
    
    /**
     * @param list 批量插入数据
     * @return
     */
    int insertList(List<TmpWpStock> list);
}
