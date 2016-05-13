package com.metersbonwe.stock.po.core;

import java.util.Date;

public class StockWarehProd {
    private Integer id;

    private String warehId;

    private String sixProdId;

    private String eightProdId;

    private String prodId;

    private Integer stkOnHand;

    private Integer qtyCommitted;

    private Integer freeShareStock;

    private Integer finalFreeShareStock;

    private Integer onlineSafeStock;

    private Integer shopRemail;

    private Integer shopDame;

    private Integer lockStock;

    private Integer wmsStock;

    private Byte isShop;

    private String tableNum;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId == null ? null : warehId.trim();
    }

    public String getSixProdId() {
        return sixProdId;
    }

    public void setSixProdId(String sixProdId) {
        this.sixProdId = sixProdId == null ? null : sixProdId.trim();
    }

    public String getEightProdId() {
        return eightProdId;
    }

    public void setEightProdId(String eightProdId) {
        this.eightProdId = eightProdId == null ? null : eightProdId.trim();
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

    public Byte getIsShop() {
        return isShop;
    }

    public void setIsShop(Byte isShop) {
        this.isShop = isShop;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTableNum() {
        return tableNum;
    }

    public void setTableNum(String tableNum) {
        this.tableNum = tableNum;
    }

    public Integer getQtyCommitted() {
        return qtyCommitted;
    }

    public void setQtyCommitted(Integer qtyCommitted) {
        this.qtyCommitted = qtyCommitted;
    }

}
