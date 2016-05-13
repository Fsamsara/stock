package com.metersbonwe.stock.po.core;

import java.util.Date;

public class TmpStockWarehProd {
    private Integer id;

    private String warehId;

    private String prodId;

    private Integer stkOnHand;

    private Integer qtyCommitted;

    private Integer freeShareStock;

    private Integer lockStock;

    private Integer safeStock;

    private Integer isShop;

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

    public Integer getLockStock() {
        return lockStock;
    }

    public void setLockStock(Integer lockStock) {
        this.lockStock = lockStock;
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

    public Integer getSafeStock() {
        return safeStock;
    }

    public void setSafeStock(Integer safeStock) {
        this.safeStock = safeStock;
    }

    public Integer getIsShop() {
        return isShop;
    }

    public void setIsShop(Integer isShop) {
        this.isShop = isShop;
    }
}
