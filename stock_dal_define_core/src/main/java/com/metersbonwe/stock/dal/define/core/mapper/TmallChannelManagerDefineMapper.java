package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;

import com.metersbonwe.stock.po.core.StockChannelIncrement;
import com.metersbonwe.stock.po.core.StockChannelIncrementSub;
import com.metersbonwe.stock.pojo.TmallChannelManagerQueryBean;
import com.metersbonwe.stock.pojo.TmallChannelManagerSubQueryBean;

public interface TmallChannelManagerDefineMapper {

    /**
     * 查询天猫库存同步管理信息
     * @param queryBean
     * @return
     */
    List<StockChannelIncrement> selectTmallChannelManagerInfos(TmallChannelManagerQueryBean queryBean);

    /**
     * 查询天猫库存同步管理明细信息
     * @param subQueryBean
     * @return
     */
    List<StockChannelIncrementSub> selectTmallChannelManagerDetailInfos(TmallChannelManagerSubQueryBean subQueryBean);

}
