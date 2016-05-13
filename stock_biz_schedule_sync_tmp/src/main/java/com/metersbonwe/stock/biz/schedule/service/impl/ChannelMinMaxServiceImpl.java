package com.metersbonwe.stock.biz.schedule.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelProdDetailDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpChannelMinmaxDefineMapper;
import com.metersbonwe.stock.facade.service.ChannelMinMaxService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.po.sync.TmpChannelMinmax;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.PageThreadLocal;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;

/**
 * @author zhq 渠道全局最大值、最小值变化定时任务实现类
 */
@Service public class ChannelMinMaxServiceImpl implements ChannelMinMaxService {

    private static StockLog                      logger = StockLogFactory.getLogger(ChannelMinMaxServiceImpl.class);

    @Resource TmpChannelMinmaxDefineMapper       tmpChannelMinmaxDefineMapper;

    @Resource StockChannelProdDetailDefineMapper stockChannelProdDetailDefineMapper;

    @Resource MqSendService                      mqSendServiceImpl;

    @Override
    public void handleChannelMinMaxChange(Map<String, String> parm) {
        String querySizeStr = parm.get("querySize");
        int querySize = 500;
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        Date stime = null;
        try {
            lock.lock();
            stime = new Date();
            logger.info("开始->渠道全局最大值、最小值变化定时任务");
            try {
                if (StringUtils.isNotBlank(querySizeStr)) {
                    querySize = Integer.valueOf(querySizeStr);
                }
                //非全量状态时的处理：				
                List<TmpChannelMinmax> tmpList = tmpChannelMinmaxDefineMapper.select();
                logger.info("获取TMP_CHANNEL_MINMAX  渠道最大-最小值变化临时表数据，要求根据渠道去重:" + tmpList.size());
                if (tmpList != null && tmpList.size() > 0) {
                    for (TmpChannelMinmax tmp : tmpList) {
                        Page<?> page = new Page<>();
                        page.setPageNo(1);
                        page.setPageSize(querySize);
                        PageThreadLocal.setThreadLocalPage(page);
                        stockChannelProdDetailDefineMapper.selectByChannelCode(tmp.getTableSuffix());
                        for (int i = 1; i <= page.getTotalPage(); i++) {
                            page.setPageNo(i);
                            page.setPageSize(querySize);
                            PageThreadLocal.setThreadLocalPage(page);
                            List<ChannelProdBean> reList = stockChannelProdDetailDefineMapper.selectByChannelCode(tmp.getTableSuffix());
                            if (CollectionUtils.isNotEmpty(reList)) {
                                mqSendServiceImpl.sendToOnLineChannelStock(reList, tmp.getChannelCode());
                            }
                            logger.debug("渠道最大、最小值变化分页查询渠道数据进度:" + i + " / " + page.getTotalPage() + ",当前渠道:" + tmp.getChannelCode());
                        }
                    }
                    this.tmpChannelMinmaxDefineMapper.deleteByMaxId(tmpList.get(0).getId().intValue());
                    logger.info("删除小于等于最大ID的临时表TMP_CHANNEL_MINMAX数据");
                }

            } catch (Exception e) {
                logger.debug("渠道全局最大值、最小值变化定时任务handleChannelMinMaxChange方法有异常", e);
            }

        } finally {
            logger.info("渠道全局最大值、最小值变化定时任务->结束" + (new Date().getTime() - stime.getTime()));
            lock.unlock();
        }

    }

}
