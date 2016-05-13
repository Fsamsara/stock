package com.metersbonwe.stock.biz.manager.service;

import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.po.sync.StActivityWareh;

public interface StActivityWarehBizService {
    /**
     * TODO 查询配发组织
     *
     * @param dameVo
     * @return
     * @throws Exception
     */
    List<StActivityWareh> selectStActivityWareh(Map<String, List<String>> paraListMap) throws Exception;
}
