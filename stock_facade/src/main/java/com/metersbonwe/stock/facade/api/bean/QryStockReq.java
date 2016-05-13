package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.List;

public class QryStockReq implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3260667700607021011L;

    private String channelSource;            //渠道来源['ONLINE','UNLINE']  

    private List<String> skuList;            //商品编码集合

    public String getChannelSource() {
        return channelSource;
    }

    public void setChannelSource(String channelSource) {
        this.channelSource = channelSource;
    }

    public List<String> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<String> skuList) {
        this.skuList = skuList;
    }

    @Override
    public String toString() {
        return "QryStockReq [channelSource=" + channelSource + ", skuList="
                + skuList + "]";
    }

    
}
