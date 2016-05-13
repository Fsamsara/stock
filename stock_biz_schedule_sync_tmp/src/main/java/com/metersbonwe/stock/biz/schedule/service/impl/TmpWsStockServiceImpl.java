package com.metersbonwe.stock.biz.schedule.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.biz.common.service.ChangeFinalFreeShareStockService;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockWarehProdMapper;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpChannelScopeMapper;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpWsStockMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpWsStockDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.UdWarehParamDefineMapper;
import com.metersbonwe.stock.facade.schedule.TmpWsStockService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.po.sync.TmpChannelScope;
import com.metersbonwe.stock.po.sync.TmpChannelScopeExample;
import com.metersbonwe.stock.po.sync.TmpWsStock;
import com.metersbonwe.stock.po.sync.TmpWsStockExample;
import com.metersbonwe.stock.po.sync.define.UdWarehParamDefine;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;

@Service public class TmpWsStockServiceImpl implements TmpWsStockService {
    private static StockLog                     stockLog     = StockLogFactory.getLogger(TmpWsStockServiceImpl.class);

    private final String                        SERVICE_NAME = "WS安全库存变化临时表流程处理";

    @Autowired TmpWsStockDefineMapper           tmpWsStockDefineMapper;

    @Autowired TmpWsStockMapper                 tmpWsStockMapper;

    @Autowired ChangeFinalFreeShareStockService changeFinalFreeShareStockService;

    @Autowired StockWarehProdMapper             stockWarehProdMapper;

    @Autowired MultiTableService                multiTableService;

    @Autowired MqSendService                    mqSendService;

    @Autowired AllocationRangeService           allocationRangeService;

    @Autowired TmpChannelScopeMapper            tmpChannelScopeMapper;

    @Autowired UdWarehParamDefineMapper         udWarehParamDefineMapper;

    private Map<String, String>                 map;

    @Override
    public void doService() {
        stockLog.info(SERVICE_NAME + "开始运行");
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        try {
            lock.lock();
            //检查仓库安全库存类型是否是WS,不是的话返回
            map = new HashMap<String, String>();
            List<UdWarehParamDefine> udWarehs = udWarehParamDefineMapper.selectAllForB2C();
            for (UdWarehParamDefine udWarehParamDefine : udWarehs) {
                if (!map.containsKey(udWarehParamDefine.getCode())) {
                    map.put(udWarehParamDefine.getCode(), udWarehParamDefine.getOnlineSafeqtyType());
                }
            }
            //同步库去重获取tmp_ws_stock数据
            List<TmpWsStock> tmpWsStocks = getTmpWsStockDeleteRepeat();
            stockLog.debug("同步库去重获取数据tmpWsStocks:" + tmpWsStocks.size());
            stockLog.debug("开始循环tmpWsStocks");
            for (TmpWsStock tmpWsStock : tmpWsStocks) {
                autmicMethod(tmpWsStock);
            }
            stockLog.debug("结束循环tmpWsStocks");
        } catch (Exception e) {
            stockLog.error(SERVICE_NAME + "出错", e);
        } finally {
            lock.unlock();
            stockLog.info(SERVICE_NAME + "结束运行");
        }
    }

    /**
     * 仓安全库存变化
     * 
     * @param tmpWsStock
     */
    private void autmicMethod(TmpWsStock tmpWsStock) {
        String msg = String.format("仓库:%S计算WS安全库存:%S", tmpWsStock.getWarehId(), tmpWsStock.getWsStock());
        try {
            stockLog.info("开始" + msg);
            if ("WS".equals(map.get(tmpWsStock.getWarehId()))) {
                //更新安全库存，重算最终自由量
                upStockWarehProd(tmpWsStock);
                stockLog.debug("更新WS安全库存,计算最终自由量");

                //通过oms获取全渠道信息
                List<String> channelLists = getChannelCode();

                //循环全渠道，增加TMP_CHANNEL_SCOPE记录
                List<TmpChannelScope> tmpChannelScopeList = genTmpChannelScopList(tmpWsStock.getWarehId(), channelLists);
                stockLog.debug("生成全渠道TMP_CHANNEL_SCOPE记录");

                //保存生成的记录
                saveTmpChannelScopList(tmpChannelScopeList);
                stockLog.debug("保存全渠道TMP_CHANNEL_SCOPE记录");
            } else {
                stockLog.debug("仓库安全库存类型不是WS" + tmpWsStock.getWarehId());
            }
            //删除同仓的，<=ID的临时表记录
            delTmpWsStock(tmpWsStock);
            stockLog.debug("删除同仓的，<=ID的临时表记录");
        } catch (Exception e) {
            stockLog.error(msg + "出错", e);
        } finally {
            stockLog.info("结束" + msg);
        }
    }

