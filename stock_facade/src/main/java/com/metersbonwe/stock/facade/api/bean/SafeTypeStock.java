package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.Date;

public class SafeTypeStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String warehId;

	private String safeType;

	private Date updateTime;

	public String getWarehId() {
		return warehId;
	}

	public void setWarehId(String warehId) {
		this.warehId = warehId == null ? null : warehId.trim();
	}

	public String getSafeType() {
		return safeType;
	}

	public void setSafeType(String safeType) {
		this.safeType = safeType == null ? null : safeType.trim();
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "SafeTypeStock [warehId=" + warehId + ", safeType=" + safeType
				+ ", updateTime=" + updateTime + "]";
	}

}