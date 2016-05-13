package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class TmpFreeStock {
    private BigDecimal id;

    private String warehId;

    private String prodId;

    private BigDecimal stkOnHand;

    private BigDecimal qtyCommitted;

    private BigDecimal freeStock;

    private Date updateTime;

    private String dataSource;

    private String isFreeChanged;

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

    public BigDecimal getStkOnHand() {
        return stkOnHand;
    }

    public void setStkOnHand(BigDecimal stkOnHand) {
        this.stkOnHand = stkOnHand;
    }

    public BigDecimal getQtyCommitted() {
        return qtyCommitted;
    }

    public void setQtyCommitted(BigDecimal qtyCommitted) {
        this.qtyCommitted = qtyCommitted;
    }

    public BigDecimal getFreeStock() {
        return freeStock;
    }

    public void setFreeStock(BigDecimal freeStock) {
        this.freeStock = freeStock;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }

    public String getIsFreeChanged() {
        return isFreeChanged;
    }

    public void setIsFreeChanged(String isFreeChanged) {
        this.isFreeChanged = isFreeChanged == null ? null : isFreeChanged.trim();
    }
}