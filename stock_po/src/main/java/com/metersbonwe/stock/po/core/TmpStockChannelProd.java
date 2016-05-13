package com.metersbonwe.stock.po.core;

import java.util.Date;

public class TmpStockChannelProd {
    private Integer id;

    private String prodId;

    private String channelCode;

    private Integer privateStock;

    private Integer lockStock;

    private Integer finalFreeStock;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public Integer getPrivateStock() {
        return privateStock;
    }

    public void setPrivateStock(Integer privateStock) {
        this.privateStock = privateStock;
    }

    public Integer getLockStock() {
        return lockStock;
    }

    public void setLockStock(Integer lockStock) {
        this.lockStock = lockStock;
    }

    public Integer getFinalFreeStock() {
        return finalFreeStock;
    }

    public void setFinalFreeStock(Integer finalFreeStock) {
        this.finalFreeStock = finalFreeStock;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}