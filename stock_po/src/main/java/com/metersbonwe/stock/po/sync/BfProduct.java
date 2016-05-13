package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;

public class BfProduct {
    private BigDecimal id;

    private BigDecimal bfProdClsId;

    private BigDecimal bfProdColorId;

    private BigDecimal bfProdEdtnId;

    private BigDecimal bfProdSpecId;

    private String prodNum;

    private String additDesc;

    private String innerBc;

    private String intnlBc;

    private String prodStatus;

    private String cancelReason;

    private String prodGrid;

    private String remark;

    private String isTransB2c;

    private String calcMargin;

    private String isSapManage;

    private String isSample;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getBfProdClsId() {
        return bfProdClsId;
    }

    public void setBfProdClsId(BigDecimal bfProdClsId) {
        this.bfProdClsId = bfProdClsId;
    }

    public BigDecimal getBfProdColorId() {
        return bfProdColorId;
    }

    public void setBfProdColorId(BigDecimal bfProdColorId) {
        this.bfProdColorId = bfProdColorId;
    }

    public BigDecimal getBfProdEdtnId() {
        return bfProdEdtnId;
    }

    public void setBfProdEdtnId(BigDecimal bfProdEdtnId) {
        this.bfProdEdtnId = bfProdEdtnId;
    }

    public BigDecimal getBfProdSpecId() {
        return bfProdSpecId;
    }

    public void setBfProdSpecId(BigDecimal bfProdSpecId) {
        this.bfProdSpecId = bfProdSpecId;
    }

    public String getProdNum() {
        return prodNum;
    }

    public void setProdNum(String prodNum) {
        this.prodNum = prodNum == null ? null : prodNum.trim();
    }

    public String getAdditDesc() {
        return additDesc;
    }

    public void setAdditDesc(String additDesc) {
        this.additDesc = additDesc == null ? null : additDesc.trim();
    }

    public String getInnerBc() {
        return innerBc;
    }

    public void setInnerBc(String innerBc) {
        this.innerBc = innerBc == null ? null : innerBc.trim();
    }

    public String getIntnlBc() {
        return intnlBc;
    }

    public void setIntnlBc(String intnlBc) {
        this.intnlBc = intnlBc == null ? null : intnlBc.trim();
    }

    public String getProdStatus() {
        return prodStatus;
    }

    public void setProdStatus(String prodStatus) {
        this.prodStatus = prodStatus == null ? null : prodStatus.trim();
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
    }

    public String getProdGrid() {
        return prodGrid;
    }

    public void setProdGrid(String prodGrid) {
        this.prodGrid = prodGrid == null ? null : prodGrid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIsTransB2c() {
        return isTransB2c;
    }

    public void setIsTransB2c(String isTransB2c) {
        this.isTransB2c = isTransB2c == null ? null : isTransB2c.trim();
    }

    public String getCalcMargin() {
        return calcMargin;
    }

    public void setCalcMargin(String calcMargin) {
        this.calcMargin = calcMargin == null ? null : calcMargin.trim();
    }

    public String getIsSapManage() {
        return isSapManage;
    }

    public void setIsSapManage(String isSapManage) {
        this.isSapManage = isSapManage == null ? null : isSapManage.trim();
    }

    public String getIsSample() {
        return isSample;
    }

    public void setIsSample(String isSample) {
        this.isSample = isSample == null ? null : isSample.trim();
    }
}