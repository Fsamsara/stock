package com.metersbonwe.stock.biz.schedule.thread;

import java.math.BigDecimal;
import java.util.Date;

import com.metersbonwe.stock.biz.common.service.ChangeFinalFreeShareStockService;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.configuration.ThreadConfig;
import com.metersbonwe.stock.dal.auto.core.mapper.StockShopSafeMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockShopSafeTranMapper;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpShopSafeStockMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockShopSafe;
import com.metersbonwe.stock.po.core.StockShopSafeExample;
import com.metersbonwe.stock.po.core.StockShopSafeTran;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.po.core.TmpQueueAll;
import com.metersbonwe.stock.po.sync.TmpShopSafeStock;
import com.metersbonwe.stock.po.sync.TmpShopSafeStockExample;

/**
 * 门店安全库存调度
 * 
 * @author zhangjf
 */
public class TmpShopSafeStockConsumerRunnable implements Runnable {
    private static StockLog          stockLog               = StockLogFactory.getLogger(TmpShopSafeStockConsumerRunnable.class);

    private final String             SHOP_SAFETY_ORDER_TYPE = "ADD";

    private TmpShopSafeStock         tmpShopSafeStock;

    private ThreadConfig             threadConfig;

    StockShopSafeMapper              stockShopSafeMapper;

    StockShopSafeTranMapper          stockShopSafeTranMapper;

    ChangeFinalFreeShareStockService changeFinalFreeShareStockService;

    MqSendService                    mqSendService;

    TmpShopSafeStockMapper           tmpShopSafeStockMapper;

    @Override
    public void run() {
        try {
            if (tmpShopSafeStock == null) {
                return;
            }
            autmicMethod(tmpShopSafeStock);
        } catch (Exception e) {
            stockLog.error("线程出错", e);
        } finally {
            threadConfig.threadDown();
        }
    }

    public TmpShopSafeStock getTmpShopSafeStock() {
        return tmpShopSafeStock;
    }

    public void setTmpShopSafeStock(TmpShopSafeStock tmpShopSafeStock) {
        this.tmpShopSafeStock = tmpShopSafeStock;
    }

    public ThreadConfig getThreadConfig() {
        return threadConfig;
    }

    public void setThreadConfig(ThreadConfig threadConfig) {
        this.threadConfig = threadConfig;
    }

    public StockShopSafeMapper getStockShopSafeMapper() {
        return stockShopSafeMapper;
    }

    public void setStockShopSafeMapper(StockShopSafeMapper stockShopSafeMapper) {
        this.stockShopSafeMapper = stockShopSafeMapper;
    }

    public StockShopSafeTranMapper getStockShopSafeTranMapper() {
        return stockShopSafeTranMapper;
    }

    public void setStockShopSafeTranMapper(StockShopSafeTranMapper stockShopSafeTranMapper) {
        this.stockShopSafeTranMapper = stockShopSafeTranMapper;
    }

    public ChangeFinalFreeShareStockService getChangeFinalFreeShareStockService() {
        return changeFinalFreeShareStockService;
    }

    public void setChangeFinalFreeShareStockService(ChangeFinalFreeShareStockService changeFinalFreeShareStockService) {
        this.changeFinalFreeShareStockService = changeFinalFreeShareStockService;
    }

    public MqSendService getMqSendService() {
        return mqSendService;
    }

    public void setMqSendService(MqSendService mqSendService) {
        this.mqSendService = mqSendService;
    }

    public TmpShopSafeStockMapper getTmpShopSafeStockMapper() {
        return tmpShopSafeStockMapper;
    }

    public void setTmpShopSafeStockMapper(TmpShopSafeStockMapper tmpShopSafeStockMapper) {
        this.tmpShopSafeStockMapper = tmpShopSafeStockMapper;
    }

    /**
     * 门店安全库存变化
     * 
     * @param tmpSafetyStock
     */
    private void autmicMethod(TmpShopSafeStock tmpShopSafeStock) {
        String msg = String.format(
                "门店:%S计算%S安全库存:%S",
                tmpShopSafeStock.getWarehId(),
                tmpShopSafeStock.getProdId(),
                tmpShopSafeStock.getShopSafeStock());
        try {
            stockLog.info("开始" + msg);
            //核心库replace into stock_shop_safe
            replaceIntoStockShopSafe(tmpShopSafeStock);
            stockLog.debug("更新插入stock_shop_safe");

            //插入stock_shop_safe_tran
            insertIntoStockShopSafeTran(tmpShopSafeStock);
            stockLog.debug("插入stock_shop_safe_tran");

            //更新stock_wareh_prod
            upStockWarehProd(tmpShopSafeStock);
            stockLog.debug("更新stock_wareh_prod");

            //推送Queue
            sendQueue(tmpShopSafeStock);
            stockLog.debug("推送Queue");

            //同步库删除小与ID的同仓同SKU的安全库存数据
            delTmpSafetyStock(tmpShopSafeStock);
            stockLog.debug("同步库删除小与ID的同仓同SKU的安全库存数据");

        } catch (Exception e) {
            stockLog.error(msg + "出错", e);
        } finally {
            stockLog.info("结束" + msg);
        }
    }

