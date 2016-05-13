package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.List;

public class QryReservedStockRes implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7075120098232914843L;
    private boolean sucessed;
    private String msg;
    private List<QryReservedStock> qryReservedStockList;
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
    public List<QryReservedStock> getQryReservedStockList() {
        return qryReservedStockList;
    }
    public void setQryReservedStockList(List<QryReservedStock> qryReservedStockList) {
        this.qryReservedStockList = qryReservedStockList;
    }
    
}
