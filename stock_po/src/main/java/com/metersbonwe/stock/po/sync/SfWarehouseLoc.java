package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class SfWarehouseLoc {
    private BigDecimal id;

    private BigDecimal sfWarehouseZoneId;

    private String code;

    private String locProp;

    private BigDecimal dimension;

    private String description;

    private String locDesc;

    private BigDecimal locTransLocId;

    private String floorNum;

    private String lockStatus;

    private String laneway;

    private Long sequenceNum;

    private String rowCode;

    private Long pickTraceNum;

    private String flowType;

    private String onShelfNum;

    private Date lastCtrlrTime;

    private String lockType;

    private String boxAdopted;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getSfWarehouseZoneId() {
        return sfWarehouseZoneId;
    }

    public void setSfWarehouseZoneId(BigDecimal sfWarehouseZoneId) {
        this.sfWarehouseZoneId = sfWarehouseZoneId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getLocProp() {
        return locProp;
    }

    public void setLocProp(String locProp) {
        this.locProp = locProp == null ? null : locProp.trim();
    }

    public BigDecimal getDimension() {
        return dimension;
    }

    public void setDimension(BigDecimal dimension) {
        this.dimension = dimension;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getLocDesc() {
        return locDesc;
    }

    public void setLocDesc(String locDesc) {
        this.locDesc = locDesc == null ? null : locDesc.trim();
    }

    public BigDecimal getLocTransLocId() {
        return locTransLocId;
    }

    public void setLocTransLocId(BigDecimal locTransLocId) {
        this.locTransLocId = locTransLocId;
    }

    public String getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum == null ? null : floorNum.trim();
    }

    public String getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(String lockStatus) {
        this.lockStatus = lockStatus == null ? null : lockStatus.trim();
    }

    public String getLaneway() {
        return laneway;
    }

    public void setLaneway(String laneway) {
        this.laneway = laneway == null ? null : laneway.trim();
    }

    public Long getSequenceNum() {
        return sequenceNum;
    }

    public void setSequenceNum(Long sequenceNum) {
        this.sequenceNum = sequenceNum;
    }

    public String getRowCode() {
        return rowCode;
    }

    public void setRowCode(String rowCode) {
        this.rowCode = rowCode == null ? null : rowCode.trim();
    }

    public Long getPickTraceNum() {
        return pickTraceNum;
    }

    public void setPickTraceNum(Long pickTraceNum) {
        this.pickTraceNum = pickTraceNum;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType == null ? null : flowType.trim();
    }

    public String getOnShelfNum() {
        return onShelfNum;
    }

    public void setOnShelfNum(String onShelfNum) {
        this.onShelfNum = onShelfNum == null ? null : onShelfNum.trim();
    }

    public Date getLastCtrlrTime() {
        return lastCtrlrTime;
    }

    public void setLastCtrlrTime(Date lastCtrlrTime) {
        this.lastCtrlrTime = lastCtrlrTime;
    }

    public String getLockType() {
        return lockType;
    }

    public void setLockType(String lockType) {
        this.lockType = lockType == null ? null : lockType.trim();
    }

    public String getBoxAdopted() {
        return boxAdopted;
    }

    public void setBoxAdopted(String boxAdopted) {
        this.boxAdopted = boxAdopted == null ? null : boxAdopted.trim();
    }
}