package com.metersbonwe.stock.po.core;

import java.util.Date;

public class StockShopSafeTran {
    private Integer id;

    private String warehId;

    private String prodId;

    private Integer safeStock;

    private String safeStockOrderType;

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

    public Integer getSafeStock() {
        return safeStock;
    }

    public void setSafeStock(Integer safeStock) {
        this.safeStock = safeStock;
    }

    public String getSafeStockOrderType() {
        return safeStockOrderType;
    }

    public void setSafeStockOrderType(String safeStockOrderType) {
        this.safeStockOrderType = safeStockOrderType == null ? null : safeStockOrderType.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}