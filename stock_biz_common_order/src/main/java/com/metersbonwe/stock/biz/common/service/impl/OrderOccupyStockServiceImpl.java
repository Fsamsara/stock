package com.metersbonwe.stock.biz.common.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.utils.CloneUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.metersbonwe.stock.biz.common.localcache.CacheManager;
import com.metersbonwe.stock.biz.common.localcache.CacheName;
import com.metersbonwe.stock.biz.common.localcache.LocalCache;
import com.metersbonwe.stock.biz.common.service.CacheService;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.OrderOccupyStockService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelOrderDetailMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelProdMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelProdSubMapper;
import com.metersbonwe.stock.dal.define.core.mapper.OrderOccupyAndReleaseDefineMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelOrderDetail;
import com.metersbonwe.stock.po.core.StockChannelOrderDetailExample;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.pojo.StockChannelBean;
import com.metersbonwe.stock.utils.concurrent.OrderOccupyReleaseLock;

@Service public class OrderOccupyStockServiceImpl implements OrderOccupyStockService {
    private static StockLog                     LOOGER = StockLogFactory.getLogger(OrderOccupyStockServiceImpl.class);

    @Resource StockChannelOrderDetailMapper     stockChannelOrderDetailMapper;

    @Resource StockChannelProdSubMapper         stockChannelProdSubMapper;

    @Resource OrderOccupyAndReleaseDefineMapper orderOccupyAndReleaseDefineMapper;

    @Resource StockChannelProdMapper            stockChannelProdMapper;

    @Resource MqSendService                     mqSendServiceImpl;

    @Resource CacheManager                      cacheManagerImpl;

    @Resource CacheService                      cacheServiceImpl;

    @Transactional
    @Override
    public void processOrderOccupyStock(StockChannelBean stockChannelBean) throws Exception {
        LOOGER.debug("=====进入订单预占流程，参数:" + JSON.toJSONString(stockChannelBean));
        long startTime = System.currentTimeMillis();
        int orderCount = 0;
        try {
            // 每个单号会存在二次占用(下单，付款)，拆单前，拆单后，拆单后会有子单号，如果存在子单说明是第二次占用，需要补充数据库数据
            String subOrderId = stockChannelBean.getSubOrderId();
            List<StockChannelOrderDetail> querydetails = selectChannelOrderDetail(stockChannelBean);
            // 无数据   需要插入订单预占明细表
            if (CollectionUtils.isEmpty(querydetails)) {
                List<String> channels = insertToOrderAndChannelSubDetail(stockChannelBean);
                // 反查一次数据 发送MQ 为了性能不用 union all  单条查询
                Set<String> set = Sets.newHashSet(channels);

                LOOGER.debug("订单预占(渠道:" + stockChannelBean.getChannelCode() + "商品:" + stockChannelBean.getProdId() + "), 关联的渠道列表:" + set.toString());

                for (String channel : set) {
                    StockChannelBean bean = new StockChannelBean();
                    bean.setChannelCode(channel);
                    bean.setProdId(stockChannelBean.getProdId());
                    ChannelProdBean prodBean = orderOccupyAndReleaseDefineMapper.selectChannelProdDetail(bean);
                    if (prodBean == null) {
                        LOOGER.warn("订单占用后，查询不到渠道商品明细数据，不作推送线上操作，参数:" + JSON.toJSONString(bean));
                        continue;
                    }
                    mqSendServiceImpl.sendToOnLineChannelStock(prodBean, prodBean.getChannelCode());
                }
                orderCount = set.size();
            } else {
                for (StockChannelOrderDetail stockChannelOrderDetail : querydetails) {
                    String subOrderIdQuery = stockChannelOrderDetail.getSubOrderId();
                    // 查询出的数据无 子单号  传过来的有子单号  说明是需要 更新预占明细表数据
                    if (StringUtils.isBlank(subOrderIdQuery) && StringUtils.isNotBlank(subOrderId)) {
                        stockChannelOrderDetail.setSubOrderId(subOrderId);
                        updateToOrderDetail(stockChannelOrderDetail);
                        orderCount++;
                    }
                }
            }

        } catch (Exception e) {
            LOOGER.error("订单占用流程出错，参数:" + JSON.toJSONString(stockChannelBean) + "," + e.getMessage(), e);
        }
        LOOGER.debug("=====订单预占流程结束，参数占用的数量总数:" + orderCount + " ,用时:" + (System.currentTimeMillis() - startTime) + " ms");
    }

