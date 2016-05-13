package com.metersbonwe.stock.po.core;

import java.util.Date;

public class StockChannelProdSub {
    private Integer id;

    private String  channelCode;

    private String  sixProdId;

    private String  eightProdId;

    private String  prodId;

    private Integer orderPrivateTotalStock;

    private Integer orderShopGroupStock;

    private Integer orderShareTotalStock;

    private Integer prePrivateStock;

    private Integer preOrderTotalStock;

    private String  tableSuffix;

    private Integer isPre;

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

    public String getTableSuffix() {
        return tableSuffix;
    }

    public void setTableSuffix(String tableSuffix) {
        this.tableSuffix = tableSuffix;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
        setTableSuffix(channelCode == null ? null : channelCode.trim().toLowerCase());
    }

    public String getSixProdId() {
        return sixProdId;
    }

    public void setSixProdId(String sixProdId) {
        this.sixProdId = sixProdId == null ? null : sixProdId.trim();
    }

    public String getEightProdId() {
        return eightProdId;
    }

    public void setEightProdId(String eightProdId) {
        this.eightProdId = eightProdId == null ? null : eightProdId.trim();
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public Integer getOrderPrivateTotalStock() {
        return orderPrivateTotalStock;
    }

    public void setOrderPrivateTotalStock(Integer orderPrivateTotalStock) {
        this.orderPrivateTotalStock = orderPrivateTotalStock;
    }

    public Integer getOrderShopGroupStock() {
        return orderShopGroupStock;
    }

    public void setOrderShopGroupStock(Integer orderShopGroupStock) {
        this.orderShopGroupStock = orderShopGroupStock;
    }

    public Integer getOrderShareTotalStock() {
        return orderShareTotalStock;
    }

    public void setOrderShareTotalStock(Integer orderShareTotalStock) {
        this.orderShareTotalStock = orderShareTotalStock;
    }

    public Integer getPrePrivateStock() {
        return prePrivateStock;
    }

    public void setPrePrivateStock(Integer prePrivateStock) {
        this.prePrivateStock = prePrivateStock;
    }

    public Integer getPreOrderTotalStock() {
        return preOrderTotalStock;
    }

    public void setPreOrderTotalStock(Integer preOrderTotalStock) {
        this.preOrderTotalStock = preOrderTotalStock;
    }

    public Integer getIsPre() {
        return isPre;
    }

    public void setIsPre(Integer isPre) {
        this.isPre = isPre;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
