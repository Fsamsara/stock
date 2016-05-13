package com.metersbonwe.stock.utils.concurrent;

import java.util.concurrent.locks.Lock;

import org.apache.commons.lang.StringUtils;

/**
 * 占用释放相关
 * 
 * @author zhangfeng
 */
public class OrderOccupyReleaseLock {

    private static final String LOCK_PATH = "order_occupy_release";

    private OrderOccupyReleaseLock() {}

    public static Lock getLock() {
        return ZkLockManager.getDefaultLock(LOCK_PATH);
    }

    public static Lock getLockByProdId(String prodId) {
        if (StringUtils.isBlank(prodId)) {
            throw new RuntimeException("订单占用释放时获取锁失败,当前商品号:" + prodId);
        }
        return ZkLockManager.getDefaultLock(LOCK_PATH + "/" + prodId.substring(0, 4) + "/" + prodId);
    }

}
