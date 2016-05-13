package com.metersbonwe.stock.facade.api.bean;

import java.util.List;

public class QryFreeShareStockRes implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1795119812726734986L;
    private boolean sucessed;
    private String msg;
    private List<QryFreeShareStock> qryFreeShareStockList;
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
    public List<QryFreeShareStock> getQryFreeShareStockList() {
        return qryFreeShareStockList;
    }
    public void setQryFreeShareStockList(
            List<QryFreeShareStock> qryFreeShareStockList) {
        this.qryFreeShareStockList = qryFreeShareStockList;
    }
    
}
