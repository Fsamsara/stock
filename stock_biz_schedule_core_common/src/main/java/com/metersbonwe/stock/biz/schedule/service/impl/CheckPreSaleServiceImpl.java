package com.metersbonwe.stock.biz.schedule.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.OrderReleaseStockService;
import com.metersbonwe.stock.dal.auto.core.mapper.StockPreSaleResultMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelProdDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelProdDetailDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelProdSubDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockPreSaleDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockPreSaleResultDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockPreSaleResultHisDefineMapper;
import com.metersbonwe.stock.facade.service.CheckPreSaleService;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelProd;
import com.metersbonwe.stock.po.core.StockChannelProdSub;
import com.metersbonwe.stock.po.core.StockPreSaleResult;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.po.core.define.StockPreSaleResultDefine;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.StockChannelBean;
import com.metersbonwe.stock.utils.MailManager;
import com.metersbonwe.stock.utils.concurrent.FullStockSyncLock;

/**
 * @author zhq
 * @description 轮询检查预售开启、关闭定时任务实现类
 * @version V1.0
 * @date 2016/03/28
 */
@Service public class CheckPreSaleServiceImpl implements CheckPreSaleService {

    private static StockLog                      logger = StockLogFactory.getLogger(CheckPreSaleServiceImpl.class);

    @Resource StockPreSaleResultDefineMapper     stockPreSaleResultDefineMapper;

    @Resource StockChannelProdSubDefineMapper    stockChannelProdSubDefineMapper;

    @Resource StockChannelProdDefineMapper       stockChannelProdDefineMapper;

    @Resource StockChannelProdDetailDefineMapper stockChannelProdDetailDefineMapper;

    @Resource MqSendService                      mqSendServiceImpl;

    @Resource StockPreSaleResultHisDefineMapper  stockPreSaleResultHisDefineMapper;

    @Resource StockPreSaleDefineMapper           stockPreSaleDefineMapper;

    @Resource OrderReleaseStockService           orderReleaseStockServiceImpl;

    @Resource StockPreSaleResultMapper           stockPreSaleResultMapper;

    @Transactional(rollbackFor = { Exception.class, RuntimeException.class })
    private void saveOpenData(StockPreSaleResultDefine stockPreSaleResultBean, StockChannelProd prodBean, StockChannelProdSub prodSubBean,
            ChannelProdBean channelProdBean) throws Exception {
        int iResult = 0;
        if (prodBean == null) { //在渠道+sku表中已经存在就直接修改
            iResult = stockChannelProdSubDefineMapper.updateByPreSaleResult(stockPreSaleResultBean);
        } else { //不存在就插入
            iResult = stockChannelProdDefineMapper.insert(prodBean);
            if (iResult > 0) {
                iResult = stockChannelProdSubDefineMapper.insert(prodSubBean);
            }
        }
        if (iResult <= 0) {
            throw new Exception(prodBean == null ? "插入" : "修改" + "数据失败,参数[渠道编码:" + stockPreSaleResultBean.getChannelCode() + ",商品编码:"
                    + stockPreSaleResultBean.getProdId() + "]");
        }

        //修改当前预售结果的isControling状态
        StockPreSaleResult record = new StockPreSaleResult();
        record.setId(stockPreSaleResultBean.getId());
        record.setIsControling(0);
        record.setUpdateTime(new Date());
        record.setUpdateBy("SA");
        iResult = stockPreSaleResultMapper.updateByPrimaryKeySelective(record);
        if (iResult <= 0) {
            throw new Exception("修改" + "数据预售结果的isControling状态失败,参数[预售单号:" + String.valueOf(stockPreSaleResultBean.getRelationId()) + ",渠道编码:"
                    + stockPreSaleResultBean.getChannelCode() + ",商品编码:" + stockPreSaleResultBean.getProdId() + "]");
        }

        logger.debug("预售开启发送给MQ数据:参数参数[渠道编码:" + channelProdBean.getChannelCode() + ",商品编码:" + channelProdBean.getProdId() + "]");
        channelProdBean.setIsPre(1);
        this.mqSendServiceImpl.sendToOnLineChannelStock(channelProdBean, channelProdBean.getChannelCode());
        logger.debug("预售开启发送给MQ数据成功");
    }

