package com.metersbonwe.stock.biz.common.service.thread;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.biz.common.service.OnlineChannelStockService;
import com.metersbonwe.stock.biz.common.service.log.LogDetailUtils;
import com.metersbonwe.stock.configuration.ThreadConfig;
import com.metersbonwe.stock.dal.auto.core.mapper.LogStockDetailMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelSendedMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockCommonConfigMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.LogStockDetail;
import com.metersbonwe.stock.po.core.StockChannelSended;
import com.metersbonwe.stock.po.core.StockChannelSendedExample;
import com.metersbonwe.stock.po.core.StockCommonConfig;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.pojo.sync.PageBean;
import com.metersbonwe.stock.pojo.sync.PageIndexBean;
import com.mtsbw.business.configuration.inventory.domain.StockChannel;
import com.mtsbw.business.configuration.inventory.domain.StockUnitChannel;
import com.mtsbw.business.configuration.inventory.domain.UnitChannelActivity;

public class OnlineChannelStockThreadBean implements Runnable {

    private static StockLog          LOGGER = StockLogFactory.getLogger(OnlineChannelStockThreadBean.class);

    LogDetailUtils                   logDetailUtils;

    StockCommonConfigMapper          stockCommonConfigMapper;

    StockChannelSendedMapper         stockChannelSendedMapper;

    LogStockDetailMapper             logStockDetailMapper;

    OnlineChannelStockService        onlineChannelStockServiceImpl;

    // 获取所有渠道的最大 最小值
    Map<String, StockChannel>        minMaxs;

    // 获取所有参与渠道活动的商品  此类商品只同步独占库存
    Map<String, UnitChannelActivity> activityMap;

    // 获取所有管控了单元最小值的商品
    Map<String, StockUnitChannel>    cellMins;

    // 获取相同值时是否推送的时间间隔配置
    StockCommonConfig                commonConfig;

    List<ChannelProdBean>            channelProdBeans;

    ThreadConfig                     config;

    PageIndexBean                    indexBean;

    PageBean                         pageBean;

    public OnlineChannelStockThreadBean(LogDetailUtils logDetailUtils, StockCommonConfigMapper stockCommonConfigMapper,
            StockChannelSendedMapper stockChannelSendedMapper, LogStockDetailMapper logStockDetailMapper,
            OnlineChannelStockService onlineChannelStockServiceImpl, Map<String, UnitChannelActivity> activityMap, Map<String, StockChannel> minMaxs,
            Map<String, StockUnitChannel> cellMins, StockCommonConfig commonConfig, List<ChannelProdBean> channelProdBeans, ThreadConfig config,
            PageIndexBean indexBean, PageBean pageBean) {
        this.logDetailUtils = logDetailUtils;
        this.stockCommonConfigMapper = stockCommonConfigMapper;
        this.stockChannelSendedMapper = stockChannelSendedMapper;
        this.logStockDetailMapper = logStockDetailMapper;
        this.onlineChannelStockServiceImpl = onlineChannelStockServiceImpl;
        this.activityMap = activityMap;
        this.minMaxs = minMaxs;
        this.cellMins = cellMins;
        this.commonConfig = commonConfig;
        this.channelProdBeans = channelProdBeans;
        this.config = config;
        this.indexBean = indexBean;
        this.pageBean = pageBean;
    }

    public OnlineChannelStockThreadBean() {}

    @Override
    public void run() {
        try {
            for (int i = indexBean.getBegin(); i < indexBean.getEnd(); i++) {
                ChannelProdBean channelProdBean = null;
                try {
                    channelProdBean = channelProdBeans.get(i);
                    calOnlineStock(channelProdBean);
                } catch (Exception e) {
                    LOGGER.error(
                            "推送线上数据出错:" + e.getMessage() + ",参数:" + JSON.toJSONString(channelProdBean) + ",pageBean : " + pageBean + ",indexBean:"
                                    + indexBean + ",channelProdBeans:" + channelProdBeans.size(),
                            e);
                }
            }
        } finally {
            config.threadDown();
        }
    }

