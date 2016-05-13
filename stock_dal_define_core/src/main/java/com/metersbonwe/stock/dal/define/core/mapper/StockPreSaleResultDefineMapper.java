package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;

import com.metersbonwe.stock.po.core.define.StockPreSaleResultDefine;

/**
 * @author zhq
 */
public interface StockPreSaleResultDefineMapper {

    /**
     * 查询可以开启预售的的预售结果信息
     * 
     * @return
     */
    public List<StockPreSaleResultDefine> selectCouldOpen();

    /**
     * 查询可以关闭的预售结果信息
     * 
     * @return
     */
    public List<StockPreSaleResultDefine> selectCouldClose();

    /**
     * TODO 根据预售单ID来查询开启的预售结果信息记录数
     * 
     * @param id
     *            预售单id
     * @return
     */
    public int selectStockPreSaleResultCountByPreSaleId(long id);

}
