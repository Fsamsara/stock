package com.metersbonwe.stock.dal.auto.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.po.core.StockWarehProdExample;

public interface StockWarehProdMapper {
    int countByExample(StockWarehProdExample example);
    
    int deleteByExample(StockWarehProdExample example);

    int deleteByPrimaryKey(StockWarehProd record);

    int insert(StockWarehProd record);

    int insertSelective(StockWarehProd record);

    List<StockWarehProd> selectByExample(StockWarehProdExample example);

    StockWarehProd selectByPrimaryKey(StockWarehProd record);

    int updateByExampleSelective(@Param("record") StockWarehProd record,
            @Param("example") StockWarehProdExample example);

    int updateByExample(@Param("record") StockWarehProd record,
            @Param("example") StockWarehProdExample example);

    int updateByPrimaryKeySelective(StockWarehProd record);

    int updateByPrimaryKey(StockWarehProd record);
}
