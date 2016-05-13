package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.List;

public class QryUsefulStkStockRes implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -9187786403132321637L;
    private boolean sucessed;
    private String msg;
    private List<QryUsefulStkStock> qryUsefulStkStockList;
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
    public List<QryUsefulStkStock> getQryUsefulStkStockList() {
        return qryUsefulStkStockList;
    }
    public void setQryUsefulStkStockList(
            List<QryUsefulStkStock> qryUsefulStkStockList) {
        this.qryUsefulStkStockList = qryUsefulStkStockList;
    }
    
}
