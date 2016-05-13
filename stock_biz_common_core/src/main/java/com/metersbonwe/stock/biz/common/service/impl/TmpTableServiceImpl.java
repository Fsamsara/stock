package com.metersbonwe.stock.biz.common.service.impl;

import com.metersbonwe.stock.biz.common.service.TmpTableService;
import com.metersbonwe.stock.dal.define.core.mapper.TmpTableCoreMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpTableSyncMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 临时表公用Service
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/3/17
 */
@Service public class TmpTableServiceImpl implements TmpTableService {

    @Autowired TmpTableCoreMapper tmpTableCoreMapper;

    @Resource TmpTableSyncMapper  tmpTableSyncMapper;

    StockLog                      log = StockLogFactory.getLogger(TmpTableServiceImpl.class);

    @Override
    public List<Map<String, Object>> getSyncTmpData(Map<String, String> paramMap) {
        return tmpTableSyncMapper.getTmpData(paramMap);
    }

    @Override
    public void delSyncTmpData(String tmpTableName, long maxId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("tableName", tmpTableName);
        paramMap.put("maxId", maxId);
        tmpTableSyncMapper.delTmpData(paramMap);
    }

    @Override
    public List<Map<String, Object>> getCoreTmpData(Map<String, String> paramMap) {
        return tmpTableCoreMapper.getTmpData(paramMap);
    }

    @Override
    public void delCoreTmpData(String tmpTableName, long maxId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("tableName", tmpTableName);
        paramMap.put("maxId", maxId);
        tmpTableCoreMapper.delTmpData(paramMap);
    }

    @Override
    public void truncateCoreTmpTable(String tmpTableName) {
        tmpTableCoreMapper.truncateCoreTable(tmpTableName);
        log.debug("truncate core database table : " + tmpTableName);
    }
}
