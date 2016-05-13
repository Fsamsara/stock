package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.Date;

public class RemailStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String warehId;

	private String prodId;
	
	private String locId;

	private Integer remailStock;

	private Date updateTime;

	private String rllNum;
	
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

	public Integer getRemailStock() {
		return remailStock;
	}

	public void setRemailStock(Integer remailStock) {
		this.remailStock = remailStock;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "RemailStock [warehId=" + warehId + ", prodId=" + prodId
				+ ", remailStock=" + remailStock + ", updateTime=" + updateTime
				+ ", rllNum=" + rllNum
				+ "]";
	}

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId;
    }

    public String getRllNum() {
        return rllNum;
    }

    public void setRllNum(String rllNum) {
        this.rllNum = rllNum;
    }

}