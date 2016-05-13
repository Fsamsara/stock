package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.metersbonwe.stock.po.core.StockWarehProd;

/**
 * 库存操作 STOCK_WAREH_PROD
 * 
 * @author TanYibin
 */
public interface StockWarehProdDefineMapper {

    /**
     * 更新MySql核心库STOCK_WAREH_PORD表变化量及最终自由量(自由量大于0)
     * 
     * @param stockWarehProd
     */
    int updateFinalFreeShareStockGTZero(StockWarehProd stockWarehProd);

    /**
     * 更新MySql核心库STOCK_WAREH_PORD表变化量及最终自由量(自由量小于0)
     * 
     * @param stockWarehProd
     */
    int updateFinalFreeShareStockLSZero(StockWarehProd stockWarehProd);

    /**
     * 更新无效污次少洗数据对应的门店污损值shop_dame
     * 
     * @param suffix
     * @param configValue
     * @return
     */
    int updateShopDame(@Param("suffix") String suffix, @Param("warehId") String warehId, @Param("prodId") String prodId);

    /**
     * 更新无效安全库存对应的门店线上安全库存online_safe_stock
     * 
     * @param suffix
     * @param configValue
     * @return
     */
    int updateShopSafe(@Param("suffix") String suffix, @Param("warehId") String warehId, @Param("prodId") String prodId);

    /**
     * TODO 根据仓库编码集合、商品编码集合查询自由量
     * 
     * @param map
     *            {tableNumList:['',...],warehList:['',...],skuList:['',...]}
     * @return
     */
    List<StockWarehProd> selectStockWarehProdListByOthers(Map<String, Object> map);

    /**
     * 查询仓库+SKU信息
     * 
     * @param stockWarehProd
     * @return
     */
    StockWarehProd selectStockWarehProd(StockWarehProd stockWarehProd);

    /**
     * TODO 根据仓库编码集合、6位商品编码集合、8位商品编码集合、商品编码集合查询自由量
     * 
     * @param map
     *            {tableNumList:['',...],warehList:['',...],sku6List:['',...],sku8List:['',...],skuList:['',...]}
     * @return
     */
    List<StockWarehProd> selectStockWarehProdListByLenProdAndOthers(Map<String, Object> map);

}