    private void updateToOrderDetail(StockChannelOrderDetail stockChannelOrderDetail) throws IllegalAccessException, InvocationTargetException {
        StockChannelOrderDetailExample example = new StockChannelOrderDetailExample();
        example.or().andBusinessIdEqualTo(stockChannelOrderDetail.getBusinessId()).andChannelCodeEqualTo(stockChannelOrderDetail.getChannelCode())
                .andProdIdEqualTo(stockChannelOrderDetail.getProdId()).andRelationChannelEqualTo(stockChannelOrderDetail.getRelationChannel());
        StockChannelOrderDetail updateDetail = new StockChannelOrderDetail();
        updateDetail.setSubOrderId(stockChannelOrderDetail.getSubOrderId());
        stockChannelOrderDetailMapper.updateByExampleSelective(updateDetail, example);
    }

    @Transactional
    private List<String> insertToOrderAndChannelSubDetail(StockChannelBean stockChannelBean) throws Exception {
        Lock lock = null;
        List<String> relationChannels = Lists.newArrayList();
        try {
            lock = OrderOccupyReleaseLock.getLockByProdId(stockChannelBean.getProdId());
            if (lock.tryLock(30, TimeUnit.SECONDS)) {
                ChannelProdBean prodBean = orderOccupyAndReleaseDefineMapper.selectChannelProdDetail(stockChannelBean);
                if (prodBean == null) {
                    throw new RuntimeException("查询不到渠道子表信息，无法预占，参数:" + JSON.toJSONString(stockChannelBean));
                }
                // 可用独占量
                int usefulPirvateStock = prodBean.getPrivateStock() - prodBean.getOrderPrivateTotalStock();
                // 店群可用值
                int shopGroupStock = prodBean.getShopGroupStock() - prodBean.getOrderShopGroupStock();
                // 占用量
                int occupyStock = stockChannelBean.getOccupyStock();
                StockChannelOrderDetail detail = new StockChannelOrderDetail();
                BeanUtils.copyProperties(detail, stockChannelBean);
                detail.setRelationChannel(stockChannelBean.getChannelCode());
                detail.setUpdateTime(new Date());
                // 1 为真 标识是全流通占用
                if (stockChannelBean.getIsFullCirculation() != null && stockChannelBean.getIsFullCirculation().intValue() == 1) {
                    //获取自由量共享时的关联渠道
                    List<String> channels = cacheServiceImpl.getAllUsefulChannelForCache();
                    for (String channel : channels) {
                        StockChannelOrderDetail orderDetail = new StockChannelOrderDetail();
                        BeanUtils.copyProperties(orderDetail, stockChannelBean);
                        orderDetail.setRelationChannel(channel);
                        // 全渠道自由共享预占量
                        orderDetail.setOrderShareStock(occupyStock);
                        orderDetail.setUpdateTime(new Date());
                        StockChannelBean channelBean = new StockChannelBean();
                        channelBean.setChannelCode(channel);
                        channelBean.setProdId(stockChannelBean.getProdId());
                        // 更新渠道商品预占总量时使用
                        channelBean.setOccupyShareStock(orderDetail.getOrderShareStock());
                        // 更新订单明细表
                        stockChannelOrderDetailMapper.insert(orderDetail);
                        // 更新渠道商品信息子表
                        orderOccupyAndReleaseDefineMapper.updateChannelSubDetailForOccupy(channelBean);
                    }
                } else {
                    // 预售逻辑 
                    if (stockChannelBean.getIsPreOccupy() != null && stockChannelBean.getIsPreOccupy() == 1 && prodBean.getIsPre() == 1) {
                        stockChannelBean.setOccupyPrePrivateStock(stockChannelBean.getOccupyStock());
                        detail.setOrderPrivateStock(occupyStock);
                        detail.setIsPreOccupy(stockChannelBean.getIsPreOccupy());
                        stockChannelOrderDetailMapper.insert(detail);
                        //更新渠道商品信息子表(预占总量)
                        orderOccupyAndReleaseDefineMapper.updateChannelSubDetailForOccupy(stockChannelBean);
                        relationChannels.add(stockChannelBean.getChannelCode());
                    }
                    // 实物且完全独占逻辑
                    else if (prodBean.getIsPre() == 0 && occupyStock <= usefulPirvateStock) {
                        stockChannelBean.setOccupyPrivateStock(occupyStock);
                        detail.setOrderPrivateStock(occupyStock);
                        stockChannelOrderDetailMapper.insert(detail);
                        //更新渠道商品信息子表(实物独占总量)
                        orderOccupyAndReleaseDefineMapper.updateChannelSubDetailForOccupy(stockChannelBean);
                        relationChannels.add(stockChannelBean.getChannelCode());
                    }
                    //实物且 订单量 大于独占可用量 小于 店群共享量 时逻辑
                    else if (prodBean.getIsPre() == 0 && occupyStock - usefulPirvateStock <= shopGroupStock) {
                        if (usefulPirvateStock > 0) {
                            detail.setOrderPrivateStock(usefulPirvateStock);
                            stockChannelBean.setOccupyPrivateStock(usefulPirvateStock);
                            stockChannelOrderDetailMapper.insert(detail);
                            //更新渠道商品信息子表(实物独占总量)
                            orderOccupyAndReleaseDefineMapper.updateChannelSubDetailForOccupy(stockChannelBean);
                        }
                        // 获取店群的关联渠道
                        List<String> channels = getShopGroupUsefulChannels(prodBean.getChannelCode());
                        for (String channel : channels) {
                            StockChannelOrderDetail orderDetail = new StockChannelOrderDetail();
                            BeanUtils.copyProperties(orderDetail, stockChannelBean);
                            orderDetail.setRelationChannel(channel);
                            // 店群共享预占量
                            orderDetail.setOrderShopGroupStock(occupyStock - usefulPirvateStock);
                            orderDetail.setUpdateTime(new Date());
                            StockChannelBean channelBean = new StockChannelBean();
                            channelBean.setChannelCode(channel);
                            channelBean.setProdId(orderDetail.getProdId());
                            // 更新渠道商品预占总量时使用
                            channelBean.setOccupyShopGroupStock(orderDetail.getOrderShopGroupStock());
                            // 更新订单明细表
                            stockChannelOrderDetailMapper.insert(orderDetail);
                            // 更新渠道商品信息子表（总量）
                            orderOccupyAndReleaseDefineMapper.updateChannelSubDetailForOccupy(channelBean);
                        }
                        relationChannels = channels;
                    }
                    // 实物 且 占用量 大于 (独占) 更新 预占独占总量、预占共享总量时逻辑
                    else if (prodBean.getIsPre() == 0 && occupyStock - usefulPirvateStock - shopGroupStock > 0) {
                        List<String> allChannels = Lists.newArrayList();
                        // 如果可用独占量 大于 0 说明有部分 库存 需要更新到独占预占总量
                        if (usefulPirvateStock > 0) {
                            detail.setOrderPrivateStock(usefulPirvateStock);
                            stockChannelBean.setOccupyPrivateStock(usefulPirvateStock);
                            stockChannelOrderDetailMapper.insert(detail);
                            //更新渠道商品信息子表(总量)
                            orderOccupyAndReleaseDefineMapper.updateChannelSubDetailForOccupy(stockChannelBean);
                        }
                        // 说明部分 库存 需要更新到 店群共享预占总量里面
                        if (shopGroupStock > 0) {
                            // 获取店群的关联渠道
                            List<String> channels = getShopGroupUsefulChannels(prodBean.getChannelCode());
                            for (String channel : channels) {
                                StockChannelOrderDetail orderDetail = new StockChannelOrderDetail();
                                BeanUtils.copyProperties(orderDetail, stockChannelBean);
                                orderDetail.setRelationChannel(channel);
                                // 店群共享预占量
                                orderDetail.setOrderShopGroupStock(shopGroupStock);
                                orderDetail.setUpdateTime(new Date());
                                StockChannelBean channelBean = new StockChannelBean();
                                channelBean.setChannelCode(channel);
                                channelBean.setProdId(orderDetail.getProdId());
                                // 更新渠道商品预占总量时使用
                                channelBean.setOccupyShopGroupStock(orderDetail.getOrderShopGroupStock());
                                // 更新订单明细表
                                stockChannelOrderDetailMapper.insert(orderDetail);
                                // 更新渠道商品信息子表（总量）
                                orderOccupyAndReleaseDefineMapper.updateChannelSubDetailForOccupy(channelBean);
                            }
                            allChannels.addAll(channels);
                        }
                        //获取自由量共享时的关联渠道
                        List<String> channels = getShareUsefulChannels(prodBean.getChannelCode());
                        for (String channel : channels) {
                            StockChannelOrderDetail orderDetail = new StockChannelOrderDetail();
                            BeanUtils.copyProperties(orderDetail, stockChannelBean);
                            orderDetail.setRelationChannel(channel);
                            // 全渠道自由共享预占量
                            orderDetail.setOrderShareStock(occupyStock - usefulPirvateStock - shopGroupStock);
                            orderDetail.setUpdateTime(new Date());
                            StockChannelBean channelBean = new StockChannelBean();
                            channelBean.setChannelCode(channel);
                            channelBean.setProdId(stockChannelBean.getProdId());
                            // 更新渠道商品预占总量时使用
                            channelBean.setOccupyShareStock(orderDetail.getOrderShareStock());
                            // 更新订单明细表
                            stockChannelOrderDetailMapper.insert(orderDetail);
                            // 更新渠道商品信息子表
                            orderOccupyAndReleaseDefineMapper.updateChannelSubDetailForOccupy(channelBean);
                        }
                        allChannels.addAll(channels);
                        relationChannels = allChannels;
                    }
                }
            } else {
                throw new Exception("订单占用时拿锁失败！");
            }
            return relationChannels;
        } catch (Exception e) {
            LOOGER.error("订单占用出错,入参:" + JSON.toJSONString(stockChannelBean) + "," + e.getMessage(), e);
            throw e;
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }

    }

