package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;

public class UdWarehParam {
    private BigDecimal id;

    private BigDecimal bfOrgId;

    private String orgType;

    private BigDecimal virtualWarehouseId;

    private BigDecimal b2cStartingQty;

    private BigDecimal b2cDistPeakValue;

    private BigDecimal b2bStartingQty;

    private BigDecimal b2bDistPeakValue;

    private String onlineSafeqtyType;

    private String offlineSafeqtyType;

    private String flag;

    private String upFlag;

    private String udOnline;

    private String udOffline;

    private BigDecimal shippingId;

    private String handCreateDoc;

    private BigDecimal minNum;

    private String prodSource;

    private BigDecimal safetyStock;

    private String isTfoDistWareh;

    private String usedMa;

    private String canadZones;

    private String isStkSync2os;

    private String isDoubleLocked;

    private BigDecimal releaseOrder;

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

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    public BigDecimal getVirtualWarehouseId() {
        return virtualWarehouseId;
    }

    public void setVirtualWarehouseId(BigDecimal virtualWarehouseId) {
        this.virtualWarehouseId = virtualWarehouseId;
    }

    public BigDecimal getB2cStartingQty() {
        return b2cStartingQty;
    }

    public void setB2cStartingQty(BigDecimal b2cStartingQty) {
        this.b2cStartingQty = b2cStartingQty;
    }

    public BigDecimal getB2cDistPeakValue() {
        return b2cDistPeakValue;
    }

    public void setB2cDistPeakValue(BigDecimal b2cDistPeakValue) {
        this.b2cDistPeakValue = b2cDistPeakValue;
    }

    public BigDecimal getB2bStartingQty() {
        return b2bStartingQty;
    }

    public void setB2bStartingQty(BigDecimal b2bStartingQty) {
        this.b2bStartingQty = b2bStartingQty;
    }

    public BigDecimal getB2bDistPeakValue() {
        return b2bDistPeakValue;
    }

    public void setB2bDistPeakValue(BigDecimal b2bDistPeakValue) {
        this.b2bDistPeakValue = b2bDistPeakValue;
    }

    public String getOnlineSafeqtyType() {
        return onlineSafeqtyType;
    }

    public void setOnlineSafeqtyType(String onlineSafeqtyType) {
        this.onlineSafeqtyType = onlineSafeqtyType == null ? null : onlineSafeqtyType.trim();
    }

    public String getOfflineSafeqtyType() {
        return offlineSafeqtyType;
    }

    public void setOfflineSafeqtyType(String offlineSafeqtyType) {
        this.offlineSafeqtyType = offlineSafeqtyType == null ? null : offlineSafeqtyType.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getUpFlag() {
        return upFlag;
    }

    public void setUpFlag(String upFlag) {
        this.upFlag = upFlag == null ? null : upFlag.trim();
    }

    public String getUdOnline() {
        return udOnline;
    }

    public void setUdOnline(String udOnline) {
        this.udOnline = udOnline == null ? null : udOnline.trim();
    }

    public String getUdOffline() {
        return udOffline;
    }

    public void setUdOffline(String udOffline) {
        this.udOffline = udOffline == null ? null : udOffline.trim();
    }

    public BigDecimal getShippingId() {
        return shippingId;
    }

    public void setShippingId(BigDecimal shippingId) {
        this.shippingId = shippingId;
    }

    public String getHandCreateDoc() {
        return handCreateDoc;
    }

    public void setHandCreateDoc(String handCreateDoc) {
        this.handCreateDoc = handCreateDoc == null ? null : handCreateDoc.trim();
    }

    public BigDecimal getMinNum() {
        return minNum;
    }

    public void setMinNum(BigDecimal minNum) {
        this.minNum = minNum;
    }

    public String getProdSource() {
        return prodSource;
    }

    public void setProdSource(String prodSource) {
        this.prodSource = prodSource == null ? null : prodSource.trim();
    }

    public BigDecimal getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(BigDecimal safetyStock) {
        this.safetyStock = safetyStock;
    }

    public String getIsTfoDistWareh() {
        return isTfoDistWareh;
    }

    public void setIsTfoDistWareh(String isTfoDistWareh) {
        this.isTfoDistWareh = isTfoDistWareh == null ? null : isTfoDistWareh.trim();
    }

    public String getUsedMa() {
        return usedMa;
    }

    public void setUsedMa(String usedMa) {
        this.usedMa = usedMa == null ? null : usedMa.trim();
    }

    public String getCanadZones() {
        return canadZones;
    }

    public void setCanadZones(String canadZones) {
        this.canadZones = canadZones == null ? null : canadZones.trim();
    }

    public String getIsStkSync2os() {
        return isStkSync2os;
    }

    public void setIsStkSync2os(String isStkSync2os) {
        this.isStkSync2os = isStkSync2os == null ? null : isStkSync2os.trim();
    }

    public String getIsDoubleLocked() {
        return isDoubleLocked;
    }

    public void setIsDoubleLocked(String isDoubleLocked) {
        this.isDoubleLocked = isDoubleLocked == null ? null : isDoubleLocked.trim();
    }

    public BigDecimal getReleaseOrder() {
        return releaseOrder;
    }

    public void setReleaseOrder(BigDecimal releaseOrder) {
        this.releaseOrder = releaseOrder;
    }
}