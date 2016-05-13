package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class StkDtl {
    private String warehId;

    private String locId;

    private String prodId;

    private BigDecimal stkOnHand;

    private BigDecimal allocQty;

    private BigDecimal expdQty;

    private Date stkChangeDate;

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId == null ? null : warehId.trim();
    }

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId == null ? null : locId.trim();
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public BigDecimal getStkOnHand() {
        return stkOnHand;
    }

    public void setStkOnHand(BigDecimal stkOnHand) {
        this.stkOnHand = stkOnHand;
    }

    public BigDecimal getAllocQty() {
        return allocQty;
    }

    public void setAllocQty(BigDecimal allocQty) {
        this.allocQty = allocQty;
    }

    public BigDecimal getExpdQty() {
        return expdQty;
    }

    public void setExpdQty(BigDecimal expdQty) {
        this.expdQty = expdQty;
    }

    public Date getStkChangeDate() {
        return stkChangeDate;
    }

    public void setStkChangeDate(Date stkChangeDate) {
        this.stkChangeDate = stkChangeDate;
    }
}