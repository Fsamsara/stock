package com.metersbonwe.stock.dal.define.sync.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 点群信息
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-23 下午1:17:19
 */
public interface BfOrgShopGroupDefineMapper {

    List<Map<String, String>> selectShopGroup(@Param("channelCodes") List<String> channelCodes);

}
