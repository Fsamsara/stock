package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.TmpStockWms;
import com.metersbonwe.stock.po.core.TmpStockWmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpStockWmsMapper {
    int countByExample(TmpStockWmsExample example);

    int deleteByExample(TmpStockWmsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmpStockWms record);

    int insertSelective(TmpStockWms record);

    List<TmpStockWms> selectByExample(TmpStockWmsExample example);

    TmpStockWms selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmpStockWms record, @Param("example") TmpStockWmsExample example);

    int updateByExample(@Param("record") TmpStockWms record, @Param("example") TmpStockWmsExample example);

    int updateByPrimaryKeySelective(TmpStockWms record);

    int updateByPrimaryKey(TmpStockWms record);
}