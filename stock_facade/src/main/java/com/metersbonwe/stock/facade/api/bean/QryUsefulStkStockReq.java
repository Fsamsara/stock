package com.metersbonwe.stock.facade.api.bean;

import java.util.List;

public class QryUsefulStkStockReq extends QryStockReq {

    /**
     * 
     */
    private static final long serialVersionUID = 2348672090528193735L;
    private String channelCode;              //渠道编码
    private String county;                   //国家
    private String province;                 //省份
    private String city;                     //市
    private String district;                 //区
    private List<String> extWarehShopList;   //被排除的仓库编码、门店编码集合
    public String getChannelCode() {
        return channelCode;
    }
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }
    public String getCounty() {
        return county;
    }
    public void setCounty(String county) {
        this.county = county;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public List<String> getExtWarehShopList() {
        return extWarehShopList;
    }
    public void setExtWarehShopList(List<String> extWarehShopList) {
        this.extWarehShopList = extWarehShopList;
    }
    @Override
    public String toString() {
        return "QryUsefulStkStockReq [channelCode=" + channelCode + ", county="
                + county + ", province=" + province + ", city=" + city
                + ", district=" + district + ", extWarehShopList="
                + extWarehShopList + ", toString()=" + super.toString() + "]";
    }
    
}
