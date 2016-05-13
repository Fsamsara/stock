package com.metersbonwe.stock.vo.free;

import java.util.List;

public class QryFreeShareStockResVo {
    private boolean                   sucessed;

    private String                    msg;

    private List<QryFreeShareStockVo> qryFreeShareStockVoList;

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

    public List<QryFreeShareStockVo> getQryFreeShareStockVoList() {
        return qryFreeShareStockVoList;
    }

    public void setQryFreeShareStockVoList(List<QryFreeShareStockVo> qryFreeShareStockVoList) {
        this.qryFreeShareStockVoList = qryFreeShareStockVoList;
    }

}
