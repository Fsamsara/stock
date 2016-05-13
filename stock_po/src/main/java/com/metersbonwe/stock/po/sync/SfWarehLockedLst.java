package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class SfWarehLockedLst {
    private BigDecimal id;

    private BigDecimal bfOrgId;

    private BigDecimal prodId;

    private BigDecimal lockedQty;

    private String lockedType;

    private String lastModifiedUser;

    private Date lastModifiedDate;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getBfOrgId() {
        return bfOrgId;
    }

    public void setBfOrgId(BigDecimal bfOrgId) {
        this.bfOrgId = bfOrgId;
    }

    public BigDecimal getProdId() {
        return prodId;
    }

    public void setProdId(BigDecimal prodId) {
        this.prodId = prodId;
    }

    public BigDecimal getLockedQty() {
        return lockedQty;
    }

    public void setLockedQty(BigDecimal lockedQty) {
        this.lockedQty = lockedQty;
    }

    public String getLockedType() {
        return lockedType;
    }

    public void setLockedType(String lockedType) {
        this.lockedType = lockedType == null ? null : lockedType.trim();
    }

    public String getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser == null ? null : lastModifiedUser.trim();
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}