    /**
     * 同步库去重获取tmp_ws_stock数据
     * 
     * @return
     */
    private List<TmpWsStock> getTmpWsStockDeleteRepeat() {
        return tmpWsStockDefineMapper.selectAllDeleteRepeat();
    }

    /**
     * 更新stock_wareh_prod 安全库存,计算最终自由量
     * 
     * @param tmpWsStock
     * @param stockWarehProdMap
     * @throws Exception
     */
    private void upStockWarehProd(TmpWsStock tmpWsStock) throws Exception {
        StockWarehProd stockWarehProd = new StockWarehProd();
        stockWarehProd.setWarehId(tmpWsStock.getWarehId());
        stockWarehProd.setOnlineSafeStock(tmpWsStock.getWsStock().intValue());
        stockWarehProd.setUpdateTime(new Date());
        changeFinalFreeShareStockService.updateStockWarehProd(stockWarehProd);
    }

    /**
     * 同步库删除小与ID的同仓的安全库存数据
     * 
     * @param tmpWsStock
     */
    private void delTmpWsStock(TmpWsStock tmpWsStock) {
        TmpWsStockExample tmpWsStockExample = new TmpWsStockExample();
        tmpWsStockExample.createCriteria().andIdLessThanOrEqualTo(tmpWsStock.getId()).andWarehIdEqualTo(tmpWsStock.getWarehId());
        tmpWsStockMapper.deleteByExample(tmpWsStockExample);
    }

    /**
     * 获取在售渠道信息 OMS提供
     * 
     * @return
     */
    private List<String> getChannelCode() {
        return allocationRangeService.getAllUsefulChannel();
    }

    /**
     * 生成TMP_CHANNEL_SCOPE对应表的 List scope_change=0, wareh_state=1, update_time=now
     * 
     * @param warehId
     * @param channelLists
     * @return
     */
    private List<TmpChannelScope> genTmpChannelScopList(String warehId, List<String> channelLists) {
        List<TmpChannelScope> tmpChannelScopeList = new ArrayList<TmpChannelScope>();
        for (String item : channelLists) {
            TmpChannelScope tmpChannelScope = new TmpChannelScope();
            tmpChannelScope.setChannelCode(item);
            tmpChannelScope.setWarehId(warehId);
            tmpChannelScope.setScopeChange("0");
            tmpChannelScope.setWarehState("2");
            tmpChannelScope.setUpdateTime(new Date());
            tmpChannelScopeList.add(tmpChannelScope);
        }
        return tmpChannelScopeList;
    }

    /**
     * 保存记录
     * 
     * @param tmpChannelScopeList
     */
    private void saveTmpChannelScopList(List<TmpChannelScope> tmpChannelScopeList) {
        for (TmpChannelScope tmpChannelScope : tmpChannelScopeList) {
            TmpChannelScopeExample tmpChannelScopeExample = new TmpChannelScopeExample();
            tmpChannelScopeExample.createCriteria().andWarehIdEqualTo(tmpChannelScope.getWarehId())
                    .andChannelCodeEqualTo(tmpChannelScope.getChannelCode());
            Integer ibak = tmpChannelScopeMapper.updateByExampleSelective(tmpChannelScope, tmpChannelScopeExample);
            if (ibak.equals(0)) {
                tmpChannelScopeMapper.insertSelective(tmpChannelScope);
            }
        }
    }
}
