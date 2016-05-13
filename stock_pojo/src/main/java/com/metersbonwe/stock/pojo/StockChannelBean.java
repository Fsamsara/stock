package com.metersbonwe.stock.pojo;

public class StockChannelBean {

    private String  channelCode;          // 渠道编码

    private Integer secondOccFlag;        // 是否第二次占用

    private Integer isFullCirculation;    // 是否全流通

    private Integer isPreOccupy;          // 是否预售预占  1 为真，0为假

    private String  tableSuffix;          //  表后缀

    private Integer occupyStock;          // 计划预占量

    private Integer occupyPrePrivateStock; // 预售预占总量

    private Integer occupyPrivateStock;   // 实物独占预占总量

    private Integer occupyShareStock;     // 实物共享预占总量

    private Integer occupyShopGroupStock; // 实物店群预占总量

    private Integer onlineStock;          // 平台线上可售库存

    private String  relationChannel;      // 预占关联渠道

    private String  businessId;           // 总订单号

    private String  subOrderId;           // 子订单号

    private String  osOrderId;            // OS订单号

    private String  prodId;               // 商品编码

    private Integer minStock;             // 渠道全局最小值

    private Integer maxStock;             // 渠道全局最大值

    private Long    relationId;

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
        setTableSuffix(channelCode.toLowerCase());
    }

    public Integer getMinStock() {
        return minStock;
    }

    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }

    public Integer getIsPreOccupy() {
        return isPreOccupy;
    }

    public void setIsPreOccupy(Integer isPreOccupy) {
        this.isPreOccupy = isPreOccupy;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public Integer getOnlineStock() {
        return onlineStock;
    }

    public Integer getSecondOccFlag() {
        return secondOccFlag;
    }

    public void setSecondOccFlag(Integer secondOccFlag) {
        this.secondOccFlag = secondOccFlag;
    }

    public Integer getIsFullCirculation() {
        return isFullCirculation;
    }

    public void setIsFullCirculation(Integer isFullCirculation) {
        this.isFullCirculation = isFullCirculation;
    }

    public void setOnlineStock(Integer onlineStock) {
        this.onlineStock = onlineStock;
    }

    public String getRelationChannel() {
        return relationChannel;
    }

    public void setRelationChannel(String relationChannel) {
        this.relationChannel = relationChannel;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(String subOrderId) {
        this.subOrderId = subOrderId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public Integer getOccupyPrivateStock() {
        return occupyPrivateStock;
    }

    public void setOccupyPrivateStock(Integer occupyPrivateStock) {
        this.occupyPrivateStock = occupyPrivateStock;
    }

    public Integer getOccupyShareStock() {
        return occupyShareStock;
    }

    public void setOccupyShareStock(Integer occupyShareStock) {
        this.occupyShareStock = occupyShareStock;
    }

    public Integer getOccupyStock() {
        return occupyStock;
    }

    public void setOccupyStock(Integer occupyStock) {
        this.occupyStock = occupyStock;
    }

    public Integer getOccupyPrePrivateStock() {
        return occupyPrePrivateStock;
    }

    public void setOccupyPrePrivateStock(Integer occupyPrePrivateStock) {
        this.occupyPrePrivateStock = occupyPrePrivateStock;
    }

    public String getOsOrderId() {
        return osOrderId;
    }

    public void setOsOrderId(String osOrderId) {
        this.osOrderId = osOrderId;
    }

    public String getTableSuffix() {
        return tableSuffix;
    }

    public void setTableSuffix(String tableSuffix) {
        this.tableSuffix = tableSuffix;
    }

    public Integer getOccupyShopGroupStock() {
        return occupyShopGroupStock;
    }

    public void setOccupyShopGroupStock(Integer occupyShopGroupStock) {
        this.occupyShopGroupStock = occupyShopGroupStock;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

}
