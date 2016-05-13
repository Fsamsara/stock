package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class TmpChannelMinmax {
	private BigDecimal id;

	private String channelCode;

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
		return "TmpChannelMinmax [id=" + id + ", channelCode=" + channelCode
				+ ", updateTime=" + updateTime + ", tableSuffix=" + tableSuffix
				+ "]";
	}

}