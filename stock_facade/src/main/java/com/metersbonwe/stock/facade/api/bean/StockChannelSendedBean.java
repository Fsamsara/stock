package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.Date;

public class StockChannelSendedBean implements Serializable {

    /**
     * TODO
     */
    private static final long serialVersionUID = 1L;

    private String            prodId;

    private String            channelCode;

    private Date              accTime;

    private String            status;

    private String            errorDetail;

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getAccTime() {
        return accTime;
    }

    public void setAccTime(Date accTime) {
        this.accTime = accTime;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    @Override
    public String toString() {
        return "StockChannelSended [prodId=" + prodId + ", channelCode=" + channelCode + ", accTime=" + accTime + ", status=" + status
                + ", errorDetail=" + errorDetail + "]";
    }

}
