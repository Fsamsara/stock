package com.metersbonwe.stock.utils.concurrent;

import java.util.concurrent.locks.Lock;

import org.menagerie.locks.ReentrantZkLock;

/**
 * 表映射相关锁对象
 * @author tony
 *
 */
@SuppressWarnings({ "deprecation", "unused" })
public class TableMappingLock {
	
	private static final String LOCK_PATH = "TABLE_MAPPING";
	
	private TableMappingLock(){
	}
	
	public static Lock getLock(){
		return ZkLockManager.getDefaultLock(LOCK_PATH);
	}
	
}
