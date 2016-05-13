package com.metersbonwe.stock.facade.api;

import com.metersbonwe.stock.facade.api.bean.ShopQueryLocStockReq;
import com.metersbonwe.stock.facade.api.bean.ShopQueryLocStockRes;
import com.metersbonwe.stock.facade.api.bean.ShopQueryStockReq;
import com.metersbonwe.stock.facade.api.bean.ShopQueryStockRes;

public interface ShopQueryStockFacade {

    /**
     * TODO 门店查询货位库存 TODO 根据门店编码、货位编码集合【非必填】、商品编码集合查询货位库存
     * 
     * @param req
     *            【warehID:'',locList:['',...],skuList:['',...]】
     * @return
     */
    public ShopQueryLocStockRes shopQueryLocStock(ShopQueryLocStockReq req);

    /**
     * TODO 门店查询库存 TODO 根据门店编码、商品编码集合查询货位库存
     * 
     * @param req
     *            【warehID:'',skuList:['',...]】
     * @return
     */
    public ShopQueryStockRes shopQueryStock(ShopQueryStockReq req);

}
