package com.metersbonwe.stock.biz.common.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.ActivityWarehService;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.biz.common.service.WarehSkuCommonService;
import com.metersbonwe.stock.biz.common.service.WmsLockedStockService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockShopDameMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockShopSafeMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockWarehProdMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockWpSafeMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockShopRemailDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.FreeAndLockStockDefineMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockShopDame;
import com.metersbonwe.stock.po.core.StockShopDameExample;
import com.metersbonwe.stock.po.core.StockShopSafe;
import com.metersbonwe.stock.po.core.StockShopSafeExample;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.po.core.StockWpSafe;
import com.metersbonwe.stock.po.core.StockWpSafeExample;
import com.metersbonwe.stock.po.core.TmpStockWms;
import com.metersbonwe.stock.po.sync.StActivityWareh;
import com.metersbonwe.stock.utils.CollectionUtil;
import com.metersbonwe.stock.utils.MapUtils;

@Service @SuppressWarnings("rawtypes") public class WarehSkuCommonServiceImpl implements WarehSkuCommonService {

    @Resource FreeAndLockStockDefineMapper freeAndLockStockDefineMapper;

    @Resource ActivityWarehService         activityWarehServiceImpl;

    @Resource StockShopSafeMapper          stockShopSafeMapper;

    @Resource StockWpSafeMapper            stockWpSafeMapper;

    @Resource StockWarehProdMapper         stockWarehProdMapper;

    @Resource MultiTableService            multiTableServiceImpl;

    @Resource StockShopDameMapper          stockShopDameMapper;

    @Resource StockShopRemailDefineMapper  stockShopRemailDefineMapper;

    @Resource WmsLockedStockService        wmsLockedStockService;

    private final StockLog                 log = StockLogFactory.getLogger(WarehSkuCommonServiceImpl.class);

    @Override
    public int insertWarehSkuWithout(String warehId, String sku) {
        StActivityWareh activityWareh = activityWarehServiceImpl.findActivityWareh(warehId);
        if (activityWareh == null) {
            log.debug("insertWarehSkuWithout 插入失败.warehId:" + warehId + ",sku:" + sku + "不在活动仓店配置表中");
            return 0;
        }
        Map freeLockItem = getFreeLockStock(warehId, sku, activityWareh);
        if (freeLockItem == null || freeLockItem.isEmpty()) {
            log.debug("insertWarehSkuWithout 插入失败.warehId:" + warehId + ",sku:" + sku + "库存总表中不存在");
            return 0;
        }
        StockWarehProd stockWarehProd = new StockWarehProd();
        setStockBean(stockWarehProd, freeLockItem, activityWareh.getIsShop());
        return stockWarehProdMapper.insertSelective(stockWarehProd);
    }

    private void setStockBean(StockWarehProd stockWarehProd, Map freeLockItem, String isShop) {
        stockWarehProd.setWarehId(MapUtils.getStringVal(freeLockItem, "WAREH_CODE"));
        setProdId(stockWarehProd, freeLockItem);
        stockWarehProd.setLockStock(MapUtils.getNumberForBigDecimal(freeLockItem, "LOCK_NUM", true));
        stockWarehProd.setStkOnHand(MapUtils.getNumberForBigDecimal(freeLockItem, "STK_ON_HAND", false));
        stockWarehProd.setQtyCommitted(MapUtils.getNumberForBigDecimal(freeLockItem, "COMMITTED_NUM", false));
        stockWarehProd.setFreeShareStock(MapUtils.getNumberForBigDecimal(freeLockItem, "FREE_NUM", false));

        boolean isShopFlag = activityWarehServiceImpl.isShop(isShop);
        String warehId = stockWarehProd.getWarehId();
        String prodId = stockWarehProd.getProdId();
        stockWarehProd.setIsShop(isShopFlag ? (byte) 1 : (byte) 0);
        // 安全库存
        int safeStockNum = getSafeStock(
                warehId,
                prodId,
                MapUtils.getStringVal(freeLockItem, "SAFEQTY_TYPE", true),
                MapUtils.getNumberForBigDecimal(freeLockItem, "SAFETY_STOCK", true),
                isShopFlag);
        stockWarehProd.setOnlineSafeStock(safeStockNum);
        // WMS正数锁定
        int wmsStock = getWmsStock(warehId, prodId, isShopFlag);
        stockWarehProd.setWmsStock(wmsStock);
        // 门店污损值
        int dameStock = getDameStock(warehId, prodId, isShopFlag);
        stockWarehProd.setShopDame(dameStock);
        // 门店未日结
        int remailStock = getRemailStock(warehId, prodId, isShopFlag);
        stockWarehProd.setShopRemail(remailStock);

        stockWarehProd.setTableNum(multiTableServiceImpl.getTableSuffixByWarehId(warehId));
        stockWarehProd.setUpdateTime(new Date());
    }

