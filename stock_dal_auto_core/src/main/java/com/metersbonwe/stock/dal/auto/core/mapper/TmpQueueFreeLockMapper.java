package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.TmpQueueFreeLock;
import com.metersbonwe.stock.po.core.TmpQueueFreeLockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpQueueFreeLockMapper {
    int countByExample(TmpQueueFreeLockExample example);

    int deleteByExample(TmpQueueFreeLockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmpQueueFreeLock record);

    int insertSelective(TmpQueueFreeLock record);

    List<TmpQueueFreeLock> selectByExample(TmpQueueFreeLockExample example);

    TmpQueueFreeLock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmpQueueFreeLock record, @Param("example") TmpQueueFreeLockExample example);

    int updateByExample(@Param("record") TmpQueueFreeLock record, @Param("example") TmpQueueFreeLockExample example);

    int updateByPrimaryKeySelective(TmpQueueFreeLock record);

    int updateByPrimaryKey(TmpQueueFreeLock record);
}