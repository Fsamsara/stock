package com.metersbonwe.stock.biz.schedule.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelProdDetailDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpChannelCellMinDefineMapper;
import com.metersbonwe.stock.facade.service.ChannelCellMinService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.po.sync.TmpChannelCellMin;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;

/**
 * @author zhq 渠道单元最小值变化定时任务
 */
@Service public class ChannelCellMinServiceImpl implements ChannelCellMinService {

    private static StockLog                      logger = StockLogFactory.getLogger(ChannelCellMinServiceImpl.class);

    @Resource TmpChannelCellMinDefineMapper      tmpChannelCellMinDefineMapper;

    @Resource StockChannelProdDetailDefineMapper stockChannelProdDetailDefineMapper;

    @Resource MqSendService                      mqSendServiceImpl;

    @Override
    public void handleChannelCellMinChange() {
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        Date stime = null;
        try {
            lock.lock();
            stime = new Date();
            logger.info("开始 渠道单元最小值变化定时任务");
            try {

                List<TmpChannelCellMin> tmpList = this.tmpChannelCellMinDefineMapper.select();
                logger.info("获取渠道单元最小值临时表TMP_CHANNEL_CELL_MIN数据，根据渠道+SKU去重后的数据量:" + (tmpList == null ? 0 : tmpList.size()));
                if (tmpList != null && tmpList.size() > 0) {
                    // 优化 by zhangfeng
                    Map<String, List<TmpChannelCellMin>> map = Maps.newConcurrentMap();
                    for (TmpChannelCellMin tmpChannelCellMin : tmpList) {
                        String channelCode = tmpChannelCellMin.getChannelCode();
                        List<TmpChannelCellMin> list = Lists.newArrayList();
                        if (map.containsKey(channelCode)) {
                            map.get(channelCode).add(tmpChannelCellMin);
                        } else {
                            list.add(tmpChannelCellMin);
                            map.put(channelCode, list);
                        }
                    }
                    int count = 0;
                    for (String channelCode : map.keySet()) {
                        List<ChannelProdBean> beanList = stockChannelProdDetailDefineMapper
                                .selectByChannelCodeAndSkus(channelCode.toLowerCase(), map.get(channelCode));
                        if (CollectionUtils.isNotEmpty(beanList)) {
                            mqSendServiceImpl.sendToOnLineChannelStock(beanList, channelCode);
                            count += beanList.size();
                        }
                    }

                    logger.info("循环渠道单元最小值临时表去重后的数据，根据每个item中的渠道ID，商品ID查询渠道+SKU的明细数量：" + count);

                    int num = this.tmpChannelCellMinDefineMapper.deleteByMaxId(tmpList.get(0).getId().intValue());
                    logger.info("根据去重后的临表数据中的最大ID，删除小于等于当前ID的信息的行数：" + num);
                }

            } catch (Exception e) {
                logger.debug("渠道单元最小值变化定时任务handleChannelCellMinChange方法有异常", e);
            }

        } finally {
            logger.info("渠道单元最小值变化定时任务-->结束,用时：" + (new Date().getTime() - stime.getTime()));
            lock.unlock();
        }
    }

}
