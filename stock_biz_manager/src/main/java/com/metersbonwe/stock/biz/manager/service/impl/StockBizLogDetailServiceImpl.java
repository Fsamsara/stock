package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.manager.service.StockBizLogDetailService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockBizLogDetailsMapper;
import com.metersbonwe.stock.po.core.StockBizLogDetails;
import com.metersbonwe.stock.po.core.StockBizLogDetailsExample;

@Service public class StockBizLogDetailServiceImpl implements StockBizLogDetailService {

    @Autowired StockBizLogDetailsMapper stockBizLogDetailsMapper;

    @Override
    public List<StockBizLogDetails> selectStockBizLogDetail(Map<String, List<String>> paraListMap) throws Exception {
        StockBizLogDetailsExample example = new StockBizLogDetailsExample();
        StockBizLogDetailsExample.Criteria criteria = example.createCriteria();
        List<String> servicenames = paraListMap.get("servicename");
        List<String> classnames = paraListMap.get("classname");
        List<String> methodnames = paraListMap.get("methodname");
        List<String> channelcodes = paraListMap.get("channelCode");
        List<String> warehids = paraListMap.get("warehid");
        List<String> prodids = paraListMap.get("prodid");

        if (CollectionUtils.isNotEmpty(servicenames)) {
            criteria.andServicenameIn(servicenames);
        }
        if (CollectionUtils.isNotEmpty(classnames)) {
            criteria.andClassnameIn(classnames);
        }
        if (CollectionUtils.isNotEmpty(methodnames)) {
            criteria.andMethodnameIn(methodnames);
        }
        if (CollectionUtils.isNotEmpty(channelcodes)) {
            criteria.andChannelcodeIn(channelcodes);
        }
        if (CollectionUtils.isNotEmpty(warehids)) {
            criteria.andWarehidIn(warehids);
        }
        if (CollectionUtils.isNotEmpty(prodids)) {
            criteria.andProdidIn(prodids);
        }
        return stockBizLogDetailsMapper.selectByExample(example);
    }

}
