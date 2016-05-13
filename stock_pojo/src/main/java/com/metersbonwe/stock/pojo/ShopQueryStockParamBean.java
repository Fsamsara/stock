package com.metersbonwe.stock.pojo;

import java.util.List;

public class ShopQueryStockParamBean {
    private String warehId;         //门店编码
    private List<String> skuList;   //商品编码集合
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
    
}
