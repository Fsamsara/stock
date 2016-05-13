package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.metersbonwe.stock.po.core.StockShopRemail;

/**
 * 门店未日结 自定义MAPPER
 * @author zhangruiyu
 *
 */
public interface StockShopRemailDefineMapper {
	 /**
     * 
     * 查询店+SKU的未日结总数 
     * @param warehId 门店code
     * @param prodId 11位码
     * @return 			wareh_id,
						prod_id,
						remailStock
     */
    List<Map<String,Object>> selectShopRemail(@Param("warehId")String warehId, @Param("prodId")String prodId);
    
    /**
     * 
     * TODO 查询门店货位未日结
     * TODO 根据门店编码、货位编码集合、商品编码集合查询门店货位未日结
     * @param map  【warehId:'',locList:['',...],skuList:['',...]】
     * @return
     */
    List<StockShopRemail> selectShopLocRemailByOthers(Map<String,Object> map);
    
    /**
     * 
     * TODO 查询门店货位未日结
     * TODO 根据门店编码、商品编码集合查询门店货位未日结
     * @param map  【warehId:'',skuList:['',...]】
     * @return
     */
    List<StockShopRemail> selectShopLocRemailByOthersAndNoLoc(Map<String,Object> map);
    
    int insertShopRemail(StockShopRemail stockShopRemail);
    
    int updateShopRemail(StockShopRemail stockShopRemail);
    
}
