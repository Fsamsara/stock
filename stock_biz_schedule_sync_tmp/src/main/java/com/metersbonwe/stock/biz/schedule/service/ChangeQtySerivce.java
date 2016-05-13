package com.metersbonwe.stock.biz.schedule.service;

import com.metersbonwe.stock.pojo.ChangeQtyGlobalBean;


/**
 * 库存变化调度服务 Service
 * @author TanYibin
 *
 */
public interface ChangeQtySerivce {
    
    /**
     * 库存变化调度服务
     * @param changeType 自由量 = 0，锁定量 = 1，预留量 = 2
     * @param threadSize 线程数
     * @throws Exception
     */
    public void doService(ChangeQtyGlobalBean changeQtyGlobalBean) throws Exception;

}
