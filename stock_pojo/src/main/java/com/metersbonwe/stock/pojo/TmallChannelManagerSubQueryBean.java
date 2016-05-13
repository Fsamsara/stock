package com.metersbonwe.stock.pojo;

import java.util.List;

public class TmallChannelManagerSubQueryBean {
    
    private List<String> reletionIds;
    
    private List<String> prodIds;
    
    private String reletionId;
    
    private String prodId;

    public List<String> getReletionIds() {
        return reletionIds;
    }

    public void setReletionIds(List<String> reletionIds) {
        this.reletionIds = reletionIds;
    }

    public List<String> getProdIds() {
        return prodIds;
    }

    public void setProdIds(List<String> prodIds) {
        this.prodIds = prodIds;
    }

    public String getReletionId() {
        return reletionId;
    }

    public void setReletionId(String reletionId) {
        this.reletionId = reletionId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

}
