package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.TmpStockWmsBak;
import com.metersbonwe.stock.po.core.TmpStockWmsBakExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpStockWmsBakMapper {
    int countByExample(TmpStockWmsBakExample example);

    int deleteByExample(TmpStockWmsBakExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmpStockWmsBak record);

    int insertSelective(TmpStockWmsBak record);

    List<TmpStockWmsBak> selectByExample(TmpStockWmsBakExample example);

    TmpStockWmsBak selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmpStockWmsBak record, @Param("example") TmpStockWmsBakExample example);

    int updateByExample(@Param("record") TmpStockWmsBak record, @Param("example") TmpStockWmsBakExample example);

    int updateByPrimaryKeySelective(TmpStockWmsBak record);

    int updateByPrimaryKey(TmpStockWmsBak record);
}