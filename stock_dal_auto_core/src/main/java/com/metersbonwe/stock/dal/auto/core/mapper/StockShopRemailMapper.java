package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockShopRemail;
import com.metersbonwe.stock.po.core.StockShopRemailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockShopRemailMapper {
    int countByExample(StockShopRemailExample example);

    int deleteByExample(StockShopRemailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockShopRemail record);

    int insertSelective(StockShopRemail record);

    List<StockShopRemail> selectByExample(StockShopRemailExample example);

    StockShopRemail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockShopRemail record, @Param("example") StockShopRemailExample example);

    int updateByExample(@Param("record") StockShopRemail record, @Param("example") StockShopRemailExample example);

    int updateByPrimaryKeySelective(StockShopRemail record);

    int updateByPrimaryKey(StockShopRemail record);
}