package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.WarehProd;
import com.metersbonwe.stock.po.sync.WarehProdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WarehProdMapper {
    int countByExample(WarehProdExample example);

    int deleteByExample(WarehProdExample example);

    int deleteByPrimaryKey(@Param("warehId") String warehId, @Param("prodId") String prodId);

    int insert(WarehProd record);

    int insertSelective(WarehProd record);

    List<WarehProd> selectByExample(WarehProdExample example);

    WarehProd selectByPrimaryKey(@Param("warehId") String warehId, @Param("prodId") String prodId);

    int updateByExampleSelective(@Param("record") WarehProd record, @Param("example") WarehProdExample example);

    int updateByExample(@Param("record") WarehProd record, @Param("example") WarehProdExample example);

    int updateByPrimaryKeySelective(WarehProd record);

    int updateByPrimaryKey(WarehProd record);
}