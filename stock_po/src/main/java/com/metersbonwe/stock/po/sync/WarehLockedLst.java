package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class WarehLockedLst {
    private String warehId;

    private String prodId;

    private String lockedType;

    private BigDecimal lockedQty;

    private Date stkChangeDate;

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId == null ? null : warehId.trim();
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public String getLockedType() {
        return lockedType;
    }

    public void setLockedType(String lockedType) {
        this.lockedType = lockedType == null ? null : lockedType.trim();
    }

    public BigDecimal getLockedQty() {
        return lockedQty;
    }

    public void setLockedQty(BigDecimal lockedQty) {
        this.lockedQty = lockedQty;
    }

    public Date getStkChangeDate() {
        return stkChangeDate;
    }

    public void setStkChangeDate(Date stkChangeDate) {
        this.stkChangeDate = stkChangeDate;
    }
}