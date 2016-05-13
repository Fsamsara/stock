package com.metersbonwe.stock.biz.schedule.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.metersbonwe.oms.api.ship.bean.ApiChannelGoods;
import com.metersbonwe.oms.channel.bean.ChannelApiResult;
import com.metersbonwe.oms.channel.service.ChannelService;
import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.biz.common.service.CacheService;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.dal.define.core.mapper.OrderOccupyAndReleaseDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelProdDetailDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelStatusDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.TmpStockChannelStatusDefineMapper;
import com.metersbonwe.stock.facade.schedule.ChannelProdIsSyncStockService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.TmpStockChannelStatus;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;

/**
 * @author zhq
 * @version V1.0
 * @description 渠道+款上下架是否同步进货与否定时对比调度任务接口实现
 * @date 2016/3/28
 */
@Service public class ChannelProdIsSyncStockServiceImpl implements ChannelProdIsSyncStockService {

    private static StockLog                      logger = StockLogFactory.getLogger(ChannelProdIsSyncStockServiceImpl.class);

    @Resource MqSendService                      mqSendServiceImpl;                                                          //推送线上提供的接口

    @Resource StockChannelStatusDefineMapper     stockChannelStatusDefineMapper;

    @Resource TmpStockChannelStatusDefineMapper  tmpStockChannelStatusDefineMapper;

    @Resource OrderOccupyAndReleaseDefineMapper  orderOccupyAndReleaseDefineMapper;

    @Resource StockChannelProdDetailDefineMapper stockChannelProdDetailDefineMapper;

    @Resource ChannelService                     channelService;

    @Resource AllocationRangeService             allocationRangeServiceImpl;

    @Resource CacheService                       cacheServiceImpl;

    /**
     * @param apiChannelGoods
     * @decription 将OMS接口传入的数据重新封装
     * @return
     */
    private List<TmpStockChannelStatus> convert(List<ApiChannelGoods> apiChannelGoods) {
        List<TmpStockChannelStatus> channelStatus = Lists.newArrayList();
        for (ApiChannelGoods apiGoods : apiChannelGoods) {
            TmpStockChannelStatus status = new TmpStockChannelStatus();
            status.setChannelCode(apiGoods.getShopCode());
            status.setSixProdId(apiGoods.getSku());
            status.setIsSync(apiGoods.getIsSyn().byteValue());
            status.setSaleStatus(apiGoods.getIsOnSell().toString());
            channelStatus.add(status);
        }
        return channelStatus;
    }

    /**
     * @decription 根据重新封装后的数据，查询推送线上的渠道+SKU明细
     * @param list
     * @return
     */
    private List<ChannelProdBean> selectChannelProdDetails(List<String> list, String channel) {
        return orderOccupyAndReleaseDefineMapper.selectChannelProdDetails(list, channel.toLowerCase());
    }

    @Override
    public void timedTaskChannelProdIsSyncStock() {
        try {
            long stimeTime = System.currentTimeMillis();
            logger.info("开始 渠道+款上下架是否同步进货与否定时对比调度任务");
            //1.从OMS中心获取渠道商品状态明细信息 (按渠道获取数据)
            List<String> channels = cacheServiceImpl.getAllUsefulChannelForCache();
            if (CollectionUtils.isNotEmpty(channels)) {
                for (String channel : channels) {
                    ChannelApiResult apiResult = channelService.getChannelGoods(channel, null, "1");
                    List<ApiChannelGoods> apiChannelGoods = apiResult.getChannelGoodsList();
                    List<TmpStockChannelStatus> tmpList = convert(apiChannelGoods);
                    logger.info("从OMS中心获取到的渠道商品明细【状态】数据量是：" + tmpList.size());
                    //2.将获取到的数据插入到tmp_stock_channel_status（渠道商品状态明细临时表）-->MYSql库
                    int num = tmpStockChannelStatusDefineMapper.insertList(tmpList);
                    logger.info("从OMS中心获取到的渠道商品明细【状态】数据插入到tmp_stock_channel_status结果是：" + num);
                    //3. 根据临时表和stock_channel_status表查询出变化的值
                    List<String> statuss = stockChannelStatusDefineMapper.selectChangedChannelsByTmp();
                    //4. 根据临时表更新 stock_channel_status表
                    this.stockChannelStatusDefineMapper.insertOrUpdateStatus();
                    //5.根据变化的值查询渠道和渠道子表推送
                    List<ChannelProdBean> cpbList = selectChannelProdDetails(statuss, channel);
                    //5.将查询到的渠道+SKU明细信息推送到线上MQ队列ONLINE_CHANNEL_STOCK
                    mqSendServiceImpl.sendToOnLineChannelStock(cpbList, channel);
                    logger.info("将查询到的渠道+SKU明细信息推送到线上MQ-->已完成");
                    //6.删除tmp_stock_channel_status的数据
                    this.tmpStockChannelStatusDefineMapper.deleteAll();
                }
            }
            logger.info("渠道+款上下架是否同步进货与否定时对比调度任务-->结束,该调度任务所用时间：" + (System.currentTimeMillis() - stimeTime));
        } catch (Exception e) {
            logger.error("渠道+款上下架是否同步进货与否定时对比调度任务出错," + e.getMessage(), e);
        }
    }

}
