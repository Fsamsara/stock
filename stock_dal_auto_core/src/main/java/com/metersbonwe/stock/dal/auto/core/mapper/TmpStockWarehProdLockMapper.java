package com.metersbonwe.stock.dal.auto.core.mapper;

import com.metersbonwe.stock.po.core.TmpStockWarehProdLock;
import com.metersbonwe.stock.po.core.TmpStockWarehProdLockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmpStockWarehProdLockMapper {
    int countByExample(TmpStockWarehProdLockExample example);

    int deleteByExample(TmpStockWarehProdLockExample example);

    int deleteByPrimaryKey(@Param("warehId") String warehId, @Param("prodId") String prodId);

    int insert(TmpStockWarehProdLock record);

    int insertSelective(TmpStockWarehProdLock record);

    List<TmpStockWarehProdLock> selectByExample(TmpStockWarehProdLockExample example);

    TmpStockWarehProdLock selectByPrimaryKey(@Param("warehId") String warehId, @Param("prodId") String prodId);

    int updateByExampleSelective(@Param("record") TmpStockWarehProdLock record, @Param("example") TmpStockWarehProdLockExample example);

    int updateByExample(@Param("record") TmpStockWarehProdLock record, @Param("example") TmpStockWarehProdLockExample example);

    int updateByPrimaryKeySelective(TmpStockWarehProdLock record);

    int updateByPrimaryKey(TmpStockWarehProdLock record);
}