package com.metersbonwe.stock.biz.common.service;

import java.util.List;

import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.pojo.Page;

public interface QueryStockWarehProdService {

    /**
     * TODO 多仓、多sku获取仓+sku库存量 TODO 根据仓库集合、商品编码集合获取仓+sku库存量
     * 
     * @param warehList
     * @param skuList
     */
    List<StockWarehProd> getWarehsSkusStock(List<String> warehList, List<String> skuList);

    /**
     * TODO 多仓、多sku分页获取仓+sku库存量 TODO 根据仓库集合、商品编码集合获取仓+sku库存量
     * 
     * @param page
     * @param warehList
     * @param skuList
     */
    List<StockWarehProd> getWarehsSkusStock_Page(Page<?> page, List<String> warehList, List<String> skuList);

    /**
     * TODO 单仓、多sku获取仓+sku库存量 TODO 根据仓库、商品编码集合获取仓+sku库存量
     * 
     * @param warehId
     * @param skuList
     * @return
     */
    List<StockWarehProd> getWarehSkuStock(String warehId, List<String> skuList);

    /**
     * TODO 可以按分页查询单仓、多sku或没有sku获取仓+sku库存量
     * 
     * @param page
     * @param warehId
     * @param skuList
     * @return
     */
    List<StockWarehProd> getWarehSkuStockByPage(Page<?> page, String warehId, List<String> skuList);

    /**
     * TODO 多仓、多sku获取仓+sku库存量 TODO 根据仓库集合、商品编码集合获取仓+sku自由量（union all）
     * 
     * @param channelSource
     * @param warehList
     * @param skuList
     */
    List<StockWarehProd> selectStockWarehProdListByOthers(String channelSource, List<String> warehList, List<String> skuList);

}
