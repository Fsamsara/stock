package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockShopSafeTran;
import com.metersbonwe.stock.po.core.StockShopSafeTranExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockShopSafeTranMapper {
    int countByExample(StockShopSafeTranExample example);

    int deleteByExample(StockShopSafeTranExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockShopSafeTran record);

    int insertSelective(StockShopSafeTran record);

    List<StockShopSafeTran> selectByExample(StockShopSafeTranExample example);

    StockShopSafeTran selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockShopSafeTran record, @Param("example") StockShopSafeTranExample example);

    int updateByExample(@Param("record") StockShopSafeTran record, @Param("example") StockShopSafeTranExample example);

    int updateByPrimaryKeySelective(StockShopSafeTran record);

    int updateByPrimaryKey(StockShopSafeTran record);
}