package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.metersbonwe.stock.po.core.TmpStockChannelStatus;

/**
 * @author zhq
 */
@Repository public interface TmpStockChannelStatusDefineMapper {

    /**
     * @description 批量插入数据
     * @param list
     * @return
     */
    public int insertList(List<TmpStockChannelStatus> list);

    /**
     * @description 删除tmp_stock_channel_status临时表所有数据
     * @return
     */
    public int deleteAll();

}
