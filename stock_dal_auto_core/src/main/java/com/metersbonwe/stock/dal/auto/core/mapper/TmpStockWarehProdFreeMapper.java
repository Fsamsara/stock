package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.TmpStockWarehProdFree;
import com.metersbonwe.stock.po.core.TmpStockWarehProdFreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpStockWarehProdFreeMapper {
    int countByExample(TmpStockWarehProdFreeExample example);

    int deleteByExample(TmpStockWarehProdFreeExample example);

    int deleteByPrimaryKey(@Param("warehId") String warehId, @Param("prodId") String prodId);

    int insert(TmpStockWarehProdFree record);

    int insertSelective(TmpStockWarehProdFree record);

    List<TmpStockWarehProdFree> selectByExample(TmpStockWarehProdFreeExample example);

    TmpStockWarehProdFree selectByPrimaryKey(@Param("warehId") String warehId, @Param("prodId") String prodId);

    int updateByExampleSelective(@Param("record") TmpStockWarehProdFree record, @Param("example") TmpStockWarehProdFreeExample example);

    int updateByExample(@Param("record") TmpStockWarehProdFree record, @Param("example") TmpStockWarehProdFreeExample example);

    int updateByPrimaryKeySelective(TmpStockWarehProdFree record);

    int updateByPrimaryKey(TmpStockWarehProdFree record);
}