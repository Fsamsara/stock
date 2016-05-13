package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.Date;

public class TmpShopSafeStock {
	private BigDecimal id;

	private String warehId;

	private String prodId;

	private BigDecimal shopSafeStock;

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

	public BigDecimal getShopSafeStock() {
		return shopSafeStock;
	}

	public void setShopSafeStock(BigDecimal shopSafeStock) {
		this.shopSafeStock = shopSafeStock;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "TmpShopSafeStock [id=" + id + ", warehId=" + warehId
				+ ", prodId=" + prodId + ", shopSafeStock=" + shopSafeStock
				+ ", updateTime=" + updateTime + "]";
	}

}