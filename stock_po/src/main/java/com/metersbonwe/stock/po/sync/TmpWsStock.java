package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class TmpWsStock {
	private BigDecimal id;

	private String warehId;

	private BigDecimal wsStock;

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

	public BigDecimal getWsStock() {
		return wsStock;
	}

	public void setWsStock(BigDecimal wsStock) {
		this.wsStock = wsStock;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "TmpWsStock [id=" + id + ", warehId=" + warehId + ", wsStock="
				+ wsStock + ", updateTime=" + updateTime + "]";
	}

}