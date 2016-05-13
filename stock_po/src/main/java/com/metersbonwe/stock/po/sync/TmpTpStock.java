package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class TmpTpStock {
	private BigDecimal id;

	private String warehId;

	private String prodId;

	private BigDecimal tpStock;

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

	public BigDecimal getTpStock() {
		return tpStock;
	}

	public void setTpStock(BigDecimal tpStock) {
		this.tpStock = tpStock;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "TmpTpStock [id=" + id + ", warehId=" + warehId + ", prodId="
				+ prodId + ", tpStock=" + tpStock + ", updateTime="
				+ updateTime + "]";
	}

}