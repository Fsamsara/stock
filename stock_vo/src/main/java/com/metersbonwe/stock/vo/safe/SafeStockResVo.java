package com.metersbonwe.stock.vo.safe;

import java.util.List;

public class SafeStockResVo {
    private boolean           sucessed;

    private String            msg;

    private List<SafeStockVo> safeStockVoList;

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

    public List<SafeStockVo> getSafeStockVoList() {
        return safeStockVoList;
    }

    public void setSafeStockVoList(List<SafeStockVo> safeStockVoList) {
        this.safeStockVoList = safeStockVoList;
    }

}
