package com.metersbonwe.stock.facade.api.bean;

import java.util.List;

public class QryReservedStockReq implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -4850181270336743200L;

    private List<String>      channelCodeList;                         //渠道编码集合

    private List<String>      reservedTypeList;                        //预留类型集合

    private List<String>      warehList;                               //仓库编码集合

    private List<String>      skuList;                                 //商品编码集合

    public List<String> getChannelCodeList() {
        return channelCodeList;
    }

    public void setChannelCodeList(List<String> channelCodeList) {
        this.channelCodeList = channelCodeList;
    }

    public List<String> getReservedTypeList() {
        return reservedTypeList;
    }

    public void setReservedTypeList(List<String> reservedTypeList) {
        this.reservedTypeList = reservedTypeList;
    }

    public List<String> getWarehList() {
        return warehList;
    }

    public void setWarehList(List<String> warehList) {
        this.warehList = warehList;
    }

    public List<String> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<String> skuList) {
        this.skuList = skuList;
    }

    @Override
    public String toString() {
        return "QryReservedStockReq [channelCodeList=" + channelCodeList + ", reservedTypeList=" + reservedTypeList + ", warehList=" + warehList
                + ", skuList=" + skuList + "]";
    }

}
