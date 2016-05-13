package com.metersbonwe.stock.po.core;

import java.util.Date;

public class StockChannelProd {
    private Integer id;

    private String  channelCode;

    private String  prodId;

    private Integer privateStock;

    private Integer channelGroupPrivateStock;

    private Integer finalFreeStock;

    private Integer lockStock;

    private String  tableSuffix;

    private Date    updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
        setTableSuffix(channelCode == null ? null : channelCode.trim().toLowerCase());
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public Integer getPrivateStock() {
        return privateStock;
    }

    public void setPrivateStock(Integer privateStock) {
        this.privateStock = privateStock;
    }

    public Integer getChannelGroupPrivateStock() {
        return channelGroupPrivateStock;
    }

    public void setChannelGroupPrivateStock(Integer channelGroupPrivateStock) {
        this.channelGroupPrivateStock = channelGroupPrivateStock;
    }

    public Integer getFinalFreeStock() {
        return finalFreeStock;
    }

    public void setFinalFreeStock(Integer finalFreeStock) {
        this.finalFreeStock = finalFreeStock;
    }

    public Integer getLockStock() {
        return lockStock;
    }

    public void setLockStock(Integer lockStock) {
        this.lockStock = lockStock;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTableSuffix() {
        return tableSuffix;
    }

    public void setTableSuffix(String tableSuffix) {
        this.tableSuffix = tableSuffix;
    }

}
