package com.metersbonwe.stock.facade.api.bean;

import java.io.Serializable;
import java.util.Date;

public class ChannelMinmax implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String            channelCode;

    private Date              updateTime;

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ChannelMinmax [channelCode=" + channelCode + ", updateTime=" + updateTime + "]";
    }

}
