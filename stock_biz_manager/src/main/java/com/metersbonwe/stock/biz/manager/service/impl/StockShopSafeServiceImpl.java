package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.manager.service.StockShopSafeService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockShopSafeMapper;
import com.metersbonwe.stock.po.core.StockShopSafe;
import com.metersbonwe.stock.po.core.StockShopSafeExample;

@Service public class StockShopSafeServiceImpl implements StockShopSafeService {

    @Autowired StockShopSafeMapper stockShopSafeMapper;

    @Override
    public List<StockShopSafe> selectStockShopSafe(Map<String, List<String>> paraListMap) throws Exception {
        StockShopSafeExample example = new StockShopSafeExample();
        StockShopSafeExample.Criteria criteria = example.createCriteria();
        List<String> warehIds = paraListMap.get("warehId");
        List<String> prodIds = paraListMap.get("prodId");
        if (CollectionUtils.isNotEmpty(warehIds)) {
            criteria.andWarehIdIn(warehIds);
        }
        if (CollectionUtils.isNotEmpty(prodIds)) {
            criteria.andProdIdIn(prodIds);
        }

        return stockShopSafeMapper.selectByExample(example);
    }

}
