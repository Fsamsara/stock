package com.metersbonwe.stock.pojo;

import java.util.List;

public class TmallChannelManagerQueryBean {
   
    private List<String> incrementIds;
    
    private List<String> incrementNames;
    
    private List<String> channelCodes;
    
    private List<String> iStatus;
    
    private List<String> createTimes;

    public List<String> getIncrementIds() {
        return incrementIds;
    }

    public void setIncrementIds(List<String> incrementIds) {
        this.incrementIds = incrementIds;
    }

    public List<String> getIncrementNames() {
        return incrementNames;
    }

    public void setIncrementNames(List<String> incrementNames) {
        this.incrementNames = incrementNames;
    }

    public List<String> getChannelCodes() {
        return channelCodes;
    }

    public void setChannelCodes(List<String> channelCodes) {
        this.channelCodes = channelCodes;
    }

    public List<String> getiStatus() {
        return iStatus;
    }

    public void setiStatus(List<String> iStatus) {
        this.iStatus = iStatus;
    }

    public List<String> getCreateTimes() {
        return createTimes;
    }

    public void setCreateTimes(List<String> createTimes) {
        this.createTimes = createTimes;
    }
    
}
