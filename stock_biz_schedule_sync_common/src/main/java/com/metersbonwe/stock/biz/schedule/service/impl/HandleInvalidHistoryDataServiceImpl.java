package com.metersbonwe.stock.biz.schedule.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.dal.define.core.mapper.StockCommonConfigDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockShopDameDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockShopSafeDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockWarehProdDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockWpSafeDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.ErpWarehProdDefineMapper;
import com.metersbonwe.stock.facade.service.HandleInvalidHistoryDataService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockCommonConfig;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;

/**
 * @author zhq
 * @decription 无效污次少洗历史数据删除/无效的门店安全库存删除/无效的仓库安全库存删除定时任务 实现类
 * @version V1.0
 * @date 2016/03/29
 */
@Service public class HandleInvalidHistoryDataServiceImpl implements HandleInvalidHistoryDataService {

    public static String                    CONFIG_NAME_SHOPDAME  = "VALID_SHOP_DAME";                                                   //通用配置表中无效污次少洗数据有效时间  配置类型

    public static String                    CONFIG_NAME_SHOPSAFE  = "VALID_SHOP_SAFE";                                                   //通用配置表中无效门店安全数据有效时间  配置类型

    public static String                    CONFIG_NAME_WAREHSAFE = "VALID_WAREH_SAFE";                                                  //通用配置表中无效仓安全数据有效时间  配置类型

    @Resource StockCommonConfigDefineMapper stockCommonConfigDefineMapper;

    @Resource StockWarehProdDefineMapper    stockWarehProdDefineMapper;

    @Resource ErpWarehProdDefineMapper      erpWarehProdDefineMapper;

    @Resource MultiTableService             multiTableServiceImpl;

    @Resource StockShopDameDefineMapper     stockShopDameDefineMapper;

    @Resource StockShopSafeDefineMapper     stockShopSafeDefineMapper;

    @Resource StockWpSafeDefineMapper       stockWpSafeDefineMapper;

    private static StockLog                 logger                = StockLogFactory.getLogger(HandleInvalidHistoryDataServiceImpl.class);

    /**
     * 获取新老ERP中实际库存为0，且最后操作时间为空、或者最后操作时间加上有效时间小于当前时间的仓|门店ID、SKU的ID
     * 
     * @param isShop
     * @param configValue
     * @return
     */
    private List<StockWarehProd> selectErpWareh(String isShop, String configValue) {
        logger.info(" 获取新老ERP中实际库存为0，且最后操作时间为空、或者最后操作时间加上有效时间小于当前时间的仓|门店ID、SKU的ID-->开始");
        int cv = new Integer(configValue);
        List<StockWarehProd> shopList = this.erpWarehProdDefineMapper.selectNewErpWarehIdAndSku(isShop, cv);
        List<StockWarehProd> oldList = this.erpWarehProdDefineMapper.selectOldErpWarehIdAndSku(isShop, cv);
        shopList.addAll(oldList);
        logger.info(" 获取新老ERP中实际库存为0，且最后操作时间为空、或者最后操作时间加上有效时间小于当前时间的仓|门店ID、SKU的ID的数据量：" + shopList.size());
        return shopList;
    }

    /**
     * 删除stock_shop_dame表的无效信息、并且更新对应仓+SKU信息
     * 
     * @param list
     * @return
     */
    private void deleteAndUpdateByShopDame(List<StockWarehProd> list) {
        logger.info(" 删除stock_shop_dame表的无效信息、并且更新对应仓+SKU信息->开始");
        try {
            // 循环查询到的门店ID、SKUID，删除数据
            for (StockWarehProd swp : list) {
                // 删除
                stockShopDameDefineMapper.deleteInvalid(swp.getWarehId(), swp.getProdId());
                // 更新
                String suffix = multiTableServiceImpl.getTableSuffixByWarehId(swp.getWarehId());
                stockWarehProdDefineMapper.updateShopDame(suffix, swp.getWarehId(), swp.getProdId());
            }
        } catch (Exception e) {
            logger.debug("无效污次少洗历史数据删除定时任务异常（deleteAndUpdateByShopDame方法中）！", e);
            e.printStackTrace();
        }
    }

    /**
     * 删除无效门店安全库存、并更新对应仓+SKU的门店安全库存
     * 
     * @param maxSeq
     * @param configValue
     */
    private void deleteAndUpdateByShopSafe(List<StockWarehProd> list) {
        logger.info(" 删除无效门店安全库存、并更新对应仓+SKU的门店安全库存->开始");
        try {
            // 循环查询到的门店ID、SKUID，删除数据
            for (StockWarehProd swp : list) {
                // 删除
                stockShopSafeDefineMapper.deleteInvalid(swp.getWarehId(), swp.getProdId());
                // 更新
                String suffix = multiTableServiceImpl.getTableSuffixByWarehId(swp.getWarehId());
                stockWarehProdDefineMapper.updateShopSafe(suffix, swp.getWarehId(), swp.getProdId());
            }
        } catch (Exception e) {
            logger.debug("无效门店安全库存数据删除异常！(deleteAndUpdateByShopSafe方法中)", e);
            e.printStackTrace();
        }
    }

