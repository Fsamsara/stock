package com.metersbonwe.stock.biz.api.insert;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.facade.api.NewErpReservedLockFacade;
import com.metersbonwe.stock.facade.sync.api.FullStockSyncService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;

/**
 * @author 张洪琴
 * 新ERP库存预留锁定类型明细表变化接口实现类
 */
@Service
public class NewErpReservedLockFacadeImpl implements NewErpReservedLockFacade {
	
	@Resource
	FullStockSyncService fullStockSyncServiceImpl;
	private static StockLog stockLog = StockLogFactory
			.getLogger(NewErpReservedLockFacadeImpl.class);
	
	@Override 
	public void reservedLockDetail() {
		stockLog.info("新ERP库存预留锁定类型明细表变化接口-->开始");
		try {
			fullStockSyncServiceImpl.performFullStockSync();
			stockLog.info("新ERP库存预留锁定类型明细表变化接口调用全量同步模块--已调用！");
		} catch (Exception e) {
			stockLog.debug("新ERP库存预留锁定类型明细表变化接口出现异常", e);;
		}finally{
			stockLog.info("新ERP库存预留锁定类型明细表变化接口-->结束");
		}
	}

}
