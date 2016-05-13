package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.StkDtl;
import com.metersbonwe.stock.po.sync.StkDtlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StkDtlMapper {
    int countByExample(StkDtlExample example);

    int deleteByExample(StkDtlExample example);

    int insert(StkDtl record);

    int insertSelective(StkDtl record);

    List<StkDtl> selectByExample(StkDtlExample example);

    int updateByExampleSelective(@Param("record") StkDtl record, @Param("example") StkDtlExample example);

    int updateByExample(@Param("record") StkDtl record, @Param("example") StkDtlExample example);
}