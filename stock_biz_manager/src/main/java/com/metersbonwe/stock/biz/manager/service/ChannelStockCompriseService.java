package com.metersbonwe.stock.biz.manager.service;

import com.metersbonwe.stock.po.core.define.ChannelProdBean;

import java.util.List;
import java.util.Map;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/5/12
 */
public interface ChannelStockCompriseService {
    /**
     * 渠道库存分部情况查询
     * @param paraListMap 参数
     * @return channelProdBean的对象集合
     */
    List<ChannelProdBean> selectChannelStockComprise(Map<String, String> paraListMap);
}
