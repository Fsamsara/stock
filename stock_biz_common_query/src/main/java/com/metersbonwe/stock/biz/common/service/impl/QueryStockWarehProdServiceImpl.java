package com.metersbonwe.stock.biz.common.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.metersbonwe.stock.biz.common.service.ActivityWarehService;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.biz.common.service.QueryStockWarehProdService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockWarehProdMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockWarehProdDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.UdWarehParamDefineMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.po.core.StockWarehProdExample;
import com.metersbonwe.stock.po.core.StockWarehProdExample.Criteria;
import com.metersbonwe.stock.po.core.define.StockWarehProdTableNumDefine;
import com.metersbonwe.stock.po.sync.define.UdWarehParamDefine;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.PageThreadLocal;

@Service public class QueryStockWarehProdServiceImpl implements QueryStockWarehProdService {

    private static StockLog                       stockLog = StockLogFactory.getLogger(QueryStockWarehProdServiceImpl.class);

    @Resource private MultiTableService           multiTableServiceImpl;

    @Autowired private StockWarehProdMapper       stockWarehProdMapper;

    @Autowired private StockWarehProdDefineMapper stockWarehProdDefineMapper;

    @Autowired private UdWarehParamDefineMapper   udWarehParamDefineMapper;

    @Resource private ActivityWarehService        activityWarehServiceImpl;

    /**
     * TODO 多仓、多sku获取仓+sku库存量
     * 
     * @see com.metersbonwe.stock.biz.common.service.QueryStockWarehProdService#getWarehSkuStock(java.util.List, java.util.List)
     */
    public List<StockWarehProd> getWarehsSkusStock(List<String> warehList, List<String> skuList) {
        return getWarehsSkusStock_Page(null, warehList, skuList);
    }

    /**
     * TODO 多仓、多sku分页获取仓+sku库存量
     * 
     * @see com.metersbonwe.stock.biz.common.service.QueryStockWarehProdService#getWarehsSkusStock_Page(com.metersbonwe.stock.pojo.Page,
     *      java.util.List, java.util.List)
     */
    public List<StockWarehProd> getWarehsSkusStock_Page(Page<?> page, List<String> warehList, List<String> skuList) {
        if (skuList == null || skuList.size() <= 0) {
            stockLog.error("getWarehSkuStock:传入的商品编码集合为空");
            return null;
        }
        try {
            String prodId = skuList.get(0);
            if (prodId == null || "".equals(prodId)) {
                stockLog.error("getWarehSkuStock:传入的第一个商品编码为空");
                return null;
            }
            int prodLen = prodId.length();
            stockLog.debug("getWarehSkuStock:开始获取仓+sku库存,根据商品" + String.valueOf(prodLen) + "位码来查");
            List<StockWarehProd> stockWarehProdList = Lists.newArrayList();
            String[] warehArray = warehList.toArray(new String[warehList.size()]);
            Map<String, Set<String>> tableSuffMap = this.multiTableServiceImpl.getTableSuffByWarehsMap(warehArray);
            if (tableSuffMap != null && tableSuffMap.size() > 0) {
                List<StockWarehProdTableNumDefine> tableNumDefineList = new ArrayList<StockWarehProdTableNumDefine>();
                for (Entry<String, Set<String>> entry : tableSuffMap.entrySet()) {
                    String tableNum = entry.getKey();
                    List<String> wList = Lists.newArrayList();
                    wList.addAll(entry.getValue());

                    StockWarehProdTableNumDefine tableNumDefine = new StockWarehProdTableNumDefine();
                    tableNumDefine.setTableNum(tableNum);
                    tableNumDefine.setWarehList(wList);

                    tableNumDefineList.add(tableNumDefine);
                }

                Map<String, Object> map = new HashMap<String, Object>();
                map.put("tableNumList", tableNumDefineList);
                if (prodLen == 6) { //商品6位码
                    map.put("sku6List", skuList);
                } else if (prodLen == 8) { //商品8位码
                    map.put("sku8List", skuList);
                } else { //商品11位码
                    map.put("skuList", skuList);
                }

                if (page != null) {
                    PageThreadLocal.setThreadLocalPage(page);
                }
                stockWarehProdList = this.stockWarehProdDefineMapper.selectStockWarehProdListByLenProdAndOthers(map);
            }
            return stockWarehProdList;
        } catch (Exception ex) {
            stockLog.error("getWarehSkuStock:获取仓+sku库存出现异常", ex);
            return null;
        } finally {
            stockLog.debug("getWarehSkuStock:结束获取仓+sku库存");
        }
    }

