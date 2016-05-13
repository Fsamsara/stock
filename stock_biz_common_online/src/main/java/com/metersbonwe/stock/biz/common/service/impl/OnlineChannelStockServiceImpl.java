package com.metersbonwe.stock.biz.common.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.metersbonwe.oms.api.ship.bean.ApiChannelGoods;
import com.metersbonwe.oms.channel.bean.ChannelApiResult;
import com.metersbonwe.oms.channel.bean.SyncStockParam;
import com.metersbonwe.oms.channel.service.ChannelService;
import com.metersbonwe.oms.channel.service.SynChannelStockService;
import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.OnlineChannelStockService;
import com.metersbonwe.stock.biz.common.service.log.LogDetailUtils;
import com.metersbonwe.stock.biz.common.service.thread.OnlineChannelStockThreadBean;
import com.metersbonwe.stock.configuration.ThreadConfig;
import com.metersbonwe.stock.configuration.ThreadConfigFactory;
import com.metersbonwe.stock.dal.auto.core.mapper.LogStockDetailMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelSendedMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockCommonConfigMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelStatus;
import com.metersbonwe.stock.po.core.StockCommonConfig;
import com.metersbonwe.stock.po.core.StockCommonConfigExample;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.po.sync.TmpChannelCellMin;
import com.metersbonwe.stock.pojo.sync.PageBean;
import com.metersbonwe.stock.pojo.sync.PageIndexBean;
import com.mtsbw.business.configuration.inventory.domain.StockChannel;
import com.mtsbw.business.configuration.inventory.domain.StockUnitChannel;
import com.mtsbw.business.configuration.inventory.domain.UnitChannelActivity;
import com.mtsbw.business.configuration.inventory.dubbo.api.IStockChannelServiceDubbo;
import com.mtsbw.business.configuration.inventory.dubbo.api.IStockUnitChannelServiceDubbo;
import com.mtsbw.business.configuration.inventory.dubbo.api.IUnitChannelActivityServiceDubbo;

/**
 * TODO 推送线上通用服务
 * 
 * @author zhangfeng zhangfeng13@metersbonwe.com
 * @date 2016年3月26日 下午2:24:11
 * @since V1.0
 * @version V1.0
 */
@Service public class OnlineChannelStockServiceImpl implements OnlineChannelStockService {

    private static StockLog                    LOGGER = StockLogFactory.getLogger(OnlineChannelStockServiceImpl.class);

    @Resource LogDetailUtils                   logDetailUtils;

    @Resource StockCommonConfigMapper          stockCommonConfigMapper;

    @Resource StockChannelSendedMapper         stockChannelSendedMapper;

    @Resource LogStockDetailMapper             logStockDetailMapper;

    @Resource ThreadPoolTaskExecutor           stockCommonExecutor;

    @Resource IUnitChannelActivityServiceDubbo unitChannelActivityServiceDubbo;

    @Resource IStockUnitChannelServiceDubbo    stockUnitChannelServiceDubbo;

    @Resource IStockChannelServiceDubbo        stockChannelServiceDubbo;

    @Resource ChannelService                   channelService;

    @Resource SynChannelStockService           synChannelStockService;

