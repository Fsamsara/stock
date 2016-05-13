package com.metersbonwe.stock.facade.api.bean;

import java.util.List;

public class QryFreeShareStockReq implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -7737315431225589577L;

    private String            channelSource;                           //渠道来源  线上/线下

    private List<String>      warehList;                               //仓库编码集合

    private List<String>      skuList;                                 //商品编码集合

    public String getChannelSource() {
        return channelSource;
    }

    public void setChannelSource(String channelSource) {
        this.channelSource = channelSource;
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

}
