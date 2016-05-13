package com.metersbonwe.stock.pojo;

import com.metersbonwe.stock.po.core.StockPreSaleModify;

public class StockPreSaleModifyResultBean {

    private boolean            sucess;

    private String             msg;

    private StockPreSaleModify masterBean;

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

    public StockPreSaleModify getMasterBean() {
        return masterBean;
    }

    public void setMasterBean(StockPreSaleModify masterBean) {
        this.masterBean = masterBean;
    }

}