    private void openProcess() {
        Page<?> page = new Page<>();
        page.setPageNo(1);
        page.setPageSize(5000); //每次查询5000条记录
        // 调度任务查询stock_pre_sale_result（预售结果表）中开始时间小于等于当前时间且正在调整字段为1的数据存入预售明细对象集合
        List<StockPreSaleResultDefine> rlist = stockPreSaleResultDefineMapper.selectCouldOpen();
        logger.debug("查询stock_pre_sale_result（预售结果表）中开始时间小于等于当前时间且正在调整字段为1的数据存入预售明细对象集合:" + rlist);

        // 根据预售明细对象集合批量更新stock_channel_prod（渠道+商品明细表）表，更新IS_PRE为预售、PRE_PRIVATE_STOCK字段为实体中的预售量、pre_order_total_stock（ 预售预占量总量）清零。
        for (StockPreSaleResultDefine r : rlist) {
            try {
                logger.debug("开始单条执行预售开启:参数参数[渠道编码:" + r.getChannelCode() + ",商品编码:" + r.getProdId() + "]");
                ChannelProdBean channelProdBean = null;
                StockChannelProd prodBean = null;
                StockChannelProdSub prodSubBean = null;
                List<StockPreSaleResultDefine> tempList = new ArrayList<>();
                tempList.add(r);
                List<ChannelProdBean> cpList = stockChannelProdDetailDefineMapper.selectByPreSaleResult(tempList);
                if (cpList != null && cpList.size() > 0) { //在渠道+sku表中已经存在
                    channelProdBean = cpList.get(0);
                } else { //不存在
                    //封装数据：
                    prodBean = new StockChannelProd();
                    prodBean.setChannelCode(r.getChannelCode());
                    prodBean.setFinalFreeStock(0);
                    prodBean.setLockStock(0);
                    prodBean.setPrivateStock(0);
                    prodBean.setProdId(r.getProdId());
                    prodBean.setUpdateTime(new Date());

                    prodSubBean = new StockChannelProdSub();
                    prodSubBean.setChannelCode(r.getChannelCode());
                    prodSubBean.setEightProdId(r.getChannelCode().substring(0, 8));
                    prodSubBean.setIsPre(1);
                    prodSubBean.setOrderPrivateTotalStock(0);
                    prodSubBean.setOrderShareTotalStock(0);
                    prodSubBean.setPreOrderTotalStock(0);
                    prodSubBean.setPrePrivateStock(r.getPrePrivateStock());
                    prodSubBean.setProdId(r.getProdId());
                    prodSubBean.setSixProdId(prodSubBean.getProdId().substring(0, 6));
                    prodSubBean.setUpdateTime(new Date());

                    channelProdBean = new ChannelProdBean();
                    channelProdBean.setChannelCode(prodSubBean.getChannelCode());
                    channelProdBean.setProdId(prodSubBean.getProdId());
                    channelProdBean.setSixProdId(prodSubBean.getSixProdId());
                    channelProdBean.setEightProdId(prodSubBean.getEightProdId());
                    channelProdBean.setFinalFreeStock(prodBean.getFinalFreeStock());
                    channelProdBean.setIsPre(prodSubBean.getIsPre());
                    channelProdBean.setLockStock(prodBean.getLockStock());
                    channelProdBean.setOrderPrivateTotalStock(prodSubBean.getOrderPrivateTotalStock());
                    channelProdBean.setOrderShareTotalStock(prodSubBean.getOrderShareTotalStock());
                    channelProdBean.setPreOrderTotalStock(prodSubBean.getPreOrderTotalStock());
                    channelProdBean.setPrePrivateStock(prodSubBean.getPrePrivateStock());
                    channelProdBean.setPrivateStock(prodBean.getPrivateStock());
                }

                saveOpenData(r, prodBean, prodSubBean, channelProdBean);

                logger.debug("单条预售开启执行成功:参数参数[渠道编码:" + r.getChannelCode() + ",商品编码:" + r.getProdId() + "]");
            } catch (Exception ex) {
                logger.error("轮询检查预售开启定时任务出现异常:" + ex.getMessage());
                continue;
            } finally {
                logger.debug("结束单条执行预售开启:参数参数[渠道编码:" + r.getChannelCode() + ",商品编码:" + r.getProdId() + "]");
            }

        }

        /*
         * 20160426 liyp 改成单条处理 // 根据渠道编码和SKU从stock_channel_prod（渠道+商品明细表）中查出数据实体转成json字符串推送数据到线上MQ（ONLINE_CHANNEL_STOCK队列）。 List<ChannelProdBean>
         * cpList = stockChannelProdDetailDefineMapper.selectByPreSaleResult(rlist); for (ChannelProdBean channelProdBean : cpList) {
         * this.mqSendServiceImpl.sendToOnLineChannelStock(channelProdBean, channelProdBean.getChannelCode()); }
         * logger.debug("根据渠道编码和SKU从stock_channel_prod（渠道+商品明细表）中查出数据实体转成json字符串推送数据到线上MQ完成");
         */

    }