    /**
     * 删除无效仓安全库存、并更新对应仓+SKU的仓安全库存
     * 
     * @param maxSeq
     * @param configValue
     */
    private void deleteAndUpdateByWarehSafe(List<StockWarehProd> list) {
        logger.info(" 删除无效仓安全库存、并更新对应仓+SKU的仓安全库存->开始");
        try {
            // 循环查询到的仓ID、SKUID，删除数据
            for (StockWarehProd swp : list) {
                // 删除
                stockWpSafeDefineMapper.deleteInvalid(swp.getWarehId(), swp.getProdId());
                // 更新
                String suffix = multiTableServiceImpl.getTableSuffixByWarehId(swp.getWarehId());
                stockWarehProdDefineMapper.updateShopSafe(suffix, swp.getWarehId(), swp.getProdId());
            }
        } catch (Exception e) {
            logger.debug("无效仓安全库存数据删除异常！(deleteAndUpdateByShopSafe方法中)", e);
            e.printStackTrace();
        }
    }

    @Override
    public void deleteInvalidShopDame() {
        // 无效污次少洗历史数据
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        Date stime = null;
        try {
            lock.lock();
            stime = new Date();
            logger.info("开始->无效污次少洗历史数据删除定时任务");
            try {
                // 获取配置表stock_common_config中污损值表数据保存的有效时间值的信息
                StockCommonConfig config = stockCommonConfigDefineMapper.selectByConfigName(CONFIG_NAME_SHOPDAME);
                String configValue = config.getConfigValue();

                // 获取数据库里的门店+SKU
                // sf_wareh_prod、wareh_prod中门店ID、SKU的ID信息(新老ERP)（实际库存为0，且操作时间加有效时间小于当前时间）
                // 删除无效污次少洗数据
                // 更新对应库存同步数据库中的门店+SKU的shop_dame门店污损值，值改为0
                deleteAndUpdateByShopDame(selectErpWareh("1", configValue));
            } catch (Exception e) {
                logger.debug("无效污次少洗历史数据删除定时任务：deleteInvalidShopDame出现异常", e);
            }

        } finally {
            lock.unlock();
            logger.info("无效污次少洗历史数据删除定时任务 -->结束,用时：" + (new Date().getTime() - stime.getTime()));
        }
    }

    @Override
    public void deleteInvalidShopSafe() {
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        Date stime = null;
        try {
            lock.lock();
            stime = new Date();
            logger.info("开始 无效的门店安全库存删除定时任务");
            try {
                // 从MYSQL数据库中获取配置表stock_common_config中关于门店安全库存表数据的有效时间值的信息
                StockCommonConfig config = stockCommonConfigDefineMapper.selectByConfigName(CONFIG_NAME_SHOPSAFE);
                String configValue = config.getConfigValue();

                // 获取数据库里的门店+SKU
                // sf_wareh_prod、wareh_prod中门店ID、SKU的ID信息(新老ERP)（实际库存为0，且操作时间加有效时间小于当前时间)
                // 删除stock_shop_safe的无效数据
                // 更新对应库存同步数据库中的门店+SKU的线上安全库存online_safe_stock值改为-1
                deleteAndUpdateByShopSafe(selectErpWareh("1", configValue));

            } catch (Exception e) {
                logger.debug("无效的门店安全库存删除定时任务：deleteInvalidShopSafe出现异常", e);
            }

        } finally {
            lock.unlock();
            logger.info("无效的门店安全库存删除定时任务---> 结束" + (new Date().getTime() - stime.getTime()));
        }
    }

    @Override
    public void deleteInvalidWarehSafe() {
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        Date stime = null;
        try {
            lock.lock();
            stime = new Date();
            logger.info("开始->无效的仓库安全库存删除定时任务");
            try {
                // 从MYSQL数据库中获取配置表stock_common_config中关于门店安全库存表数据的有效时间值的信息
                StockCommonConfig config = stockCommonConfigDefineMapper.selectByConfigName(CONFIG_NAME_WAREHSAFE);
                String configValue = config.getConfigValue();

                // 获取数据库里的仓+SKU
                // sf_wareh_prod、wareh_prod中门店ID、SKU的ID信息(新老ERP)（实际库存为0，且操作时间加有效时间小于当前时间)
                // 删除库存同步数据库中仓安全库存表stock_wp_safe的数据
                // 根据查询到的仓+SKU的仓ID、SKU的ID，更新对应库存同步数据库中的仓+SKU的线上安全库存online_safe_stock，值改为-1
                deleteAndUpdateByWarehSafe(selectErpWareh("0", configValue));

            } catch (Exception e) {
                logger.debug("无效的门店安全库存删除定时任务：deleteInvalidShopSafe出现异常", e);
            }

        } finally {
            lock.unlock();
            logger.info("无效的仓库安全库存删除定时任务->结束" + (new Date().getTime() - stime.getTime()));
        }
    }

}
