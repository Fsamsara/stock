package com.metersbonwe.stock.utils.concurrent;

import java.util.concurrent.locks.ReadWriteLock;


public class QueueLock {
	
	private static final String LOCK_PATH = "QUEUE_LOCK";
	
	public static ReadWriteLock getLock(){
		return ZkLockManager.getReadWriteLock(LOCK_PATH);
	}


}
