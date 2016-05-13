package com.metersbonwe.stock.pojo;

import java.util.List;

public class ShopQueryLocStockParamBean extends ShopQueryStockParamBean {
    private List<String> locList;   //货位编码集合

    public List<String> getLocList() {
        return locList;
    }

    public void setLocList(List<String> locList) {
        this.locList = locList;
    }
    
}
