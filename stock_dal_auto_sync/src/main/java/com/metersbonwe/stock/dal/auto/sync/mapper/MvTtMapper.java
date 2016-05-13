package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.MvTt;
import com.metersbonwe.stock.po.sync.MvTtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MvTtMapper {
    int countByExample(MvTtExample example);

    int deleteByExample(MvTtExample example);

    int insert(MvTt record);

    int insertSelective(MvTt record);

    List<MvTt> selectByExample(MvTtExample example);

    int updateByExampleSelective(@Param("record") MvTt record, @Param("example") MvTtExample example);

    int updateByExample(@Param("record") MvTt record, @Param("example") MvTtExample example);
}