package com.metersbonwe.stock.pojo;

public class StockChannelActivityBean {

    private Integer id;          // 非业务id

    private String  channelCode; //  渠道编码

    private String  goodsn;      //   商品6位编码

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getGoodsn() {
        return goodsn;
    }

    public void setGoodsn(String goodsn) {
        this.goodsn = goodsn;
    }

}
