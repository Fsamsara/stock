package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockUser;
import com.metersbonwe.stock.po.core.StockUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockUserMapper {
    int countByExample(StockUserExample example);

    int deleteByExample(StockUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockUser record);

    int insertSelective(StockUser record);

    List<StockUser> selectByExample(StockUserExample example);

    StockUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockUser record, @Param("example") StockUserExample example);

    int updateByExample(@Param("record") StockUser record, @Param("example") StockUserExample example);

    int updateByPrimaryKeySelective(StockUser record);

    int updateByPrimaryKey(StockUser record);
}