package com.metersbonwe.stock.po.core;

import java.util.Date;

public class StockPreSaleReserved {
    private Integer id;

    private Long relationId;

    private Short optionType;

    private Date createTime;

    private String remark;

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

    public Short getOptionType() {
        return optionType;
    }

    public void setOptionType(Short optionType) {
        this.optionType = optionType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}