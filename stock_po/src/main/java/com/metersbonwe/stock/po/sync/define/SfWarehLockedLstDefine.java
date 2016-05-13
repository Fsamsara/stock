package com.metersbonwe.stock.po.sync.define;

import com.metersbonwe.stock.po.sync.SfWarehLockedLst;

public class SfWarehLockedLstDefine extends SfWarehLockedLst {
    private String warehId;
    private String prodNum;

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId;
    }

    public String getProdNum() {
        return prodNum;
    }

    public void setProdNum(String prodNum) {
        this.prodNum = prodNum;
    }
    
}
