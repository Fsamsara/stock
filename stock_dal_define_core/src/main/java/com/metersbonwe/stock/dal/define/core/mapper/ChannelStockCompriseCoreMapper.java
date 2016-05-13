package com.metersbonwe.stock.dal.define.core.mapper;

import com.metersbonwe.stock.po.core.define.ChannelProdBean;

import java.util.List;
import java.util.Map;

public interface ChannelStockCompriseCoreMapper {

    /**
     * @description 获取自由量，锁定量
     * @param paramMap 参数
     * @return 表数据的结果集合
     */
    List<ChannelProdBean> getFreeLockStock(Map<String, String> paramMap);

}
