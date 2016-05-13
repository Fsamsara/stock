package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.SfWarehLockedLst;
import com.metersbonwe.stock.po.sync.SfWarehLockedLstExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SfWarehLockedLstMapper {
    int countByExample(SfWarehLockedLstExample example);

    int deleteByExample(SfWarehLockedLstExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(SfWarehLockedLst record);

    int insertSelective(SfWarehLockedLst record);

    List<SfWarehLockedLst> selectByExample(SfWarehLockedLstExample example);

    SfWarehLockedLst selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") SfWarehLockedLst record, @Param("example") SfWarehLockedLstExample example);

    int updateByExample(@Param("record") SfWarehLockedLst record, @Param("example") SfWarehLockedLstExample example);

    int updateByPrimaryKeySelective(SfWarehLockedLst record);

    int updateByPrimaryKey(SfWarehLockedLst record);
}