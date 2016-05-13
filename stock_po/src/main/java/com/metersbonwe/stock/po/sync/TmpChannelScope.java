package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class TmpChannelScope {
	private BigDecimal id;

	private String channelCode;

	private String warehId;

	private String scopeChange;

	private String warehState;

	private Date updateTime;

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
	}

	public String getWarehId() {
		return warehId;
	}

	public void setWarehId(String warehId) {
		this.warehId = warehId == null ? null : warehId.trim();
	}

	public String getScopeChange() {
		return scopeChange;
	}

	public void setScopeChange(String scopeChange) {
		this.scopeChange = scopeChange == null ? null : scopeChange.trim();
	}

	public String getWarehState() {
		return warehState;
	}

	public void setWarehState(String warehState) {
		this.warehState = warehState == null ? null : warehState.trim();
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "TmpChannelScope [id=" + id + ", channelCode=" + channelCode
				+ ", warehId=" + warehId + ", scopeChange=" + scopeChange
				+ ", warehState=" + warehState + ", updateTime=" + updateTime
				+ "]";
	}

}