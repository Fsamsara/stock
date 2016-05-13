package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.StActivityWareh;
import com.metersbonwe.stock.po.sync.StActivityWarehExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StActivityWarehMapper {
    int countByExample(StActivityWarehExample example);

    int deleteByExample(StActivityWarehExample example);

    int deleteByPrimaryKey(String warehId);

    int insert(StActivityWareh record);

    int insertSelective(StActivityWareh record);

    List<StActivityWareh> selectByExample(StActivityWarehExample example);

    StActivityWareh selectByPrimaryKey(String warehId);

    int updateByExampleSelective(@Param("record") StActivityWareh record, @Param("example") StActivityWarehExample example);

    int updateByExample(@Param("record") StActivityWareh record, @Param("example") StActivityWarehExample example);

    int updateByPrimaryKeySelective(StActivityWareh record);

    int updateByPrimaryKey(StActivityWareh record);
}