    /**
     * 核心库replace into StockShopSafe
     * 
     * @param tmpShopSafeStock
     */
    private void replaceIntoStockShopSafe(TmpShopSafeStock tmpShopSafeStock) {
        int r = tmpShopSafeStock.getShopSafeStock().compareTo(new BigDecimal(-1));
        if (r == 0) {
            stockLog.debug("删除核心库Stock_Shop_Safe:"+tmpShopSafeStock.getWarehId()+" "+tmpShopSafeStock.getProdId());
            StockShopSafeExample stockShopSafeExample = new StockShopSafeExample();
            stockShopSafeExample.createCriteria().andWarehIdEqualTo(tmpShopSafeStock.getWarehId()).andProdIdEqualTo(tmpShopSafeStock.getProdId());
            stockShopSafeMapper.deleteByExample(stockShopSafeExample);
        } else {
            stockLog.debug("更新插入核心库Stock_Shop_Safe:"+tmpShopSafeStock.getWarehId()+" "+tmpShopSafeStock.getProdId());
            StockShopSafe stockShopSafe = new StockShopSafe();
            stockShopSafe.setWarehId(tmpShopSafeStock.getWarehId());
            stockShopSafe.setProdId(tmpShopSafeStock.getProdId());
            stockShopSafe.setSafeStock(tmpShopSafeStock.getShopSafeStock().intValue());
            stockShopSafe.setUpdateTime(new Date());

            StockShopSafeExample stockShopSafeExample = new StockShopSafeExample();
            stockShopSafeExample.createCriteria().andWarehIdEqualTo(tmpShopSafeStock.getWarehId()).andProdIdEqualTo(tmpShopSafeStock.getProdId());
            Integer bak = stockShopSafeMapper.updateByExampleSelective(stockShopSafe, stockShopSafeExample);
            if (bak.equals(0)) {
                stockShopSafeMapper.insertSelective(stockShopSafe);
            }
        }
    }

    /**
     * 记录事务stock_shop_safe_tran
     * 
     * @param tmpShopSafeStock
     */
    private void insertIntoStockShopSafeTran(TmpShopSafeStock tmpShopSafeStock) {
        StockShopSafeTran stockShopSafeTran = new StockShopSafeTran();
        stockShopSafeTran.setProdId(tmpShopSafeStock.getProdId());
        stockShopSafeTran.setSafeStock(tmpShopSafeStock.getShopSafeStock().intValue());
        stockShopSafeTran.setWarehId(tmpShopSafeStock.getWarehId());
        stockShopSafeTran.setSafeStockOrderType(SHOP_SAFETY_ORDER_TYPE);
        stockShopSafeTran.setUpdateTime(new Date());
        stockShopSafeTranMapper.insertSelective(stockShopSafeTran);
    }

    /**
     * 更新仓+sku表
     * 
     * @param tmpShopSafeStock
     * @throws Exception
     */
    private void upStockWarehProd(TmpShopSafeStock tmpShopSafeStock) throws Exception {
        StockWarehProd stockWarehProd = new StockWarehProd();
        stockWarehProd.setWarehId(tmpShopSafeStock.getWarehId());
        stockWarehProd.setProdId(tmpShopSafeStock.getProdId());
        stockWarehProd.setOnlineSafeStock(tmpShopSafeStock.getShopSafeStock().intValue());
        changeFinalFreeShareStockService.updateStockWarehProd(stockWarehProd);
    }

    /**
     * 推送渠道自由量变化queue
     * 
     * @param tmpShopSafeStock
     */
    private void sendQueue(TmpShopSafeStock tmpShopSafeStock) {
        TmpQueueAll tmpQueueAll = new TmpQueueAll();
        tmpQueueAll.setWarehId(tmpShopSafeStock.getWarehId());
        tmpQueueAll.setProdId(tmpShopSafeStock.getProdId());
        mqSendService.sendToChannelAll(tmpQueueAll);
    }

    /**
     * 删除小于等于 ID的同店同SKU的安全库存数据
     * 
     * @param tmpShopSafeStock
     */
    private void delTmpSafetyStock(TmpShopSafeStock tmpShopSafeStock) {
        TmpShopSafeStockExample tmpShopSafeStockExample = new TmpShopSafeStockExample();
        tmpShopSafeStockExample.createCriteria().andIdLessThanOrEqualTo(tmpShopSafeStock.getId()).andWarehIdEqualTo(tmpShopSafeStock.getWarehId())
                .andProdIdEqualTo(tmpShopSafeStock.getProdId());
        tmpShopSafeStockMapper.deleteByExample(tmpShopSafeStockExample);
    }
}
