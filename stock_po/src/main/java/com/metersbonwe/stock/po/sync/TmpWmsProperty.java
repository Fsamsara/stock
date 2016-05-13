package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class TmpWmsProperty {
	private BigDecimal id;

	private String warehId;

	private String usedMa;

	private Date updateTime;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

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
		this.usedMa = usedMa == null ? null : usedMa.trim();
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "TmpWmsProperty [id=" + id + ", warehId=" + warehId
				+ ", usedMa=" + usedMa + ", updateTime=" + updateTime + "]";
	}

}