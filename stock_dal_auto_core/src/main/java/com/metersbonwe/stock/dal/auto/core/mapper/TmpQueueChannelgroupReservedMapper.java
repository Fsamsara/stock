package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.TmpQueueChannelgroupReserved;
import com.metersbonwe.stock.po.core.TmpQueueChannelgroupReservedExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TmpQueueChannelgroupReservedMapper {
    int countByExample(TmpQueueChannelgroupReservedExample example);

    int deleteByExample(TmpQueueChannelgroupReservedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmpQueueChannelgroupReserved record);

    int insertSelective(TmpQueueChannelgroupReserved record);

    List<TmpQueueChannelgroupReserved> selectByExample(TmpQueueChannelgroupReservedExample example);

    TmpQueueChannelgroupReserved selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmpQueueChannelgroupReserved record, @Param("example") TmpQueueChannelgroupReservedExample example);

    int updateByExample(@Param("record") TmpQueueChannelgroupReserved record, @Param("example") TmpQueueChannelgroupReservedExample example);

    int updateByPrimaryKeySelective(TmpQueueChannelgroupReserved record);

    int updateByPrimaryKey(TmpQueueChannelgroupReserved record);
}
