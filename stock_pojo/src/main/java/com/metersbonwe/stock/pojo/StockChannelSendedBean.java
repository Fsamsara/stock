package com.metersbonwe.stock.pojo;

import java.util.List;

public class StockChannelSendedBean {

    private List<String> channelCodes;

    private List<String> prodIds;
    
    /**是否预售*/
    private List<String> isPres;

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

    public List<String> getIsPres() {
        return isPres;
    }

    public void setIsPres(List<String> isPres) {
        this.isPres = isPres;
    }

}
