package com.metersbonwe.stock.pojo.imexcel;

public class QryWarehFreeShareStockExcelBean {

    @Header(value = "仓库编码", order = 1) private String      warehId;

    @Header(value = "商品编码", order = 2) private String      prodId;

    @Header(value = "自由量", order = 3) private Integer      finalFreeShareStock;

    @Header(value = "实际库存量", order = 4) private Integer    stkOnHand;

    @Header(value = "已分配量", order = 5) private Integer     qtyCommitted;

    @Header(value = "线上安全库存", order = 6) private Integer   onlineSafeStock;

    @Header(value = "锁定共享量", order = 7) private Integer    lockStock;

    @Header(value = "WMS正数锁定量", order = 8) private Integer wmsStock;

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

    public Integer getFinalFreeShareStock() {
        return finalFreeShareStock;
    }

    public void setFinalFreeShareStock(Integer finalFreeShareStock) {
        this.finalFreeShareStock = finalFreeShareStock;
    }

    public Integer getStkOnHand() {
        return stkOnHand;
    }

    public void setStkOnHand(Integer stkOnHand) {
        this.stkOnHand = stkOnHand;
    }

    public Integer getQtyCommitted() {
        return qtyCommitted;
    }

    public void setQtyCommitted(Integer qtyCommitted) {
        this.qtyCommitted = qtyCommitted;
    }

    public Integer getOnlineSafeStock() {
        return onlineSafeStock;
    }

    public void setOnlineSafeStock(Integer onlineSafeStock) {
        this.onlineSafeStock = onlineSafeStock;
    }

    public Integer getLockStock() {
        return lockStock;
    }

    public void setLockStock(Integer lockStock) {
        this.lockStock = lockStock;
    }

    public Integer getWmsStock() {
        return wmsStock;
    }

    public void setWmsStock(Integer wmsStock) {
        this.wmsStock = wmsStock;
    }

}
