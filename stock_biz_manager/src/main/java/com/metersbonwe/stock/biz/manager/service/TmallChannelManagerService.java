package com.metersbonwe.stock.biz.manager.service;

import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.po.core.StockChannelIncrement;
import com.metersbonwe.stock.po.core.StockChannelIncrementSub;

public interface TmallChannelManagerService {

    /**
     * 查询天猫库存同步管理信息
     * @param paramListMap
     * @return
     */
    public List<StockChannelIncrement> selectTmallChannelManagerInfos(Map<String, List<String>> paramListMap);

    /**
     * 查询天猫库存同步管理明细信息
     * @param paramListMap
     * @return
     */
    public List<StockChannelIncrementSub> selectTmallChannelManagerDetailInfos(Map<String, String> paramListMap);

    /**
     * 查询同步明细信息是否存在并返回
     * @param paramListMap
     * @return
     */
    public List<StockChannelIncrementSub> isExistTmallChannelManagerDetailInfo(Map<String, String> paramMap);

    /**
     * 新增同步明细信息
     * @param paramListMap
     * @return
     */
    public Integer addTmallChannelManagerDetailInfo(Map<String, String> paramMap);

}
