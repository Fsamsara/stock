package com.metersbonwe.stock.biz.common.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.ActivityWarehService;
import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.biz.common.service.PosAlloctSumQueryStockService;
import com.metersbonwe.stock.biz.common.service.QueryStockWarehProdService;
import com.metersbonwe.stock.dal.define.sync.mapper.BfOrgShopGroupDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.UdChannleStockScopeDtlDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.UdWarehParamDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.UrUnitReservedResultDefineMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.po.sync.UdChannleStockScopeDtl;
import com.metersbonwe.stock.po.sync.UrUnitReservedResult;
import com.metersbonwe.stock.po.sync.define.UdWarehParamDefine;
import com.metersbonwe.stock.pojo.AllotScopeParamBean;
import com.metersbonwe.stock.pojo.AllotScopeStockBean;
import com.metersbonwe.stock.pojo.QueryStockAllParamBean;
import com.metersbonwe.stock.pojo.QueryStockResultBean;
import com.metersbonwe.stock.pojo.WarehProdLockedBean;

@Service public class PosAlloctSumQueryStockServiceImpl implements PosAlloctSumQueryStockService {

    private static StockLog                               stockLog = StockLogFactory.getLogger(PosAlloctSumQueryStockServiceImpl.class);

    @Resource private AllocationRangeService              allocationRangeServiceImpl;

    @Autowired private UdChannleStockScopeDtlDefineMapper udChannleStockScopeDtlDefineMapper;

    @Autowired private UrUnitReservedResultDefineMapper   urUnitReservedResultMapper;

    @Autowired private UdWarehParamDefineMapper           udWarehParamDefineMapper;

    @Resource private QueryStockWarehProdService          queryStockWarehProdServiceImpl;

    @Resource private ActivityWarehService                activityWarehServiceImpl;

    @Autowired private BfOrgShopGroupDefineMapper         bfOrgShopGroupDefineMapper;

    /**
     * TODO 获取有效的配发范围 TODO 获取配发范围并且排除掉过滤的仓库门店
     * 
     * @param paramBean
     * @return
     */
    private List<AllotScopeStockBean> getRightAllotScope(QueryStockAllParamBean paramBean) {

        AllotScopeParamBean allotScopeParamBean = new AllotScopeParamBean();
        allotScopeParamBean.setChannelSource(paramBean.getChannelSource());
        if (paramBean.getQueryModule() != 3) { //非全流通库存查询（总查询）
            allotScopeParamBean.setChannelCode(paramBean.getChannelCode());
            allotScopeParamBean.setCounty(paramBean.getCounty());
            allotScopeParamBean.setProvince(paramBean.getProvince());
            allotScopeParamBean.setCity(paramBean.getCity());
            allotScopeParamBean.setDistrict(paramBean.getDistrict());
        }

        //掉用配发范围接口查询配发范围
        List<AllotScopeStockBean> allotScopeList = this.allocationRangeServiceImpl.getAllotScope(allotScopeParamBean);
        if (allotScopeList == null || allotScopeList.size() <= 0) {
            stockLog.warn("getRightAllotScope:没有找到配发范围,参数" + paramBean.getChannelCode());
            return null;
        }

        //过滤掉排除仓和店
        List<String> extWarehShopList = paramBean.getExtWarehShopList();
        if (null != extWarehShopList && extWarehShopList.size() > 0) {
            List<AllotScopeStockBean> delAllotScopeList = new ArrayList<AllotScopeStockBean>(); //需排除的配发范围
            for (AllotScopeStockBean allotScopeBean : allotScopeList) {
                if (extWarehShopList.contains(allotScopeBean.getWarehShopId())) {
                    delAllotScopeList.add(allotScopeBean);
                }
            }
            allotScopeList.removeAll(delAllotScopeList);
        }

        return allotScopeList;
    }

