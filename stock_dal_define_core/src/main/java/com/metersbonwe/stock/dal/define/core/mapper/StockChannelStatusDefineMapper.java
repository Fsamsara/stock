package com.metersbonwe.stock.dal.define.core.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.metersbonwe.stock.po.core.StockChannelStatus;
import com.metersbonwe.stock.pojo.PageStockChannelStatusBean;

/**
 * @author 张洪琴
 */
@Repository public interface StockChannelStatusDefineMapper {

    /**
     * @param stockChannelStatus
     *            单个数据的replace into （插入或替换）
     * @return
     */
    public int insertOrReplace(StockChannelStatus stockChannelStatus);

    /**
     * @param stockChannelStatusList
     * @return 多个数据的replace into （插入或替换）
     */
    public int insertOrReplaceList(List<StockChannelStatus> stockChannelStatusList);

    /**
     * @description 根据 tmp_stock_channel_status的数据 更新 stock_channel_status表
     * @return
     */
    public int updateByTmp();

    /**
     * TODO 更新或插入数据
     *
     * @return
     */
    public int insertOrUpdateStatus();

    /**
     * TODO 根据临时表查询出需要更新的推送的数据
     *
     * @return
     */
    public List<String> selectChangedChannelsByTmp();
    
    /**
     * 页面查询
     * @param stockChannelStatus
     * @return
     */
    public List<StockChannelStatus> selectStockChannelStatus(PageStockChannelStatusBean stockChannelStatusBean);
}
