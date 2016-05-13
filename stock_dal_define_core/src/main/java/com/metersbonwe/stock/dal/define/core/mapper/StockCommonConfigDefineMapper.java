package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.metersbonwe.stock.po.core.StockCommonConfig;

/**
 * @author zhq
 */
@Repository public interface StockCommonConfigDefineMapper {

    public StockCommonConfig selectByConfigName(@Param("configName") String configName);

    public List<StockCommonConfig> selectByConfigNames(@Param("configNames") List<String> congifNames);

}
