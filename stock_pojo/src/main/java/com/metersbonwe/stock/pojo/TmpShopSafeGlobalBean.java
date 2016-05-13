package com.metersbonwe.stock.pojo;

public class TmpShopSafeGlobalBean {
    private Integer maxDataCount;

    private Integer startId;

    public TmpShopSafeGlobalBean() {
        setMaxDataCount(100);
    }

    public Integer getMaxDataCount() {
        return maxDataCount;
    }

    public void setMaxDataCount(Integer maxDataCount) {
        this.maxDataCount = maxDataCount;
    }

    public Integer getStartId() {
        return startId;
    }

    public void setStartId(Integer startId) {
        this.startId = startId;
    }

}
