package com.metersbonwe.stock.vo.free;

import java.util.List;

public class QryFreeShareStockReqVo {
    private String       warehId;

    private List<String> skuList;

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId;
    }

    public List<String> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<String> skuList) {
        this.skuList = skuList;
    }

}
