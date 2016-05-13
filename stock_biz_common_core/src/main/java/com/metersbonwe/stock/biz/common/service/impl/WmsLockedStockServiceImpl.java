package com.metersbonwe.stock.biz.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.metersbonwe.stock.biz.common.service.WmsLockedStockService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockCommonConfigMapper;
import com.metersbonwe.stock.dal.define.core.mapper.TmpStockWmsBakDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.TmpStockWmsDefineMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockCommonConfig;
import com.metersbonwe.stock.po.core.StockCommonConfigExample;
import com.metersbonwe.stock.po.core.TmpStockWms;

@Service public class WmsLockedStockServiceImpl implements WmsLockedStockService {
    @SuppressWarnings("unused") private static StockLog stockLog                          = StockLogFactory
                                                                                                  .getLogger(WmsLockedStockServiceImpl.class);

    private final String                                STOCK_COMMON_CONFIG_DEFAULT_VALUE = "tmp_stock_wms";

    private final String                                STOCK_COMMON_FONFIG_NAME          = "WMS_LOCKED_STOCK_TABLE";

    @Autowired StockCommonConfigMapper                  stockCommonConfigMapper;

    @Autowired TmpStockWmsDefineMapper                  tmpStockWmsDefineMapper;

    @Autowired TmpStockWmsBakDefineMapper               tmpStockWmsBakDefineMapper;

    @Override
    public String getTmpTableNameFromStockCommonConfig() {
        return getTmpTableName();
    }

    /*
     * 由于调度每次清空的是配置的表，所以要查询另外一张表
     * @see com.metersbonwe.stock.biz.common.service.WmsLockedStockService#selectTmpStockWmsList()
     */
    @Override
    public List<TmpStockWms> selectTmpStockWmsList() {
        String tableName = getCurrentWmsLockedStockTableName();
        Map<String, Object> map = Maps.newHashMap();
        map.put("tableName", tableName);
        return tmpStockWmsDefineMapper.selectAll(map);
    }

    @Override
    public void updCommonConfigNewTableName(String tableName) {
        StockCommonConfigExample stockCommonConfigExample = new StockCommonConfigExample();
        stockCommonConfigExample.createCriteria().andConfigNameEqualTo(STOCK_COMMON_FONFIG_NAME);
        StockCommonConfig stockCommonConfig = new StockCommonConfig();
        stockCommonConfig.setConfigValue(tableName);

        stockCommonConfigMapper.updateByExampleSelective(stockCommonConfig, stockCommonConfigExample);
    }

    @Override
    public void truncateTable(String tableName) {
        if (STOCK_COMMON_CONFIG_DEFAULT_VALUE.equals(tableName)) {
            tmpStockWmsDefineMapper.truncateTable();
        } else {
            tmpStockWmsBakDefineMapper.truncateTable();
        }
    }

    @Override
    public TmpStockWms selectTmpStockWms(String warehId, String prodId) {
        String tableName = getCurrentWmsLockedStockTableName();
        Map<String, Object> map = Maps.newHashMap();
        map.put("tableName", tableName);
        map.put("warehId", warehId);
        map.put("prodId", prodId);
        List<TmpStockWms> bak = tmpStockWmsDefineMapper.selectAll(map);
        if (bak == null || bak.size() == 0) {
            return null;
        } else {
            return bak.get(0);
        }
    }

    /**
     * 获取配置的临时表表名
     * 
     * @return
     */
    private String getTmpTableName() {
        String sBak = STOCK_COMMON_CONFIG_DEFAULT_VALUE;
        StockCommonConfigExample stockCommonConfigExample = new StockCommonConfigExample();
        stockCommonConfigExample.createCriteria().andConfigNameEqualTo(STOCK_COMMON_FONFIG_NAME);
        List<StockCommonConfig> stockCommonConfigs = stockCommonConfigMapper.selectByExample(stockCommonConfigExample);
        if (stockCommonConfigs.size() > 0) {
            String tmpSbak = stockCommonConfigs.get(0).getConfigValue();
            if (tmpSbak == null || tmpSbak.isEmpty()) {
                sBak = STOCK_COMMON_CONFIG_DEFAULT_VALUE;
            } else {
                sBak = tmpSbak;
            }
        }
        return sBak;
    }

    @Override
    public String getOtherTableName(String tableName) {
        String sBak = STOCK_COMMON_CONFIG_DEFAULT_VALUE;

        String tableName_1 = STOCK_COMMON_CONFIG_DEFAULT_VALUE;
        String tableName_2 = STOCK_COMMON_CONFIG_DEFAULT_VALUE + "_bak";

        Map<String, String> map = Maps.newHashMap();
        map.put(tableName_1, tableName_2);
        map.put(tableName_2, tableName_1);
        if (map.containsKey(tableName)) {
            sBak = map.get(tableName);
        }
        return sBak;
    }

    @Override
    public String getCurrentWmsLockedStockTableName() {
        String tableName = getTmpTableName();
        tableName = getOtherTableName(tableName);
        return tableName;
    }
}
