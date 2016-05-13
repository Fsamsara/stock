package com.metersbonwe.stock.pojo;

import java.math.BigDecimal;

public class WarehProdLockedBean {
    private String warehId;

    private String prodId;

    private BigDecimal lockedQty;

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

    public BigDecimal getLockedQty() {
        return lockedQty;
    }

    public void setLockedQty(BigDecimal lockedQty) {
        this.lockedQty = lockedQty;
    }
    
    
}
