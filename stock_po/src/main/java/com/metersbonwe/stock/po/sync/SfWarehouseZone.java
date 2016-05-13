package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;

public class SfWarehouseZone {
    private BigDecimal id;

    private BigDecimal bfOrgId;

    private String code;

    private String description;

    private Integer floor;

    private String locDesc;

    private String moveType;

    private String satelliteInfo;

    private String isTransLocareaAdpt;

    private BigDecimal supTransLocId;

    private String zoneType;

    private Integer priv;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getLocDesc() {
        return locDesc;
    }

    public void setLocDesc(String locDesc) {
        this.locDesc = locDesc == null ? null : locDesc.trim();
    }

    public String getMoveType() {
        return moveType;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType == null ? null : moveType.trim();
    }

    public String getSatelliteInfo() {
        return satelliteInfo;
    }

    public void setSatelliteInfo(String satelliteInfo) {
        this.satelliteInfo = satelliteInfo == null ? null : satelliteInfo.trim();
    }

    public String getIsTransLocareaAdpt() {
        return isTransLocareaAdpt;
    }

    public void setIsTransLocareaAdpt(String isTransLocareaAdpt) {
        this.isTransLocareaAdpt = isTransLocareaAdpt == null ? null : isTransLocareaAdpt.trim();
    }

    public BigDecimal getSupTransLocId() {
        return supTransLocId;
    }

    public void setSupTransLocId(BigDecimal supTransLocId) {
        this.supTransLocId = supTransLocId;
    }

    public String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType == null ? null : zoneType.trim();
    }

    public Integer getPriv() {
        return priv;
    }

    public void setPriv(Integer priv) {
        this.priv = priv;
    }
}