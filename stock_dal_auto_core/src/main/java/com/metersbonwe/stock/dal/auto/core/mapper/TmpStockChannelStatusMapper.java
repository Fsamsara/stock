package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.TmpStockChannelStatus;
import com.metersbonwe.stock.po.core.TmpStockChannelStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpStockChannelStatusMapper {
    int countByExample(TmpStockChannelStatusExample example);

    int deleteByExample(TmpStockChannelStatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmpStockChannelStatus record);

    int insertSelective(TmpStockChannelStatus record);

    List<TmpStockChannelStatus> selectByExample(TmpStockChannelStatusExample example);

    TmpStockChannelStatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmpStockChannelStatus record, @Param("example") TmpStockChannelStatusExample example);

    int updateByExample(@Param("record") TmpStockChannelStatus record, @Param("example") TmpStockChannelStatusExample example);

    int updateByPrimaryKeySelective(TmpStockChannelStatus record);

    int updateByPrimaryKey(TmpStockChannelStatus record);
}