package com.metersbonwe.stock.biz.manager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.manager.service.TmpStockWmsService;
import com.metersbonwe.stock.dal.auto.core.mapper.TmpStockWmsBakMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.TmpStockWmsMapper;
import com.metersbonwe.stock.po.core.TmpStockWms;
import com.metersbonwe.stock.po.core.TmpStockWmsBak;
import com.metersbonwe.stock.po.core.TmpStockWmsBakExample;
import com.metersbonwe.stock.po.core.TmpStockWmsExample;

@Service public class TmpStockWmsServiceImpl implements TmpStockWmsService {

    @Autowired TmpStockWmsMapper     tmpStockWmsMapper;

    @Autowired TmpStockWmsBakMapper  tmpStockWmsBakMapper;

    @Override
    public List<TmpStockWms> selectTmpStockWms(Map<String, List<String>> paraListMap) throws Exception {

        String tableName = paraListMap.get("tbn").get(0);

        if (tableName.equals("tmp_stock_wms")) {
            TmpStockWmsExample example = new TmpStockWmsExample();
            TmpStockWmsExample.Criteria criteria = example.createCriteria();
            List<String> warehIds = paraListMap.get("warehId");
            List<String> prodIds = paraListMap.get("prodId");
            if (CollectionUtils.isNotEmpty(warehIds)) {
                criteria.andWarehIdIn(warehIds);
            }
            if (CollectionUtils.isNotEmpty(prodIds)) {
                criteria.andProdIdIn(prodIds);
            }
            return tmpStockWmsMapper.selectByExample(example);
        } else {
            TmpStockWmsBakExample example = new TmpStockWmsBakExample();
            TmpStockWmsBakExample.Criteria criteria = example.createCriteria();
            List<String> warehIds = paraListMap.get("warehId");
            List<String> prodIds = paraListMap.get("prodId");
            if (CollectionUtils.isNotEmpty(warehIds)) {
                criteria.andWarehIdIn(warehIds);
            }
            if (CollectionUtils.isNotEmpty(prodIds)) {
                criteria.andProdIdIn(prodIds);
            }
            List<TmpStockWmsBak> tmpStockWmsBaks = tmpStockWmsBakMapper.selectByExample(example);
            List<TmpStockWms> tmpStockWmss = new ArrayList<TmpStockWms>();
            for (TmpStockWmsBak tmpStockWmsBak : tmpStockWmsBaks) {
                TmpStockWms tmpStockWms = new TmpStockWms();
                BeanUtils.copyProperties(tmpStockWmsBak, tmpStockWms);
                tmpStockWmss.add(tmpStockWms);
            }
            return tmpStockWmss;
        }
    }

}
