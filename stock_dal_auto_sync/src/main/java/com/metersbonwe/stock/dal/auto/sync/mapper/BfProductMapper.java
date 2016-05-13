package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.BfProduct;
import com.metersbonwe.stock.po.sync.BfProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BfProductMapper {
    int countByExample(BfProductExample example);

    int deleteByExample(BfProductExample example);

    int insert(BfProduct record);

    int insertSelective(BfProduct record);

    List<BfProduct> selectByExample(BfProductExample example);

    int updateByExampleSelective(@Param("record") BfProduct record, @Param("example") BfProductExample example);

    int updateByExample(@Param("record") BfProduct record, @Param("example") BfProductExample example);
}