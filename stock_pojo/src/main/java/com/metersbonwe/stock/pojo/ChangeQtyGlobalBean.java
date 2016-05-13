package com.metersbonwe.stock.pojo;

import java.util.List;

/**
 * 库存变化调度服务 全局对象
 * @author TanYibin
 * @param changeType 自由量 = 1，锁定量 = 2，预留量 = 3，第三方自由量 = 4，门店未日结量 = 5，门店污损值 = 6，门店安全库存 = 7，活动期间渠道商品推送独占量 = 8
 * @param maxDataCount 最多处理记录数
 */
public class ChangeQtyGlobalBean {
    
    private Integer changeType;
    
    private Integer maxDataCount;
    
    private Character queryType;
    
    private Integer startId;
    
    public ChangeQtyGlobalBean(){
        setMaxDataCount(100);
    }
    
    /**
     * 变化信息集合
     */
    private List<ChangeQtyInfoBean> changeQtyInfols;
    
    /**
     * 变化类型：自由量 = 1，锁定量 = 2，预留量 = 3，第三方自由量 = 4，门店未日结量 = 5，门店污损值 = 6，门店安全库存 = 7，活动期间渠道商品推送独占量 = 8
     */
    public Integer getChangeType() {
        return changeType;
    }

    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    public List<ChangeQtyInfoBean> getChangeQtyInfols() {
        return changeQtyInfols;
    }

    public void setChangeQtyInfols(List<ChangeQtyInfoBean> changeQtyInfols) {
        this.changeQtyInfols = changeQtyInfols;
    }

    public Integer getMaxDataCount() {
        return maxDataCount;
    }

    public void setMaxDataCount(Integer maxDataCount) {
        this.maxDataCount = maxDataCount;
    }

    public Character getQueryType() {
        return queryType;
    }

    public void setQueryType(Character queryType) {
        this.queryType = queryType;
    }

    public Integer getStartId() {
        return startId;
    }

    public void setStartId(Integer startId) {
        this.startId = startId;
    }

}
