package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.SfWarehProd;
import com.metersbonwe.stock.po.sync.SfWarehProdExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SfWarehProdMapper {
    int countByExample(SfWarehProdExample example);

    int deleteByExample(SfWarehProdExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(SfWarehProd record);

    int insertSelective(SfWarehProd record);

    List<SfWarehProd> selectByExample(SfWarehProdExample example);

    SfWarehProd selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") SfWarehProd record, @Param("example") SfWarehProdExample example);

    int updateByExample(@Param("record") SfWarehProd record, @Param("example") SfWarehProdExample example);

    int updateByPrimaryKeySelective(SfWarehProd record);

    int updateByPrimaryKey(SfWarehProd record);
}