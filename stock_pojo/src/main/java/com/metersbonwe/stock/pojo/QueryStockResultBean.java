package com.metersbonwe.stock.pojo;

import java.math.BigDecimal;

public class QueryStockResultBean {
    private String prodId;           //商品编码
    private String warehShopType;    //组织类型
    private String warehShopId;      //仓库编码/门店编码
    private BigDecimal usefulStock;  //可用库存
    private BigDecimal stkOnHand;    //实物库存
    public String getProdId() {
        return prodId;
    }
    public void setProdId(String prodId) {
        this.prodId = prodId;
    }
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
    public BigDecimal getUsefulStock() {
        return usefulStock;
    }
    public void setUsefulStock(BigDecimal usefulStock) {
        this.usefulStock = usefulStock;
    }
    public BigDecimal getStkOnHand() {
        return stkOnHand;
    }
    public void setStkOnHand(BigDecimal stkOnHand) {
        this.stkOnHand = stkOnHand;
    }
    
}
