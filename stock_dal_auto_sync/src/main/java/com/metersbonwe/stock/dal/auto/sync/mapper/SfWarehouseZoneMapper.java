package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.SfWarehouseZone;
import com.metersbonwe.stock.po.sync.SfWarehouseZoneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SfWarehouseZoneMapper {
    int countByExample(SfWarehouseZoneExample example);

    int deleteByExample(SfWarehouseZoneExample example);

    int insert(SfWarehouseZone record);

    int insertSelective(SfWarehouseZone record);

    List<SfWarehouseZone> selectByExample(SfWarehouseZoneExample example);

    int updateByExampleSelective(@Param("record") SfWarehouseZone record, @Param("example") SfWarehouseZoneExample example);

    int updateByExample(@Param("record") SfWarehouseZone record, @Param("example") SfWarehouseZoneExample example);
}