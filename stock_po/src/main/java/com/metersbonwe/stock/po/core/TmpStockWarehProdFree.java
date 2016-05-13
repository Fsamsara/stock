package com.metersbonwe.stock.po.core;

import java.util.Date;

public class TmpStockWarehProdFree {
    private String warehId;

    private String prodId;

    private Integer stkOnHand;

    private Integer qtyCommitted;

    private Integer freeShareStock;

    private String safeType;

    private Integer safeStock;
    
    private String usedMa;

    private Integer wmsStock;

    private Integer remailStock;

    private Integer dameStock;

    private Integer isShop;

    private Date updateTime;

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId == null ? null : warehId.trim();
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
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

    public String getSafeType() {
        return safeType;
    }

    public void setSafeType(String safeType) {
        this.safeType = safeType == null ? null : safeType.trim();
    }

    public Integer getSafeStock() {
        return safeStock;
    }

    public void setSafeStock(Integer safeStock) {
        this.safeStock = safeStock;
    }

    public Integer getWmsStock() {
        return wmsStock;
    }

    public void setWmsStock(Integer wmsStock) {
        this.wmsStock = wmsStock;
    }

    public Integer getRemailStock() {
        return remailStock;
    }

    public void setRemailStock(Integer remailStock) {
        this.remailStock = remailStock;
    }

    public Integer getDameStock() {
        return dameStock;
    }

    public void setDameStock(Integer dameStock) {
        this.dameStock = dameStock;
    }

    public Integer getIsShop() {
        return isShop;
    }

    public void setIsShop(Integer isShop) {
        this.isShop = isShop;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public String getUsedMa() {
        return usedMa;
    }

    public void setUsedMa(String usedMa) {
        this.usedMa = usedMa;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}