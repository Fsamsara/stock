package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockShopRemailTran;
import com.metersbonwe.stock.po.core.StockShopRemailTranExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockShopRemailTranMapper {
    int countByExample(StockShopRemailTranExample example);

    int deleteByExample(StockShopRemailTranExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockShopRemailTran record);

    int insertSelective(StockShopRemailTran record);

    List<StockShopRemailTran> selectByExample(StockShopRemailTranExample example);

    StockShopRemailTran selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockShopRemailTran record, @Param("example") StockShopRemailTranExample example);

    int updateByExample(@Param("record") StockShopRemailTran record, @Param("example") StockShopRemailTranExample example);

    int updateByPrimaryKeySelective(StockShopRemailTran record);

    int updateByPrimaryKey(StockShopRemailTran record);
}