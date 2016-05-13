package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.Date;

public class StockChannelStatusBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String channelCode;

	private String sixProdId;

	private String saleStatus;

	private Byte isSync;

	private Date updateTime;

	private String updateBy;

	private Date createTime;

	private String createBy;

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode == null ? null : channelCode.trim();
	}

	public String getSixProdId() {
		return sixProdId;
	}

	public void setSixProdId(String sixProdId) {
		this.sixProdId = sixProdId == null ? null : sixProdId.trim();
	}

	public String getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus == null ? null : saleStatus.trim();
	}

	public Byte getIsSync() {
		return isSync;
	}

	public void setIsSync(Byte isSync) {
		this.isSync = isSync;
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
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	@Override
	public String toString() {
		return "StockChannelStatusBean [channelCode=" + channelCode
				+ ", sixProdId=" + sixProdId + ", saleStatus=" + saleStatus
				+ ", isSync=" + isSync + ", updateTime=" + updateTime
				+ ", updateBy=" + updateBy + ", createTime=" + createTime
				+ ", createBy=" + createBy + "]";
	}

}