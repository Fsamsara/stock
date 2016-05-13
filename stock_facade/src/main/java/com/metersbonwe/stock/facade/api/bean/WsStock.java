package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.Date;

public class WsStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String warehId;

	private Integer wsStock;

	private Date updateTime;

	public String getWarehId() {
		return warehId;
	}

	public void setWarehId(String warehId) {
		this.warehId = warehId == null ? null : warehId.trim();
	}

	public Integer getWsStock() {
		return wsStock;
	}

	public void setWsStock(Integer wsStock) {
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
		return "WsStock [warehId=" + warehId + ", wsStock=" + wsStock
				+ ", updateTime=" + updateTime + "]";
	}

}