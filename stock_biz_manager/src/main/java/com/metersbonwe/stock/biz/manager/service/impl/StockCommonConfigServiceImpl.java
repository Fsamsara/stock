package com.metersbonwe.stock.biz.manager.service.impl;

import com.metersbonwe.stock.biz.manager.service.StockCommonConfigService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockCommonConfigMapper;
import com.metersbonwe.stock.po.core.StockCommonConfig;
import com.metersbonwe.stock.po.core.StockCommonConfigExample;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/5/10
 */
@Service public class StockCommonConfigServiceImpl implements StockCommonConfigService {
    @Resource StockCommonConfigMapper stockCommonConfigMapper;

    @Override
    public List<StockCommonConfig> selectStockCommonConfig(Map<String, String> paraMap) throws UnsupportedEncodingException {
        StockCommonConfigExample stockCommonConfigExample = new StockCommonConfigExample();
        StockCommonConfigExample.Criteria criteria = stockCommonConfigExample.createCriteria();
        String configName = paraMap.get("configName");
        String configGroup = paraMap.get("configGroup");
        if (StringUtils.isNotBlank(configName)) {
            criteria.andConfigNameEqualTo(configName);
        }
        if (StringUtils.isNotBlank(configGroup)) {
            criteria.andConfigGroupEqualTo(configGroup);
        }
        List<StockCommonConfig> stockCommonConfigList = stockCommonConfigMapper.selectByExample(stockCommonConfigExample);
        for (StockCommonConfig stockCommonConfig : stockCommonConfigList) {
            String configValue = stockCommonConfig.getConfigValue() == null ? "" : stockCommonConfig.getConfigValue();
            stockCommonConfig.setConfigValue(URLEncoder.encode(configValue, "utf-8"));
        }
        return stockCommonConfigList;
    }

    @Override public int deleteStockCommonConfig(Map<String, List<String>> paraMap) {
        int deleteCount = 0;
        List<String> idList = paraMap.get("id");
        for (String id : idList) {
            StockCommonConfigExample example = new StockCommonConfigExample();
            example.createCriteria().andIdEqualTo(Integer.parseInt(id));
            deleteCount = deleteCount + stockCommonConfigMapper.deleteByExample(example);
        }
        return deleteCount;
    }

    @Override public int addStockCommonConfig(StockCommonConfig stockCommonConfig) {
        return stockCommonConfigMapper.insert(stockCommonConfig);
    }

    @Override public int editStockCommonConfig(Map<String, String> paraMap) throws InvocationTargetException, IllegalAccessException {
        StockCommonConfig stockCommonConfig = new StockCommonConfig();
        BeanUtils.populate(stockCommonConfig, paraMap);
        StockCommonConfigExample stockCommonConfigExample = new StockCommonConfigExample();
        StockCommonConfigExample.Criteria criteria = stockCommonConfigExample.createCriteria();
        criteria.andIdEqualTo(stockCommonConfig.getId());
        return stockCommonConfigMapper.updateByExampleSelective(stockCommonConfig, stockCommonConfigExample);
    }
}
