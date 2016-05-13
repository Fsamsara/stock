package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.Date;

public class ShopSafeStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String warehId;

	private String prodId;

	private Integer shopSafeStock;

	private Date updateTime;

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

	public Integer getShopSafeStock() {
		return shopSafeStock;
	}

	public void setShopSafeStock(Integer shopSafeStock) {
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
		return "ShopSafeStock [warehId=" + warehId + ", prodId=" + prodId
				+ ", shopSafeStock=" + shopSafeStock + ", updateTime="
				+ updateTime + "]";
	}

}