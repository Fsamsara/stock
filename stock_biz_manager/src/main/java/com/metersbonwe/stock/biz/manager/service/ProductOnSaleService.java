package com.metersbonwe.stock.biz.manager.service;

import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.pojo.Page;

import java.util.List;
import java.util.Map;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/5/6
 */
public interface ProductOnSaleService {

    /**
     * @description 获取渠道在售商品清单
     * @param channelCode 渠道
     * @param page
     * @return 在售商品清单Map
     */
    List<ChannelProdBean> selectOnlineChannelStock(Map<String, String> channelCode, Page<?> page) throws Exception;

}
