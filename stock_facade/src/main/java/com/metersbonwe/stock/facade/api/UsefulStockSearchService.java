package com.metersbonwe.stock.facade.api;

import com.metersbonwe.stock.facade.api.bean.SkuStock;

import java.util.List;

/**
 * @author huangbiao
 * @version V1.0
 * @description 通用可用库存查询接口
 * @date 2016/3/28
 */
public interface UsefulStockSearchService {
    /**
     * @description 返回指定SKU在指定channelCode的实际可用库存
     * @param sku 11位码
     * @param channelCode 渠道编号
     * @return -9sku不存在
     */
    int getStock(String sku, String channelCode);

    /**
     * 批量查询指定sku在指定channelCode的库存
     * @param sku 指定sku列表11位
     * @param channelCode 渠道编号
     * @return SkuStock对象集合
     */
    List<SkuStock> getBatchStock(List<String> sku, String channelCode);

    /**
     * 根据指定sn码查询其下所有sku的库存量
     * @param sn 六位码
     * @param channelCode 渠道号
     * @return SkuStock对象集合
     */
    List<SkuStock> getBatchStockBySn(String sn, String channelCode);
}
