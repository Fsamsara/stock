package com.metersbonwe.stock.pojo;

import java.util.List;

public class StockChannelOrderDetailHisBean {
    
    /** 渠道编码集合 */
    private List<String> channelCodes;

    /** 商品编码集合 */
    private List<String> prodIds;

    public List<String> getchannelCodes() {
        return channelCodes;
    }

    public void setchannelCodes(List<String> channelCodes) {
        this.channelCodes = channelCodes;
    }

    public List<String> getprodIds() {
        return prodIds;
    }

    public void setprodIds(List<String> prodIds) {
        this.prodIds = prodIds;
    }

}
