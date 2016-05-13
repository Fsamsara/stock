package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.WarehLockedLst;
import com.metersbonwe.stock.po.sync.WarehLockedLstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WarehLockedLstMapper {
    int countByExample(WarehLockedLstExample example);

    int deleteByExample(WarehLockedLstExample example);

    int deleteByPrimaryKey(@Param("warehId") String warehId, @Param("prodId") String prodId, @Param("lockedType") String lockedType);

    int insert(WarehLockedLst record);

    int insertSelective(WarehLockedLst record);

    List<WarehLockedLst> selectByExample(WarehLockedLstExample example);

    WarehLockedLst selectByPrimaryKey(@Param("warehId") String warehId, @Param("prodId") String prodId, @Param("lockedType") String lockedType);

    int updateByExampleSelective(@Param("record") WarehLockedLst record, @Param("example") WarehLockedLstExample example);

    int updateByExample(@Param("record") WarehLockedLst record, @Param("example") WarehLockedLstExample example);

    int updateByPrimaryKeySelective(WarehLockedLst record);

    int updateByPrimaryKey(WarehLockedLst record);
}