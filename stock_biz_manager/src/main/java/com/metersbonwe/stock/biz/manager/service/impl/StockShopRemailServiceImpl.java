package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.manager.service.StockShopRemailService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockShopRemailMapper;
import com.metersbonwe.stock.po.core.StockShopRemail;
import com.metersbonwe.stock.po.core.StockShopRemailExample;

@Service public class StockShopRemailServiceImpl implements StockShopRemailService {

    @Autowired StockShopRemailMapper stockShopRemailMapper;

    @Override
    public List<StockShopRemail> selectStockShopRemail(Map<String, List<String>> paraListMap) throws Exception {
        StockShopRemailExample example = new StockShopRemailExample();
        StockShopRemailExample.Criteria criteria = example.createCriteria();
        List<String> warehIds = paraListMap.get("warehId");
        List<String> prodIds = paraListMap.get("prodId");
        List<String> locIds = paraListMap.get("locId");
        List<String> rllNums = paraListMap.get("rllNum");
        if (CollectionUtils.isNotEmpty(warehIds)) {
            criteria.andWarehIdIn(warehIds);
        }
        if (CollectionUtils.isNotEmpty(prodIds)) {
            criteria.andProdIdIn(prodIds);
        }
        if (CollectionUtils.isNotEmpty(locIds)) {
            criteria.andLocIdIn(locIds);
        }
        if (CollectionUtils.isNotEmpty(rllNums)) {
            criteria.andRllNumIn(rllNums);
        }
        return stockShopRemailMapper.selectByExample(example);
    }
}
