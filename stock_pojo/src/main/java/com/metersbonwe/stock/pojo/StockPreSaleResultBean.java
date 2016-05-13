package com.metersbonwe.stock.pojo;

import com.metersbonwe.stock.po.core.StockPreSale;

public class StockPreSaleResultBean {

    private boolean      sucess;

    private String       msg;

    private StockPreSale masterBean;

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public StockPreSale getMasterBean() {
        return masterBean;
    }

    public void setMasterBean(StockPreSale masterBean) {
        this.masterBean = masterBean;
    }

}