    /**
     * TODO 查询启用B2B仓的预留独占量 TODO 查询启用B2B仓的预留独占量
     * 
     * @param channelCode
     * @param skuList
     * @param udWarehParamDefineList
     * @return
     */
    private List<UrUnitReservedResult> getReservedStockByB2BWareh(String channelCode, List<String> skuList,
            List<UdWarehParamDefine> udWarehParamDefineList) {
        List<String> b2bWarehList = new ArrayList<String>();
        for (UdWarehParamDefine udWarehParamDefine : udWarehParamDefineList) {
            if ("1".equals(udWarehParamDefine.getIsTfoDistWareh())) {
                b2bWarehList.add(udWarehParamDefine.getCode());
            }
        }
        List<UrUnitReservedResult> urUnitReservedResultList = null;
        if (b2bWarehList.size() > 0) { //有B2B仓
            List<UdChannleStockScopeDtl> udChannleStockScopeList = this.udChannleStockScopeDtlDefineMapper.selectLockTypeByOnlineAndMonopolize();
            if (udChannleStockScopeList != null && udChannleStockScopeList.size() > 0) {

                List<String> channelCodeList = new ArrayList<String>();
                channelCodeList.add(channelCode);
                //查找店群编码
                List<Map<String, String>> channelGroupMapList = bfOrgShopGroupDefineMapper.selectShopGroup(channelCodeList);
                if (channelGroupMapList != null && channelGroupMapList.size() > 0) {
                    for (Map<String, String> channelGroupMap : channelGroupMapList) {
                        String groupCode = channelGroupMap.get("GROUP_CODE");
                        stockLog.info("getReservedStockByB2BWareh:当前渠道编码" + channelGroupMap.get("CHANNEL_CODE") + "对应的店群编码" + groupCode);
                        channelCodeList.add(groupCode);
                    }
                }

                List<String> lockTypeList = new ArrayList<String>();
                for (UdChannleStockScopeDtl udChannleStockScope : udChannleStockScopeList) {
                    lockTypeList.add(udChannleStockScope.getUdLockedType());
                }
                Map<String, Object> prarmMap = new HashMap<String, Object>();
                prarmMap.put("unitList", channelCodeList);
                prarmMap.put("reservedTypeList", lockTypeList);
                prarmMap.put("warehList", b2bWarehList);
                prarmMap.put("skuList", skuList);
                urUnitReservedResultList = this.urUnitReservedResultMapper.selectReservedStockByOthers(prarmMap);
            }
        }
        return urUnitReservedResultList;
    }

    /**
     * TODO 获取线下锁定量 TODO 功能详细描述
     */
    //    private List<WarehProdLockedBean> getLockStockUnLine(List<String> skuList, List<UdWarehParamDefine> udWarehParamDefineList) {
    //        List<WarehProdLockedBean> warehProdLockedList = new ArrayList<WarehProdLockedBean>();
    //
    //        List<String> newWarehList = new ArrayList<String>();
    //        List<String> oldWarehList = new ArrayList<String>();
    //        for (UdWarehParamDefine udWarehParamDefine : udWarehParamDefineList) {
    //            if (0 == udWarehParamDefine.getShoped()) { //非门店
    //                if (activityWarehServiceImpl.isNewERP(udWarehParamDefine.getProdSource())) {
    //                    newWarehList.add(udWarehParamDefine.getCode());
    //                } else {
    //                    oldWarehList.add(udWarehParamDefine.getCode());
    //                }
    //            }
    //        }
    //
    //        Map<String, Object> map = new HashMap<String, Object>();
    //        if (newWarehList.size() > 0) {
    //            map.clear();
    //            map.put("warehList", newWarehList);
    //            map.put("skuList", skuList);
    //            List<SfWarehLockedLstDefine> sfWarehLockedList = this.sfWarehLockedLstMapper.selectLockStockByOthersNoInLockedType(map);
    //            if (sfWarehLockedList != null && sfWarehLockedList.size() > 0) {
    //                for (SfWarehLockedLstDefine itemDefine : sfWarehLockedList) {
    //                    WarehProdLockedBean bean = new WarehProdLockedBean();
    //                    bean.setWarehId(itemDefine.getWarehId());
    //                    bean.setProdId(itemDefine.getProdNum());
    //                    bean.setLockedQty(itemDefine.getLockedQty());
    //                    warehProdLockedList.add(bean);
    //                }
    //            }
    //        }
    //
    //        if (oldWarehList.size() > 0) {
    //            map.clear();
    //            map.put("warehList", oldWarehList);
    //            map.put("skuList", skuList);
    //            List<WarehLockedLst> warehLockedList = this.warehLockedLstMapper.selectLockStockByOthersNoInLockedType(map);
    //            for (WarehLockedLst itemDefine : warehLockedList) {
    //                WarehProdLockedBean bean = new WarehProdLockedBean();
    //                bean.setWarehId(itemDefine.getWarehId());
    //                bean.setProdId(itemDefine.getProdId());
    //                bean.setLockedQty(itemDefine.getLockedQty());
    //                warehProdLockedList.add(bean);
    //            }
    //        }
    //
    //        return warehProdLockedList;
    //    }

    private int IntegerToInt(Integer gInteger) {
        int v = 0;
        if (gInteger != null) {
            v = gInteger;
        }
        return v;
    }

    private int BigDecimalToInt(BigDecimal bigDecimal) {
        int v = 0;
        if (bigDecimal != null) {
            v = bigDecimal.intValue();
        }
        return v;
    }

