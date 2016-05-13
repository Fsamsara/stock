package com.metersbonwe.stock.facade.api.bean;

import java.math.BigDecimal;

public class QryUsefulStkStock extends QryStock {
    /**
     * 
     */
    private static final long serialVersionUID = 4323085779739464045L; 
    private String warehShopType;    //组织类型
    private String warehShopId;      //仓库编码/门店编码
    private BigDecimal stkOnHand;    //实物库存
    public String getWarehShopType() {
        return warehShopType;
    }
    public void setWarehShopType(String warehShopType) {
        this.warehShopType = warehShopType;
    }
    public String getWarehShopId() {
        return warehShopId;
    }
    public void setWarehShopId(String warehShopId) {
        this.warehShopId = warehShopId;
    }
    public BigDecimal getStkOnHand() {
        return stkOnHand;
    }
    public void setStkOnHand(BigDecimal stkOnHand) {
        this.stkOnHand = stkOnHand;
    }
    
}
