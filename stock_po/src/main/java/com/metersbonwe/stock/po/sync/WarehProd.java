package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class WarehProd {
    private String warehId;

    private String prodId;

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

    private String dfltZoneId;

    private Integer stdLocCap;

    private String dfltLocId;

    private BigDecimal stkJustTime;

    private BigDecimal qtyFucComm;

    private BigDecimal qtyCurComm;

    private Date stkChangeDate;

    private BigDecimal bgrStk;

    private BigDecimal inRcvStk;

    private BigDecimal lockedQty;

    private BigDecimal reservedQty;

    private BigDecimal lockStockin;

    private BigDecimal stockinFree;

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

    public String getDfltZoneId() {
        return dfltZoneId;
    }

    public void setDfltZoneId(String dfltZoneId) {
        this.dfltZoneId = dfltZoneId == null ? null : dfltZoneId.trim();
    }

    public Integer getStdLocCap() {
        return stdLocCap;
    }

    public void setStdLocCap(Integer stdLocCap) {
        this.stdLocCap = stdLocCap;
    }

    public String getDfltLocId() {
        return dfltLocId;
    }

    public void setDfltLocId(String dfltLocId) {
        this.dfltLocId = dfltLocId == null ? null : dfltLocId.trim();
    }

    public BigDecimal getStkJustTime() {
        return stkJustTime;
    }

    public void setStkJustTime(BigDecimal stkJustTime) {
        this.stkJustTime = stkJustTime;
    }

    public BigDecimal getQtyFucComm() {
        return qtyFucComm;
    }

    public void setQtyFucComm(BigDecimal qtyFucComm) {
        this.qtyFucComm = qtyFucComm;
    }

    public BigDecimal getQtyCurComm() {
        return qtyCurComm;
    }

    public void setQtyCurComm(BigDecimal qtyCurComm) {
        this.qtyCurComm = qtyCurComm;
    }

    public Date getStkChangeDate() {
        return stkChangeDate;
    }

    public void setStkChangeDate(Date stkChangeDate) {
        this.stkChangeDate = stkChangeDate;
    }

    public BigDecimal getBgrStk() {
        return bgrStk;
    }

    public void setBgrStk(BigDecimal bgrStk) {
        this.bgrStk = bgrStk;
    }

    public BigDecimal getInRcvStk() {
        return inRcvStk;
    }

    public void setInRcvStk(BigDecimal inRcvStk) {
        this.inRcvStk = inRcvStk;
    }

    public BigDecimal getLockedQty() {
        return lockedQty;
    }

    public void setLockedQty(BigDecimal lockedQty) {
        this.lockedQty = lockedQty;
    }

    public BigDecimal getReservedQty() {
        return reservedQty;
    }

    public void setReservedQty(BigDecimal reservedQty) {
        this.reservedQty = reservedQty;
    }

    public BigDecimal getLockStockin() {
        return lockStockin;
    }

    public void setLockStockin(BigDecimal lockStockin) {
        this.lockStockin = lockStockin;
    }

    public BigDecimal getStockinFree() {
        return stockinFree;
    }

    public void setStockinFree(BigDecimal stockinFree) {
        this.stockinFree = stockinFree;
    }
}