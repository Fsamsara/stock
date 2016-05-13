package com.metersbonwe.stock.vo.presale;

import java.util.Date;

public class StockPreSaleModifyDetailVo {

    private Integer id;

    private Long    relationId;

    private String  warehId;

    private String  prodId;

    private Integer prePrivateStock;

    private Integer prePrivateStockModify;

    private Date    startTime;

    private Date    endTime;

    private Date    endTimeModify;

    private String  modifyType;

    private Date    updateTime;

    private String  updateBy;

    private Integer reservedStatus;

    private String  reservedRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

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

    public Integer getPrePrivateStock() {
        return prePrivateStock;
    }

    public void setPrePrivateStock(Integer prePrivateStock) {
        this.prePrivateStock = prePrivateStock;
    }

    public Integer getPrePrivateStockModify() {
        return prePrivateStockModify;
    }

    public void setPrePrivateStockModify(Integer prePrivateStockModify) {
        this.prePrivateStockModify = prePrivateStockModify;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTimeModify() {
        return endTimeModify;
    }

    public void setEndTimeModify(Date endTimeModify) {
        this.endTimeModify = endTimeModify;
    }

    public String getModifyType() {
        return modifyType;
    }

    public void setModifyType(String modifyType) {
        this.modifyType = modifyType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getReservedStatus() {
        return reservedStatus;
    }

    public void setReservedStatus(Integer reservedStatus) {
        this.reservedStatus = reservedStatus;
    }

    public String getReservedRemark() {
        return reservedRemark;
    }

    public void setReservedRemark(String reservedRemark) {
        this.reservedRemark = reservedRemark;
    }

}
