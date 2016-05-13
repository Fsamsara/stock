package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.List;

public class ShopQueryLocStockRes implements Serializable {

    /**
     * 
     */
    private static final long       serialVersionUID = -7206593351540314853L;

    private boolean                 sucessed;

    private String                  msg;

    private List<ShopQueryLocStock> shopQueryLocStockList;

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

    public List<ShopQueryLocStock> getShopQueryLocStockList() {
        return shopQueryLocStockList;
    }

    public void setShopQueryLocStockList(List<ShopQueryLocStock> shopQueryLocStockList) {
        this.shopQueryLocStockList = shopQueryLocStockList;
    }

}
