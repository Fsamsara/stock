package com.metersbonwe.stock.biz.manager.service;

import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.po.core.StockShopDame;

/**
 * TODO 污损值查询服务
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年3月30日 上午9:21:04
 * @since V1.0
 * @version V1.0
 */
public interface StockShopDameService {

    /**
     * TODO 条件查询污损值
     *
     * @param dameVo
     * @return
     * @throws Exception
     */
    List<StockShopDame> selectStockShopDame(Map<String, List<String>> paraListMap) throws Exception;

    /**
     * TODO 污损值修正
     *
     * @param dameVo
     * @return
     * @throws Exception
     */
    int updateStockShopDame(StockShopDame damePo) throws Exception;

    /**
     * TODO 污损值删除
     *
     * @param dameVo
     * @return
     * @throws Exception
     */
    int deleteStockShopDame(StockShopDame damePo) throws Exception;

    /**
     * TODO 新增污损值
     *
     * @param dameVo
     * @return
     * @throws Exception
     */
    int addStockShopDame(StockShopDame vo) throws Exception;

}
