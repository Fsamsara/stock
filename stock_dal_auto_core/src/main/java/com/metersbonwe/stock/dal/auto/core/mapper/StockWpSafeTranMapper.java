package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockWpSafeTran;
import com.metersbonwe.stock.po.core.StockWpSafeTranExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockWpSafeTranMapper {
    int countByExample(StockWpSafeTranExample example);

    int deleteByExample(StockWpSafeTranExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockWpSafeTran record);

    int insertSelective(StockWpSafeTran record);

    List<StockWpSafeTran> selectByExample(StockWpSafeTranExample example);

    StockWpSafeTran selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockWpSafeTran record, @Param("example") StockWpSafeTranExample example);

    int updateByExample(@Param("record") StockWpSafeTran record, @Param("example") StockWpSafeTranExample example);

    int updateByPrimaryKeySelective(StockWpSafeTran record);

    int updateByPrimaryKey(StockWpSafeTran record);
}