package com.metersbonwe.stock.dal.define.core.mapper;

import com.metersbonwe.stock.po.core.StockPreSale;
import com.metersbonwe.stock.po.core.StockPreSaleExample;
import com.metersbonwe.stock.po.core.StockPreSaleResult;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StockPreSaleDefineMapper {
    
	public int deleteByPreSaleResult(StockPreSaleResult stockPreSaleResult);
}