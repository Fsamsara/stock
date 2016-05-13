package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;

public class MvTt {
    private BigDecimal idx;

    private String warehId;

    private String prodId;

    private BigDecimal stkOnHand;

    private BigDecimal skuNum;

    public BigDecimal getIdx() {
        return idx;
    }

    public void setIdx(BigDecimal idx) {
        this.idx = idx;
    }

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

    public BigDecimal getStkOnHand() {
        return stkOnHand;
    }

    public void setStkOnHand(BigDecimal stkOnHand) {
        this.stkOnHand = stkOnHand;
    }

    public BigDecimal getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(BigDecimal skuNum) {
        this.skuNum = skuNum;
    }
}