package com.metersbonwe.stock.pojo;

import java.util.List;

public class PageStockChannelStatusBean {
    
    private List<String> channelCodes;
    
    private List<String> sixProdIds;
    
    private List<String> saleStatus;
    
    private List<String> isSyncs;

    public List<String> getChannelCodes() {
        return channelCodes;
    }

    public void setChannelCodes(List<String> channelCodes) {
        this.channelCodes = channelCodes;
    }

    public List<String> getSixProdIds() {
        return sixProdIds;
    }

    public void setSixProdIds(List<String> sixProdIds) {
        this.sixProdIds = sixProdIds;
    }

    public List<String> getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(List<String> saleStatus) {
        this.saleStatus = saleStatus;
    }

    public List<String> getIsSyncs() {
        return isSyncs;
    }

    public void setIsSyncs(List<String> isSyncs) {
        this.isSyncs = isSyncs;
    }
}
