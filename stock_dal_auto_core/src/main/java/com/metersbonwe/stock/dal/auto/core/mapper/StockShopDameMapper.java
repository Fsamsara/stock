package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockShopDame;
import com.metersbonwe.stock.po.core.StockShopDameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockShopDameMapper {
    int countByExample(StockShopDameExample example);

    int deleteByExample(StockShopDameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockShopDame record);

    int insertSelective(StockShopDame record);

    List<StockShopDame> selectByExample(StockShopDameExample example);

    StockShopDame selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockShopDame record, @Param("example") StockShopDameExample example);

    int updateByExample(@Param("record") StockShopDame record, @Param("example") StockShopDameExample example);

    int updateByPrimaryKeySelective(StockShopDame record);

    int updateByPrimaryKey(StockShopDame record);
}