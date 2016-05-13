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
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpChannelScopeMapper;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpWmsPropertyMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpWmsPropertyDefineMapper;
import com.metersbonwe.stock.dal.define.wms.mapper.WmsStockProdQtyDefineMapper;
import com.metersbonwe.stock.facade.schedule.WmsAttributeChangesService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.po.sync.TmpChannelScope;
import com.metersbonwe.stock.po.sync.TmpChannelScopeExample;
import com.metersbonwe.stock.po.sync.TmpWmsProperty;
import com.metersbonwe.stock.po.sync.TmpWmsPropertyExample;
import com.metersbonwe.stock.po.wms.WmsStockProdQty;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;

@Service public class WmsAttributeChangesServiceImpl implements WmsAttributeChangesService {
    private static StockLog                     stockLog     = StockLogFactory.getLogger(WmsAttributeChangesServiceImpl.class);

    private final String                        SERVICE_NAME = "仓库WMS属性变化（used_ma变化）";

    @Autowired TmpWmsPropertyDefineMapper       tmpWmsPropertyDefineMapper;

    @Autowired TmpWmsPropertyMapper             tmpWmsPropertyMapper;

    @Autowired ChangeFinalFreeShareStockService changeFinalFreeShareStockService;

    @Autowired WmsStockProdQtyDefineMapper      wmsStockProdQtyDefineMapper;

    @Autowired TmpChannelScopeMapper            tmpChannelScopeMapper;

    @Autowired AllocationRangeService           allocationRangeService;

    @Override
    public void doService() {
        stockLog.info(SERVICE_NAME + "开始运行");
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        try {
            lock.lock();
            //去重获取tmpWmsPropertys
            List<TmpWmsProperty> tmpWmsPropertys = getTmpWmsPropertysDeleteRepeat();
            stockLog.debug("去重获取tmpWmsPropertys" + tmpWmsPropertys.size());

            //通过oms获取全渠道信息
            List<String> channelLists = getChannelCode();
            stockLog.debug("获取全渠道信息" + channelLists.size());

            //获取ma库存正数锁定量
            List<WmsStockProdQty> wmsStockProdQtys = getWmsStockProdQtys();
            stockLog.debug("获取MA库存正数锁定量");

            stockLog.debug("开始循环tmpWmsPropertys");
            for (TmpWmsProperty tmpWmsProperty : tmpWmsPropertys) {
                autmicMethod(channelLists, wmsStockProdQtys, tmpWmsProperty);
            }
            stockLog.debug("结束循环tmpWmsPropertys");
        } catch (Exception e) {
            stockLog.error(SERVICE_NAME + "出错", e);
        } finally {
            lock.unlock();
            stockLog.info(SERVICE_NAME + "结束运行");
        }
    }

    /**
     * 仓库MA属性变化
     * 
     * @param channelLists
     * @param wmsStockProdQtys
     * @param tmpWmsProperty
     */
    private void autmicMethod(List<String> channelLists, List<WmsStockProdQty> wmsStockProdQtys, TmpWmsProperty tmpWmsProperty) throws Exception {
        String msg = String.format("仓库:%S ma属性:%S", tmpWmsProperty.getWarehId(), tmpWmsProperty.getUsedMa());
        try {
            stockLog.info("开始" + msg);
            //更新仓+sku表的 wms_stock=0;
            upStockWarehProdWmsStockZero(tmpWmsProperty);
            stockLog.debug("更新warehId:" + tmpWmsProperty.getWarehId() + "的wms_stock=0");
            if ("1".equals(tmpWmsProperty.getUsedMa())) {
                stockLog.debug("更新warehId:" + tmpWmsProperty.getWarehId() + "使用MA库存，开始更新wms_stock为正数锁定库存");
                //循环更新仓+sku表的wms_stock
                upStockWarehProdWmsStock(tmpWmsProperty.getWarehId(), wmsStockProdQtys);
            }
            //循环全渠道，增加TMP_CHANNEL_SCOPE记录
            List<TmpChannelScope> tmpChannelScopeList = genTmpChannelScopList(tmpWmsProperty.getWarehId(), channelLists);
            stockLog.debug("生成全渠道TMP_CHANNEL_SCOPE记录");
            //保存生成的记录
            saveTmpChannelScopList(tmpChannelScopeList);
            stockLog.debug("保存全渠道TMP_CHANNEL_SCOPE记录");
            //删除小于ID的记录
            deledtLessThranMaxIdRecord(tmpWmsProperty);
            stockLog.debug("删除小于等于ID的tmpWmsProperty记录");
        } catch (Exception e) {
            stockLog.error(msg + "出错", e);
        } finally {
            stockLog.info("结束" + msg);
        }
    }

    /**
     * 去重获取 TmpWmsProperty(仓库USED_MA属性变化临时表)
     * 
     * @return
     */
    private List<TmpWmsProperty> getTmpWmsPropertysDeleteRepeat() {
        return tmpWmsPropertyDefineMapper.selectAllDeleteRepeat();
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
     * 更新仓+sku表的正数锁定量为0
     * 
     * @param tmpWmsProperty
     * @throws Exception
     */
    private void upStockWarehProdWmsStockZero(TmpWmsProperty tmpWmsProperty) throws Exception {
        StockWarehProd stockWarehProd = new StockWarehProd();
        stockWarehProd.setWarehId(tmpWmsProperty.getWarehId());
        stockWarehProd.setWmsStock(0);
        changeFinalFreeShareStockService.updateStockWarehProd(stockWarehProd);
    }

    /**
     * 获取WMS正数锁定量
     * 
     * @return
     */
    private List<WmsStockProdQty> getWmsStockProdQtys() {
        Map<String, Object> map = new HashMap<String, Object>();
        return wmsStockProdQtyDefineMapper.selectAll(map);
    }

    /**
     * 更新wms正数锁定量
     * 
     * @param warehId
     * @param wmsStockProdQtys
     * @throws Exception
     */
    private void upStockWarehProdWmsStock(String warehId, List<WmsStockProdQty> wmsStockProdQtys) throws Exception {
        for (WmsStockProdQty wmsStockProdQty : wmsStockProdQtys) {
            StockWarehProd stockWarehProd = new StockWarehProd();
            stockWarehProd.setWarehId(warehId);
            stockWarehProd.setProdId(wmsStockProdQty.getProdId());
            stockWarehProd.setWmsStock(wmsStockProdQty.getTotalQty().intValue());
            changeFinalFreeShareStockService.updateStockWarehProd(stockWarehProd);
        }
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

    /**
     * 删除小于等于ID，且等与仓库的临时表数据
     * 
     * @param tmpWmsProperty
     */
    private void deledtLessThranMaxIdRecord(TmpWmsProperty tmpWmsProperty) {
        TmpWmsPropertyExample tmpWmsPropertyExample = new TmpWmsPropertyExample();
        tmpWmsPropertyExample.createCriteria().andWarehIdEqualTo(tmpWmsProperty.getWarehId()).andIdLessThanOrEqualTo(tmpWmsProperty.getId());
        tmpWmsPropertyMapper.deleteByExample(tmpWmsPropertyExample);
    }
}
