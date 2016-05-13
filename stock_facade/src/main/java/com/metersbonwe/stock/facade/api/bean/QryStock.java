package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class QryStock implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1462348434678673226L;
    private String prodId;           //商品编码
    private BigDecimal usefulStock;  //可用库存
    public String getProdId() {
        return prodId;
    }
    public void setProdId(String prodId) {
        this.prodId = prodId;
    }
    public BigDecimal getUsefulStock() {
        return usefulStock;
    }
    public void setUsefulStock(BigDecimal usefulStock) {
        this.usefulStock = usefulStock;
    }

}
