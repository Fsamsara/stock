package com.metersbonwe.stock.dal.define.core.mapper;

import com.metersbonwe.stock.po.core.StockPreSaleResult;

import java.util.List;

/**
 * @author zhq
 *
 */
public interface StockPreSaleResultHisDefineMapper {
	/**
	 * 根据传入的ChannelCode、prodId将stock_pre_sale 的数据插入到  stock_pre_sale_result_his
	 * @param list
	 * @return
	 */
	public int insertFromPreSale(List<StockPreSaleResult> list);
}