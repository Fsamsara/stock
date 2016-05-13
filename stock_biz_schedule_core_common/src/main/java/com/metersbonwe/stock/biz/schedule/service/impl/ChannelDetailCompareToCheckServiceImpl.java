package com.metersbonwe.stock.biz.schedule.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.dal.define.core.mapper.StockChannelOrderDetailDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelProdSubDefineMapper;
import com.metersbonwe.stock.facade.service.ChannelDetailCompareToCheckService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelOrderDetail;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;

/**
 * @author zhq
 * 预占明细和渠道信息表总量对比校验定时任务实现类
 */
@Service
public class ChannelDetailCompareToCheckServiceImpl implements
		ChannelDetailCompareToCheckService {
	
	private static StockLog logger = StockLogFactory
			.getLogger(ChannelDetailCompareToCheckServiceImpl.class);
	
	@Resource
	StockChannelOrderDetailDefineMapper stockChannelOrderDetailDefineMapper;
	@Resource
	StockChannelProdSubDefineMapper stockChannelProdSubDefineMapper;
	
	@Override
	public void checkChannelAndDetail() {
		ReadWriteLock rwLock = FullStockSyncLock.getLock();
		Lock lock = rwLock.readLock();
		Date stime = null;
		try {
			lock.lock();
			stime = new Date();
			logger.info("预占明细和渠道信息表总量对比校验定时任务-->开始");
			try {
				//获取 预占明细信息表数据stock_channel_order_detail 的关联渠道号：
				List<StockChannelOrderDetail> dList = this.stockChannelOrderDetailDefineMapper.selectRelationChannel();
				//循环获取到的渠道：更新每个渠道中对比结果不一致的数据：
				for (StockChannelOrderDetail d : dList) {
					//有预售的数据对比更新：
					this.stockChannelProdSubDefineMapper.updateByChannelDetailWhenIsPre(d.getRelationChannel());
					//没有预售的数据对比更新：
					this.stockChannelProdSubDefineMapper.updateByChannelDetailWhenIsNotPre(d.getRelationChannel());
				}
			} catch (Exception e) {
				logger.debug("预占明细和渠道信息表总量对比校验定时任务checkChannelAndDetail方法有异常", e);
			}

		} finally {
			logger.info("预占明细和渠道信息表总量对比校验定时任务-->结束,用时："+(new Date().getTime()-stime.getTime()));
			lock.unlock();
		}
	}

}
