package com.metersbonwe.stock.pojo;

import java.util.Date;

public class StockChannelMinMaxBean {

    private Integer id;          // 非业务id

    private String  channelCode; //  渠道编码

    private Integer minStock;    //   渠道全局最小值

    private Integer maxStock;    //   渠道全局最大值

    private Date    updateTime;  // 更新时间

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public Integer getMinStock() {
        return minStock;
    }

    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
