package com.metersbonwe.stock.pojo;

import java.util.List;

public class StockShopOnlineBean {
    private List<String> prodIds;

    private List<String> warehShopIds;

    private List<String> tableSeqs;

    public List<String> getTableSeqs() {
        return tableSeqs;
    }

    public void setTableSeqs(List<String> tableSeqs) {
        this.tableSeqs = tableSeqs;
    }

    public List<String> getProdIds() {
        return prodIds;
    }

    public void setProdIds(List<String> prodIds) {
        this.prodIds = prodIds;
    }

    public List<String> getWarehShopIds() {
        return warehShopIds;
    }

    public void setWarehShopIds(List<String> warehShopIds) {
        this.warehShopIds = warehShopIds;
    }
}
