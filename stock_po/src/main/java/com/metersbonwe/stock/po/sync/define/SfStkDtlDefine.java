package com.metersbonwe.stock.po.sync.define;

import com.metersbonwe.stock.po.sync.SfStkDtl;

public class SfStkDtlDefine extends SfStkDtl {
    private String warehId;  //仓库编码
    private String locId;    //货位编码
    private String prodNum;  //商品编码
    public String getWarehId() {
        return warehId;
    }
    public void setWarehId(String warehId) {
        this.warehId = warehId;
    }
    public String getLocId() {
        return locId;
    }
    public void setLocId(String locId) {
        this.locId = locId;
    }
    public String getProdNum() {
        return prodNum;
    }
    public void setProdNum(String prodNum) {
        this.prodNum = prodNum;
    }
    
}
