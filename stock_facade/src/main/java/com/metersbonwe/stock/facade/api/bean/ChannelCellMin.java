package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.Date;

public class ChannelCellMin implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String channelCode;

    private String prodId;

    private Integer channelCellMin;

    private Date updateTime;

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public Integer getChannelCellMin() {
        return channelCellMin;
    }

    public void setChannelCellMin(Integer channelCellMin) {
        this.channelCellMin = channelCellMin;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "ChannelCellMin [channelCode=" + channelCode + ", prodId="
				+ prodId + ", channelCellMin=" + channelCellMin
				+ ", updateTime=" + updateTime + "]";
	}
   
}