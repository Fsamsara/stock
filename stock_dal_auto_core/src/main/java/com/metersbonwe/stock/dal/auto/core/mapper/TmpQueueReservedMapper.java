package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.TmpQueueReserved;
import com.metersbonwe.stock.po.core.TmpQueueReservedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpQueueReservedMapper {
    int countByExample(TmpQueueReservedExample example);

    int deleteByExample(TmpQueueReservedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmpQueueReserved record);

    int insertSelective(TmpQueueReserved record);

    List<TmpQueueReserved> selectByExample(TmpQueueReservedExample example);

    TmpQueueReserved selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmpQueueReserved record, @Param("example") TmpQueueReservedExample example);

    int updateByExample(@Param("record") TmpQueueReserved record, @Param("example") TmpQueueReservedExample example);

    int updateByPrimaryKeySelective(TmpQueueReserved record);

    int updateByPrimaryKey(TmpQueueReserved record);
}