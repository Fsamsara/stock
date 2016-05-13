package com.metersbonwe.stock.biz.manager.service.impl;

import com.metersbonwe.stock.biz.manager.service.ShopDamageChangeLogsService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockShopDameTranMapper;
import com.metersbonwe.stock.po.core.StockShopDameTran;
import com.metersbonwe.stock.po.core.StockShopDameTranExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/5/12
 */
@Service
public class ShopDamageChangeLogsServiceImpl implements ShopDamageChangeLogsService {

    @Resource StockShopDameTranMapper stockShopDameTranMapper;

    @Override public List<StockShopDameTran> selectShopDamageChangeLogs(Map<String, List<String>> paraListMap) {
        StockShopDameTranExample stockShopDameTranExample = new StockShopDameTranExample();
        StockShopDameTranExample.Criteria criteria = stockShopDameTranExample.createCriteria();
        List<String> paramWarehList = paraListMap.get("warehId");
        List<String> paramProdList = paraListMap.get("prodId");
        List<String> warehIdList = new ArrayList<>();
        if (paramWarehList != null) {
            warehIdList = paramWarehList;
        }
        criteria.andWarehIdIn(warehIdList);
        if(paramProdList != null){
            criteria.andProdIdIn(paramProdList);
        }
        return stockShopDameTranMapper.selectByExample(stockShopDameTranExample);
    }

}


