package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpChannelMinmax;
import com.metersbonwe.stock.po.sync.TmpChannelMinmaxExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpChannelMinmaxMapper {
    int countByExample(TmpChannelMinmaxExample example);

    int deleteByExample(TmpChannelMinmaxExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpChannelMinmax record);

    int insertSelective(TmpChannelMinmax record);

    List<TmpChannelMinmax> selectByExample(TmpChannelMinmaxExample example);

    TmpChannelMinmax selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpChannelMinmax record, @Param("example") TmpChannelMinmaxExample example);

    int updateByExample(@Param("record") TmpChannelMinmax record, @Param("example") TmpChannelMinmaxExample example);

    int updateByPrimaryKeySelective(TmpChannelMinmax record);

    int updateByPrimaryKey(TmpChannelMinmax record);
}