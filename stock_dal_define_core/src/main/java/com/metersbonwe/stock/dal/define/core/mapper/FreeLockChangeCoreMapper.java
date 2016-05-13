package com.metersbonwe.stock.dal.define.core.mapper;

import java.math.BigDecimal;
import java.util.Map;

/* *
 * @description 自由量锁定量变化
 * @author huangbiao
 * @date 2016/03/24
 * @version V1.0
 */
public interface FreeLockChangeCoreMapper {
    int updateChannelProd(Map<String, Object> paramMap);

    Map<String, BigDecimal> getFreeLockData(Map<String, Object> paramMap);
}
