package com.metersbonwe.stock.biz.schedule.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.ChangeFinalFreeShareStockService;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockShopRemailMapper;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpRemailStockMapper;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpRemailedStockMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockShopRemailDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockShopRemailTranDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockWarehProdDefineMapper;
import com.metersbonwe.stock.facade.schedule.TmpRemailedStockService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockShopRemail;
import com.metersbonwe.stock.po.core.StockShopRemailExample;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.po.core.TmpQueueFreeLock;
import com.metersbonwe.stock.po.sync.TmpRemailStockExample;
import com.metersbonwe.stock.po.sync.TmpRemailedStock;
import com.metersbonwe.stock.po.sync.TmpRemailedStockExample;
import com.metersbonwe.stock.utils.CollectionUtil;
import com.metersbonwe.stock.utils.DateUtil;

@Service public class TmpRemailedStockServiceImpl implements TmpRemailedStockService {
    private static StockLog                       stockLog               = StockLogFactory.getLogger(TmpRemailedStockServiceImpl.class);

    private final String                          SERVICE_NAME           = "门店日结调度任务";

    private final String                          MAP_BEGIN_STRING       = "begin";

    private final String                          MAP_END_STRING         = "end";

    private final String                          CELL_REMAIL_ORDER_TYPE = "DTL";

    @Autowired TmpRemailStockMapper               tmpRemailStockMapper;

    @Autowired StockShopRemailTranDefineMapper    stockShopRemailTranDefineMapper;

    @Autowired StockShopRemailMapper              stockShopRemailMapper;

    @Autowired ChangeFinalFreeShareStockService   changeFinalFreeShareStockService;

    @Autowired MqSendService                      mqSendService;

    @Autowired TmpRemailedStockMapper             tmpRemailedStockMapper;

    @Autowired StockShopRemailDefineMapper        stockShopRemailDefineMapper;

    @Autowired private StockWarehProdDefineMapper stockWarehProdDefineMapper;

    @Resource private MultiTableService           multiTableService;

    @Override
    public void doService() {
        stockLog.info(SERVICE_NAME + "开始运行");
        try {
            List<TmpRemailedStock> tmpRemaileds = getTmpRemailedStockDeleteRepeat();
            stockLog.debug("同步库获取数据tmpRemaileds:" + tmpRemaileds.size());
            stockLog.debug("开始循环tmpRemaileds");
            for (TmpRemailedStock tmpRemailedStock : tmpRemaileds) {
                autmicMethod(tmpRemailedStock);
            }
            stockLog.debug("结束循环tmpRemaileds");
        } catch (Exception e) {
            stockLog.error(SERVICE_NAME + "出错", e);
        } finally {
            stockLog.info(SERVICE_NAME + "结束运行");
        }

    }

    /**
     * 仓库未日结数据变化
     * 
     * @param tmpRemailedStock
     * @throws Exception
     */
    private void autmicMethod(TmpRemailedStock tmpRemailedStock) {
        String msg = String.format("仓库:%S 日结日期:%tF", tmpRemailedStock.getWarehId(), tmpRemailedStock.getRemailDate());
        try {
            stockLog.info("开始" + msg);
            Map<String, Date> map = getDateScop(tmpRemailedStock.getRemailDate());
            stockLog.debug("开始时间" + map.get(MAP_BEGIN_STRING));
            stockLog.debug("结束时间" + map.get(MAP_END_STRING));

            delTmpRemailStock(tmpRemailedStock, map);
            stockLog.debug("删除同步库未日结数据");

            insertStockShopRemailTran(tmpRemailedStock, map);
            stockLog.debug("核心库插入未日结事务");

            Set<String> skus = getNeedDelStockShopRemail(tmpRemailedStock, map);
            stockLog.debug("核心库需要日结的sku有:" + skus.size() + "门店:" + tmpRemailedStock.getWarehId());
            //删除未日结记录
            deleteStockShopRemail(tmpRemailedStock, map);
            stockLog.debug("核心库删除未日结记录");

            for (String sku : skus) {
                stockLog.debug("日结，重新计算门店" + tmpRemailedStock.getWarehId() + "sku:" + sku + "的自由量");
                //更新仓库+sku 1.扣减未日结数据 2.重算自由量
                updateStockWarehProd(tmpRemailedStock.getWarehId(), sku);

                //推送queue
                sendQueue(tmpRemailedStock.getWarehId(), sku);
            }

            //删除日结数据
            deleteTmpRemailedStock(tmpRemailedStock);
            stockLog.debug("同步库删除日结数据");

        } catch (Exception e) {
            stockLog.error(msg + "出错", e);
        } finally {
            stockLog.info("结束" + msg);
        }

    }

    /**
     * 同步库删除日结数据
     * 
     * @param tmpRemailedStock
     */
    private void deleteTmpRemailedStock(TmpRemailedStock tmpRemailedStock) {
        TmpRemailedStockExample example = new TmpRemailedStockExample();
        example.createCriteria().andWarehIdEqualTo(tmpRemailedStock.getWarehId()).andIdLessThanOrEqualTo(tmpRemailedStock.getId());
        tmpRemailedStockMapper.deleteByExample(example);
    }

    /**
     * 获取TmpRemailedStock表数据
     * 
     * @return
     */
    private List<TmpRemailedStock> getTmpRemailedStockDeleteRepeat() {
        TmpRemailedStockExample example = new TmpRemailedStockExample();
        example.createCriteria();
        return tmpRemailedStockMapper.selectByExample(example);
    }

