package com.metersbonwe.stock.po.core;

import java.util.Date;

public class StockWpSafeTran {
    private Integer id;

    private String warehId;

    private String prodId;

    private Integer safeStock;

    private String safeStockType;

    private String wpOrderType;

    private String updateBy;

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

    public String getSafeStockType() {
        return safeStockType;
    }

    public void setSafeStockType(String safeStockType) {
        this.safeStockType = safeStockType == null ? null : safeStockType.trim();
    }

    public String getWpOrderType() {
        return wpOrderType;
    }

    public void setWpOrderType(String wpOrderType) {
        this.wpOrderType = wpOrderType == null ? null : wpOrderType.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}