package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class UrUnitReservedResult {
    private BigDecimal id;

    private String unitId;

    private String prodId;

    private String warehId;

    private BigDecimal reservedQty;

    private String reservedType;

    private BigDecimal allocatedQty;

    private BigDecimal lockedQty;

    private BigDecimal reservedAllocatedQty;

    private Date lastModifiedDate;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId == null ? null : unitId.trim();
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId == null ? null : warehId.trim();
    }

    public BigDecimal getReservedQty() {
        return reservedQty;
    }

    public void setReservedQty(BigDecimal reservedQty) {
        this.reservedQty = reservedQty;
    }

    public String getReservedType() {
        return reservedType;
    }

    public void setReservedType(String reservedType) {
        this.reservedType = reservedType == null ? null : reservedType.trim();
    }

    public BigDecimal getAllocatedQty() {
        return allocatedQty;
    }

    public void setAllocatedQty(BigDecimal allocatedQty) {
        this.allocatedQty = allocatedQty;
    }

    public BigDecimal getLockedQty() {
        return lockedQty;
    }

    public void setLockedQty(BigDecimal lockedQty) {
        this.lockedQty = lockedQty;
    }

    public BigDecimal getReservedAllocatedQty() {
        return reservedAllocatedQty;
    }

    public void setReservedAllocatedQty(BigDecimal reservedAllocatedQty) {
        this.reservedAllocatedQty = reservedAllocatedQty;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}