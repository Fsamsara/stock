package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.Date;

public class DameStock implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String warehId;

	private String prodId;

	private Integer dameStock;

	private Date updateTime;

	private String updateBy;
	
	private Date createTime;

    private String createBy;
    
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

	public Integer getDameStock() {
		return dameStock;
	}

	public void setDameStock(Integer dameStock) {
		this.dameStock = dameStock;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	
	public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
	public String toString() {
		return "DameStock [warehId=" + warehId + ", prodId=" + prodId
				+ ", dameStock=" + dameStock + ", updateTime=" + updateTime
				+ ", updateBy=" + updateBy + ", createTime=" + createTime
				+ ", createBy=" + createBy
				+ "]";
	}

}