package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class TmpRemailedStock {
    private BigDecimal id;

    private String warehId;

    private Date remailDate;

    private Date updateTime;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId == null ? null : warehId.trim();
    }

    public Date getRemailDate() {
        return remailDate;
    }

    public void setRemailDate(Date remailDate) {
        this.remailDate = remailDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}