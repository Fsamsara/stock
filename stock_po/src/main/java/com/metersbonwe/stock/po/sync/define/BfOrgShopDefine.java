package com.metersbonwe.stock.po.sync.define;

import java.math.BigDecimal;

import com.metersbonwe.stock.po.sync.BfOrgShop;

public class BfOrgShopDefine extends BfOrgShop {

    private String code;

    private String name;

    private BigDecimal ownerId;

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

    public BigDecimal getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(BigDecimal ownerId) {
        this.ownerId = ownerId;
    }

}