    /**
     * TODO 单仓、多sku获取仓+sku库存量
     * 
     * @see com.metersbonwe.stock.biz.common.service.QueryStockWarehProdService#getWarehSkuStock(java.lang.String, java.util.List)
     */
    public List<StockWarehProd> getWarehSkuStock(String warehId, List<String> skuList) {
        if (skuList == null || skuList.size() <= 0) {
            stockLog.error("getWarehSkuStock:传入的商品编码集合为空");
            return null;
        }
        return getWarehSkuStockByPage(null, warehId, skuList);
    }

    /**
     * TODO 可以按分页查询单仓、多sku或没有sku获取仓+sku库存量
     * 
     * @see com.metersbonwe.stock.biz.common.service.QueryStockWarehProdService#getWarehSkuStock(java.lang.String, java.util.List)
     */
    public List<StockWarehProd> getWarehSkuStockByPage(Page<?> page, String warehId, List<String> skuList) {
        try {
            stockLog.debug("getWarehSkuStock:开始获取仓+sku库存,根据仓库编码" + warehId + "来查");
            String tableNum = this.multiTableServiceImpl.getTableSuffixByWarehId(warehId);

            StockWarehProdExample example = new StockWarehProdExample();
            example.setTableNum(tableNum);
            Criteria criteria = example.createCriteria();
            criteria.andWarehIdEqualTo(warehId);

            if (skuList != null && skuList.size() > 0) {
                String prodId = skuList.get(0);
                if (prodId == null || "".equals(prodId)) {
                    stockLog.error("getWarehSkuStock:传入的第一个商品编码为空");
                    return null;
                }
                int prodLen = prodId.length();
                if (prodLen == 6) { //商品6位码
                    criteria.andSixProdIdIn(skuList);
                } else if (prodLen == 8) { //商品8位码
                    criteria.andEightProdIdIn(skuList);
                } else { //商品11位码
                    criteria.andProdIdIn(skuList);
                }
            }
            if (page != null) {
                PageThreadLocal.setThreadLocalPage(page);
            }
            List<StockWarehProd> stockWarehProdList = this.stockWarehProdMapper.selectByExample(example);
            return stockWarehProdList;
        } catch (Exception ex) {
            stockLog.error("getWarehSkuStock:获取仓+sku库存出现异常", ex);
            return null;
        } finally {
            stockLog.debug("getWarehSkuStock:结束获取仓+sku库存");
        }
    }

