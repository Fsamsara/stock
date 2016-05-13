package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.List;

public class ShopQueryStockRes implements Serializable {

    /**
     * 
     */
    private static final long    serialVersionUID = -3007820638889486347L;

    private boolean              sucessed;

    private String               msg;

    private List<ShopQueryStock> shopQueryStockList;

    public boolean isSucessed() {
        return sucessed;
    }

    public void setSucessed(boolean sucessed) {
        this.sucessed = sucessed;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ShopQueryStock> getShopQueryStockList() {
        return shopQueryStockList;
    }

    public void setShopQueryStockList(List<ShopQueryStock> shopQueryStockList) {
        this.shopQueryStockList = shopQueryStockList;
    }

}
