package com.metersbonwe.stock.pojo;

import java.util.List;

import com.metersbonwe.stock.po.core.StockChannelProd;

public class StockChannelProdBean extends StockChannelProd {

    private String sixProdId;

    private String eightProdId;

    private Integer orderPrivateTotalStock;

    private Integer orderShareTotalStock;

    private Integer prePrivateStock;

    private Integer preOrderTotalStock;

    private Integer isPre;

    private List<String> channelCodes;

    private List<String> prodIds;

    public List<String> getChannelCodes() {
        return channelCodes;
    }

    public void setChannelCodes(List<String> channelCodes) {
        this.channelCodes = channelCodes;
    }

    public List<String> getProdIds() {
        return prodIds;
    }

    public void setProdIds(List<String> prodIds) {
        this.prodIds = prodIds;
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

    public Integer getOrderPrivateTotalStock() {
        return orderPrivateTotalStock;
    }

    public void setOrderPrivateTotalStock(Integer orderPrivateTotalStock) {
        this.orderPrivateTotalStock = orderPrivateTotalStock;
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

}
