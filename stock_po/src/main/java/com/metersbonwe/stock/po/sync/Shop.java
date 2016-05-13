package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class Shop {
    private String shopId;

    private String shopType;

    private String manId;

    private Date openDate;

    private Date closeDate;

    private BigDecimal acreage;

    private Date settleDate;

    private BigDecimal rentRate;

    private String joinFlag;

    private String accountGroup;

    private String companyCode;

    private String profitCenter;

    private String shopSaleCls;

    private String smsMarketCode;

    private String curStockType;

    private String consignType;

    private String consignWarehid;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType == null ? null : shopType.trim();
    }

    public String getManId() {
        return manId;
    }

    public void setManId(String manId) {
        this.manId = manId == null ? null : manId.trim();
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public void setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
    }

    public Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    public BigDecimal getRentRate() {
        return rentRate;
    }

    public void setRentRate(BigDecimal rentRate) {
        this.rentRate = rentRate;
    }

    public String getJoinFlag() {
        return joinFlag;
    }

    public void setJoinFlag(String joinFlag) {
        this.joinFlag = joinFlag == null ? null : joinFlag.trim();
    }

    public String getAccountGroup() {
        return accountGroup;
    }

    public void setAccountGroup(String accountGroup) {
        this.accountGroup = accountGroup == null ? null : accountGroup.trim();
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public String getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(String profitCenter) {
        this.profitCenter = profitCenter == null ? null : profitCenter.trim();
    }

    public String getShopSaleCls() {
        return shopSaleCls;
    }

    public void setShopSaleCls(String shopSaleCls) {
        this.shopSaleCls = shopSaleCls == null ? null : shopSaleCls.trim();
    }

    public String getSmsMarketCode() {
        return smsMarketCode;
    }

    public void setSmsMarketCode(String smsMarketCode) {
        this.smsMarketCode = smsMarketCode == null ? null : smsMarketCode.trim();
    }

    public String getCurStockType() {
        return curStockType;
    }

    public void setCurStockType(String curStockType) {
        this.curStockType = curStockType == null ? null : curStockType.trim();
    }

    public String getConsignType() {
        return consignType;
    }

    public void setConsignType(String consignType) {
        this.consignType = consignType == null ? null : consignType.trim();
    }

    public String getConsignWarehid() {
        return consignWarehid;
    }

    public void setConsignWarehid(String consignWarehid) {
        this.consignWarehid = consignWarehid == null ? null : consignWarehid.trim();
    }
}