package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockWarehTableMapping;
import com.metersbonwe.stock.po.core.StockWarehTableMappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockWarehTableMappingMapper {
    int countByExample(StockWarehTableMappingExample example);

    int deleteByExample(StockWarehTableMappingExample example);

    int deleteByPrimaryKey(String warehId);

    int insert(StockWarehTableMapping record);

    int insertSelective(StockWarehTableMapping record);

    List<StockWarehTableMapping> selectByExample(StockWarehTableMappingExample example);

    StockWarehTableMapping selectByPrimaryKey(String warehId);

    int updateByExampleSelective(@Param("record") StockWarehTableMapping record, @Param("example") StockWarehTableMappingExample example);

    int updateByExample(@Param("record") StockWarehTableMapping record, @Param("example") StockWarehTableMappingExample example);

    int updateByPrimaryKeySelective(StockWarehTableMapping record);

    int updateByPrimaryKey(StockWarehTableMapping record);
}