    @Override
    public void proccessToOnlineList(List<ChannelProdBean> channelProdBeans) throws Exception {

        LOGGER.debug("进入推送线上队列消费流程，获取参数对象数量:" + (channelProdBeans == null ? 0 : channelProdBeans.size()));

        long timeStart = System.currentTimeMillis();
        try {

            if (CollectionUtils.isNotEmpty(channelProdBeans)) {

                List<UnitChannelActivity> activitys = new ArrayList<>();
                List<StockUnitChannel> cells = new ArrayList<>();
                List<String> channelCodes = new ArrayList<>();
                for (ChannelProdBean channelProdBean : channelProdBeans) {
                    StockUnitChannel channel = new StockUnitChannel();
                    channel.setProdCode(channelProdBean.getProdId().substring(0, 6));
                    channel.setUnitChannelCode(channelProdBean.getChannelCode());
                    cells.add(channel);
                    UnitChannelActivity activity = new UnitChannelActivity();
                    activity.setChannelCode(channelProdBean.getChannelCode());
                    activity.setGoodsCode(channelProdBean.getProdId());
                    activitys.add(activity);
                    channelCodes.add(channelProdBean.getChannelCode());
                }

                // 获取所有渠道的最大 最小值
                Map<String, StockChannel> minMaxs = getChannelMinmax(channelCodes);
                // 获取所有参与渠道活动的商品  此类商品只同步独占库存
                Map<String, UnitChannelActivity> activityMap = getOnActivityProds(activitys);
                // 获取所有管控了单元最小值的商品
                Map<String, StockUnitChannel> cellMins = getChannelCellMin(cells);

                // 获取相同值时是否推送的时间间隔配置
                StockCommonConfig commonConfig = selectStockCommonCofig(Constants.ONLINE_INTERVAL_TIME);

                ThreadConfig config = ThreadConfigFactory.getThreadConfig(Constants.THREAD_CONFIG_BIZNAME_SEND_ONLINE);

                PageBean pageBean = new PageBean(channelProdBeans.size() / config.getMaxThreadCount() + 1, channelProdBeans.size());

                while (pageBean.hasNext()) {
                    config.waitThreadPoolNotEmpty();
                    config.threadUp();
                    PageIndexBean indexBean = pageBean.next();

                    OnlineChannelStockThreadBean threadBean = new OnlineChannelStockThreadBean(logDetailUtils, stockCommonConfigMapper,
                            stockChannelSendedMapper, logStockDetailMapper, this, activityMap, minMaxs, cellMins, commonConfig, channelProdBeans,
                            config, indexBean, pageBean);
                    stockCommonExecutor.execute(threadBean);
                }
                config.waitAllThreadDown();
            }
        } catch (Exception e) {
            LOGGER.error("批量处理推送线上流程出错," + e.getMessage(), e);
            throw e;
        }
        LOGGER.debug("进入推送线上队列消费流程，结束，耗时:" + (System.currentTimeMillis() - timeStart) / 1000 + "秒");
    }

