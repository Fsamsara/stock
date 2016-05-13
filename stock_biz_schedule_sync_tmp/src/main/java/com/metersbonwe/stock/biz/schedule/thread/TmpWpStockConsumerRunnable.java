package com.metersbonwe.stock.biz.schedule.thread;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;


import com.metersbonwe.stock.biz.common.service.ChangeFinalFreeShareStockService;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.impl.MultiTableServiceImpl;
import com.metersbonwe.stock.configuration.ThreadConfig;
import com.metersbonwe.stock.dal.auto.core.mapper.StockWpSafeMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockWpSafeTranMapper;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpWpStockMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.UdWarehParamDefineMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.po.core.StockWpSafe;
import com.metersbonwe.stock.po.core.StockWpSafeExample;
import com.metersbonwe.stock.po.core.StockWpSafeTran;
import com.metersbonwe.stock.po.core.TmpQueueAll;
import com.metersbonwe.stock.po.sync.TmpWpStock;
import com.metersbonwe.stock.po.sync.TmpWpStockExample;

public class TmpWpStockConsumerRunnable implements Runnable {
    private static StockLog          stockLog      = StockLogFactory.getLogger(TmpWpStockConsumerRunnable.class);

    private final String             WP_ORDER_TYPE = "ADD";

    TmpWpStockMapper                 tmpWpStockMapper;

    StockWpSafeMapper                stockWpSafeMapper;

    StockWpSafeTranMapper            stockWpSafeTranMapper;

    ChangeFinalFreeShareStockService changeFinalFreeShareStockService;

    MultiTableServiceImpl            multiTableServiceImpl;

    MqSendService                    mqSendService;

    UdWarehParamDefineMapper         udWarehParamDefineMapper;

    private Map<String, String>      map;

    private ThreadConfig             threadConfig;

    private TmpWpStock               tmpWpStock;

    public TmpWpStockMapper getTmpWpStockMapper() {
        return tmpWpStockMapper;
    }

    public void setTmpWpStockMapper(TmpWpStockMapper tmpWpStockMapper) {
        this.tmpWpStockMapper = tmpWpStockMapper;
    }

    public StockWpSafeMapper getStockWpSafeMapper() {
        return stockWpSafeMapper;
    }

    public void setStockWpSafeMapper(StockWpSafeMapper stockWpSafeMapper) {
        this.stockWpSafeMapper = stockWpSafeMapper;
    }

    public StockWpSafeTranMapper getStockWpSafeTranMapper() {
        return stockWpSafeTranMapper;
    }

    public void setStockWpSafeTranMapper(StockWpSafeTranMapper stockWpSafeTranMapper) {
        this.stockWpSafeTranMapper = stockWpSafeTranMapper;
    }

    public ChangeFinalFreeShareStockService getChangeFinalFreeShareStockService() {
        return changeFinalFreeShareStockService;
    }

    public void setChangeFinalFreeShareStockService(ChangeFinalFreeShareStockService changeFinalFreeShareStockService) {
        this.changeFinalFreeShareStockService = changeFinalFreeShareStockService;
    }

    public MultiTableServiceImpl getMultiTableServiceImpl() {
        return multiTableServiceImpl;
    }

    public void setMultiTableServiceImpl(MultiTableServiceImpl multiTableServiceImpl) {
        this.multiTableServiceImpl = multiTableServiceImpl;
    }

    public MqSendService getMqSendService() {
        return mqSendService;
    }

    public void setMqSendService(MqSendService mqSendService) {
        this.mqSendService = mqSendService;
    }

    public UdWarehParamDefineMapper getUdWarehParamDefineMapper() {
        return udWarehParamDefineMapper;
    }

    public void setUdWarehParamDefineMapper(UdWarehParamDefineMapper udWarehParamDefineMapper) {
        this.udWarehParamDefineMapper = udWarehParamDefineMapper;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public ThreadConfig getThreadConfig() {
        return threadConfig;
    }

    public void setThreadConfig(ThreadConfig threadConfig) {
        this.threadConfig = threadConfig;
    }

    public TmpWpStock getTmpWpStock() {
        return tmpWpStock;
    }

    public void setTmpWpStock(TmpWpStock tmpWpStock) {
        this.tmpWpStock = tmpWpStock;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            if (tmpWpStock == null) {
                return;
            }
            autmicMethod(tmpWpStock);
        } catch (Exception e) {
            stockLog.error("线程出错", e);
        } finally {
            threadConfig.threadDown();
        }
    }

