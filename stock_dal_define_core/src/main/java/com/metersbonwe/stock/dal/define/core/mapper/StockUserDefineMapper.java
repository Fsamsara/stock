package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;

import com.metersbonwe.stock.po.core.StockUser;

public interface StockUserDefineMapper {

    int insertStockUser(StockUser record);

    List<StockUser> selectStockUserByUserName(String userName);

}
