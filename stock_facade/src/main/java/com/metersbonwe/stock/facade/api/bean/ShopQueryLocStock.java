package com.metersbonwe.stock.facade.api.bean;

public class ShopQueryLocStock extends ShopQueryStock {
    /**
     * 
     */
    private static final long serialVersionUID = 5772824763243662781L;

    private String            locId;                                  //货位编码

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId;
    }

}
