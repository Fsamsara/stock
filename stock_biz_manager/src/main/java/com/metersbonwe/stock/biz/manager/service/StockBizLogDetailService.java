package com.metersbonwe.stock.biz.manager.service;

import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.po.core.StockBizLogDetails;

public interface StockBizLogDetailService {
    /**
     * TODO 业务日志查询
     *
     * @param dameVo
     * @return
     * @throws Exception
     */
    List<StockBizLogDetails> selectStockBizLogDetail(Map<String, List<String>> paraListMap) throws Exception;
}
