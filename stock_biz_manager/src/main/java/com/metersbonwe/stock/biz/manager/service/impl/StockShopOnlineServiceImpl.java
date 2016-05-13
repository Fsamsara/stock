package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.manager.service.StockShopOnlineService;
import com.metersbonwe.stock.dal.define.core.mapper.StockShopOnlineDefineMapper;
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
@Service public class StockShopOnlineServiceImpl implements StockShopOnlineService {

    @Resource StockShopOnlineDefineMapper stockShopOnlineDefineMapper;

    @Override
    public List<StockChannelBean> selectShopOnlineStock(StockShopOnlineBean scope) throws Exception {

        return stockShopOnlineDefineMapper.selectShopOnlineStock(scope.getWarehShopIds(), scope.getProdIds(), scope.getTableSeqs());
    }

}
