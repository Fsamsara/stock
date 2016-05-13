package com.metersbonwe.stock.po.core;

import java.util.Date;

public class StockChannelOrderDetailHis {
    private Integer id;

    private String channelCode;

    private String businessId;

    private String osOrderId;

    private String subOrderId;

    private String prodId;

    private Integer isPreOccupy;

    private Integer orderPrivateStock;

    private Integer orderShareStock;

    private Integer orderShopGroupStock;

    private String relationChannel;

    private Date updateTime;

    private Date releaseTime;

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
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    public String getOsOrderId() {
        return osOrderId;
    }

    public void setOsOrderId(String osOrderId) {
        this.osOrderId = osOrderId == null ? null : osOrderId.trim();
    }

    public String getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(String subOrderId) {
        this.subOrderId = subOrderId == null ? null : subOrderId.trim();
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public Integer getIsPreOccupy() {
        return isPreOccupy;
    }

    public void setIsPreOccupy(Integer isPreOccupy) {
        this.isPreOccupy = isPreOccupy;
    }

    public Integer getOrderPrivateStock() {
        return orderPrivateStock;
    }

    public void setOrderPrivateStock(Integer orderPrivateStock) {
        this.orderPrivateStock = orderPrivateStock;
    }

    public Integer getOrderShareStock() {
        return orderShareStock;
    }

    public void setOrderShareStock(Integer orderShareStock) {
        this.orderShareStock = orderShareStock;
    }

    public Integer getOrderShopGroupStock() {
        return orderShopGroupStock;
    }

    public void setOrderShopGroupStock(Integer orderShopGroupStock) {
        this.orderShopGroupStock = orderShopGroupStock;
    }

    public String getRelationChannel() {
        return relationChannel;
    }

    public void setRelationChannel(String relationChannel) {
        this.relationChannel = relationChannel == null ? null : relationChannel.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }
}