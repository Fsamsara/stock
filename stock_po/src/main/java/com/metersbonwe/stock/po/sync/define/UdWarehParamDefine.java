package com.metersbonwe.stock.po.sync.define;

import com.metersbonwe.stock.po.sync.UdWarehParam;

public class UdWarehParamDefine extends UdWarehParam {
    private String code;

    private String name;
    
    private int shoped;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShoped() {
        return shoped;
    }

    public void setShoped(int shoped) {
        this.shoped = shoped;
    }

}
