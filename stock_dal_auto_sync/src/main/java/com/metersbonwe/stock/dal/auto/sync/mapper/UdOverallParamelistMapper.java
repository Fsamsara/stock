package com.metersbonwe.stock.dal.auto.sync.mapper;

import com.metersbonwe.stock.po.sync.UdOverallParamelist;
import com.metersbonwe.stock.po.sync.UdOverallParamelistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UdOverallParamelistMapper {
    int countByExample(UdOverallParamelistExample example);

    int deleteByExample(UdOverallParamelistExample example);

    int insert(UdOverallParamelist record);

    int insertSelective(UdOverallParamelist record);

    List<UdOverallParamelist> selectByExample(UdOverallParamelistExample example);

    int updateByExampleSelective(@Param("record") UdOverallParamelist record, @Param("example") UdOverallParamelistExample example);

    int updateByExample(@Param("record") UdOverallParamelist record, @Param("example") UdOverallParamelistExample example);
}