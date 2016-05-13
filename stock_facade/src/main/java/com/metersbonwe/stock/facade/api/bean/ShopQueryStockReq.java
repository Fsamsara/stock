package com.metersbonwe.stock.facade.api.bean;

import java.util.List;

public class ShopQueryStockReq implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -5741825221163308747L;

    private String            warehId;                                 //门店编码

    private List<String>      skuList;                                 //商品编码集合

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId;
    }

    public List<String> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<String> skuList) {
        this.skuList = skuList;
    }

    @Override
    public String toString() {
        return "ShopQueryStockReq [warehId=" + warehId + ", skuList=" + skuList + "]";
    }

}
