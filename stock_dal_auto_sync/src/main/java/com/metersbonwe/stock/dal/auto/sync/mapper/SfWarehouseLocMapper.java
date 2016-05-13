package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.SfWarehouseLoc;
import com.metersbonwe.stock.po.sync.SfWarehouseLocExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SfWarehouseLocMapper {
    int countByExample(SfWarehouseLocExample example);

    int deleteByExample(SfWarehouseLocExample example);

    int insert(SfWarehouseLoc record);

    int insertSelective(SfWarehouseLoc record);

    List<SfWarehouseLoc> selectByExample(SfWarehouseLocExample example);

    int updateByExampleSelective(@Param("record") SfWarehouseLoc record, @Param("example") SfWarehouseLocExample example);

    int updateByExample(@Param("record") SfWarehouseLoc record, @Param("example") SfWarehouseLocExample example);
}