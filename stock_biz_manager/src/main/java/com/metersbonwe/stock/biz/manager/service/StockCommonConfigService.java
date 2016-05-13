package com.metersbonwe.stock.biz.manager.service;

import com.metersbonwe.stock.po.core.StockCommonConfig;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/5/10
 */
public interface StockCommonConfigService {

    List<StockCommonConfig> selectStockCommonConfig(Map<String, String> paraMap) throws UnsupportedEncodingException;

    int deleteStockCommonConfig(Map<String, List<String>> paraMap);

    int addStockCommonConfig(StockCommonConfig stockCommonConfig);

    int editStockCommonConfig(Map<String, String> paraMap) throws InvocationTargetException, IllegalAccessException;
}
