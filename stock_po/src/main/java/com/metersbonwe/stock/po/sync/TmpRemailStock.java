package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class TmpRemailStock {
    private BigDecimal id;

    private String warehId;

    private String prodId;

    private BigDecimal remailStock;

    private Date updateTime;

    private String locId;

    private String rllNum;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public BigDecimal getRemailStock() {
        return remailStock;
    }

    public void setRemailStock(BigDecimal remailStock) {
        this.remailStock = remailStock;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId == null ? null : locId.trim();
    }

    public String getRllNum() {
        return rllNum;
    }

    public void setRllNum(String rllNum) {
        this.rllNum = rllNum == null ? null : rllNum.trim();
    }
}