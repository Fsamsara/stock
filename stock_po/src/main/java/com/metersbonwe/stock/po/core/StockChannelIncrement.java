package com.metersbonwe.stock.po.core;

import java.util.Date;

public class StockChannelIncrement {
    private Integer id;

    private Long incrementId;

    private String incrementName;

    private String channelCode;

    private String channelName;

    private String iStatus;

    private Date updateTime;

    private String updateBy;

    private Date createTime;

    private String createBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getIncrementId() {
        return incrementId;
    }

    public void setIncrementId(Long incrementId) {
        this.incrementId = incrementId;
    }

    public String getIncrementName() {
        return incrementName;
    }

    public void setIncrementName(String incrementName) {
        this.incrementName = incrementName == null ? null : incrementName.trim();
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus == null ? null : iStatus.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }
}