    /**
     * TODO 计算库存结果 TODO 计算库存结果
     * 
     * @param isOnline
     *            是否线上
     * @param stockWarehProdList
     *            仓+sku库存集合
     * @param urUnitReservedList
     *            B2B仓的预留独占量
     * @param warehProdLockedList
     *            线下获取仓库商品锁定量
     * @param udWarehParamDefineList
     *            仓库属性集合
     */
    private List<QueryStockResultBean> calcStockResult(boolean isOnline, List<StockWarehProd> stockWarehProdList,
            List<UrUnitReservedResult> urUnitReservedList, List<WarehProdLockedBean> warehProdLockedList,
            List<UdWarehParamDefine> udWarehParamDefineList) {

        //B2B仓的预留独占量有值(证明是线上)
        Map<String, UrUnitReservedResult> urUnitReservedMap = new HashMap<String, UrUnitReservedResult>();
        if (urUnitReservedList != null && urUnitReservedList.size() > 0) {
            for (UrUnitReservedResult urUnitReserved : urUnitReservedList) {
                String key = urUnitReserved.getWarehId() + ":" + urUnitReserved.getProdId();
                urUnitReservedMap.put(key, urUnitReserved);
            }
        }

        //        //仓库商品锁定量有值(证明是线下)  20160418  去掉了  因为仓+SKU表中的自由量已经减过锁定量
        //        Map<String, WarehProdLockedBean> warehProdLockedMap = new HashMap<String, WarehProdLockedBean>();
        //        if (warehProdLockedList != null && warehProdLockedList.size() > 0) {
        //            for (WarehProdLockedBean warehProdLocked : warehProdLockedList) {
        //                String key = warehProdLocked.getWarehId() + ":" + warehProdLocked.getProdId();
        //                warehProdLockedMap.put(key, warehProdLocked);
        //            }
        //        }

        //仓库参数Map
        Map<String, UdWarehParamDefine> udWarehParamMap = new HashMap<String, UdWarehParamDefine>();
        if (udWarehParamDefineList != null && udWarehParamDefineList.size() > 0) {
            for (UdWarehParamDefine udWarehParamDefine : udWarehParamDefineList) {
                udWarehParamMap.put(udWarehParamDefine.getCode(), udWarehParamDefine);
            }
        }

        List<QueryStockResultBean> queryStockResultList = new ArrayList<QueryStockResultBean>();
        for (StockWarehProd stockWarehProd : stockWarehProdList) {
            String warehShopId = stockWarehProd.getWarehId();
            String warehShopType = "";
            String prodId = stockWarehProd.getProdId();
            BigDecimal usefulStock = new BigDecimal(0); //可用库存

            //实物库存=实际库存量-已分配量
            BigDecimal stkOnHand = BigDecimal.valueOf(IntegerToInt(stockWarehProd.getStkOnHand()) - IntegerToInt(stockWarehProd.getQtyCommitted()));

            //B2B仓的预留独占量有值(证明是线上)
            BigDecimal duz_LockedQty = new BigDecimal(0); //预留独占量
            if (urUnitReservedMap.size() > 0) {
                String key = warehShopId + ":" + prodId;
                UrUnitReservedResult urUnitReserved = urUnitReservedMap.get(key);
                if (urUnitReserved != null) {
                    duz_LockedQty = urUnitReserved.getLockedQty();
                }
            }

            UdWarehParamDefine udWarehParam = udWarehParamMap.get(warehShopId);
            if (udWarehParam == null) {
                continue;
            }
            warehShopType = udWarehParam.getOrgType();

            if (udWarehParam.getShoped() == 1) { //门店
                warehShopType = "门店";
                //最终自由量共享(自由量-WMS正数锁定量-未日结-门店污损值-线上安全库存/线下安全库存)
                usefulStock = BigDecimal.valueOf(IntegerToInt(stockWarehProd.getFinalFreeShareStock()));
            } else { //仓库
                warehShopType = "仓库";
                if (isOnline) { //线上
                    //最终自由量共享(自由量-WMS正数锁定量-线上安全库存)+锁定共享量+预留独占量
                    usefulStock = BigDecimal.valueOf(IntegerToInt(stockWarehProd.getFinalFreeShareStock())
                            + IntegerToInt(stockWarehProd.getLockStock()) + BigDecimalToInt(duz_LockedQty));
                } else { //线下
                    //获取安全库存
                    BigDecimal saleQty = new BigDecimal(0);
                    String offlineSafeqtyTyp = udWarehParam.getOfflineSafeqtyType();
                    if (activityWarehServiceImpl.isWSSafetyStockType(offlineSafeqtyTyp)) {
                        saleQty = udWarehParam.getSafetyStock(); //取仓库属性中的全局安全库存
                    }

                    //                    //获取锁定量  20160418  去掉了  因为仓+SKU表中的自由量已经减过锁定量
                    //                    BigDecimal lockedQty = new BigDecimal(0); //锁定量
                    //                    String key = warehShopId + ":" + prodId;
                    //                    WarehProdLockedBean warehProdLocked = warehProdLockedMap.get(key);
                    //                    if (warehProdLocked != null) {
                    //                        lockedQty = warehProdLocked.getLockedQty();
                    //                    }

                    if (stockWarehProd.getFreeShareStock() > 0) {
                        //自由量-正数锁定量-锁定量-安全库存;  20160418  去掉了  因为仓+SKU表中的自由量已经减过锁定量
                        //                    usefulStock = BigDecimal.valueOf(IntegerToInt(stockWarehProd.getFreeShareStock()) - IntegerToInt(stockWarehProd.getWmsStock())
                        //                            - BigDecimalToLong(lockedQty) - BigDecimalToLong(saleQty));
                        //自由量-正数锁定量 -安全库存;
                        int v = IntegerToInt(stockWarehProd.getFreeShareStock()) - IntegerToInt(stockWarehProd.getWmsStock())
                                - BigDecimalToInt(saleQty);

                        usefulStock = v > 0 ? BigDecimal.valueOf(v) : new BigDecimal(0);

                    } else {
                        usefulStock = BigDecimal.valueOf(stockWarehProd.getFreeShareStock());
                    }
                }
            }

            QueryStockResultBean queryStockResultBean = new QueryStockResultBean();
            queryStockResultBean.setWarehShopId(warehShopId);
            queryStockResultBean.setProdId(prodId);
            queryStockResultBean.setWarehShopType(warehShopType);
            queryStockResultBean.setUsefulStock(usefulStock); //可用库存
            queryStockResultBean.setStkOnHand(stkOnHand); //实物库存
            queryStockResultList.add(queryStockResultBean);
        }
        return queryStockResultList;
    }

