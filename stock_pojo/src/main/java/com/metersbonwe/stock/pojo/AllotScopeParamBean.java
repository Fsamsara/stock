package com.metersbonwe.stock.pojo;

public class AllotScopeParamBean {
    private String channelSource;            //渠道来源['ONLINE','UNLINE']
    private String channelCode;              //渠道编码
    private String county;                   //国家
    private String province;                 //省份
    private String city;                     //市
    private String district;                 //区
    public String getChannelSource() {
        return channelSource;
    }
    public void setChannelSource(String channelSource) {
        this.channelSource = channelSource;
    }
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
    
}