    /**
     * TODO 轮询检查预售开启任务
     * 
     * @see com.metersbonwe.stock.facade.service.CheckPreSaleService#checkPreSaleOpen()
     */
    @Override
    public void checkPreSaleOpen() {
        logger.debug("进入轮询检查预售开启定时任务 ");
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        Date stime = null;
        try {
            lock.lock();
            stime = new Date();
            logger.debug("开始--> 轮询检查预售开启定时任务 ");
            openProcess();
            logger.debug("checkPreSaleOpen:轮询检查预售任务执行完成");
        } catch (Exception e) {
            logger.error("checkPreSaleOpen方法有异常", e);
        } finally {
            logger.debug("轮询检查预售开启定时任务-->结束,调度任务使用时间： " + (new Date().getTime() - stime.getTime()));
            lock.unlock();
        }
    }

    @Transactional(rollbackFor = { Exception.class, RuntimeException.class })
    private void saveCloseData(List<ChannelProdBean> channelProdList, List<StockPreSaleResult> stockPreSaleResultlist) throws Exception {
        // 4.批量更新stock_channel_prod表中的IS_PRE字段的值为渠道+SKU实体对象的IS_PRE、
        // PRE_PRIVATE_STOCK字段的值为渠道+SKU实体对象的PRE_PRIVATE_STOCK，
        // PRIVATE_STOCK【预留独占】K字段的值为渠道+SKU实体对象的PRIVATE_STOCK【预留独占】，
        // PRE_ORDER_TOTAL_STOCK字段的值为渠道+SKU实体对象的PRE_ORDER_TOTAL_STOCK。
        for (ChannelProdBean channelProdBean : channelProdList) {
            this.stockChannelProdDetailDefineMapper.updateChannelByBeanList(channelProdBean);
        }

        // 5.把预售明细对象集合批量插入到
        // stock_pre_sale_result_his【预售历史明细表】中，再删除stock_pre_sale_result【预售明细表】对应的数据
        stockPreSaleResultHisDefineMapper.insertFromPreSale(stockPreSaleResultlist);
        //删除stock_pre_sale【预售明细表】对应的数据  
        for (StockPreSaleResult stockPreSaleResult : stockPreSaleResultlist) {
            stockPreSaleDefineMapper.deleteByPreSaleResult(stockPreSaleResult);
        }

        // 7.渠道+SKU实体对象转为转为JSON推送数据到 线上MQ（ONLINE_CHANNEL_STOCK队列）
        for (ChannelProdBean channelProdBean : channelProdList) {
            logger.debug("预售关闭发送给MQ数据:参数参数[渠道编码:" + channelProdBean.getChannelCode() + ",商品编码:" + channelProdBean.getProdId() + "]");
            mqSendServiceImpl.sendToOnLineChannelStock(channelProdBean, channelProdBean.getChannelCode());
            logger.debug("预售关闭发送给MQ数据成功");
        }
    }