    /**
     * TODO 获取自由量配发范围关联渠道
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @SuppressWarnings("unchecked")
    private List<String> getShareUsefulChannels(String channelCode) throws CloneNotSupportedException {
        List<String> reChannels = Lists.newArrayList();
        List<String> conWarehIds = Lists.newArrayList();
        LocalCache<Object, Object> cache = cacheManagerImpl.getCache(CacheName.CHANNELUSEFULWAREH.getCacheName());
        if (cache.containsKey(channelCode)) {
            conWarehIds = (List<String>) cache.get(channelCode);
        }
        for (Object key : cache.getMap().keySet()) {
            List<String> warehIds = (List<String>) cache.getMap().get(key);
            List<String> cloneList = (List<String>) CloneUtils.clone(conWarehIds);
            cloneList.retainAll(warehIds);
            if (cloneList.size() > 0) {
                reChannels.add(key.toString());
            }
        }
        return reChannels;
    }

    /**
     * TODO 获取店群关联渠道
     *
     * @param channelCode
     * @return
     */
    private List<String> getShopGroupUsefulChannels(String channelCode) {
        List<String> channels = Lists.newArrayList();
        LocalCache<Object, Object> cache = cacheManagerImpl.getCache(CacheName.SHOPGROUP.getCacheName());
        Map<Object, Object> map = cache.getMap();
        if (cache.containsKey(channelCode)) {
            String groupId = (String) map.get(channelCode);
            for (Object obj : map.keySet()) {
                if (groupId.equals(map.get(obj))) {
                    channels.add(obj.toString());
                }
            }
        }
        return channels;
    }

    private List<StockChannelOrderDetail> selectChannelOrderDetail(StockChannelBean stockChannelBean) {
        StockChannelOrderDetailExample example = new StockChannelOrderDetailExample();
        example.or().andChannelCodeEqualTo(stockChannelBean.getChannelCode()).andProdIdEqualTo(stockChannelBean.getProdId())
                .andBusinessIdEqualTo(stockChannelBean.getBusinessId());
        return stockChannelOrderDetailMapper.selectByExample(example);
    }

}