    public void calOnlineStock(ChannelProdBean channelProdBean) throws Exception {

        UnitChannelActivity activityFlag = activityMap.get(channelProdBean.getChannelCode() + "#" + channelProdBean.getProdId());
        StockUnitChannel cellMin = cellMins.get(channelProdBean.getChannelCode() + "#" + channelProdBean.getProdId());
        StockChannel minmax = minMaxs.get(channelProdBean.getChannelCode());
        // 如果没有配置全局最大最小值  用默认不管控
        if (minmax == null) {
            minmax = new StockChannel();
            minmax.setMinStock(Integer.MIN_VALUE);
            minmax.setMaxStock(Integer.MAX_VALUE);
        }

        // 是否是预售 1是 0否
        int preSale = channelProdBean.getIsPre();
        int shareStock = channelProdBean.getFinalFreeStock();
        int lockStock = channelProdBean.getLockStock();
        // 实物独占量
        int privateStock = channelProdBean.getPrivateStock() - channelProdBean.getOrderPrivateTotalStock() + channelProdBean.getShopGroupStock()
                - channelProdBean.getOrderShopGroupStock();
        // 预售独占量
        int prePrivateStock = channelProdBean.getPrePrivateStock() - channelProdBean.getPreOrderTotalStock();
        // 实物可用自由量
        int finalShareStock = shareStock + lockStock - channelProdBean.getOrderShareTotalStock();
        int finalStock = 0;

        if (activityFlag != null && preSale == 0) {
            // 实物且在活动状态 只同步独占库存
            finalStock = privateStock;
            finalStock = shareStock < 0 ? finalStock + shareStock : finalStock;
            finalStock = lockStock < 0 ? finalStock + lockStock : finalStock;
        } else {
            finalShareStock = preSale == 1 ? prePrivateStock : finalShareStock;
            if (cellMin != null && preSale == 0) {
                //实物时 渠道在单元最小值管控范围
                finalShareStock = finalShareStock < cellMin.getUnitMinStock().intValue() ? 0 : finalShareStock;
            } else if (cellMin == null && preSale == 0) {
                //实物时 渠道不在单元最小值管控中
                finalShareStock = finalShareStock < minmax.getMinStock() ? 0 : finalShareStock;
            }
            // 计算可用库存 = 共享+独占
            finalStock = preSale == 1 ? finalShareStock : (finalShareStock + privateStock);
        }
        finalStock = finalStock < 0 ? 0 : finalStock;
        // 渠道最大值过滤
        finalStock = finalStock > minmax.getMaxStock() ? minmax.getMaxStock() : finalStock;

        StockChannelSended sended = selectStockChannelSended(channelProdBean.getChannelCode(), channelProdBean.getProdId());

        if (sended != null && sended.getStockSended() == finalStock) {
            if (commonConfig != null
                    && (sended.getUpdateTime().getTime() + Long.valueOf(commonConfig.getConfigValue())) < System.currentTimeMillis()) {
                LOGGER.warn("库存相同且在设置时间间隔内不用推送，渠道:" + channelProdBean.getChannelCode() + ",商品:" + channelProdBean.getProdId() + ",库存:" + finalStock);
                return;
            }
        }
        channelProdBean.setOnlineStock(finalStock);
        insertAndUpdateData(channelProdBean); // 更新数据库
        try {
            getOmsApiAndSendData(channelProdBean); // 获取API 调用发送数据
        } catch (Exception e) {
            LOGGER.error("获取渠道中心接口推送线上库存出错,参数:" + JSON.toJSONString(channelProdBean) + "," + e.getMessage(), e);
        }
        insertOperLog(channelProdBean); // 插入操作日志表
    }

    private void getOmsApiAndSendData(ChannelProdBean channelProdBean) throws Exception {
        onlineChannelStockServiceImpl.getOmsApiAndSendData(channelProdBean);
    }

    private StockChannelSended selectStockChannelSended(String channelCode, String prodId) {
        StockChannelSended stockChannelSended = new StockChannelSended();
        stockChannelSended.setChannelCode(channelCode);
        stockChannelSended.setProdId(prodId);
        StockChannelSendedExample example = new StockChannelSendedExample();
        example.or().andChannelCodeEqualTo(channelCode).andProdIdEqualTo(prodId);
        List<StockChannelSended> sendeds = stockChannelSendedMapper.selectByExample(stockChannelSended, example);
        if (CollectionUtils.isNotEmpty(sendeds)) {
            stockChannelSended = sendeds.get(0);
        } else {
            stockChannelSended = null;
        }
        return stockChannelSended;
    }

    private void insertAndUpdateData(ChannelProdBean channelProdBean) throws Exception {
        StockChannelSended sended = new StockChannelSended();
        sended.setChannelCode(channelProdBean.getChannelCode());
        sended.setProdId(channelProdBean.getProdId());
        sended.setStockSended(channelProdBean.getOnlineStock());
        sended.setTableSuffix(channelProdBean.getTableSuffix());
        sended.setUpdateTime(new Date());
        StockChannelSendedExample example = new StockChannelSendedExample();
        example.or().andProdIdEqualTo(channelProdBean.getProdId());
        int result = stockChannelSendedMapper.updateByExampleSelective(sended, example);
        if (result <= 0) {
            stockChannelSendedMapper.insert(sended);
        }
    }

    private void insertOperLog(ChannelProdBean channelProdBean) throws Exception {
        LogStockDetail detail = new LogStockDetail();
        detail.setChannelCode(channelProdBean.getChannelCode());
        detail.setProdId(channelProdBean.getProdId());
        detail.setStock(channelProdBean.getOnlineStock());
        detail.setOrderSource(channelProdBean.getOperType());
        detail.setUpdateTime(new Date());
        logDetailUtils.insertLogDetail(detail);
    }
}
