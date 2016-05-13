package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class SfWarehProd {
    private BigDecimal id;

    private BigDecimal bfOrgId;

    private BigDecimal bfProductId;

    private BigDecimal stkOnHand;

    private BigDecimal qtyOnOrder;

    private BigDecimal qtyInTransit;

    private BigDecimal qtyCommitted;

    private BigDecimal qtyInDoubt;

    private BigDecimal stkPublished;

    private BigDecimal minStk;

    private BigDecimal maxStk;

    private BigDecimal alertMinStk;

    private BigDecimal alertMaxStk;

    private BigDecimal minAdStk;

    private BigDecimal maxAdStk;

    private BigDecimal sfWarehouseLocId;

    private Integer stdLocCap;

    private BigDecimal stkJustTime;

    private BigDecimal qtyCurComm;

    private BigDecimal qtyFucComm;

    private String qtyType;

    private Date lastModifiedDate;

    private BigDecimal qtyOnLock;

    private BigDecimal inRcvStk;

    private BigDecimal curCost;

    private BigDecimal qtyInTransitAg;

    private BigDecimal lockedQty;

    private BigDecimal reservedCommittedQty;

    private BigDecimal lockStockin;

    private BigDecimal reservedQty;

    private BigDecimal stockinFree;

    private BigDecimal b2bLockedQty;

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

    public BigDecimal getBfProductId() {
        return bfProductId;
    }

    public void setBfProductId(BigDecimal bfProductId) {
        this.bfProductId = bfProductId;
    }

    public BigDecimal getStkOnHand() {
        return stkOnHand;
    }

    public void setStkOnHand(BigDecimal stkOnHand) {
        this.stkOnHand = stkOnHand;
    }

    public BigDecimal getQtyOnOrder() {
        return qtyOnOrder;
    }

    public void setQtyOnOrder(BigDecimal qtyOnOrder) {
        this.qtyOnOrder = qtyOnOrder;
    }

    public BigDecimal getQtyInTransit() {
        return qtyInTransit;
    }

    public void setQtyInTransit(BigDecimal qtyInTransit) {
        this.qtyInTransit = qtyInTransit;
    }

    public BigDecimal getQtyCommitted() {
        return qtyCommitted;
    }

    public void setQtyCommitted(BigDecimal qtyCommitted) {
        this.qtyCommitted = qtyCommitted;
    }

    public BigDecimal getQtyInDoubt() {
        return qtyInDoubt;
    }

    public void setQtyInDoubt(BigDecimal qtyInDoubt) {
        this.qtyInDoubt = qtyInDoubt;
    }

    public BigDecimal getStkPublished() {
        return stkPublished;
    }

    public void setStkPublished(BigDecimal stkPublished) {
        this.stkPublished = stkPublished;
    }

    public BigDecimal getMinStk() {
        return minStk;
    }

    public void setMinStk(BigDecimal minStk) {
        this.minStk = minStk;
    }

    public BigDecimal getMaxStk() {
        return maxStk;
    }

    public void setMaxStk(BigDecimal maxStk) {
        this.maxStk = maxStk;
    }

    public BigDecimal getAlertMinStk() {
        return alertMinStk;
    }

    public void setAlertMinStk(BigDecimal alertMinStk) {
        this.alertMinStk = alertMinStk;
    }

    public BigDecimal getAlertMaxStk() {
        return alertMaxStk;
    }

    public void setAlertMaxStk(BigDecimal alertMaxStk) {
        this.alertMaxStk = alertMaxStk;
    }

    public BigDecimal getMinAdStk() {
        return minAdStk;
    }

    public void setMinAdStk(BigDecimal minAdStk) {
        this.minAdStk = minAdStk;
    }

    public BigDecimal getMaxAdStk() {
        return maxAdStk;
    }

    public void setMaxAdStk(BigDecimal maxAdStk) {
        this.maxAdStk = maxAdStk;
    }

    public BigDecimal getSfWarehouseLocId() {
        return sfWarehouseLocId;
    }

    public void setSfWarehouseLocId(BigDecimal sfWarehouseLocId) {
        this.sfWarehouseLocId = sfWarehouseLocId;
    }

    public Integer getStdLocCap() {
        return stdLocCap;
    }

    public void setStdLocCap(Integer stdLocCap) {
        this.stdLocCap = stdLocCap;
    }

    public BigDecimal getStkJustTime() {
        return stkJustTime;
    }

    public void setStkJustTime(BigDecimal stkJustTime) {
        this.stkJustTime = stkJustTime;
    }

    public BigDecimal getQtyCurComm() {
        return qtyCurComm;
    }

    public void setQtyCurComm(BigDecimal qtyCurComm) {
        this.qtyCurComm = qtyCurComm;
    }

    public BigDecimal getQtyFucComm() {
        return qtyFucComm;
    }

    public void setQtyFucComm(BigDecimal qtyFucComm) {
        this.qtyFucComm = qtyFucComm;
    }

    public String getQtyType() {
        return qtyType;
    }

    public void setQtyType(String qtyType) {
        this.qtyType = qtyType == null ? null : qtyType.trim();
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public BigDecimal getQtyOnLock() {
        return qtyOnLock;
    }

    public void setQtyOnLock(BigDecimal qtyOnLock) {
        this.qtyOnLock = qtyOnLock;
    }

    public BigDecimal getInRcvStk() {
        return inRcvStk;
    }

    public void setInRcvStk(BigDecimal inRcvStk) {
        this.inRcvStk = inRcvStk;
    }

    public BigDecimal getCurCost() {
        return curCost;
    }

    public void setCurCost(BigDecimal curCost) {
        this.curCost = curCost;
    }

    public BigDecimal getQtyInTransitAg() {
        return qtyInTransitAg;
    }

    public void setQtyInTransitAg(BigDecimal qtyInTransitAg) {
        this.qtyInTransitAg = qtyInTransitAg;
    }

    public BigDecimal getLockedQty() {
        return lockedQty;
    }

    public void setLockedQty(BigDecimal lockedQty) {
        this.lockedQty = lockedQty;
    }

    public BigDecimal getReservedCommittedQty() {
        return reservedCommittedQty;
    }

    public void setReservedCommittedQty(BigDecimal reservedCommittedQty) {
        this.reservedCommittedQty = reservedCommittedQty;
    }

    public BigDecimal getLockStockin() {
        return lockStockin;
    }

    public void setLockStockin(BigDecimal lockStockin) {
        this.lockStockin = lockStockin;
    }

    public BigDecimal getReservedQty() {
        return reservedQty;
    }

    public void setReservedQty(BigDecimal reservedQty) {
        this.reservedQty = reservedQty;
    }

    public BigDecimal getStockinFree() {
        return stockinFree;
    }

    public void setStockinFree(BigDecimal stockinFree) {
        this.stockinFree = stockinFree;
    }

    public BigDecimal getB2bLockedQty() {
        return b2bLockedQty;
    }

    public void setB2bLockedQty(BigDecimal b2bLockedQty) {
        this.b2bLockedQty = b2bLockedQty;
    }
}