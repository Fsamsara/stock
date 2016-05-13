package com.metersbonwe.stock.pojo;

import java.util.Date;

public class StockChannelCellMinBean {

    private Integer id;             // 非业务id

    private String  channelCode;    //  渠道编码

    private String  prodId;         //   商品编码(11位码)

    private Integer channelCellMin; //   渠道单元最小值

    private Date    updateTime;     // 更新时间

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

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public Integer getChannelCellMin() {
        return channelCellMin;
    }

    public void setChannelCellMin(Integer channelCellMin) {
        this.channelCellMin = channelCellMin;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
