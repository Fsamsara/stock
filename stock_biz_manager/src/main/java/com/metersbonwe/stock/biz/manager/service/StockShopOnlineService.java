package com.metersbonwe.stock.biz.manager.service;

import java.util.List;

import com.metersbonwe.stock.pojo.StockChannelBean;
import com.metersbonwe.stock.pojo.StockShopOnlineBean;

/**
 * TODO 库存全流通查询服务
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年3月30日 上午10:24:17
 * @since V1.0
 * @version V1.0
 */
public interface StockShopOnlineService {

    /**
     * TODO 全流通库存查询
     *
     * @param scope
     *            根据条件查询全流通库存
     * @return
     * @throws Exception
     */
    List<StockChannelBean> selectShopOnlineStock(StockShopOnlineBean scope) throws Exception;

}
