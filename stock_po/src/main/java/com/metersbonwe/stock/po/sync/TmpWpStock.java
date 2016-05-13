package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class TmpWpStock {
	private BigDecimal id;

	private String warehId;

	private String prodId;

	private BigDecimal wpStock;

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

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId == null ? null : prodId.trim();
	}

	public BigDecimal getWpStock() {
		return wpStock;
	}

	public void setWpStock(BigDecimal wpStock) {
		this.wpStock = wpStock;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "TmpWpStock [id=" + id + ", warehId=" + warehId + ", prodId="
				+ prodId + ", wpStock=" + wpStock + ", updateTime="
				+ updateTime + "]";
	}

}