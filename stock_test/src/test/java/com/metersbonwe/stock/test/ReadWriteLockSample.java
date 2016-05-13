package com.metersbonwe.stock.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;

public class ReadWriteLockSample {
	/**
	 * 读锁用法，在调度任务中使用
	 */
	public static void readLock(){
		ReadWriteLock rwLock =  FullStockSyncLock.getLock();
		Lock lock = rwLock.readLock();
		try {
			lock.lock();
//			...
		} finally {
			lock.unlock();
		}
	}
	
	/**
	 * 全量同步时候使用
	 */
	public static void writeLock(){
		ReadWriteLock rwLock =  FullStockSyncLock.getLock();
		Lock lock = rwLock.writeLock();
		try {
			lock.lock();
//			...
		} finally {
			lock.unlock();
		}
	}
	
	
	
}