    /**
     * 仓库安全库存变化
     * 
     * @param tmpWpStock
     */
    private void autmicMethod(TmpWpStock tmpWpStock) {
        String msg = String.format("仓库:%S 商品:%S WP安全库存:%S", tmpWpStock.getWarehId(), tmpWpStock.getProdId(), tmpWpStock.getWpStock());
        try {
            stockLog.info("开始" + msg);
            //核心库replace into stock_wp_safe
            replaceIntoStockWpSafe(tmpWpStock);
            stockLog.debug("更新插入stock_wp_safe");

            //插入stock_wp_safe_tran
            insertIntoStockWpSafeTran(tmpWpStock);
            stockLog.debug("插入stock_wp_safe_tran");

            if ("WP".equals(map.get(tmpWpStock.getWarehId()))) {

                //更新stock_wareh_prod
                upStockWarehProd(tmpWpStock);
                stockLog.debug("更新stock_wareh_prod");

                //推送Queue
                sendQueue(tmpWpStock);
                stockLog.debug("推送Queue");
            } else {
                stockLog.debug("仓库安全库存类型不是WP" + tmpWpStock.getWarehId());
            }

            //同步库删除小与ID的同仓同SKU的安全库存数据
            delTmpWpStock(tmpWpStock);
            stockLog.debug("同步库删除小与ID的同仓同SKU的安全库存数据");

        } catch (Exception e) {
            stockLog.error(msg + "出错", e);
        } finally {
            stockLog.info("结束" + msg);
        }

    }

    /**
     * 更新插入仓库安全库存
     * 
     * @param tmpWpStock
     */
    private void replaceIntoStockWpSafe(TmpWpStock tmpWpStock) {
        int r = tmpWpStock.getWpStock().compareTo(new BigDecimal(-1));
        if (r == 0) {
            stockLog.debug("删除核心库Stock_Wp_Safe:"+tmpWpStock.getWarehId()+" "+tmpWpStock.getProdId());
            StockWpSafeExample stockWpSafeExample = new StockWpSafeExample();
            stockWpSafeExample.createCriteria().andWarehIdEqualTo(tmpWpStock.getWarehId()).andProdIdEqualTo(tmpWpStock.getProdId());
            stockWpSafeMapper.deleteByExample(stockWpSafeExample);
        } else {
            stockLog.debug("更新插入核心库Stock_Wp_Safe:"+tmpWpStock.getWarehId()+" "+tmpWpStock.getProdId());
            StockWpSafe stockWpSafe = new StockWpSafe();
            stockWpSafe.setWarehId(tmpWpStock.getWarehId());
            stockWpSafe.setProdId(tmpWpStock.getProdId());
            stockWpSafe.setSafeStock(tmpWpStock.getWpStock().intValue());
            stockWpSafe.setUpdateTime(new Date());

            StockWpSafeExample stockWpSafeExample = new StockWpSafeExample();
            stockWpSafeExample.createCriteria().andWarehIdEqualTo(tmpWpStock.getWarehId()).andProdIdEqualTo(tmpWpStock.getProdId());
            Integer upStockWpSafeBak = stockWpSafeMapper.updateByExampleSelective(stockWpSafe, stockWpSafeExample);
            if (upStockWpSafeBak.equals(0)) {
                stockWpSafeMapper.insertSelective(stockWpSafe);
            }
        }
    }

    /**
     * 插入安全库存事务
     * 
     * @param tmpWpStock
     */
    private void insertIntoStockWpSafeTran(TmpWpStock tmpWpStock) {
        StockWpSafeTran stockWpSafeTran = new StockWpSafeTran();
        stockWpSafeTran.setWarehId(tmpWpStock.getWarehId());
        stockWpSafeTran.setProdId(tmpWpStock.getProdId());
        stockWpSafeTran.setSafeStock(tmpWpStock.getWpStock().intValue());
        stockWpSafeTran.setSafeStockType("WP");
        stockWpSafeTran.setUpdateBy("");
        stockWpSafeTran.setUpdateTime(new Date());
        stockWpSafeTran.setWpOrderType(WP_ORDER_TYPE);
        stockWpSafeTranMapper.insertSelective(stockWpSafeTran);
    }

    /**
     * 更新stock_wareh_prod
     * 
     * @param tmpWpStock
     * @throws Exception
     */
    private void upStockWarehProd(TmpWpStock tmpWpStock) throws Exception {

        StockWarehProd stockWarehProd = new StockWarehProd();
        stockWarehProd.setWarehId(tmpWpStock.getWarehId());
        stockWarehProd.setProdId(tmpWpStock.getProdId());
        stockWarehProd.setOnlineSafeStock(tmpWpStock.getWpStock().intValue());
        changeFinalFreeShareStockService.updateStockWarehProd(stockWarehProd);
    }

    /**
     * 推送queue到渠道
     * 
     * @param tmpWpStock
     */
    private void sendQueue(TmpWpStock tmpWpStock) {
        TmpQueueAll tmpQueueAll = new TmpQueueAll();
        tmpQueueAll.setWarehId(tmpWpStock.getWarehId());
        tmpQueueAll.setProdId(tmpWpStock.getProdId());
        mqSendService.sendToChannelAll(tmpQueueAll);
    }

    /**
     * 同步库删除小与ID的同仓同SKU的安全库存数据
     * 
     * @param tmpWpStock
     */
    private void delTmpWpStock(TmpWpStock tmpWpStock) {
        TmpWpStockExample tmpWpStockExample = new TmpWpStockExample();
        tmpWpStockExample.createCriteria().andIdLessThanOrEqualTo(tmpWpStock.getId()).andWarehIdEqualTo(tmpWpStock.getWarehId())
                .andProdIdEqualTo(tmpWpStock.getProdId());
        tmpWpStockMapper.deleteByExample(tmpWpStockExample);
    }
}
