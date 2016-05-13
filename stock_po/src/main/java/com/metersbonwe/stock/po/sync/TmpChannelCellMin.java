package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class TmpChannelCellMin {
	private BigDecimal id;

	private String channelCode;

	private String prodId;

	private BigDecimal channelCellMin;

	private Date updateTime;

	private String tableSuffix;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode == null ? null : channelCode.trim();
		this.tableSuffix = channelCode == null ? null : channelCode.trim()
				.toLowerCase();
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId == null ? null : prodId.trim();
	}

	public BigDecimal getChannelCellMin() {
		return channelCellMin;
	}

	public void setChannelCellMin(BigDecimal channelCellMin) {
		this.channelCellMin = channelCellMin;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getTableSuffix() {
		return tableSuffix;
	}

	@Override
	public String toString() {
		return "TmpChannelCellMin [id=" + id + ", channelCode=" + channelCode
				+ ", prodId=" + prodId + ", channelCellMin=" + channelCellMin
				+ ", updateTime=" + updateTime + ", tableSuffix=" + tableSuffix
				+ "]";
	}

}