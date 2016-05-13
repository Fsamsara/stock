package com.metersbonwe.stock.biz.common.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.ActivityWarehService;
import com.metersbonwe.stock.biz.common.service.FreeShareReservedLockedStockService;
import com.metersbonwe.stock.dal.define.sync.mapper.SfWarehLockedLstDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.UrUnitReservedResultDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.WarehLockedLstDefineMapper;
import com.metersbonwe.stock.po.sync.StActivityWareh;
import com.metersbonwe.stock.po.sync.UrUnitReservedResult;
import com.metersbonwe.stock.po.sync.WarehLockedLst;
import com.metersbonwe.stock.po.sync.define.SfWarehLockedLstDefine;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.PageThreadLocal;
import com.metersbonwe.stock.pojo.QryLockStockResultBean;

@Service public class FreeShareReservedLockedStockServiceImpl implements FreeShareReservedLockedStockService {

    @Autowired private UrUnitReservedResultDefineMapper urUnitReservedResultMapper;

    @Autowired private SfWarehLockedLstDefineMapper     sfWarehLockedLstMapper;

    @Autowired private WarehLockedLstDefineMapper       warehLockedLstMapper;

    @Resource private ActivityWarehService              activityWarehServiceImpl;

    /**
     * TODO 获取渠道的预留量 TODO 根据渠道编码集合、预留类型集合、仓库编码集合、商品编码集合获取预留量
     * 
     * @param unitList
     * @param reservedTypeList
     * @param warehList
     * @param skuList
     * @return
     */
    public List<UrUnitReservedResult> getUnitReserved(List<String> unitList, List<String> reservedTypeList, List<String> warehList,
            List<String> skuList) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("unitList", unitList);
        map.put("reservedTypeList", reservedTypeList);
        map.put("warehList", warehList);
        map.put("skuList", skuList);

        List<UrUnitReservedResult> urUnitReservedResultList = this.urUnitReservedResultMapper.selectReservedStockByOthers(map);
        return urUnitReservedResultList;
    }

    /**
     * TODO 获取仓库锁定量
     * 
     * @see com.metersbonwe.stock.biz.common.service.FreeShareReservedLockedStockService#getLockStock(java.util.List, java.util.List, java.util.List)
     */
    public List<QryLockStockResultBean> getLockStock(List<String> reservedTypeList, List<String> warehList, List<String> skuList) {
        return getLockStock_Page(null, reservedTypeList, warehList, skuList);
    }

    /**
     * TODO 获取仓库分页锁定量
     * 
     * @see com.metersbonwe.stock.biz.common.service.FreeShareReservedLockedStockService#getLockStock_Page(com.metersbonwe.stock.pojo.Page,
     *      java.util.List, java.util.List, java.util.List)
     */
    public List<QryLockStockResultBean> getLockStock_Page(Page<?> page, List<String> reservedTypeList, List<String> warehList, List<String> skuList) {
        List<StActivityWareh> stActivityWarehList = activityWarehServiceImpl.findActivityWarehs(warehList);
        if (null == stActivityWarehList || stActivityWarehList.size() <= 0) {
            return null;
        }

        //分出新ERP仓和老ERP仓
        List<String> newErpWarehList = new ArrayList<String>(); //新ERP仓库编码集合
        List<String> oldErpWarehList = new ArrayList<String>(); //老ERP仓库编码集合
        for (StActivityWareh stActivityWareh : stActivityWarehList) {
            if (activityWarehServiceImpl.isNewERP(stActivityWareh.getDataSource())) {
                newErpWarehList.add(stActivityWareh.getWarehId());
            } else {
                oldErpWarehList.add(stActivityWareh.getWarehId());
            }
        }

        List<QryLockStockResultBean> qryLockStockList = new ArrayList<QryLockStockResultBean>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("reservedTypeList", reservedTypeList);
        map.put("skuList", skuList);

        if (page != null) {
            PageThreadLocal.setThreadLocalPage(page);
        }

        //根据新ERP仓库编码集合查出对应锁定量
        if (newErpWarehList.size() > 0) {
            map.put("warehList", newErpWarehList);
            List<SfWarehLockedLstDefine> list = this.sfWarehLockedLstMapper.selectLockStockByOthers(map);

            for (SfWarehLockedLstDefine bean : list) {
                QryLockStockResultBean qryLockStock = new QryLockStockResultBean();
                qryLockStock.setWarehId(bean.getWarehId());
                qryLockStock.setReservedType(bean.getLockedType());
                qryLockStock.setProdId(bean.getProdNum());
                qryLockStock.setStock(bean.getLockedQty());
                qryLockStockList.add(qryLockStock);
            }
        }

        //根据老ERP仓库编码集合查出对应锁定量
        if (oldErpWarehList.size() > 0) {
            map.put("warehList", oldErpWarehList);
            List<WarehLockedLst> list = this.warehLockedLstMapper.selectLockStockByOthers(map);

            for (WarehLockedLst bean : list) {
                QryLockStockResultBean qryLockStock = new QryLockStockResultBean();
                qryLockStock.setWarehId(bean.getWarehId());
                qryLockStock.setReservedType(bean.getLockedType());
                qryLockStock.setProdId(bean.getProdId());
                qryLockStock.setStock(bean.getLockedQty());
                qryLockStockList.add(qryLockStock);
            }
        }

        return qryLockStockList;
    }

}
