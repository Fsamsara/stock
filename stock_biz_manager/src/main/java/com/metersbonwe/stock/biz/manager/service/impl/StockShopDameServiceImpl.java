package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.manager.service.StockShopDameService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockShopDameMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockShopDameDefineMapper;
import com.metersbonwe.stock.po.core.StockShopDame;
import com.metersbonwe.stock.po.core.StockShopDameExample;

@Service public class StockShopDameServiceImpl implements StockShopDameService {

    @Resource StockShopDameDefineMapper stockShopDameDefineMapper;

    @Resource StockShopDameMapper       stockShopDameMapper;

    @Override
    public List<StockShopDame> selectStockShopDame(Map<String, List<String>> paraListMap) throws Exception {
        StockShopDameExample example = new StockShopDameExample();
        StockShopDameExample.Criteria criteria = example.createCriteria();
        List<String> warehIds = paraListMap.get("warehId");
        List<String> prodIds = paraListMap.get("prodId");
        if (CollectionUtils.isNotEmpty(warehIds)) {
            criteria.andWarehIdIn(warehIds);
        }
        if (CollectionUtils.isNotEmpty(prodIds)) {
            criteria.andProdIdIn(prodIds);
        }
        return stockShopDameMapper.selectByExample(example);
    }

    @Override
    public int updateStockShopDame(StockShopDame damePo) throws Exception {
        StockShopDameExample example = new StockShopDameExample();
        example.or().andWarehIdEqualTo(damePo.getWarehId()).andProdIdEqualTo(damePo.getProdId());
        StockShopDame dame = new StockShopDame();
        dame.setDameStock(damePo.getDameStock());
        return stockShopDameMapper.updateByExampleSelective(dame, example);
    }

    @Override
    public int deleteStockShopDame(StockShopDame damePo) throws Exception {
        return stockShopDameMapper.deleteByPrimaryKey(damePo.getId());
    }

    @Override
    public int addStockShopDame(StockShopDame vo) throws Exception {
        return stockShopDameMapper.insert(vo);
    }
}
