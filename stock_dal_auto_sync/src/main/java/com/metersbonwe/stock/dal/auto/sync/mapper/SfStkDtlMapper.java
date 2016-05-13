package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.SfStkDtl;
import com.metersbonwe.stock.po.sync.SfStkDtlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SfStkDtlMapper {
    int countByExample(SfStkDtlExample example);

    int deleteByExample(SfStkDtlExample example);

    int insert(SfStkDtl record);

    int insertSelective(SfStkDtl record);

    List<SfStkDtl> selectByExample(SfStkDtlExample example);

    int updateByExampleSelective(@Param("record") SfStkDtl record, @Param("example") SfStkDtlExample example);

    int updateByExample(@Param("record") SfStkDtl record, @Param("example") SfStkDtlExample example);
}