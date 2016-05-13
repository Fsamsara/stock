package com.metersbonwe.stock.biz.common.service.impl;

import java.util.ArrayList;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.oms.common.bean.ReturnInfo;
import com.metersbonwe.oms.orderop.service.OrderCommonService;
import com.metersbonwe.stock.biz.common.service.CacheService;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.OrderReleaseStockService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelOrderDetailHisMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockChannelOrderDetailMapper;
import com.metersbonwe.stock.dal.auto.core.mapper.StockPreSaleResultMapper;
import com.metersbonwe.stock.dal.define.core.mapper.OrderOccupyAndReleaseDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelProdSubDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockPreSaleDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockPreSaleResultHisDefineMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelOrderDetail;
import com.metersbonwe.stock.po.core.StockChannelOrderDetailExample;
import com.metersbonwe.stock.po.core.StockPreSaleResult;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.pojo.StockChannelBean;
import com.metersbonwe.stock.utils.concurrent.OrderOccupyReleaseLock;

@Service public class OrderReleaseStockServiceImpl implements OrderReleaseStockService {

    private static StockLog                     LOGGER  = StockLogFactory.getLogger(OrderReleaseStockServiceImpl.class);

    @Resource OrderOccupyAndReleaseDefineMapper orderOccupyAndReleaseDefineMapper;

    @Resource StockChannelOrderDetailMapper     stockChannelOrderDetailMapper;

    @Resource StockChannelOrderDetailHisMapper  stockChannelOrderDetailHisMapper;

    @Resource MqSendService                     mqSendServiceImpl;

    @Resource CacheService                      cacheServiceImpl;

    @Resource StockChannelProdSubDefineMapper   stockChannelProdSubDefineMapper;

    @Resource OrderCommonService                orderCommonServiceImpl;

    @Resource StockPreSaleResultMapper          stockPreSaleResultMapper;

    @Resource StockPreSaleResultHisDefineMapper stockPreSaleResultHisDefineMapper;

    @Resource StockPreSaleDefineMapper          stockPreSaleDefineMapper;

    ExecutorCompletionService<Integer>          service = new ExecutorCompletionService<Integer>(Executors.newFixedThreadPool(5));

    @Override
    public int updateOrderReleaseStock(StockChannelBean stockChannelBean) throws Exception {
        LOGGER.debug("=======进入订单释放||取消==更新延迟释放渠道标识======,入参:" + (stockChannelBean == null ? null : JSON.toJSONString(stockChannelBean)));
        long startTime = System.currentTimeMillis();
        if (stockChannelBean == null
                || (StringUtils.isBlank(stockChannelBean.getSubOrderId()) && (StringUtils.isBlank(stockChannelBean.getBusinessId()) || StringUtils
                        .isBlank(stockChannelBean.getChannelCode())))) {
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

    @Override
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

    @Transactional
    @Override
    public void processForCloseProOrder(StockChannelBean stockChannelBean) throws Exception {
        if (stockChannelBean == null) {
            throw new RuntimeException("预售关闭流程，入参不能为空！");
        }
        Long relationId = stockChannelBean.getRelationId();
        String channelCode = stockChannelBean.getChannelCode();
        String prodId = stockChannelBean.getProdId();
        // 更新渠道SUB表的预售预占总量为0，并把预售预占总量累加到 实物独占预占总量
        updateAndSumPreOrderStock(channelCode, prodId);
        // 更新订单预占明细表里面预售预占信息为 实物预占信息
        updateOrderDetailForPreOrder(channelCode, prodId);
        //调用渠道接口通知立马下发分配
        //getOmsApiForAllot(channelCode, prodId);
        // 写关闭预售日记记录数据
        insertLogDetailForPre(channelCode, prodId, relationId);
        // 反查一次数据发送MQ
        ChannelProdBean prodBean = orderOccupyAndReleaseDefineMapper.selectChannelProdDetail(stockChannelBean);
        // 发送 MQ
        mqSendServiceImpl.sendToOnLineChannelStock(prodBean, channelCode);
    }

    private void insertLogDetailForPre(String channelCode, String prodId, Long relationId) {
        StockPreSaleResult stockPreSaleResult = new StockPreSaleResult();
        stockPreSaleResult.setRelationId(relationId);
        stockPreSaleResult.setChannelCode(channelCode);
        stockPreSaleResult.setProdId(prodId);
        List<StockPreSaleResult> stockPreSaleResultlist = new ArrayList<>();
        stockPreSaleResultlist.add(stockPreSaleResult);
        int iResult = 0;
        if (CollectionUtils.isNotEmpty(stockPreSaleResultlist)) {
            iResult = stockPreSaleResultHisDefineMapper.insertFromPreSale(stockPreSaleResultlist);
            if (iResult > 0) {
                //删除stock_pre_sale【预售明细表】对应的数据
                iResult = stockPreSaleDefineMapper.deleteByPreSaleResult(stockPreSaleResult);
            }
            if (iResult <= 0) {
                throw new RuntimeException("预售关闭流程，写关闭预售日记记录数据失败！");
            }
        }
    }

    private ReturnInfo getOmsApiForAllot(String channelCode, String prodId) {
        return orderCommonServiceImpl.advanceSaleClose(channelCode, prodId);
    }

    private void updateOrderDetailForPreOrder(String channelCode, String prodId) {
        orderOccupyAndReleaseDefineMapper.updateOrderDetailForPreOrder(channelCode, prodId);
    }

    private void updateAndSumPreOrderStock(String channelCode, String prodId) {
        stockChannelProdSubDefineMapper.updateAndSumPreOrderStock(channelCode.toLowerCase(), channelCode, prodId);
    }
}
