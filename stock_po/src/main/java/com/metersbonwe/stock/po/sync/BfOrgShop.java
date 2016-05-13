package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class BfOrgShop {
    private BigDecimal bfOrgId;

    private String shopType;

    private String manCode;

    private Date openDate;

    private Date closeDate;

    private BigDecimal acreage;

    private Date settleDate;

    private BigDecimal rentRate;

    private String companyCode;

    private String profitCenter;

    private String accountGroup;

    private BigDecimal sapId;

    private Date lastModifiedDate;

    private BigDecimal ownerId;

    private BigDecimal defaultWarehId;

    private String storeScope;

    private String customerLevel;

    private String offlineship;

    private String offlincac;

    private String offlineOrderShip;

    private String isSynctoos;

    public BigDecimal getBfOrgId() {
        return bfOrgId;
    }

    public void setBfOrgId(BigDecimal bfOrgId) {
        this.bfOrgId = bfOrgId;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType == null ? null : shopType.trim();
    }

    public String getManCode() {
        return manCode;
    }

    public void setManCode(String manCode) {
        this.manCode = manCode == null ? null : manCode.trim();
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

    public String getAccountGroup() {
        return accountGroup;
    }

    public void setAccountGroup(String accountGroup) {
        this.accountGroup = accountGroup == null ? null : accountGroup.trim();
    }

    public BigDecimal getSapId() {
        return sapId;
    }

    public void setSapId(BigDecimal sapId) {
        this.sapId = sapId;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public BigDecimal getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(BigDecimal ownerId) {
        this.ownerId = ownerId;
    }

    public BigDecimal getDefaultWarehId() {
        return defaultWarehId;
    }

    public void setDefaultWarehId(BigDecimal defaultWarehId) {
        this.defaultWarehId = defaultWarehId;
    }

    public String getStoreScope() {
        return storeScope;
    }

    public void setStoreScope(String storeScope) {
        this.storeScope = storeScope == null ? null : storeScope.trim();
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel == null ? null : customerLevel.trim();
    }

    public String getOfflineship() {
        return offlineship;
    }

    public void setOfflineship(String offlineship) {
        this.offlineship = offlineship == null ? null : offlineship.trim();
    }

    public String getOfflincac() {
        return offlincac;
    }

    public void setOfflincac(String offlincac) {
        this.offlincac = offlincac == null ? null : offlincac.trim();
    }

    public String getOfflineOrderShip() {
        return offlineOrderShip;
    }

    public void setOfflineOrderShip(String offlineOrderShip) {
        this.offlineOrderShip = offlineOrderShip == null ? null : offlineOrderShip.trim();
    }

    public String getIsSynctoos() {
        return isSynctoos;
    }

    public void setIsSynctoos(String isSynctoos) {
        this.isSynctoos = isSynctoos == null ? null : isSynctoos.trim();
    }
}