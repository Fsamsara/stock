package com.metersbonwe.stock.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class QryLockStockResultBean implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -6213391074063712932L;
    private String reservedType;    //预留类型
    private String warehId;        //仓库编码
    private String prodId;         //商品编码
    private BigDecimal stock;       //锁定量
    public String getReservedType() {
        return reservedType;
    }
    public void setReservedType(String reservedType) {
        this.reservedType = reservedType;
    }
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
