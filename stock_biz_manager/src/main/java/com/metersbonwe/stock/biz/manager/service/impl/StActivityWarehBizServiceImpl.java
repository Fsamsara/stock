package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.manager.service.StActivityWarehBizService;
import com.metersbonwe.stock.dal.auto.sync.mapper.StActivityWarehMapper;
import com.metersbonwe.stock.po.sync.StActivityWareh;
import com.metersbonwe.stock.po.sync.StActivityWarehExample;

@Service public class StActivityWarehBizServiceImpl implements StActivityWarehBizService {

    @Autowired StActivityWarehMapper        stActivityWarehMapper;

    @Override
    public List<StActivityWareh> selectStActivityWareh(Map<String, List<String>> paraListMap) throws Exception {
        StActivityWarehExample example = new StActivityWarehExample();
        StActivityWarehExample.Criteria criteria = example.createCriteria();
        List<String> warehIds = paraListMap.get("warehId");
        List<String> isShops = paraListMap.get("isShop");
        List<String> dataSources = paraListMap.get("dataSource");
        if (CollectionUtils.isNotEmpty(warehIds)) {
            criteria.andWarehIdIn(warehIds);
        }
        if (CollectionUtils.isNotEmpty(isShops)) {
            criteria.andIsShopIn(isShops);
        }
        if (CollectionUtils.isNotEmpty(dataSources)) {
            criteria.andDataSourceIn(dataSources);
        }
        return stActivityWarehMapper.selectByExample(example);
    }
}
