package com.metersbonwe.stock.facade.api.bean;

import java.util.List;

public class QryProdSumStockRes implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2348672090528193735L;
    private boolean sucessed;
    private String msg;
    private List<QryStock> qryStockList;
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
    public List<QryStock> getQryStockList() {
        return qryStockList;
    }
    public void setQryStockList(List<QryStock> qryStockList) {
        this.qryStockList = qryStockList;
    }
    @Override
    public String toString() {
        return "QryProdSumStockRes [sucessed=" + sucessed + ", msg=" + msg
                + ", qryStockList=" + qryStockList + "]";
    }
    
    
}
