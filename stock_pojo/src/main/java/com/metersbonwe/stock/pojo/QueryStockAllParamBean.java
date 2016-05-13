package com.metersbonwe.stock.pojo;

import java.util.List;

public class QueryStockAllParamBean {
    private String channelSource;            //渠道来源['ONLINE','UNLINE']
    private String channelCode;              //渠道编码
    private String county;                   //国家
    private String province;                 //省份
    private String city;                     //市
    private String district;                 //区
    private List<String> skuList;            //商品编码集合
    private List<String> extWarehShopList;   //被排除的仓库编码、门店编码集合
    private int queryModule;                 //1：POS全流通库存查询 2: 分配时查询库存（手工分单） 3: 全流通库存查询（总查询）
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
    public List<String> getSkuList() {
        return skuList;
    }
    public void setSkuList(List<String> skuList) {
        this.skuList = skuList;
    }
    public List<String> getExtWarehShopList() {
        return extWarehShopList;
    }
    public void setExtWarehShopList(List<String> extWarehShopList) {
        this.extWarehShopList = extWarehShopList;
    }
    public int getQueryModule() {
        return queryModule;
    }
    public void setQueryModule(int queryModule) {
        this.queryModule = queryModule;
    }
    @Override
    public String toString() {
        return "QueryStockAllParamBean [channelSource=" + channelSource
                + ", channelCode=" + channelCode + ", county=" + county
                + ", province=" + province + ", city=" + city + ", district="
                + district + ", skuList=" + skuList + ", extWarehShopList="
                + extWarehShopList + ", queryModule=" + queryModule + "]";
    }
    
}
