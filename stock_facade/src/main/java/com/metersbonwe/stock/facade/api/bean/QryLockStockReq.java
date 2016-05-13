package com.metersbonwe.stock.facade.api.bean;

import java.util.List;

public class QryLockStockReq implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 2629699060072385669L;
    private List<String> reservedTypeList;    //预留类型集合
    private List<String> warehList;           //仓库编码集合
    private List<String> skuList;             //商品编码集合
    public List<String> getReservedTypeList() {
        return reservedTypeList;
    }
    public void setReservedTypeList(List<String> reservedTypeList) {
        this.reservedTypeList = reservedTypeList;
    }
    public List<String> getWarehList() {
        return warehList;
    }
    public void setWarehList(List<String> warehList) {
        this.warehList = warehList;
    }
    public List<String> getSkuList() {
        return skuList;
    }
    public void setSkuList(List<String> skuList) {
        this.skuList = skuList;
    }
    @Override
    public String toString() {
        return "QryLockStockReq [reservedTypeList=" + reservedTypeList
                + ", warehList=" + warehList + ", skuList=" + skuList + "]";
    }
    
}
