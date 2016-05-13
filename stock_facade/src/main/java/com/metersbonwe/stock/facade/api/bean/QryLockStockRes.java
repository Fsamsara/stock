package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.List;

public class QryLockStockRes implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1863534580662669645L;
    private boolean sucessed;
    private String msg;
    private List<QryLockStock> qryLockStockList;
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
    public List<QryLockStock> getQryLockStockList() {
        return qryLockStockList;
    }
    public void setQryLockStockList(List<QryLockStock> qryLockStockList) {
        this.qryLockStockList = qryLockStockList;
    }

    
}
