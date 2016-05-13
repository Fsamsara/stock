package com.metersbonwe.stock.po.core;

import java.util.Date;

public class StockShopRemail {
    private Integer id;

    private String warehId;

    private String prodId;

    private String locId;

    private Integer remailStock;

    private Date updateTime;

    private String rllNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId == null ? null : locId.trim();
    }

    public Integer getRemailStock() {
        return remailStock;
    }

    public void setRemailStock(Integer remailStock) {
        this.remailStock = remailStock;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRllNum() {
        return rllNum;
    }

    public void setRllNum(String rllNum) {
        this.rllNum = rllNum == null ? null : rllNum.trim();
    }
}