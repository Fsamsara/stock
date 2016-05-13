package com.metersbonwe.stock.po.core;

import java.util.Date;

public class StockTpStock {
    private Integer id;

    private String warehId;

    private String prodId;

    private Integer tpStock;

    private Date updateTime;

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

    public Integer getTpStock() {
        return tpStock;
    }

    public void setTpStock(Integer tpStock) {
        this.tpStock = tpStock;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}