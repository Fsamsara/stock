package com.metersbonwe.stock.pojo.imexcel;

import java.math.BigDecimal;

public class ShopQueryLocStockExcelBean {
    @Header(value = "门店编码", order = 1) private String     warehId;

    @Header(value = "货位编码", order = 2) private String     locId;

    @Header(value = "商品编码", order = 3) private String     prodId;

    @Header(value = "库存数量", order = 4) private BigDecimal stock;

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId;
    }

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId;
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
