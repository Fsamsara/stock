package com.metersbonwe.stock.biz.schedule.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.schedule.service.ChangeQtySerivce;
import com.metersbonwe.stock.facade.schedule.ChangeQtyDubboSerivce;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.ChangeQtyGlobalBean;

@Service("changeQtyDubboSerivce")
public class ChangeQtyDubboSerivceImpl implements ChangeQtyDubboSerivce {
    
    private static StockLog stockLog = StockLogFactory.getLogger(ChangeQtyDubboSerivceImpl.class);
    
    @Resource(name="changeQtySerivce")
    private ChangeQtySerivce changeQtySerivce;

    @Override
    public void changeFreeQty() throws Exception {
        stockLog.info("###自由量变化调度任务:[执行开始]ChangeType:" + Constants.STOCK_CHANGE_TYPE_FREE_QTY + "###");
        // 根据map中的key设置bean的属性
        try {
            ChangeQtyGlobalBean changeQtyGlobalBean =  new ChangeQtyGlobalBean();
            changeQtyGlobalBean.setChangeType(Constants.STOCK_CHANGE_TYPE_FREE_QTY);
            changeQtySerivce.doService(changeQtyGlobalBean);
        } catch (Exception ex) {
            stockLog.error("###自由量变化调度任务:[执行失败]ChangeType:" + Constants.STOCK_CHANGE_TYPE_FREE_QTY + "###", ex);
            throw ex;
        } finally {
            stockLog.info("###自由量变化调度任务:[执行结束]ChangeType:" + Constants.STOCK_CHANGE_TYPE_FREE_QTY + "###");
        }
    }

    @Override
    public void changeLockedQty() throws Exception {
        stockLog.info("###锁定量变化调度任务:[执行开始]ChangeType:" + Constants.STOCK_CHANGE_TYPE_LOCKED_QTY + "###");
        // 根据map中的key设置bean的属性
        try {
            ChangeQtyGlobalBean changeQtyGlobalBean =  new ChangeQtyGlobalBean();
            changeQtyGlobalBean.setChangeType(Constants.STOCK_CHANGE_TYPE_LOCKED_QTY);
            changeQtySerivce.doService(changeQtyGlobalBean);
        } catch (Exception ex) {
            stockLog.error("###锁定量变化调度任务:[执行失败]ChangeType:" + Constants.STOCK_CHANGE_TYPE_LOCKED_QTY + "###", ex);
            throw ex;
        } finally {
            stockLog.info("###锁定量变化调度任务:[执行结束]ChangeType:" + Constants.STOCK_CHANGE_TYPE_LOCKED_QTY + "###");
        }
    }

    @Override
    public void changeReservedQty() throws Exception {
        stockLog.info("###预留量变化调度任务:[执行开始]ChangeType:" + Constants.STOCK_CHANGE_TYPE_RESERVED_QTY + "###");
        // 根据map中的key设置bean的属性
        try {
            ChangeQtyGlobalBean changeQtyGlobalBean =  new ChangeQtyGlobalBean();
            changeQtyGlobalBean.setChangeType(Constants.STOCK_CHANGE_TYPE_RESERVED_QTY);
            changeQtySerivce.doService(changeQtyGlobalBean);
        } catch (Exception ex) {
            stockLog.error("###预留量变化调度任务:[执行失败]ChangeType:" + Constants.STOCK_CHANGE_TYPE_RESERVED_QTY + "###", ex);
            throw ex;
        } finally {
            stockLog.info("###预留量变化调度任务:[执行结束]ChangeType:" + Constants.STOCK_CHANGE_TYPE_RESERVED_QTY + "###");
        }
    }

