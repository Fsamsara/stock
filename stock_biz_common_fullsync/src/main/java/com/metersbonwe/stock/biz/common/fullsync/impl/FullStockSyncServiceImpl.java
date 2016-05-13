package com.metersbonwe.stock.biz.common.fullsync.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.fullsync.ThirdPartyStockSyncService;
import com.metersbonwe.stock.biz.common.fullsync.invoke.StockFullSyncExector;
import com.metersbonwe.stock.biz.common.service.ChangeFinalFreeShareStockService;
import com.metersbonwe.stock.biz.common.service.ChannelCalService;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.biz.common.service.TmpTableService;
import com.metersbonwe.stock.biz.common.service.WmsLockedStockService;
import com.metersbonwe.stock.biz.common.service.iocutils.SpringApplicationContextAware;
import com.metersbonwe.stock.configuration.ThreadConfig;
import com.metersbonwe.stock.configuration.ThreadConfigFactory;
import com.metersbonwe.stock.facade.sync.api.FullStockSyncService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;

/**
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-3-26 下午2:05:54
 */
@Service public class FullStockSyncServiceImpl implements FullStockSyncService {

    @Autowired SpringApplicationContextAware   springContextUtil;

    @Resource TmpTableService                  tmpTableServiceImpl;

    @Resource MultiTableService                multiTableServiceImpl;

    @Resource ThreadPoolTaskExecutor           stockCommonExecutor;

    @Resource ChangeFinalFreeShareStockService changeFinalFreeShareStockServiceImpl;

    @Resource WmsLockedStockService            wmsLockedStockServiceImpl;

    @Resource StockFullSyncExector             stockFullSyncExector;

    @Resource ChannelCalService                channelCalServiceImpl;

    @Resource ThirdPartyStockSyncService       thirdPartyStockSyncServiceImpl;

    StockLog                                   log = StockLogFactory.getLogger(FullStockSyncServiceImpl.class);

    @Override
    public void performFullStockSync() {
        Lock lock = FullStockSyncLock.getLock().writeLock();
        try {
            log.debug("全量同步准备获取写入锁");
            lock.lock();
            log.debug("全量同步已经获取写入锁");
            long b = System.currentTimeMillis();
            syncData(b);
            long bget = System.currentTimeMillis();
            int maxSeq = multiTableServiceImpl.getMaxTableSeq() + 1; // 最大表序列
            log.debug("一共有" + maxSeq + "张表需要处理");
            //更新核心库临时表  并且写入仓+sku业务表
            updateCoreDBTmpTable(maxSeq);
            log.debug("更新到仓库+sku共耗时:" + (System.currentTimeMillis() - bget));
            long bsku = System.currentTimeMillis();
            //调用渠道全量汇总
            channelCalServiceImpl.processChannelUsefulWarehChange(true);
            log.debug("渠道汇总共耗时:" + (System.currentTimeMillis() - bsku) + ",全量同步共耗时:" + (System.currentTimeMillis() - b));
        } catch (Exception e) {
            log.error("全量同步执行失败 ", e);
        } finally {
            log.debug("全量同步准备释放写入锁");
            lock.unlock();
            log.debug("全量同步已经释放写入锁");
        }
    }

    protected void syncData(long b) {
        clearTableData(); //清除表数据
        try {
            thirdPartyStockSyncServiceImpl.syncTpStock();
            ThreadConfig config = createThreadConfig();
            log.debug("全量同步配置信息" + config);
            stockFullSyncExector.preform(config);
        } catch (SQLException | IOException e) {
            log.error("从同步库拉取库存数据出错" + e.getMessage(), e);
        }
        log.debug("拉取数据共耗时:" + (System.currentTimeMillis() - b));
    }

    protected ThreadConfig createThreadConfig() {
        return ThreadConfigFactory.getThreadConfig(Constants.THREAD_CONFIG_BIZNAME_FULLSYNC);
    }

    private void clearTableData() {
        int maxSeq = multiTableServiceImpl.getMaxTableSeq(); // 最大表序列
        for (int i = 0; i <= maxSeq; i++) {
            String suffix = multiTableServiceImpl.getMappingSuffix(i);
            //            清除自由量临时表
            log.debug("清除自由量临时表 : " + "tmp_stock_wareh_prod_free_" + suffix);
            truncateTable("tmp_stock_wareh_prod_free_" + suffix);

            //            清除锁定量临时表  
            log.debug("清除锁定量临时表   : " + "tmp_stock_wareh_prod_lock_" + suffix);
            truncateTable("tmp_stock_wareh_prod_lock_" + suffix);
        }
        truncateTable("tmp_shop_remail");
        log.debug("清除门店未日结临时表 : " + "tmp_shop_remail");
    }

    private void truncateTable(String tableName) {
        tmpTableServiceImpl.truncateCoreTmpTable(tableName);
    }

    private void updateCoreDBTmpTable(int maxSeq) {
        ThreadConfig tmpconfig = ThreadConfigFactory.getThreadConfig(Constants.THREAD_CONFIG_BIZNAME_FULLSYNCMYSQL);

        String wmsLockedTableName = wmsLockedStockServiceImpl.getCurrentWmsLockedStockTableName();

        for (int i = 0; i < maxSeq; i++) {
            tmpconfig.waitThreadPoolNotEmpty();
            tmpconfig.threadUp();
            stockCommonExecutor.execute(new UpdateTmpTableRunner(i, wmsLockedTableName, tmpconfig));
        }
        tmpconfig.waitAllThreadDown();
    }

}
