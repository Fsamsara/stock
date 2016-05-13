package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockShopSafe;
import com.metersbonwe.stock.po.core.StockShopSafeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockShopSafeMapper {
    int countByExample(StockShopSafeExample example);

    int deleteByExample(StockShopSafeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockShopSafe record);

    int insertSelective(StockShopSafe record);

    List<StockShopSafe> selectByExample(StockShopSafeExample example);

    StockShopSafe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockShopSafe record, @Param("example") StockShopSafeExample example);

    int updateByExample(@Param("record") StockShopSafe record, @Param("example") StockShopSafeExample example);

    int updateByPrimaryKeySelective(StockShopSafe record);

    int updateByPrimaryKey(StockShopSafe record);
}