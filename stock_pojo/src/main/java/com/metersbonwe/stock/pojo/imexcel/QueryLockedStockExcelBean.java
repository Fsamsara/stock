package com.metersbonwe.stock.pojo.imexcel;

import java.math.BigDecimal;

public class QueryLockedStockExcelBean {

    @Header(value = "仓库编码", order = 1) private String    warehId;

    @Header(value = "预留类型", order = 2) private String    reservedType;

    @Header(value = "商品编码", order = 3) private String    prodId;

    @Header(value = "锁定量", order = 4) private BigDecimal stock;

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId;
    }

    public String getReservedType() {
        return reservedType;
    }

    public void setReservedType(String reservedType) {
        this.reservedType = reservedType;
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
