package com.metersbonwe.stock.biz.manager.service;

import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.po.core.TmpStockWms;

public interface TmpStockWmsService {
    /**
     * TODO 条件查询门店安全库存
     *
     * @param dameVo
     * @return
     * @throws Exception
     */
    List<TmpStockWms> selectTmpStockWms(Map<String, List<String>> paraListMap) throws Exception;
}
