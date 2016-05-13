package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.Date;

public class RemailedStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String warehId;

	private Date remailDate;

	private Date updateTime;

	public String getWarehId() {
		return warehId;
	}

	public void setWarehId(String warehId) {
		this.warehId = warehId == null ? null : warehId.trim();
	}

	public Date getRemailDate() {
		return remailDate;
	}

	public void setRemailDate(Date remailDate) {
		this.remailDate = remailDate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "RemailedStock [warehId=" + warehId + ", remailDate="
				+ remailDate + ", updateTime=" + updateTime + "]";
	}

}