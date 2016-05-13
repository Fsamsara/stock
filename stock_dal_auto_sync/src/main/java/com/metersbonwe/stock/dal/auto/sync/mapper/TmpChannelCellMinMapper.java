package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.TmpChannelCellMin;
import com.metersbonwe.stock.po.sync.TmpChannelCellMinExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpChannelCellMinMapper {
    int countByExample(TmpChannelCellMinExample example);

    int deleteByExample(TmpChannelCellMinExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(TmpChannelCellMin record);

    int insertSelective(TmpChannelCellMin record);

    List<TmpChannelCellMin> selectByExample(TmpChannelCellMinExample example);

    TmpChannelCellMin selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") TmpChannelCellMin record, @Param("example") TmpChannelCellMinExample example);

    int updateByExample(@Param("record") TmpChannelCellMin record, @Param("example") TmpChannelCellMinExample example);

    int updateByPrimaryKeySelective(TmpChannelCellMin record);

    int updateByPrimaryKey(TmpChannelCellMin record);
}