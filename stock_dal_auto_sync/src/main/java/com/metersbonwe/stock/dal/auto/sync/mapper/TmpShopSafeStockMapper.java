package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpShopSafeStock;
import com.metersbonwe.stock.po.sync.TmpShopSafeStockExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpShopSafeStockMapper {
    int countByExample(TmpShopSafeStockExample example);

    int deleteByExample(TmpShopSafeStockExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpShopSafeStock record);

    int insertSelective(TmpShopSafeStock record);

    List<TmpShopSafeStock> selectByExample(TmpShopSafeStockExample example);

    TmpShopSafeStock selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpShopSafeStock record, @Param("example") TmpShopSafeStockExample example);

    int updateByExample(@Param("record") TmpShopSafeStock record, @Param("example") TmpShopSafeStockExample example);

    int updateByPrimaryKeySelective(TmpShopSafeStock record);

    int updateByPrimaryKey(TmpShopSafeStock record);
}