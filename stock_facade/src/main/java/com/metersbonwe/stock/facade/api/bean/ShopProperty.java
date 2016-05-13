package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;

public class ShopProperty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String warehId;

	private String warehState;

	public String getWarehId() {
		return warehId;
	}

	public void setWarehId(String warehId) {
		this.warehId = warehId == null ? null : warehId.trim();
	}

	public String getWarehState() {
		return warehState;
	}

	public void setWarehState(String warehState) {
		this.warehState = warehState;
	}

	@Override
	public String toString() {
		return "ShopProperty [warehId=" + warehId + ", warehState="
				+ warehState + "]";
	}

}