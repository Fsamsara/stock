package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.Date;

public class WmsProperty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String warehId;

	private String usedMa;

	private Date updateTime;

	public String getWarehId() {
		return warehId;
	}

	public void setWarehId(String warehId) {
		this.warehId = warehId == null ? null : warehId.trim();
	}

	public String getUsedMa() {
		return usedMa;
	}

	public void setUsedMa(String usedMa) {
		this.usedMa = usedMa;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "WmsProperty [warehId=" + warehId + ", usedMa=" + usedMa
				+ ", updateTime=" + updateTime + "]";
	}

}