    /**
     * TODO 查询库存 TODO POS全流通、分配（手工分单）、全流通（总查询）共用方法
     * 
     * @param bean
     * @return
     */
    public List<QueryStockResultBean> queryStock(QueryStockAllParamBean paramBean) {

        boolean isOnline = activityWarehServiceImpl.isChannelSourceOnLine(paramBean.getChannelSource());
        int queryModule = paramBean.getQueryModule();

        //获取配发范围并过滤掉排除仓和店
        List<AllotScopeStockBean> allotScopeList = getRightAllotScope(paramBean);

        //查询仓库的所有参数
        List<String> warehList = new ArrayList<String>();
        for (AllotScopeStockBean allotScopeBean : allotScopeList) {
            warehList.add(allotScopeBean.getWarehShopId());
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("warehList", warehList);
        List<UdWarehParamDefine> udWarehParamDefineList = this.udWarehParamDefineMapper.selectWarehParamByWarehs(map);
        if (udWarehParamDefineList != null && udWarehParamDefineList.size() > 0) {
            warehList.clear();
            for (UdWarehParamDefine beanDefine : udWarehParamDefineList) {
                warehList.add(beanDefine.getCode());
            }
        } else {
            stockLog.error("queryStock:传入的仓库不支持统一库存,请排查仓库" + warehList.toString());
            return null;
        }

        //如果是线上且不是总量查询,查询启用B2B仓的预留独占量
        List<UrUnitReservedResult> urUnitReservedList = null;
        if (isOnline && queryModule != 3) {
            urUnitReservedList = getReservedStockByB2BWareh(paramBean.getChannelCode(), paramBean.getSkuList(), udWarehParamDefineList);
        }

        //获取仓+sku的库存量
        List<StockWarehProd> stockWarehProdList = this.queryStockWarehProdServiceImpl.getWarehsSkusStock(warehList, paramBean.getSkuList());

        //        //线下获取仓库商品锁定量  20160418  去掉了  因为仓+SKU表中的自由量已经减过锁定量
        List<WarehProdLockedBean> warehProdLockedList = null;
        //        if (!isOnline) {
        //            warehProdLockedList = getLockStockUnLine(paramBean.getSkuList(), udWarehParamDefineList);
        //        }

        //计算库存结果
        List<QueryStockResultBean> queryStockResultList = calcStockResult(
                isOnline,
                stockWarehProdList,
                urUnitReservedList,
                warehProdLockedList,
                udWarehParamDefineList);

        return queryStockResultList;
    }

}
