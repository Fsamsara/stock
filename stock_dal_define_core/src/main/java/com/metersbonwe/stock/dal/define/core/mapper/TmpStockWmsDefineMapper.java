package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.po.core.TmpStockWms;
import com.metersbonwe.stock.po.wms.WmsStockProdQty;

/**
 * @author zhangjf
 */
public interface TmpStockWmsDefineMapper {
    /**
     * 清空表tmp_stock_wms
     */
    void truncateTable();

    /**
     * 插入临时表数据
     * 
     * @param map
     * @return
     */
    int insertToTmpStockWms(Map<String, Object> map);

    /**
     * 查询差异数据
     * 
     * @return
     */
    List<TmpStockWms> selectDiffData();

    /**
     * 根据配置表获取表数据
     * @param map
     * @return
     */
    List<TmpStockWms> selectAll(Map<String,Object> map);
    
    /**
     * 删除不使用USMA的仓的正数锁定数据
     * @param map
     * @return
     */
    int deleteWmsNoAttribute(Map<String, Object> map);
}
