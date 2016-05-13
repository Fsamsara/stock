package com.metersbonwe.stock.biz.manager.service;

import com.metersbonwe.stock.po.core.StockShopDameTran;

import java.util.List;
import java.util.Map;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/5/12
 */
public interface ShopDamageChangeLogsService {

    /**
     * @description 获取污次少洗维护日志
     * @param paraListMap 参数列表
     * @return 记录集合
     */
    List<StockShopDameTran> selectShopDamageChangeLogs(Map<String, List<String>> paraListMap);
}
