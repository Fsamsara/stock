package com.metersbonwe.stock.utils.concurrent;


import java.util.concurrent.locks.ReadWriteLock;


/**
 * 全量同步读写锁
 * @author tony
 *
 */
public class FullStockSyncLock {
	
	private static final String LOCK_PATH = "FULL_STOCK_SYNC";
	
	public static ReadWriteLock getLock(){
		return ZkLockManager.getReadWriteLock(LOCK_PATH);
	}
}
