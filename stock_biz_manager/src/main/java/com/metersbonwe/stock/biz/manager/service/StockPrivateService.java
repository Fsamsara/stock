package com.metersbonwe.stock.biz.manager.service;

import com.metersbonwe.stock.po.sync.define.ChannelReservedBean;

import java.util.List;
import java.util.Map;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/5/5
 */
public interface StockPrivateService {

    /**
     * @description 获取预留独占量
     * @param paraListMap 参数列表
     * @param privateStockOpFlg 预留量操作标识
     * @return 预留量记录集合
     */
    List<ChannelReservedBean> selectPrivateStock(Map<String, List<String>> paraListMap, String privateStockOpFlg);

}
