package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.TmpQueueAll;
import com.metersbonwe.stock.po.core.TmpQueueAllExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpQueueAllMapper {
    int countByExample(TmpQueueAllExample example);

    int deleteByExample(TmpQueueAllExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmpQueueAll record);

    int insertSelective(TmpQueueAll record);

    List<TmpQueueAll> selectByExample(TmpQueueAllExample example);

    TmpQueueAll selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmpQueueAll record, @Param("example") TmpQueueAllExample example);

    int updateByExample(@Param("record") TmpQueueAll record, @Param("example") TmpQueueAllExample example);

    int updateByPrimaryKeySelective(TmpQueueAll record);

    int updateByPrimaryKey(TmpQueueAll record);
}