package com.metersbonwe.stock.po.core;

import java.util.Date;

public class StockShopDameTran {
    private Integer id;

    private String warehId;

    private String prodId;

    private Integer cellDameStock;

    private String dameStockOrderType;

    private String updateBy;

    private Date updateTime;

    private String createBy;

    private Date createTime;

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

    public Integer getCellDameStock() {
        return cellDameStock;
    }

    public void setCellDameStock(Integer cellDameStock) {
        this.cellDameStock = cellDameStock;
    }

    public String getDameStockOrderType() {
        return dameStockOrderType;
    }

    public void setDameStockOrderType(String dameStockOrderType) {
        this.dameStockOrderType = dameStockOrderType == null ? null : dameStockOrderType.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}