package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpChannelScope;
import com.metersbonwe.stock.po.sync.TmpChannelScopeExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpChannelScopeMapper {
    int countByExample(TmpChannelScopeExample example);

    int deleteByExample(TmpChannelScopeExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpChannelScope record);

    int insertSelective(TmpChannelScope record);

    List<TmpChannelScope> selectByExample(TmpChannelScopeExample example);

    TmpChannelScope selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpChannelScope record, @Param("example") TmpChannelScopeExample example);

    int updateByExample(@Param("record") TmpChannelScope record, @Param("example") TmpChannelScopeExample example);

    int updateByPrimaryKeySelective(TmpChannelScope record);

    int updateByPrimaryKey(TmpChannelScope record);
}