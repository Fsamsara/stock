package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class SfStkDtl {
    private BigDecimal id;

    private BigDecimal sfWarehouseLocId;

    private BigDecimal prodId;

    private BigDecimal stkOnHand;

    private BigDecimal expdQty;

    private BigDecimal allocQty;

    private BigDecimal bfOrgId;

    private Date lastModifiedDate;

    private Date lastPickTime;

    private BigDecimal lockQty;

    private BigDecimal stkOnHandBefor;

    private BigDecimal expdQtyBefor;

    private BigDecimal sttkLockQty;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getSfWarehouseLocId() {
        return sfWarehouseLocId;
    }

    public void setSfWarehouseLocId(BigDecimal sfWarehouseLocId) {
        this.sfWarehouseLocId = sfWarehouseLocId;
    }

    public BigDecimal getProdId() {
        return prodId;
    }

    public void setProdId(BigDecimal prodId) {
        this.prodId = prodId;
    }

    public BigDecimal getStkOnHand() {
        return stkOnHand;
    }

    public void setStkOnHand(BigDecimal stkOnHand) {
        this.stkOnHand = stkOnHand;
    }

    public BigDecimal getExpdQty() {
        return expdQty;
    }

    public void setExpdQty(BigDecimal expdQty) {
        this.expdQty = expdQty;
    }

    public BigDecimal getAllocQty() {
        return allocQty;
    }

    public void setAllocQty(BigDecimal allocQty) {
        this.allocQty = allocQty;
    }

    public BigDecimal getBfOrgId() {
        return bfOrgId;
    }

    public void setBfOrgId(BigDecimal bfOrgId) {
        this.bfOrgId = bfOrgId;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getLastPickTime() {
        return lastPickTime;
    }

    public void setLastPickTime(Date lastPickTime) {
        this.lastPickTime = lastPickTime;
    }

    public BigDecimal getLockQty() {
        return lockQty;
    }

    public void setLockQty(BigDecimal lockQty) {
        this.lockQty = lockQty;
    }

    public BigDecimal getStkOnHandBefor() {
        return stkOnHandBefor;
    }

    public void setStkOnHandBefor(BigDecimal stkOnHandBefor) {
        this.stkOnHandBefor = stkOnHandBefor;
    }

    public BigDecimal getExpdQtyBefor() {
        return expdQtyBefor;
    }

    public void setExpdQtyBefor(BigDecimal expdQtyBefor) {
        this.expdQtyBefor = expdQtyBefor;
    }

    public BigDecimal getSttkLockQty() {
        return sttkLockQty;
    }

    public void setSttkLockQty(BigDecimal sttkLockQty) {
        this.sttkLockQty = sttkLockQty;
    }
}