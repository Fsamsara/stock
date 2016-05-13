package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class ShopQueryStock implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 4848763910626521561L;

    private String            warehId;                                //仓库、门店编码

    private String            prodId;                                 //商品编码

    private BigDecimal        stock;                                  //库存数量

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

}
