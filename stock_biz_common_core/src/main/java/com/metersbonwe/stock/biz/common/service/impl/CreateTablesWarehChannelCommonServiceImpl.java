package com.metersbonwe.stock.biz.common.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.localcache.provider.ChannelCodeCacheProvider;
import com.metersbonwe.stock.biz.common.service.CreateTablesWarehChannelCommonService;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.configuration.PropertiesManager;
import com.metersbonwe.stock.dal.define.core.mapper.CreateTablesWarehChannelDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockCommonConfigDefineMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockCommonConfig;

@Service public class CreateTablesWarehChannelCommonServiceImpl implements CreateTablesWarehChannelCommonService {

    private static StockLog                        LOGGER = StockLogFactory.getLogger(CreateTablesWarehChannelCommonServiceImpl.class);

    @Resource CreateTablesWarehChannelDefineMapper createTablesWarehChannelDefineMapper;

    @Resource StockCommonConfigDefineMapper        stockCommonConfigDefineMapper;

    @Resource ChannelCodeCacheProvider channelCodeCacheProvider;
    @Resource MultiTableService                    multiTableServiceImpl;

    @Override
    public void createChannelTable() {
        String channelTabelPrefix = PropertiesManager.getPropertiesManager().getProperty("channel.table.prefix");
        if (StringUtils.isNotBlank(channelTabelPrefix)) {
            // 获取所有渠道
            List<String> channels = channelCodeCacheProvider.getAllUsefulChannel();
            List<String> keys = Arrays.asList(channelTabelPrefix.split(","));
            for (String tableName : keys) {
                List<String> schemas = selectTableSchemas(tableName);
                if (CollectionUtils.isNotEmpty(schemas)) {
                    List<String> addChannelTables = new ArrayList<>();
                    for (String channel : channels) {
                        addChannelTables.add(tableName + "_" + channel.toLowerCase());
                    }
                    addChannelTables.removeAll(schemas);
                    if (addChannelTables.size() > 0) {
                        for (String orgTableName : addChannelTables) {
                            createTablesWarehChannelDefineMapper.createTable(orgTableName, tableName);
                            LOGGER.debug("创建表完成,表名:" + orgTableName);
                        }
                    }
                }
            }
        }
    }

    private List<String> selectTableSchemas(String tableName) {
        return createTablesWarehChannelDefineMapper.selectTableSchemas(tableName);
    }

    @Override
    public void createWarehTable() {
        String channelTabelPrefix = PropertiesManager.getPropertiesManager().getProperty("wareh.table.prefix");
        List<String> schemas = selectTableSchemas(channelTabelPrefix);
        if (StringUtils.isNotBlank(channelTabelPrefix) && CollectionUtils.isNotEmpty(schemas)) {
            int maxSeq = multiTableServiceImpl.getMaxTableSeq();
            int schemaSize = schemas.size();
            StockCommonConfig commonConfig = stockCommonConfigDefineMapper.selectByConfigName("TABLE_BUFFER_SIZE");
            if (commonConfig != null) {
                String tableBufferSize = null;
                if (StringUtils.isNotBlank(tableBufferSize)) {
                    List<String> keys = Arrays.asList(channelTabelPrefix.split(","));
                    for (String tableName : keys) {
                        String orgTableName = tableName;
                        for (int i = schemaSize; i <= Integer.valueOf(tableBufferSize) - (schemaSize - maxSeq); i++) {
                            tableName = tableName + "_" + multiTableServiceImpl.getMappingSuffix(i);
                            createTablesWarehChannelDefineMapper.createTable(tableName, orgTableName);
                            LOGGER.debug("创建表完成,表名:" + tableName);
                        }
                    }
                }
            }
        }
    }

    public void createWarehTableBak() {
        String channelTabelPrefix = PropertiesManager.getPropertiesManager().getProperty("wareh.table.prefix");
        List<String> schemas = selectTableSchemas(channelTabelPrefix);
        if (StringUtils.isNotBlank(channelTabelPrefix) && CollectionUtils.isNotEmpty(schemas)) {
            String orgTableName = schemas.get(0);
            int maxSeq = multiTableServiceImpl.getMaxTableSeq();
            int schemaSize = schemas.size();
            List<String> configNames = new ArrayList<>();
            configNames.add("TABLE_BUFFER_SIZE");
            configNames.add("TABLE_CREATE_SIZE");
            List<StockCommonConfig> commonConfigs = stockCommonConfigDefineMapper.selectByConfigNames(configNames);
            if (CollectionUtils.isNotEmpty(commonConfigs)) {
                String tableBufferSize = null;
                String tableCreateSize = null;
                for (StockCommonConfig stockCommonConfig : commonConfigs) {
                    if (stockCommonConfig.getConfigName().equals("TABLE_BUFFER_SIZE")) {
                        tableBufferSize = stockCommonConfig.getConfigValue();
                    } else if (stockCommonConfig.getConfigName().equals("TABLE_CREATE_SIZE")) {
                        tableCreateSize = stockCommonConfig.getConfigValue();
                    }
                }
                if (StringUtils.isNotBlank(tableCreateSize) && StringUtils.isNotBlank(tableBufferSize)
                        && schemaSize - maxSeq < Integer.valueOf(tableBufferSize)) {
                    List<String> keys = Arrays.asList(channelTabelPrefix.split(","));
                    for (String tableName : keys) {
                        for (int i = maxSeq + 1; i <= maxSeq + Integer.valueOf(tableCreateSize); i++) {
                            createTablesWarehChannelDefineMapper
                                    .createTable(orgTableName, tableName + "_" + multiTableServiceImpl.getMappingSuffix(i));
                        }
                    }
                }
            }
        }
    }
}
