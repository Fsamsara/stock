package com.metersbonwe.stock.biz.common.service;

import java.util.List;

import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.ShopQueryLocStockParamBean;
import com.metersbonwe.stock.pojo.ShopQueryLocStockResultBean;
import com.metersbonwe.stock.pojo.ShopQueryStockParamBean;
import com.metersbonwe.stock.pojo.ShopQueryStockResultBean;

public interface ShopQueryStockService {

    /**
     * TODO 门店查询货位库存 TODO 根据门店编码、货位编码集合【非必填】、商品编码集合查询货位库存
     * 
     * @param paramBean
     *            【warehID:'',locList:['',...],skuList:['',...]】
     * @return
     */
    List<ShopQueryLocStockResultBean> shopQueryLocStock(ShopQueryLocStockParamBean paramBean);

    /**
     * TODO 门店查询库存 TODO 根据门店编码、商品编码集合查询货位库存
     * 
     * @param paramBean
     *            【warehID:'',skuList:['',...]】
     * @return
     */
    List<ShopQueryStockResultBean> shopQueryStock(ShopQueryStockParamBean paramBean);

    /**
     * TODO 门店按分页查询货位库存
     * 
     * @param page
     * @param paramBean
     * @return
     */
    List<ShopQueryLocStockResultBean> shopQueryLocStock_Page(Page<?> page, ShopQueryLocStockParamBean paramBean);

    /**
     * TODO 门店分页查询库存 TODO 根据门店编码、商品编码集合查询货位库存
     * 
     * @param page
     * @param paramBean
     *            【warehID:'',skuList:['',...]】
     * @return
     */
    List<ShopQueryStockResultBean> shopQueryStock_Page(Page<?> page, ShopQueryStockParamBean paramBean);
}
