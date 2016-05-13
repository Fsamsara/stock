package com.metersbonwe.stock.pojo.imexcel;

public class SafeStockExcelBean {

    @Header(value = "仓库编码", order = 1) private String   warehId;

    @Header(value = "商品编码", order = 2) private String   prodId;

    @Header(value = "安全库存值", order = 3) private Integer safeStock;

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

    public Integer getSafeStock() {
        return safeStock;
    }

    public void setSafeStock(Integer safeStock) {
        this.safeStock = safeStock;
    }

}
