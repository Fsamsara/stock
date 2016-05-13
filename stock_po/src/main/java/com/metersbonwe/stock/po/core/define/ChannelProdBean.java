package com.metersbonwe.stock.po.core.define;

/**
 * @author sky
 * @version V1.0
 * @description 渠道商品明细javaBean
 * @date 2016/3/18
 */
public class ChannelProdBean {

    private String  channelCode;

    private String  channelName;

    private String  prodId;

    private int     privateStock;

    private int     finalFreeStock;

    private int     lockStock;

    private int     shopGroupStock;

    private String  sixProdId;

    private String  eightProdId;

    private int     orderPrivateTotalStock;

    private int     orderShareTotalStock;

    private int     orderShopGroupStock;

    private int     prePrivateStock;

    private int     preOrderTotalStock;

    private int     isPre;

    private String  operType;

    private String  tableSuffix;

    private Integer onlineStock;

    private Long    relationId;

    private String warehId;

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
        this.tableSuffix = channelCode == null ? null : channelCode.trim().toLowerCase();
    }

    public int getOrderShopGroupStock() {
        return orderShopGroupStock;
    }

    public int getShopGroupStock() {
        return shopGroupStock;
    }

    public Integer getOnlineStock() {
        return onlineStock;
    }

    public void setOnlineStock(Integer onlineStock) {
        this.onlineStock = onlineStock;
    }

    public void setShopGroupStock(int shopGroupStock) {
        this.shopGroupStock = shopGroupStock;
    }

    public void setOrderShopGroupStock(int orderShopGroupStock) {
        this.orderShopGroupStock = orderShopGroupStock;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public int getPrivateStock() {
        return privateStock;
    }

    public void setPrivateStock(int privateStock) {
        this.privateStock = privateStock;
    }

    public int getFinalFreeStock() {
        return finalFreeStock;
    }

    public void setFinalFreeStock(int finalFreeStock) {
        this.finalFreeStock = finalFreeStock;
    }

    public int getLockStock() {
        return lockStock;
    }

    public void setLockStock(int lockStock) {
        this.lockStock = lockStock;
    }

    public String getSixProdId() {
        return sixProdId;
    }

    public void setSixProdId(String sixProdId) {
        this.sixProdId = sixProdId;
    }

    public String getEightProdId() {
        return eightProdId;
    }

    public void setEightProdId(String eightProdId) {
        this.eightProdId = eightProdId;
    }

    public int getOrderPrivateTotalStock() {
        return orderPrivateTotalStock;
    }

    public void setOrderPrivateTotalStock(int orderPrivateTotalStock) {
        this.orderPrivateTotalStock = orderPrivateTotalStock;
    }

    public int getOrderShareTotalStock() {
        return orderShareTotalStock;
    }

    public void setOrderShareTotalStock(int orderShareTotalStock) {
        this.orderShareTotalStock = orderShareTotalStock;
    }

    public int getPrePrivateStock() {
        return prePrivateStock;
    }

    public void setPrePrivateStock(int prePrivateStock) {
        this.prePrivateStock = prePrivateStock;
    }

    public int getPreOrderTotalStock() {
        return preOrderTotalStock;
    }

    public void setPreOrderTotalStock(int preOrderTotalStock) {
        this.preOrderTotalStock = preOrderTotalStock;
    }

    public int getIsPre() {
        return isPre;
    }

    public void setIsPre(int isPre) {
        this.isPre = isPre;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getTableSuffix() {
        return tableSuffix;
    }

    public void setTableSuffix(String tableSuffix) {
        this.tableSuffix = tableSuffix;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

}
