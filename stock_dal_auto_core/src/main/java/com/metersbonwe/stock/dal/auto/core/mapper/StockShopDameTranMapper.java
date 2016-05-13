package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockShopDameTran;
import com.metersbonwe.stock.po.core.StockShopDameTranExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockShopDameTranMapper {
    int countByExample(StockShopDameTranExample example);

    int deleteByExample(StockShopDameTranExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockShopDameTran record);

    int insertSelective(StockShopDameTran record);

    List<StockShopDameTran> selectByExample(StockShopDameTranExample example);

    StockShopDameTran selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockShopDameTran record, @Param("example") StockShopDameTranExample example);

    int updateByExample(@Param("record") StockShopDameTran record, @Param("example") StockShopDameTranExample example);

    int updateByPrimaryKeySelective(StockShopDameTran record);

    int updateByPrimaryKey(StockShopDameTran record);
}