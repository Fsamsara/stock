package com.metersbonwe.stock.facade.schedule;


/**
 * 库存变化调度Dubbo服务
 * @author TanYibin
 */
public interface ChangeQtyDubboSerivce {
    
    /**
     * 自由量变化调度任务Dubbo接口
     * @param param
     * @throws Exception
     */
    public void changeFreeQty() throws Exception;
    
    /**
     * 锁定量变化调度任务Dubbo接口
     * @param param
     * @throws Exception
     */
    public void changeLockedQty() throws Exception;
    
    /**
     * 预留量变化调度任务Dubbo接口
     * @param param
     * @throws Exception
     */
    public void changeReservedQty() throws Exception;
    
    /**
     * 第三方自由量变化调度任务Dubbo接口
     * @param param
     * @throws Exception
     */
    public void changeTpFreeQty() throws Exception;
    
    /**
     * 门店未日结变化调度任务Dubbo接口
     * @param param
     * @throws Exception
     */
    public void changeRemailQty() throws Exception;
    
    /**
     * 门店污损值变化调度任务Dubbo接口
     * @param param
     * @throws Exception
     */
    public void changeDameQty() throws Exception;
    
    /**
     * 活动期间渠道商品推送独占量调度任务Dubbo接口
     * @param param
     * @throws Exception
     */
    public void changeChannelQty() throws Exception;
    
}
