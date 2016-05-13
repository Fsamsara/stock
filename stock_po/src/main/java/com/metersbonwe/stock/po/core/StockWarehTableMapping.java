package com.metersbonwe.stock.po.core;

public class StockWarehTableMapping {
    private String warehId;

    private Integer warehDataCnt;

    private Integer hash;

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId == null ? null : warehId.trim();
    }

    public Integer getWarehDataCnt() {
        return warehDataCnt;
    }

    public void setWarehDataCnt(Integer warehDataCnt) {
        this.warehDataCnt = warehDataCnt;
    }

    public Integer getHash() {
        return hash;
    }

    public void setHash(Integer hash) {
        this.hash = hash;
    }
}