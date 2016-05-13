package com.metersbonwe.stock.vo.free;

public class QryFreeShareStockVo {
    private String  warehId;

    private String  prodId;

    private Integer stkOnHand;

    private Integer qtyCommitted;

    private Integer freeShareStock;

    private Integer finalFreeShareStock;

    private Integer onlineSafeStock;

    private Integer lockStock;

    private Integer wmsStock;

    private Integer shopRemail;

    private Integer shopDame;

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

    public Integer getFreeShareStock() {
        return freeShareStock;
    }

    public void setFreeShareStock(Integer freeShareStock) {
        this.freeShareStock = freeShareStock;
    }

    public Integer getFinalFreeShareStock() {
        return finalFreeShareStock;
    }

    public void setFinalFreeShareStock(Integer finalFreeShareStock) {
        this.finalFreeShareStock = finalFreeShareStock;
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

    public Integer getShopRemail() {
        return shopRemail;
    }

    public void setShopRemail(Integer shopRemail) {
        this.shopRemail = shopRemail;
    }

    public Integer getShopDame() {
        return shopDame;
    }

    public void setShopDame(Integer shopDame) {
        this.shopDame = shopDame;
    }

}