    @Override
    public void changeTpFreeQty() throws Exception {
        stockLog.info("###第三方自由量变化调度任务:[执行开始]ChangeType:" + Constants.STOCK_CHANGE_TYPE_TP_FREE_QTY + "###");
        // 根据map中的key设置bean的属性
        try {
            ChangeQtyGlobalBean changeQtyGlobalBean =  new ChangeQtyGlobalBean();
            changeQtyGlobalBean.setChangeType(Constants.STOCK_CHANGE_TYPE_TP_FREE_QTY);
            changeQtySerivce.doService(changeQtyGlobalBean);
        } catch (Exception ex) {
            stockLog.error("###第三方自由量变化调度任务:[执行失败]ChangeType:" + Constants.STOCK_CHANGE_TYPE_TP_FREE_QTY + "###", ex);
            throw ex;
        } finally {
            stockLog.info("###第三方自由量变化调度任务:[执行结束]ChangeType:" + Constants.STOCK_CHANGE_TYPE_TP_FREE_QTY + "###");
        }
    }

    @Override
    public void changeRemailQty() throws Exception {
        stockLog.info("###门店未日结量变化调度任务:[执行开始]ChangeType:" + Constants.STOCK_CHANGE_TYPE_REMAIL_QTY + "###");
        // 根据map中的key设置bean的属性
        try {
            ChangeQtyGlobalBean changeQtyGlobalBean =  new ChangeQtyGlobalBean();
            changeQtyGlobalBean.setChangeType(Constants.STOCK_CHANGE_TYPE_REMAIL_QTY);
            changeQtySerivce.doService(changeQtyGlobalBean);
        } catch (Exception ex) {
            stockLog.error("###门店未日结量变化调度任务:[执行失败]ChangeType:" + Constants.STOCK_CHANGE_TYPE_REMAIL_QTY + "###", ex);
            throw ex;
        } finally {
            stockLog.info("###门店未日结量变化调度任务:[执行结束]ChangeType:" + Constants.STOCK_CHANGE_TYPE_REMAIL_QTY + "###");
        }
    }

    @Override
    public void changeDameQty() throws Exception {
        stockLog.info("###门店污损值变化调度任务:[执行开始]ChangeType:" + Constants.STOCK_CHANGE_TYPE_DAME_QTY + "###");
        // 根据map中的key设置bean的属性
        try {
            ChangeQtyGlobalBean changeQtyGlobalBean =  new ChangeQtyGlobalBean();
            changeQtyGlobalBean.setChangeType(Constants.STOCK_CHANGE_TYPE_DAME_QTY);
            changeQtySerivce.doService(changeQtyGlobalBean);
        } catch (Exception ex) {
            stockLog.error("###门店污损值变化调度任务:[执行失败]ChangeType:" + Constants.STOCK_CHANGE_TYPE_DAME_QTY + "###", ex);
            throw ex;
        } finally {
            stockLog.info("###门店污损值变化调度任务:[执行结束]ChangeType:" + Constants.STOCK_CHANGE_TYPE_DAME_QTY + "###");
        }
    }

    @Override
    public void changeChannelQty() throws Exception {
        stockLog.info("###活动期间渠道商品推送独占量调度任务:[执行开始]ChangeType:" + Constants.STOCK_CHANGE_TYPE_CHANNEL_PORD + "###");
        // 根据map中的key设置bean的属性
        try {
            ChangeQtyGlobalBean changeQtyGlobalBean =  new ChangeQtyGlobalBean();
            changeQtyGlobalBean.setChangeType(Constants.STOCK_CHANGE_TYPE_CHANNEL_PORD);
            changeQtySerivce.doService(changeQtyGlobalBean);
        } catch (Exception ex) {
            stockLog.error("###活动期间渠道商品推送独占量调度任务:[执行失败]ChangeType:" + Constants.STOCK_CHANGE_TYPE_CHANNEL_PORD + "###", ex);
            throw ex;
        } finally {
            stockLog.info("###活动期间渠道商品推送独占量调度任务:[执行结束]ChangeType:" + Constants.STOCK_CHANGE_TYPE_CHANNEL_PORD + "###");
        }
    }

}