    /**
     * 根据日结记录表，删除同步库为日结数据
     * 
     * @param tmpRemailedStock
     * @param map
     */
    private void delTmpRemailStock(TmpRemailedStock tmpRemailedStock, Map<String, Date> map) {
        TmpRemailStockExample tmpRemailStockExample = new TmpRemailStockExample();
        tmpRemailStockExample.createCriteria().andWarehIdEqualTo(tmpRemailedStock.getWarehId())
                .andUpdateTimeBetween(map.get(MAP_BEGIN_STRING), map.get(MAP_END_STRING));
        tmpRemailStockMapper.deleteByExample(tmpRemailStockExample);
    }

    /**
     * 查询出需要日结的SKU
     * 
     * @param tmpRemailedStock
     * @param map
     * @return
     */
    private Set<String> getNeedDelStockShopRemail(TmpRemailedStock tmpRemailedStock, Map<String, Date> map) {
        StockShopRemailExample stockShopRemailExample = new StockShopRemailExample();
        stockShopRemailExample.createCriteria().andWarehIdEqualTo(tmpRemailedStock.getWarehId())
                .andUpdateTimeBetween(map.get(MAP_BEGIN_STRING), map.get(MAP_END_STRING));
        List<StockShopRemail> stockShopRemails = stockShopRemailMapper.selectByExample(stockShopRemailExample);
        Set<String> skus = new HashSet<String>();
        for (StockShopRemail stockShopRemail : stockShopRemails) {
            skus.add(stockShopRemail.getProdId());
        }
        return skus;
    }

    /**
     * 核心库插入未日结事务表
     * 
     * @param tmpRemailedStock
     * @param map
     */
    private void insertStockShopRemailTran(TmpRemailedStock tmpRemailedStock, Map<String, Date> map) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("wareh_id", tmpRemailedStock.getWarehId());
        queryMap.put("beginTime", map.get(MAP_BEGIN_STRING));
        queryMap.put("endTime", map.get(MAP_END_STRING));
        queryMap.put("cell_remail_order_type", CELL_REMAIL_ORDER_TYPE);
        stockShopRemailTranDefineMapper.insertDataByWarehIdRemailTime(queryMap);
    }

    /**
     * 核心库删除未日结记录
     * 
     * @param tmpRemailedStock
     * @param map
     */
    private void deleteStockShopRemail(TmpRemailedStock tmpRemailedStock, Map<String, Date> map) {
        StockShopRemailExample stockShopRemailExample = new StockShopRemailExample();
        stockShopRemailExample.createCriteria().andWarehIdEqualTo(tmpRemailedStock.getWarehId())
                .andUpdateTimeBetween(map.get(MAP_BEGIN_STRING), map.get(MAP_END_STRING));
        stockShopRemailMapper.deleteByExample(stockShopRemailExample);
    }

    /**
     * 核心库更新仓+sku表 更新未日结数量 计算最终自由量
     * 
     * @param stockShopRemail
     * @throws Exception
     */
    private void updateStockWarehProd(String warehId, String prodId) throws Exception {

        //查询门店商品的未日结数量
        int shopRemailQty = getRemailStock(warehId, prodId);
        stockLog.debug("日结：门店" + warehId + "sku:" + prodId + "未日结量是：" + shopRemailQty);

        StockWarehProd stockWarehProd = new StockWarehProd();
        stockWarehProd.setWarehId(warehId);
        stockWarehProd.setProdId(prodId);
        stockWarehProd.setShopRemail(shopRemailQty);
        changeFinalFreeShareStockService.updateStockWarehProd(stockWarehProd);
    }

    /**
     * 根据日期生成时间范围
     * 
     * @param date
     * @return
     */
    private Map<String, Date> getDateScop(Date date) {
        Map<String, Date> map = new HashMap<String, Date>();
        String sDate = DateUtil.date2String(date, "yyyy-MM-dd");
        map.put(MAP_BEGIN_STRING, DateUtil.string2Date(sDate + " 00:00:00", "yyyy-MM-dd HH:mm:ss"));
        map.put(MAP_END_STRING, DateUtil.string2Date(sDate + " 23:59:59", "yyyy-MM-dd HH:mm:ss"));
        return map;
    }

    /**
     * 推送queue到渠道
     * 
     * @param stockShopRemail
     */
    private void sendQueue(String warehId, String prodId) {
        StockWarehProd freeStockWarehProdBean = new StockWarehProd();
        freeStockWarehProdBean.setWarehId(warehId);
        freeStockWarehProdBean.setProdId(prodId);
        freeStockWarehProdBean.setTableNum(multiTableService.getTableSuffixByWarehId(warehId));
        StockWarehProd dameStockWarehProd = stockWarehProdDefineMapper.selectStockWarehProd(freeStockWarehProdBean);

        if (dameStockWarehProd != null && dameStockWarehProd.getOnlineSafeStock() != -1) {
            TmpQueueFreeLock tmpQueueFreeLock = new TmpQueueFreeLock();
            tmpQueueFreeLock.setWarehId(warehId);
            tmpQueueFreeLock.setProdId(prodId);
            mqSendService.sendToChannelWarehProdFreeLock(tmpQueueFreeLock);
        }
    }

    /**
     * 门店未日结
     * 
     * @param warehId
     *            仓库
     * @param prodId
     *            11位码
     * @return
     */
    private int getRemailStock(String warehId, String prodId) {
        List<Map<String, Object>> item = stockShopRemailDefineMapper.selectShopRemail(warehId, prodId);
        if (CollectionUtil.isEmpty(item)) {
            return 0;
        }
        try {
            return Integer.parseInt(item.get(0).get("remailStock").toString());
        } catch (Exception e) {
            stockLog.error("获取门店未日结数量时出错warehId:" + warehId + ",prodId:" + prodId + ",remailStock:" + item.get(0).get("remailStock"), e);
        }
        return 0;
    }
}
