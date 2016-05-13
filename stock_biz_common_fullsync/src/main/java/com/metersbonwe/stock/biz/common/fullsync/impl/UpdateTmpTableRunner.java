package com.metersbonwe.stock.biz.common.fullsync.impl;

import com.metersbonwe.stock.biz.common.service.ChangeFinalFreeShareStockService;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.biz.common.service.TmpTableService;
import com.metersbonwe.stock.biz.common.service.iocutils.SpringApplicationContextAware;
import com.metersbonwe.stock.configuration.ThreadConfig;
import com.metersbonwe.stock.dal.define.core.mapper.FullStockCoreDefineMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockWarehProd;

public class UpdateTmpTableRunner implements Runnable {

    private int                 tableIdx;

    private String              wmsLockedTableName;

    private ThreadConfig config;

    StockLog                    log = StockLogFactory.getLogger(UpdateTmpTableRunner.class);

    public UpdateTmpTableRunner(int tableIdx, String wmsLockedTableName, ThreadConfig config) {
        super();
        this.tableIdx = tableIdx;
        this.wmsLockedTableName = wmsLockedTableName;
        this.config = config;
    }

    @Override
    public void run() {
        String suffix = "";
        try {
            suffix = getMultiTableService().getMappingSuffix(tableIdx);
            
            updateWPandShopSafeStockDefault(suffix);

            updateWpSafeStock(suffix);

            updateNOSafeStock(suffix);
            
            updateShopSafeStock(suffix);

            updateShopDame(suffix);

            updateShopRemail(suffix);

            updateWmsStock(suffix);

            log.debug("正在清除stock_wareh_prod_" + suffix + "表数据");
            truncateTable("stock_wareh_prod_" + suffix);

            insertStockWarehProd(suffix);

            updateFinalFreeStock(suffix);
        } catch (Exception e) {
            log.error("全量同步插入数据出错" + suffix, e);
        } finally {
            config.threadDown();
        }
    }

    protected void updateWPandShopSafeStockDefault(String suffix) {
        log.debug("初始化WP和门店的安全库存：" + suffix);
        getMapper().updateShopSafeStockDefaultTmp(suffix);
    }

    protected void updateFinalFreeStock(String suffix) {
        log.debug("正在更新最终自由量stock_wareh_prod_" + suffix);
        StockWarehProd stockWarehProd = new StockWarehProd();
        stockWarehProd.setTableNum(suffix);
        try {
            getFinalFreeService().updateStockWarehProd(stockWarehProd);
        } catch (Exception e) {
            log.error("更新stock_wareh_prod_" + suffix + "最终自由量出错", e);
        }
    }

    protected void insertStockWarehProd(String suffix) {
        log.debug("正在插入stock_wareh_prod_" + suffix);
        getMapper().insertStockWarehProdTableFormTmp(suffix);
    }

    protected void updateWmsStock(String suffix) {
        log.debug("正在更新WMS正数锁定-" + suffix);
        getMapper().updateStockWmsLockedStock(suffix, wmsLockedTableName);
    }

    protected void updateShopRemail(String suffix) {
        log.debug("正在更新门店未日结-" + suffix);
        getMapper().updateShopRemail(suffix);
    }

    protected void updateShopDame(String suffix) {
        log.debug("正在更新门店污损值-" + suffix);
        getMapper().updateShopDame(suffix);
    }

    protected void updateShopSafeStock(String suffix) {
        log.debug("正在更新门店安全库存-" + suffix);
        getMapper().updateShopSafeStockTmp(suffix);
    }

    protected void updateWpSafeStock(String suffix) {
        log.debug("正在更新WP安全库存-" + suffix);
        getMapper().updateWpSafeStockTmp(suffix);
    }
    
    protected void updateNOSafeStock(String suffix) {
        log.debug("正在更新NO安全库存-" + suffix);
        getMapper().updateNOSafeStockTmp(suffix);
    }


    private FullStockCoreDefineMapper getMapper() {
        return SpringApplicationContextAware.getBean(FullStockCoreDefineMapper.class);
    }

    private MultiTableService getMultiTableService() {
        return SpringApplicationContextAware.getBean("multiTableServiceImpl", MultiTableService.class);
    }

    private ChangeFinalFreeShareStockService getFinalFreeService() {
        return SpringApplicationContextAware.getBean(ChangeFinalFreeShareStockService.class);
    }

    private void truncateTable(String tableName) {
        TmpTableService tmpTableServiceImpl = SpringApplicationContextAware.getBean(TmpTableService.class);
        tmpTableServiceImpl.truncateCoreTmpTable(tableName);
    }
}