    @Override
    public void getOmsApiAndSendDatas(List<ChannelProdBean> channelProdBeans) throws Exception {
        List<SyncStockParam> params = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(channelProdBeans) && channelProdBeans.size() > 0) {
            for (ChannelProdBean channelProdBean : channelProdBeans) {
                SyncStockParam param = new SyncStockParam();
                param.setShopCode(channelProdBean.getChannelCode());
                param.setSku(channelProdBean.getProdId());
                param.setStockCount(channelProdBean.getOnlineStock());
                params.add(param);
            }
            LOGGER.debug("获取线上渠道接口并推送，推送数据:" + params.size());
            synChannelStockService.synStock(params);
        }
    }

    @Override
    public void getOmsApiAndSendData(ChannelProdBean channelProdBean) throws Exception {
        List<ChannelProdBean> channelProdBeans = new ArrayList<>();
        channelProdBeans.add(channelProdBean);
        getOmsApiAndSendDatas(channelProdBeans);
    }

    private StockCommonConfig selectStockCommonCofig(String onlineIntervalTime) {
        StockCommonConfig commonConfig = null;
        StockCommonConfigExample example = new StockCommonConfigExample();
        example.or().andConfigNameEqualTo(onlineIntervalTime);
        List<StockCommonConfig> commonConfigs = stockCommonConfigMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(commonConfigs)) {
            commonConfig = commonConfigs.get(0);
        }
        return commonConfig;
    }

    @Override
    public StockChannelStatus getChannelProdStatus(String channelCode, String prod) throws Exception {
        StockChannelStatus status = null;
        ChannelApiResult<?> result = channelService.getChannelGoods(channelCode, prod, "1");
        List<ApiChannelGoods> goods = result.getChannelGoodsList();
        if (CollectionUtils.isNotEmpty(goods) && goods.size() == 1) {
            status = new StockChannelStatus();
            ApiChannelGoods good = goods.get(0);
            status.setChannelCode(good.getShopCode());
            status.setSixProdId(good.getSku());
            status.setIsSync(good.getIsSyn().byteValue());
            status.setSaleStatus(good.getIsOnSell().toString());
        }
        return status;
    }

    @Override
    public Map<String, StockChannel> getChannelMinmax(List<String> channelCodes) throws Exception {
        Map<String, StockChannel> map = Maps.newConcurrentMap();
        //        List<StockChannel> reChannels = stockChannelServiceDubbo.getStockChannelList(channelCodes);
        // 测试代码  begin
        List<StockChannel> reChannels = Lists.newArrayList();
        for (String channel : channelCodes) {
            StockChannel channelBean = new StockChannel();
            channelBean.setChannelCode(channel);
            channelBean.setMaxStock(100000);
            channelBean.setMinStock(0);
            reChannels.add(channelBean);
        }
        // 测试代码 end
        if (CollectionUtils.isNotEmpty(reChannels)) {
            for (StockChannel stockChannel : reChannels) {
                map.put(stockChannel.getChannelCode(), stockChannel);
            }
        }
        return map;
    }

    @Override
    public Boolean isOnActivity(String channelCode, String prodId) throws Exception {
        Boolean flag = false;
        UnitChannelActivity activity = new UnitChannelActivity();
        activity.setChannelCode(channelCode);
        activity.setGoodsCode(prodId);
        List<UnitChannelActivity> activitys = Lists.newArrayList();
        activitys.add(activity);
        List<UnitChannelActivity> reActivities = unitChannelActivityServiceDubbo.getUnitChannelActivityList(activitys);
        if (CollectionUtils.isNotEmpty(reActivities)) {
            flag = true;
        }
        return flag;
    }

    private Map<String, UnitChannelActivity> getOnActivityProds(List<UnitChannelActivity> activitys) throws Exception {
        Map<String, UnitChannelActivity> activities = Maps.newConcurrentMap();
        //        List<UnitChannelActivity> reActivities = unitChannelActivityServiceDubbo.getUnitChannelActivityList(activitys);
        // 测试代码 begin
        List<UnitChannelActivity> reActivities = Lists.newArrayList();
        // 测试代码 end
        if (CollectionUtils.isNotEmpty(reActivities)) {
            for (UnitChannelActivity unitChannelActivity : reActivities) {
                activities.put(unitChannelActivity.getChannelCode() + "#" + unitChannelActivity.getGoodsCode(), unitChannelActivity);
            }
        }
        return activities;
    }

    @Override
    public TmpChannelCellMin getChannelCellMin(String channelCode, String prodId) throws Exception {
        TmpChannelCellMin tmpChannelCellMin = new TmpChannelCellMin();
        tmpChannelCellMin.setChannelCellMin(new BigDecimal(5));
        tmpChannelCellMin.setChannelCode(channelCode);
        tmpChannelCellMin.setProdId(prodId);
        return tmpChannelCellMin;
    }

    private Map<String, StockUnitChannel> getChannelCellMin(List<StockUnitChannel> cells) throws Exception {
        Map<String, StockUnitChannel> map = Maps.newConcurrentMap();
        //        List<StockUnitChannel> reStockUnitChannels = stockUnitChannelServiceDubbo.getStockUnitChannelList(cells);
        // 测试代码 begin
        List<StockUnitChannel> reStockUnitChannels = Lists.newArrayList();
        // 测试代码 end
        if (CollectionUtils.isNotEmpty(reStockUnitChannels)) {
            for (StockUnitChannel stockUnitChannel : reStockUnitChannels) {
                map.put(stockUnitChannel.getUnitChannelCode() + "#" + stockUnitChannel.getProdCode(), stockUnitChannel);
            }
        }
        return map;
    }

    @Override
    public void proccessToOnline(ChannelProdBean channelProdBean) throws Exception {
        List<ChannelProdBean> beans = Lists.newArrayList();
        beans.add(channelProdBean);
        proccessToOnlineList(beans);
    }
}