    private void closeProcess() {
        try {
            String toEmailAddress = "liyingping@metersbonwe.com"; //接收邮件地址
            String emailTitle = "渠道SKU表中的预售预占量总量大于实物预留独占量"; //邮件标题
            Page<?> page = new Page<>();
            page.setPageNo(1);
            page.setPageSize(5000); //每次查询5000条记录
            // 1.查询MYSQL库中stock_pre_sale_result【预售结果表】中的end_time预售结束时间小于等于当前时间的记录关联stock_channel_prod表
            List<StockPreSaleResultDefine> stockPreSaleResultlist = this.stockPreSaleResultDefineMapper.selectCouldClose();
            if (CollectionUtils.isEmpty(stockPreSaleResultlist)) {
                logger.debug("没有需要关闭预售的数据!");
            }
            if (stockPreSaleResultlist != null && stockPreSaleResultlist.size() > 0) {
                List<ChannelProdBean> channelProdList = stockChannelProdDetailDefineMapper.selectByPreSaleResult(stockPreSaleResultlist);
                logger.debug("查询MYSQL库中stock_pre_sale_result【预售结果表】中的end_time预售结束时间小于等于当前时间的记录关联stock_channel_prod表:" + channelProdList);

                // 2.如果渠道+SKU实体对象中的属性PRE_ORDER_TOTAL_STOCK【预售预占量总量】大于PRIVATE_STOCK【预留独占】就推送通知邮件
                for (ChannelProdBean cpb : channelProdList) {
                    if (cpb.getPreOrderTotalStock() > cpb.getPrivateStock()) {
                        // 推送邮件通知
                        String msg = "渠道编码:" + cpb.getChannelCode() + ",商品编码:" + cpb.getProdId() + "对应渠道SKU表中的预售预占量总量大于实物预留独占量,请检查";
                        MailManager.sendMail(emailTitle, toEmailAddress, msg);
                    }
                    StockChannelBean stockChannelBean = new StockChannelBean();
                    stockChannelBean.setRelationId(cpb.getRelationId());
                    stockChannelBean.setChannelCode(cpb.getChannelCode());
                    stockChannelBean.setProdId(cpb.getProdId());
                    try {
                        logger.debug("渠道编码:" + cpb.getChannelCode() + ",商品编码:" + cpb.getProdId() + "processForCloseProOrder开始");
                        orderReleaseStockServiceImpl.processForCloseProOrder(stockChannelBean);
                        logger.debug("渠道编码:" + cpb.getChannelCode() + ",商品编码:" + cpb.getProdId() + "processForCloseProOrder成功");
                    } catch (Exception e) {
                        logger.error("processForCloseProOrder出现异常：" + e.getMessage(), e);
                        continue;
                    } finally {
                        logger.debug("渠道编码:" + cpb.getChannelCode() + ",商品编码:" + cpb.getProdId() + "processForCloseProOrder结束");
                    }
                }
            }
        } catch (Exception ex) {
            logger.error("checkPreSaleClose出现异常：" + ex.getMessage(), ex);
        }
    }

    /**
     * TODO 轮询检查预售关闭任务
     * 
     * @see com.metersbonwe.stock.facade.service.CheckPreSaleService#checkPreSaleClose()
     */
    @Override
    public void checkPreSaleClose() {
        logger.debug("进入轮询检查预售关闭定时任务 ");
        ReadWriteLock rwLock = FullStockSyncLock.getLock();
        Lock lock = rwLock.readLock();
        Date stime = null;
        try {
            lock.lock();
            stime = new Date();
            logger.debug("开始--> 轮询检查预售关闭定时任务 ");
            closeProcess();
            logger.debug("checkPreSaleClose:轮询检查预售任务执行完成");
        } catch (Exception e) {
            logger.error("checkPreSaleClose方法有异常", e);
        } finally {
            logger.debug("轮询检查预售关闭定时任务-->结束,调度任务使用时间： " + (new Date().getTime() - stime.getTime()));
            lock.unlock();
        }
    }

}
