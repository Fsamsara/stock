package com.metersbonwe.stock.biz.common.service.impl;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.biz.common.service.CacheService;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelOrderDetailHisMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelOrderDetailMapper;
import com.metersbonwe.stock.dal.define.core.mapper.OrderOccupyAndReleaseDefineMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelOrderDetail;
import com.metersbonwe.stock.po.core.StockChannelOrderDetailExample;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.pojo.StockChannelBean;
import com.metersbonwe.stock.utils.concurrent.OrderOccupyReleaseLock;

public class OrderReleaseStockServiceImplBak {

    private static StockLog                     LOGGER  = StockLogFactory.getLogger(OrderReleaseStockServiceImplBak.class);

    @Resource OrderOccupyAndReleaseDefineMapper orderOccupyAndReleaseDefineMapper;

    @Resource StockChannelOrderDetailMapper     stockChannelOrderDetailMapper;

    @Resource StockChannelOrderDetailHisMapper  stockChannelOrderDetailHisMapper;

    @Resource MqSendService                     mqSendServiceImpl;

    @Resource CacheService                      cacheServiceImpl;

    ExecutorCompletionService<Integer>          service = new ExecutorCompletionService<Integer>(Executors.newFixedThreadPool(5));

    public int updateOrderReleaseStock(StockChannelBean stockChannelBean) throws Exception {
        LOGGER.debug("=======进入订单释放||取消==更新延迟释放渠道标识======,入参:" + (stockChannelBean == null ? null : JSON.toJSONString(stockChannelBean)));
        long startTime = System.currentTimeMillis();
        if (stockChannelBean == null || (StringUtils.isBlank(stockChannelBean.getSubOrderId())
                && (StringUtils.isBlank(stockChannelBean.getBusinessId()) || StringUtils.isBlank(stockChannelBean.getChannelCode())))) {
            throw new RuntimeException("订单释放||取消更新STATUS状态时 入参的 子单号为空的情况下 外部订单号和下单渠道 不能为空！");
        }
        List<String> prodIds = orderOccupyAndReleaseDefineMapper.selectReleaseProdIdsByChannelBean(stockChannelBean);
        int resultCount = 0;
        if (CollectionUtils.isNotEmpty(prodIds)) {
            for (String prodId : prodIds) {
                Lock lock = null;
                try {
                    lock = OrderOccupyReleaseLock.getLockByProdId(prodId);
                    if (lock.tryLock(60, TimeUnit.SECONDS)) {
                        stockChannelBean.setProdId(prodId);
                        resultCount += orderOccupyAndReleaseDefineMapper.updateReleaseChannelSubDetail(stockChannelBean);
                    } else {
                        throw new Exception("订单释放||取消更新STATUS状态 时拿锁失败！");
                    }
                } catch (Exception e) {
                    LOGGER.error("订单释放||取消更新STATUS状态失败，不作处理，参数:" + JSON.toJSONString(stockChannelBean) + "," + e.getMessage(), e);
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
            }
        }
        LOGGER.debug("====订单释放||取消更新STATUS状态===完成数量:" + resultCount + " , 耗时:" + (System.currentTimeMillis() - startTime) + " ms");
        return resultCount;
    }

    public void processOrderReleaseStock_bak() throws Exception {
        LOGGER.debug("=========进入订单释放调度任务========");
        long startTime = System.currentTimeMillis();
        int count = 0;
        // 查询所有的订单信息
        List<StockChannelOrderDetail> details = orderOccupyAndReleaseDefineMapper.selectReleaseChannelSubDetails();
        count += details == null ? 0 : details.size();
        if (CollectionUtils.isNotEmpty(details)) {
            // 查询预占明细表
            for (StockChannelOrderDetail orderDetail : details) {
                long time1 = System.currentTimeMillis();
                Lock lock = null;
                try {
                    lock = OrderOccupyReleaseLock.getLockByProdId(orderDetail.getProdId());
                    if (lock.tryLock(60, TimeUnit.SECONDS)) {
                        LOGGER.debug("订单释放获取锁，用时:" + (System.currentTimeMillis() - time1) + " ms");
                        StockChannelBean stockChannelBean = new StockChannelBean();
                        BeanUtils.copyProperties(stockChannelBean, orderDetail);
                        stockChannelBean.setOccupyPrivateStock(orderDetail.getOrderPrivateStock());
                        stockChannelBean.setOccupyShareStock(orderDetail.getOrderShareStock());
                        stockChannelBean.setOccupyShopGroupStock(orderDetail.getOrderShopGroupStock());
                        // 用关联的渠道号去释放
                        stockChannelBean.setChannelCode(orderDetail.getRelationChannel());

                        if (StringUtils.isBlank(stockChannelBean.getBusinessId()) && StringUtils.isBlank(stockChannelBean.getSubOrderId())) {
                            LOGGER.error("当前 外部订单号 和 子单号 都为空，不能释放，数据有问题，参数:" + JSON.toJSONString(stockChannelBean));
                            continue;
                        }

                        // 查询渠道商品明细数据
                        ChannelProdBean prodBean = orderOccupyAndReleaseDefineMapper.selectChannelProdDetail(stockChannelBean);
                        // 预售不需要释放
                        if (prodBean == null || prodBean.getIsPre() == 1) {
                            LOGGER.warn("查询不到渠道商品明细信息  ||  预售商品  不需要释放！参数:" + JSON.toJSONString(stockChannelBean));
                            continue;
                        }
                        updateInsertDeleteOrderData(stockChannelBean);
                        long time3 = System.currentTimeMillis();
                        // 反查一次数据发送MQ
                        prodBean = orderOccupyAndReleaseDefineMapper.selectChannelProdDetail(stockChannelBean);
                        LOGGER.debug("反查询，用时:" + (System.currentTimeMillis() - time3) + " ms");
                        // 发送 MQ
                        mqSendServiceImpl.sendToOnLineChannelStock(prodBean, prodBean.getChannelCode());
                    } else {
                        throw new Exception("订单释放，拿锁失败！");
                    }
                } catch (Exception e) {
                    LOGGER.error("释放失败，不作处理，参数:" + JSON.toJSONString(orderDetail) + "," + e.getMessage(), e);
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
                LOGGER.debug("释放单条记录完成，用时:" + (System.currentTimeMillis() - time1) + " ms");
            }
        } else {
            throw new Exception("订单释放||取消 时拿锁失败！");
        }
        LOGGER.debug("========订单释放调度任务结束，释放数据:" + count + " ，用时:" + (System.currentTimeMillis() - startTime) + " ms");
    }

    public void processOrderReleaseStock() throws Exception {
        LOGGER.debug("=========进入订单释放调度任务========");
        long startTime = System.currentTimeMillis();
        int count = 0;
        // 获取所有需要释放的商品编码
        List<String> prodIds = orderOccupyAndReleaseDefineMapper.selectReleaseProdIds();
        List<String> channels = cacheServiceImpl.getAllUsefulChannelForCache();
        if (CollectionUtils.isNotEmpty(prodIds) && CollectionUtils.isNotEmpty(channels)) {
            for (String channelCode : channels) {
                StockReleaseThreadBean bean = new StockReleaseThreadBean(channelCode, prodIds);
                service.submit(bean);
            }
            for (int i = 0; i < channels.size(); i++) {
                count += service.take().get();
            }
        }
        LOGGER.debug("=========进入订单释放调度任务完成，数量:" + count + ",用时:" + (System.currentTimeMillis() - startTime) + " ms");
    }

    /**
     * TODO
     *
     * @param stockChannelBean
     */
    @Transactional
    private void updateInsertDeleteOrderData_bak(StockChannelBean stockChannelBean) {
        long time1 = System.currentTimeMillis();
        // 更新渠道子表预占总量（独占|共享）  根据渠道和商品
        orderOccupyAndReleaseDefineMapper.updateChannelSubDetailForRelease(stockChannelBean);
        long time2 = System.currentTimeMillis();
        LOGGER.debug("释放更新渠道子表预占总量，用时:" + (time2 - time1) + " ms");
        // 插入 实占信息表   
        orderOccupyAndReleaseDefineMapper.insertToOrderHis(stockChannelBean);
        long time3 = System.currentTimeMillis();
        LOGGER.debug("释放插入实占信息表数据，用时:" + (time3 - time2) + " ms");
        // 删除预占信息表信息  
        deleteOrderDetail(stockChannelBean);
        long time4 = System.currentTimeMillis();
        LOGGER.debug("释放删除预占信息表数据，用时:" + (time4 - time3) + " ms");
    }

    private void deleteOrderDetail(StockChannelBean stockChannelBean) {

        StockChannelOrderDetailExample example = new StockChannelOrderDetailExample();

        StockChannelOrderDetailExample.Criteria criteria = example.createCriteria();

        criteria.andRelationChannelEqualTo(stockChannelBean.getChannelCode()).andProdIdEqualTo(stockChannelBean.getProdId());

        if (StringUtils.isBlank(stockChannelBean.getBusinessId()) && StringUtils.isNotBlank(stockChannelBean.getSubOrderId())) {
            criteria.andSubOrderIdEqualTo(stockChannelBean.getSubOrderId());
        }
        if (StringUtils.isNotBlank(stockChannelBean.getBusinessId()) && StringUtils.isBlank(stockChannelBean.getSubOrderId())) {
            criteria.andBusinessIdEqualTo(stockChannelBean.getBusinessId());
        }
        if (stockChannelBean.getOccupyPrivateStock() != null) {
            criteria.andOrderPrivateStockEqualTo(stockChannelBean.getOccupyPrivateStock());
        }
        if (stockChannelBean.getOccupyShareStock() != null) {
            criteria.andOrderShareStockEqualTo(stockChannelBean.getOccupyShareStock());
        }
        if (stockChannelBean.getOccupyShopGroupStock() != null) {
            criteria.andOrderShopGroupStockEqualTo(stockChannelBean.getOccupyShopGroupStock());
        }

        stockChannelOrderDetailMapper.deleteByExample(example);
    }

    private void deleteOrderDetailByCodeAndProdId(StockChannelBean stockChannelBean) {
        StockChannelOrderDetailExample example = new StockChannelOrderDetailExample();
        StockChannelOrderDetailExample.Criteria criteria = example.createCriteria();
        criteria.andRelationChannelEqualTo(stockChannelBean.getChannelCode()).andProdIdEqualTo(stockChannelBean.getProdId()).andLazyStatusEqualTo(1);
        stockChannelOrderDetailMapper.deleteByExample(example);
    }

    /**
     * TODO
     *
     * @param stockChannelBean
     */
    @Transactional
    private void updateInsertDeleteOrderData(StockChannelBean stockChannelBean) {
        long time1 = System.currentTimeMillis();
        // 更新渠道子表预占总量（独占|共享）  根据渠道和商品
        orderOccupyAndReleaseDefineMapper.updateChannelSubDetailForReleaseOverWrite(stockChannelBean);
        long time2 = System.currentTimeMillis();
        LOGGER.debug("释放更新渠道子表预占总量，用时:" + (time2 - time1) + " ms");
        // 插入 实占信息表   
        orderOccupyAndReleaseDefineMapper.insertToOrderHisByCodeAndProdId(stockChannelBean);
        long time3 = System.currentTimeMillis();
        LOGGER.debug("释放插入实占信息表数据，用时:" + (time3 - time2) + " ms");
        // 删除预占信息表信息  
        deleteOrderDetailByCodeAndProdId(stockChannelBean);
        long time4 = System.currentTimeMillis();
        LOGGER.debug("释放删除预占信息表数据，用时:" + (time4 - time3) + " ms");
    }

    class StockReleaseThreadBean implements Callable<Integer> {

        String       channelCode;

        List<String> prodIds;

        public StockReleaseThreadBean(String channelCode, List<String> prodIds) {
            this.channelCode = channelCode;
            this.prodIds = prodIds;
        }

        @Override
        public Integer call() throws Exception {
            int count = 0;
            for (String prodId : prodIds) {
                long startTime = System.currentTimeMillis();
                Lock lock = null;
                try {
                    lock = OrderOccupyReleaseLock.getLockByProdId(prodId);
                    if (lock.tryLock(60, TimeUnit.SECONDS)) {
                        StockChannelOrderDetail orderDetail = orderOccupyAndReleaseDefineMapper.selectReleaseProdStocks(channelCode, prodId);
                        StockChannelBean stockChannelBean = new StockChannelBean();
                        if (orderDetail == null) {
                            stockChannelBean.setChannelCode(channelCode);
                            stockChannelBean.setProdId(prodId);
                        } else {
                            BeanUtils.copyProperties(stockChannelBean, orderDetail);
                        }
                        stockChannelBean.setOccupyPrivateStock(orderDetail == null ? 0 : orderDetail.getOrderPrivateStock());
                        stockChannelBean.setOccupyShareStock(orderDetail == null ? 0 : orderDetail.getOrderShareStock());
                        stockChannelBean.setOccupyShopGroupStock(orderDetail == null ? 0 : orderDetail.getOrderShopGroupStock());
                        updateInsertDeleteOrderData(stockChannelBean);
                        long time3 = System.currentTimeMillis();
                        // 反查一次数据发送MQ
                        ChannelProdBean prodBean = orderOccupyAndReleaseDefineMapper.selectChannelProdDetail(stockChannelBean);
                        LOGGER.debug("反查询，用时:" + (System.currentTimeMillis() - time3) + " ms");
                        // 发送 MQ
                        mqSendServiceImpl.sendToOnLineChannelStock(prodBean, channelCode);
                        count++;
                    } else {
                        throw new Exception(" 商品释放||取消 时拿锁失败！");
                    }
                } catch (Exception e) {
                    LOGGER.error("当前商品，释放||取消时失败，不作处理，参数: " + prodId + " ," + e.getMessage(), e);
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
                LOGGER.debug("执行完一个商品的一个渠道的释放用时:" + (System.currentTimeMillis() - startTime) + " ms");
            }
            return count;
        }
    }

    public void processForCloseProOrder(StockChannelBean stockChannelBean) throws Exception {
        // TODO Auto-generated method stub

    }
}