    /**
     * 门店未日结
     * 
     * @param warehId
     *            仓库
     * @param prodId
     *            11位码
     * @param isShopFlag
     *            是否门店
     * @return
     */
    private int getRemailStock(String warehId, String prodId, boolean isShopFlag) {
        if (!isShopFlag)
            return 0;
        List<Map<String, Object>> item = stockShopRemailDefineMapper.selectShopRemail(warehId, prodId);
        if (CollectionUtil.isEmpty(item)) {
            return 0;
        }
        try {
            return Integer.parseInt(item.get(0).get("remailStock").toString());
        } catch (Exception e) {
            log.error("获取门店未日结数量时出错warehId:" + warehId + ",prodId:" + prodId + ",remailStock:" + item.get(0).get("remailStock"), e);
        }
        return 0;
    }

    /**
     * 得到污损值
     * 
     * @param warehId
     *            仓店ID
     * @param prodId
     *            11位码
     * @param isShop
     *            是否店铺
     * @return
     */
    private int getDameStock(String warehId, String prodId, boolean isShop) {
        if (!isShop)
            return 0;
        StockShopDameExample example = new StockShopDameExample();
        example.or().andWarehIdEqualTo(warehId).andProdIdEqualTo(prodId);
        List<StockShopDame> item = stockShopDameMapper.selectByExample(example);
        if (CollectionUtil.isEmpty(item)) {
            return 0;
        }
        return item.get(0).getDameStock();
    }

    private void setProdId(StockWarehProd stockWarehProd, Map freeLockItem) {
        stockWarehProd.setProdId(MapUtils.getStringVal(freeLockItem, "SKU"));
        stockWarehProd.setSixProdId(getProdIdCode(stockWarehProd.getProdId(), 6));
        stockWarehProd.setEightProdId(getProdIdCode(stockWarehProd.getProdId(), 8));
    }

    private String getProdIdCode(String prodId, int len) {
        return prodId.substring(0, len);
    }

    private int getWmsStock(String warehId, String prodId, boolean isShopFlag) {
        if (isShopFlag)
            return 0;
        TmpStockWms tmpStockWms = wmsLockedStockService.selectTmpStockWms(warehId, prodId);
        if (tmpStockWms != null && tmpStockWms.getWmsStock() != null) {
            return tmpStockWms.getWmsStock();
        }
        return 0;
    }

    /**
     * 获取仓库门店安全库存
     * 
     * @param warehId
     *            仓库code
     * @param prodId
     *            11位码
     * @param safeType
     *            安全库存类型
     * @param safeStock
     *            安全库存值
     * @param isShopFlag
     *            是否门店
     * @return
     */
    private int getSafeStock(String warehId, String prodId, String safeType, int safeStock, boolean isShopFlag) {
        int safeStockNum = -1;
        if (isShopFlag) {
            // 门店安全库存
            safeStockNum = getShopSafeStock(warehId, prodId);
        } else {
            // 仓库安全库存
            safeStockNum = getWarehStockSafe(warehId, prodId, safeType, safeStock);
        }
        return safeStockNum;
    }

    /**
     * 获取仓库安全库存
     * 
     * @param warehId
     * @param prodId
     * @param safeStockType
     * @param defSafeStock
     * @return
     */
    private int getWarehStockSafe(String warehId, String prodId, String safeStockType, int defSafeStock) {
        // WP安全库存
        if (activityWarehServiceImpl.isWPSafetyStockType(safeStockType)) {
            return getWarehWpSafeStock(warehId, prodId);
        }
        // NO
        if (activityWarehServiceImpl.isNOSafetyStockType(safeStockType)) {
            return 0;
        }
        // WS
        if (activityWarehServiceImpl.isWSSafetyStockType(safeStockType)) {
            return defSafeStock;
        }
        return -1;
    }

    /**
     * 获取仓库WP类型的安全库存
     * 
     * @param warehId
     * @param prodId
     * @return
     */
    private int getWarehWpSafeStock(String warehId, String prodId) {
        StockWpSafeExample example = new StockWpSafeExample();
        example.or().andWarehIdEqualTo(warehId).andProdIdEqualTo(prodId);
        List<StockWpSafe> stockWpSafeList = stockWpSafeMapper.selectByExample(example);
        if (CollectionUtil.isEmpty(stockWpSafeList)) {
            return -1;
        } else {
            return stockWpSafeList.get(0).getSafeStock();
        }
    }

    /**
     * 获取门店安全库存
     * 
     * @param stockWarehProd
     * @return
     */
    private int getShopSafeStock(String warehId, String prodId) {
        StockShopSafeExample example = new StockShopSafeExample();
        example.or().andWarehIdEqualTo(warehId).andProdIdEqualTo(prodId);
        List<StockShopSafe> shopSafeList = stockShopSafeMapper.selectByExample(example);
        if (CollectionUtil.isEmpty(shopSafeList)) {
            return -1;
        }
        return shopSafeList.get(0).getSafeStock();

    }

    private Map getFreeLockStock(String warehId, String sku, StActivityWareh activityWareh) {
        if (activityWareh == null) {
            return null;
        }
        List<Map> item = null;
        if (activityWarehServiceImpl.isNewERP(activityWareh.getDataSource())) {
            item = freeAndLockStockDefineMapper.selectFreeAndLockedStockNewErp(warehId, sku);
        } else {
            item = freeAndLockStockDefineMapper.selectFreeAndLockedStockOldErp(warehId, sku);
        }
        if (CollectionUtil.isEmpty(item)) {
            return null;
        }
        return item.get(0);
    }

}