    /**
     * 多仓、多sku获取仓+sku库存量 TODO 根据仓库集合、商品编码集合获取仓+sku自由量（union all）
     * 
     * @see com.metersbonwe.stock.biz.common.service.QueryStockWarehProdService#selectStockWarehProdListByOthers(java.util.List, java.util.List)
     */
    public List<StockWarehProd> selectStockWarehProdListByOthers(String channelSource, List<String> warehList, List<String> skuList) {
        if (warehList == null || warehList.size() <= 0) {
            stockLog.error("selectStockWarehProdListByOthers:传入的仓库编码集合为空");
            return null;
        }
        if (skuList == null || skuList.size() <= 0) {
            stockLog.error("selectStockWarehProdListByOthers:传入的商品编码集合为空");
            return null;
        }
        try {
            //仓库参数Map
            Map<String, UdWarehParamDefine> udWarehParamMap = null;
            boolean isOffline = activityWarehServiceImpl.isChannelSourceOffLine(channelSource);
            if (isOffline) { //线下
                Map<String, Object> paramMap = new HashMap<String, Object>();
                paramMap.put("warehList", warehList);
                //查询仓属性安全库存
                List<UdWarehParamDefine> udWarehParamDefineList = this.udWarehParamDefineMapper.selectWarehParamByWarehs(paramMap);
                if (udWarehParamDefineList != null && udWarehParamDefineList.size() > 0) {
                    udWarehParamMap = new HashMap<String, UdWarehParamDefine>();
                    for (UdWarehParamDefine udWarehParamDefine : udWarehParamDefineList) {
                        udWarehParamMap.put(udWarehParamDefine.getCode(), udWarehParamDefine);
                    }
                } else {
                    stockLog.error("selectStockWarehProdListByOthers:传入的仓库不支持统一库存,请排查仓库" + warehList.toString());
                    return null;
                }
            }

            List<StockWarehProd> stockWarehProdList = Lists.newArrayList();
            List<StockWarehProdTableNumDefine> tableNumDefineList = new ArrayList<StockWarehProdTableNumDefine>();
            String[] warehArray = warehList.toArray(new String[warehList.size()]);
            Map<String, Set<String>> tableSuffMap = this.multiTableServiceImpl.getTableSuffByWarehsMap(warehArray);
            if (tableSuffMap != null && tableSuffMap.size() > 0) {
                for (Entry<String, Set<String>> entry : tableSuffMap.entrySet()) {
                    String tableNum = entry.getKey();
                    List<String> wList = Lists.newArrayList();
                    wList.addAll(entry.getValue());

                    StockWarehProdTableNumDefine tableNumDefine = new StockWarehProdTableNumDefine();
                    tableNumDefine.setTableNum(tableNum);
                    tableNumDefine.setWarehList(wList);

                    tableNumDefineList.add(tableNumDefine);
                }

                Map<String, Object> map = new HashMap<String, Object>();
                map.put("tableNumList", tableNumDefineList);
                map.put("skuList", skuList);
                stockWarehProdList = this.stockWarehProdDefineMapper.selectStockWarehProdListByOthers(map);

                for (StockWarehProd stockWarehProd : stockWarehProdList) {
                    String warehId = stockWarehProd.getWarehId();
                    if (udWarehParamMap != null && udWarehParamMap.size() > 0) { //线下计算仓库最终自由量
                        UdWarehParamDefine udWarehParamDefine = udWarehParamMap.get(warehId);
                        if (udWarehParamDefine != null && udWarehParamDefine.getShoped() != 1) { //非门店
                            if (stockWarehProd.getFreeShareStock() > 0) {
                                //获取安全库存
                                BigDecimal saleQty = new BigDecimal(0);
                                String offlineSafeqtyTyp = udWarehParamDefine.getOfflineSafeqtyType();
                                if (activityWarehServiceImpl.isWSSafetyStockType(offlineSafeqtyTyp)) {
                                    saleQty = udWarehParamDefine.getSafetyStock(); //取仓库属性中的全局安全库存
                                }

                                //自由量-正数锁定量-安全库存;
                                int finalFreeShareStock = IntegerToInt(stockWarehProd.getFreeShareStock())
                                        - IntegerToInt(stockWarehProd.getWmsStock()) - BigDecimalToInt(saleQty);
                                if (finalFreeShareStock < 0) {
                                    finalFreeShareStock = 0;
                                }
                                stockWarehProd.setFinalFreeShareStock(finalFreeShareStock);
                            } else {
                                stockWarehProd.setFinalFreeShareStock(stockWarehProd.getFreeShareStock());
                            }

                        }
                    }
                }
            }

            return stockWarehProdList;
        } catch (Exception ex) {
            stockLog.error("getWarehSkuStock:获取仓+sku库存出现异常", ex);
            return null;
        } finally {
            stockLog.debug("getWarehSkuStock:结束获取仓+sku库存");
        }
    }

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

}
