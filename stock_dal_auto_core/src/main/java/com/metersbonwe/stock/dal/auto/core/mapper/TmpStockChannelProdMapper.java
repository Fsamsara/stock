package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.TmpStockChannelProd;
import com.metersbonwe.stock.po.core.TmpStockChannelProdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpStockChannelProdMapper {
    int countByExample(TmpStockChannelProdExample example);

    int deleteByExample(TmpStockChannelProdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TmpStockChannelProd record);

    int insertSelective(TmpStockChannelProd record);

    List<TmpStockChannelProd> selectByExample(TmpStockChannelProdExample example);

    TmpStockChannelProd selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TmpStockChannelProd record, @Param("example") TmpStockChannelProdExample example);

    int updateByExample(@Param("record") TmpStockChannelProd record, @Param("example") TmpStockChannelProdExample example);

    int updateByPrimaryKeySelective(TmpStockChannelProd record);

    int updateByPrimaryKey(TmpStockChannelProd record);
}