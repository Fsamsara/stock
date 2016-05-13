package com.metersbonwe.stock.biz.common.service;


import java.util.List;
import java.util.Map;

import com.metersbonwe.stock.po.core.StockChannelStatus;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.po.sync.TmpChannelCellMin;
import com.mtsbw.business.configuration.inventory.domain.StockChannel;

/**
 * TODO 推送线上通用服务
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年3月26日 下午2:24:11
 * @since V1.0
 * @version V1.0
 */
public interface OnlineChannelStockService {
    /**
     * TODO 推送线上流程
     *
     * @param channelProdBean
     *            需要推送线上的数据对象
     */
    void proccessToOnline(ChannelProdBean channelProdBean) throws Exception;

    /**
     * TODO 推送线上流程 （批量）
     *
     * @param channelProdBean
     *            需要推送线上的数据对象
     */
    void proccessToOnlineList(List<ChannelProdBean> channelProdBeans) throws Exception;

    /**
     * TODO 通过渠道+款号获取状态
     *
     * @param channelCode
     *            渠道编码
     * @param prod
     *            6位商品码
     * @return
     */
    StockChannelStatus getChannelProdStatus(String channelCode, String prod) throws Exception;

    /**
     * TODO 获取渠道全局最小值、最大值
     *
     * @param channelCode
     * @return
     */
    Map<String, StockChannel> getChannelMinmax(List<String> channelCodes) throws Exception;

    /**
     * TODO 获取渠道单元最小值
     *
     * @param channelCode
     *            渠道码
     * @param prodId
     *            商品码
     * @return
     */
    TmpChannelCellMin getChannelCellMin(String channelCode, String prodId) throws Exception;

    /**
     * TODO 获取渠道商品是否参与活动
     *
     * @param channelCode
     *            渠道码
     * @param prodId
     *            商品码
     * @return
     */
    Boolean isOnActivity(String channelCode, String prodId) throws Exception;

    /**
     * TODO 获取API推送数据
     *
     * @param channelProdBean
     */
    void getOmsApiAndSendDatas(List<ChannelProdBean> channelProdBeans) throws Exception;

    /**
     * TODO 获取API推送数据
     *
     * @param channelProdBean
     */
    void getOmsApiAndSendData(ChannelProdBean channelProdBean) throws Exception;
}
