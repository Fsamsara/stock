package com.metersbonwe.stock.po.core;

public class TmpStockChannelStatus {
    private Integer id;

    private String channelCode;

    private String sixProdId;

    private String saleStatus;

    private Byte isSync;
    
    private String tableSuffix;

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
        this.tableSuffix = channelCode == null ? null : channelCode.trim().toLowerCase();
    }

    public String getSixProdId() {
        return sixProdId;
    }

    public void setSixProdId(String sixProdId) {
        this.sixProdId = sixProdId == null ? null : sixProdId.trim();
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus == null ? null : saleStatus.trim();
    }

    public Byte getIsSync() {
        return isSync;
    }

    public void setIsSync(Byte isSync) {
        this.isSync = isSync;
    }
    
    public String getTableSuffix() {
        return tableSuffix;
    }
}