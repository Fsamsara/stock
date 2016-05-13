package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class UdChannleStockScopeDtl {
    private BigDecimal id;

    private BigDecimal udCwId;

    private String udLockedType;

    private String status;

    private String remark;

    private String lastModifiedUser;

    private Date lastModifiedDate;

    private String forcedLockedType;

    private Integer seqNum;

    private String ismonopolize;

    private String isSyncOs;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getUdCwId() {
        return udCwId;
    }

    public void setUdCwId(BigDecimal udCwId) {
        this.udCwId = udCwId;
    }

    public String getUdLockedType() {
        return udLockedType;
    }

    public void setUdLockedType(String udLockedType) {
        this.udLockedType = udLockedType == null ? null : udLockedType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getForcedLockedType() {
        return forcedLockedType;
    }

    public void setForcedLockedType(String forcedLockedType) {
        this.forcedLockedType = forcedLockedType == null ? null : forcedLockedType.trim();
    }

    public Integer getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(Integer seqNum) {
        this.seqNum = seqNum;
    }

    public String getIsmonopolize() {
        return ismonopolize;
    }

    public void setIsmonopolize(String ismonopolize) {
        this.ismonopolize = ismonopolize == null ? null : ismonopolize.trim();
    }

    public String getIsSyncOs() {
        return isSyncOs;
    }

    public void setIsSyncOs(String isSyncOs) {
        this.isSyncOs = isSyncOs == null ? null : isSyncOs.trim();
    }
}