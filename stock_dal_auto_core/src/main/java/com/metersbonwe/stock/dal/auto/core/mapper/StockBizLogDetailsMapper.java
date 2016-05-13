package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.StockBizLogDetails;
import com.metersbonwe.stock.po.core.StockBizLogDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockBizLogDetailsMapper {
    int countByExample(StockBizLogDetailsExample example);

    int deleteByExample(StockBizLogDetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockBizLogDetails record);

    int insertSelective(StockBizLogDetails record);

    List<StockBizLogDetails> selectByExampleWithBLOBs(StockBizLogDetailsExample example);

    List<StockBizLogDetails> selectByExample(StockBizLogDetailsExample example);

    StockBizLogDetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockBizLogDetails record, @Param("example") StockBizLogDetailsExample example);

    int updateByExampleWithBLOBs(@Param("record") StockBizLogDetails record, @Param("example") StockBizLogDetailsExample example);

    int updateByExample(@Param("record") StockBizLogDetails record, @Param("example") StockBizLogDetailsExample example);

    int updateByPrimaryKeySelective(StockBizLogDetails record);

    int updateByPrimaryKeyWithBLOBs(StockBizLogDetails record);

    int updateByPrimaryKey(StockBizLogDetails record);
}