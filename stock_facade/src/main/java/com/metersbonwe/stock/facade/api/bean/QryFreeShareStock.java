package com.metersbonwe.stock.facade.api.bean;

public class QryFreeShareStock implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -7979710045337794694L;

    private String            warehId;

    private String            prodId;

    private Integer           freeShareStock;

    private Integer           finalFreeShareStock;

    private Integer           wmsStock;

    private Integer           onlineSafeStock;

    public String getWarehId() {
        return warehId;
    }

    public void setWarehId(String warehId) {
        this.warehId = warehId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public Integer getFreeShareStock() {
        return freeShareStock;
    }

    public void setFreeShareStock(Integer freeShareStock) {
        this.freeShareStock = freeShareStock;
    }

    public Integer getFinalFreeShareStock() {
        return finalFreeShareStock;
    }

    public void setFinalFreeShareStock(Integer finalFreeShareStock) {
        this.finalFreeShareStock = finalFreeShareStock;
    }

    public Integer getWmsStock() {
        return wmsStock;
    }

    public void setWmsStock(Integer wmsStock) {
        this.wmsStock = wmsStock;
    }

    public Integer getOnlineSafeStock() {
        return onlineSafeStock;
    }

    public void setOnlineSafeStock(Integer onlineSafeStock) {
        this.onlineSafeStock = onlineSafeStock;
    }

}
