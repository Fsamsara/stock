package com.metersbonwe.stock.dal.auto.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.metersbonwe.stock.po.core.TmpStockWarehProd;
import com.metersbonwe.stock.po.core.TmpStockWarehProdExample;

public interface TmpStockWarehProdMapper {
    int countByExample(TmpStockWarehProdExample example);

    int deleteByExample(TmpStockWarehProdExample example);

    int deleteByPrimaryKey(TmpStockWarehProd record);

    int insert(TmpStockWarehProd record);

    int insertSelective(TmpStockWarehProd record);

    List<TmpStockWarehProd> selectByExample(TmpStockWarehProdExample example);

    TmpStockWarehProd selectByPrimaryKey(TmpStockWarehProd record);

    int updateByExampleSelective(@Param("record") TmpStockWarehProd record,
            @Param("example") TmpStockWarehProdExample example);

    int updateByExample(@Param("record") TmpStockWarehProd record,
            @Param("example") TmpStockWarehProdExample example);

    int updateByPrimaryKeySelective(TmpStockWarehProd record);

    int updateByPrimaryKey(TmpStockWarehProd record);
}
