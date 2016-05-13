package com.metersbonwe.stock.facade.api.bean;

import java.util.List;

public class ShopQueryLocStockReq extends ShopQueryStockReq {

    /**
     * 
     */
    private static final long serialVersionUID = 7819841047361413862L;

    private List<String>      locList;                                //货位编码集合

    public List<String> getLocList() {
        return locList;
    }

    public void setLocList(List<String> locList) {
        this.locList = locList;
    }

    @Override
    public String toString() {
        return "ShopQueryLocStockReq [locList=" + locList + ", toString()=" + super.toString() + "]";
    }

}
