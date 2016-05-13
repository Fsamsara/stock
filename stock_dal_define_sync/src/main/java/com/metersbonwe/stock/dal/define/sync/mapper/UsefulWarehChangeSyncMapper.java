package com.metersbonwe.stock.dal.define.sync.mapper;

import com.metersbonwe.stock.po.sync.define.ChannelReservedBean;
import com.metersbonwe.stock.po.sync.define.TmpStockWareh;

import java.util.List;
import java.util.Map;

/* *
 * @description 渠道可用仓变化专用mapper
 * @author huangbiao
 * @date 2016/03/23
 * @version V1.0
 */
public interface UsefulWarehChangeSyncMapper {
    List<ChannelReservedBean> getChannelReservedData(Map<String, Object> paramMap);

    List<TmpStockWareh> getAllWareh();
}
