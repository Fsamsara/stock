package com.metersbonwe.stock.po.wms;

import java.math.BigDecimal;

/**
 * WMS正数锁定量
 * @author zhangjf
 */
public class WmsStockProdQty {

    private String warehId;

    private String prodId;

    private BigDecimal totalQty;

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public BigDecimal getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(BigDecimal totalQty) {
        this.totalQty = totalQty;
    }
    
    
}
