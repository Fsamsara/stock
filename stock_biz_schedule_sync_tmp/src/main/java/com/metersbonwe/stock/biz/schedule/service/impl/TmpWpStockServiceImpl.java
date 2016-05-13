package com.metersbonwe.stock.biz.schedule.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.ChangeFinalFreeShareStockService;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.impl.MultiTableServiceImpl;
import com.metersbonwe.stock.biz.schedule.thread.TmpWpStockConsumerRunnable;
import com.metersbonwe.stock.configuration.ThreadConfig;
import com.metersbonwe.stock.configuration.ThreadConfigFactory;
import com.metersbonwe.stock.dal.auto.core.mapper.StockWpSafeMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockWpSafeTranMapper;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpWpStockMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpWpStockDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.UdWarehParamDefineMapper;
import com.metersbonwe.stock.facade.schedule.TmpWpStockService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpWpStock;
import com.metersbonwe.stock.po.sync.define.UdWarehParamDefine;
import com.metersbonwe.stock.pojo.TmpWpStockGlobalBean;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;

@Service public class TmpWpStockServiceImpl implements TmpWpStockService {
    private static StockLog                                                stockLog     = StockLogFactory.getLogger(TmpWpStockServiceImpl.class);

    private final String                                                   SERVICE_NAME = "WP安全库存变化临时表流程处理";

    @Autowired TmpWpStockDefineMapper                                      tmpWpStockDefineMapper;

    @Autowired TmpWpStockMapper                                            tmpWpStockMapper;

    @Autowired StockWpSafeMapper                                           stockWpSafeMapper;

    @Autowired StockWpSafeTranMapper                                       stockWpSafeTranMapper;

    @Autowired ChangeFinalFreeShareStockService                            changeFinalFreeShareStockService;

    @Autowired MultiTableServiceImpl                                       multiTableServiceImpl;

    @Autowired MqSendService                                               mqSendService;

    @Autowired UdWarehParamDefineMapper                                    udWarehParamDefineMapper;

    private Map<String, String>                                            map;

    @Resource(name = "stockCommonExecutor") private ThreadPoolTaskExecutor stockCommonExecutor;

    @Override
    public void doService() {
        stockLog.info(SERVICE_NAME + "开始运行");
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        try {
            lock.lock();
            //检查仓库安全库存类型是否是WP，不是的话返回
            map = new HashMap<String, String>();
            List<UdWarehParamDefine> udWarehs = udWarehParamDefineMapper.selectAllForB2C();
            for (UdWarehParamDefine udWarehParamDefine : udWarehs) {
                if (!map.containsKey(udWarehParamDefine.getCode())) {
                    map.put(udWarehParamDefine.getCode(), udWarehParamDefine.getOnlineSafeqtyType());
                }
            }
            TmpWpStockGlobalBean TmpWpStockGlobalBean = new TmpWpStockGlobalBean();
            ThreadConfig threadConfig = ThreadConfigFactory.getThreadConfig(Constants.THREAD_CONFIG_BIZNAME_SHOPSAFE);
            TmpWpStockGlobalBean.setMaxDataCount(threadConfig.getSize());
            while (true) {
                Long time1 = System.currentTimeMillis();
                //同步库去重获取tmp_wp_stock数据
                List<TmpWpStock> tmpWpStocks = getTmpWpStockDeleteRepeat(TmpWpStockGlobalBean);
                stockLog.debug("同步库去重获取数据tmpWpStocks:" + tmpWpStocks.size());
                Long time2 = System.currentTimeMillis();
                stockLog.info("获取仓库WP安全库存信息" + tmpWpStocks.size() + "条，耗时：" + (time2 - time1) + "ms");
                if (tmpWpStocks.size() == 0) {
                    break;
                } else {
                    time1 = System.currentTimeMillis();
                    stockLog.debug("开始循环tmpWpStocks");
                    for (TmpWpStock tmpWpStock : tmpWpStocks) {
                        threadConfig.waitThreadPoolNotEmpty();
                        threadConfig.threadUp();

                        TmpWpStockConsumerRunnable r = new TmpWpStockConsumerRunnable();
                        r.setChangeFinalFreeShareStockService(changeFinalFreeShareStockService);
                        r.setMap(map);
                        r.setMqSendService(mqSendService);
                        r.setMultiTableServiceImpl(multiTableServiceImpl);
                        r.setStockWpSafeMapper(stockWpSafeMapper);
                        r.setStockWpSafeTranMapper(stockWpSafeTranMapper);
                        r.setThreadConfig(threadConfig);
                        r.setTmpWpStock(tmpWpStock);
                        r.setTmpWpStockMapper(tmpWpStockMapper);
                        r.setUdWarehParamDefineMapper(udWarehParamDefineMapper);
                        stockCommonExecutor.execute(r);
                    }
                    threadConfig.waitAllThreadDown();
                    stockLog.debug("结束循环tmpWpStocks");
                    time2 = System.currentTimeMillis();
                    stockLog.info("处理仓库WP安全库存信息耗时：" + (time2 - time1) + "ms");
                }

            }
        } catch (Exception e) {
            stockLog.error(SERVICE_NAME + "出错", e);
        } finally {
            lock.unlock();
            stockLog.info(SERVICE_NAME + "结束运行");
        }
    }

    /**
     * 同步库去重获取tmp_wp_stock数据
     * 
     * @return
     */
    private List<TmpWpStock> getTmpWpStockDeleteRepeat(TmpWpStockGlobalBean tmpWpStockGlobalBean) {
        return tmpWpStockDefineMapper.selectAllDeleteRepeat(tmpWpStockGlobalBean);
    }

}
