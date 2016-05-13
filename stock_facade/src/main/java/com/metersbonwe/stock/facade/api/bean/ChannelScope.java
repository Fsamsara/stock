package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.Date;

public class ChannelScope implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String channelCode;

	private String warehId;

	private String scopeChange;

	private String warehState;

	private Date updateTime;

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
		this.scopeChange = scopeChange;
	}

	public String getWarehState() {
		return warehState;
	}

	public void setWarehState(String warehState) {
		this.warehState = warehState;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "ChannelScope [channelCode=" + channelCode + ", warehId="
				+ warehId + ", scopeChange=" + scopeChange + ", warehState="
				+ warehState + ", updateTime=" + updateTime + "]";
	}

}