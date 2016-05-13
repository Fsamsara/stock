package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.manager.service.SafeStockService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockWpSafeMapper;
import com.metersbonwe.stock.po.core.StockWpSafe;
import com.metersbonwe.stock.po.core.StockWpSafeExample;

@Service public class SafeStockServiceImpl implements SafeStockService {

    @Resource private StockWpSafeMapper stockWpSafeMapper;

    /**
     * TODO 按分页查询单仓、多sku或没有sku获取仓+sku安全库存量
     * 
     * @see com.metersbonwe.stock.biz.manager.service.SafeStockService#getErpWarehSafeStock(com.metersbonwe.stock.pojo.Page, java.lang.String,
     *      java.util.List)
     */
    public List<StockWpSafe> getErpWarehSafeStock(List<String> warehList, List<String> skuList) {
        StockWpSafeExample example = new StockWpSafeExample();
        StockWpSafeExample.Criteria criteria = example.createCriteria();
        criteria.andWarehIdIn(warehList);
        if (skuList != null && skuList.size() > 0) {
            criteria.andProdIdIn(skuList);
        }
        List<StockWpSafe> stockWpSafeList = this.stockWpSafeMapper.selectByExample(example);
        return stockWpSafeList;
    }

}
