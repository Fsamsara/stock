package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.TmpStockBatchReserved;
import com.metersbonwe.stock.po.core.TmpStockBatchReservedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpStockBatchReservedMapper {
    int countByExample(TmpStockBatchReservedExample example);

    int deleteByExample(TmpStockBatchReservedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmpStockBatchReserved record);

    int insertSelective(TmpStockBatchReserved record);

    List<TmpStockBatchReserved> selectByExample(TmpStockBatchReservedExample example);

    TmpStockBatchReserved selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmpStockBatchReserved record, @Param("example") TmpStockBatchReservedExample example);

    int updateByExample(@Param("record") TmpStockBatchReserved record, @Param("example") TmpStockBatchReservedExample example);

    int updateByPrimaryKeySelective(TmpStockBatchReserved record);

    int updateByPrimaryKey(TmpStockBatchReserved record);
}