package com.metersbonwe.stock.biz.api.insert;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.log.LogService;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpActivityStockMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpActivityStockDefineMapper;
import com.metersbonwe.stock.facade.api.ActivityStockFacade;
import com.metersbonwe.stock.facade.api.bean.ActivityStock;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpActivityStock;

/**
 * @author 张洪琴 活动期间渠道商品推送独占量接收接口实现
 */
@Service public class ActivityStockFacadeImpl implements ActivityStockFacade {

    private static StockLog                stockLog = StockLogFactory.getLogger(ActivityStockFacadeImpl.class);

    @Resource TmpActivityStockDefineMapper tmpActivityStockDefineMapper;

    @Resource TmpActivityStockMapper       tmpActivityStockMapper;

    /**
     * 检查传入的参数是否有效
     * 
     * @param activityStock
     * @return
     */
    private Map<String, Object> checkParam(ActivityStock activityStock) {
        //申明数据检查的消息：
        Map<String, Object> msg = new HashMap<String, Object>();
        //申明封装的数据类型：
        TmpActivityStock target = null;

        //检查数据：有效的数据就进行封装
        if (activityStock == null) {
            msg.put("tag", false);
            msg.put("wrongMsg", "activityStock对象为空");
        } else if (activityStock.getChannelCode() == null || StringUtils.isEmpty(activityStock.getChannelCode())) {
            msg.put("tag", false);
            msg.put("wrongMsg", "channelCode(渠道编码)字段为空");
        } else if (activityStock.getProdId() == null || StringUtils.isEmpty(activityStock.getProdId())) {
            msg.put("tag", false);
            msg.put("wrongMsg", "prodId（商品11位码）字段为空");
        } else {
            if (activityStock.getUpdateTime() == null) {
                activityStock.setUpdateTime(new Date());
            }
            target = new TmpActivityStock();
            BeanUtils.copyProperties(activityStock, target);
            msg.put("tag", true);
            msg.put("tmpActivityStock", target);
        }
        return msg;
    }

    /**
     * 检查传入的参数列表，对有效的数据进行封装
     * 
     * @param paramList
     * @return
     */
    private Map<String, Object> checkParamList(List<ActivityStock> paramList) {
        //申明保存有效的封装数据的变量
        List<TmpActivityStock> validParamList = new ArrayList<TmpActivityStock>();
        //申明 保存 无效的封装数据的变量
        List<ActivityStock> invalidParamList = new ArrayList<ActivityStock>();
        //申明返回结果
        Map<String, Object> map = new HashMap<String, Object>();
        if (paramList == null || paramList.size() == 0) {
            map.put("tag", false);
            return map;
        }
        stockLog.debug("传入的参数数量：" + paramList.size());
        for (ActivityStock activityStock : paramList) {
            Map<String, Object> msg = checkParam(activityStock);
            if (!(Boolean) msg.get("tag")) {
                invalidParamList.add(activityStock);
            }
            TmpActivityStock tmp = (TmpActivityStock) msg.get("tmpActivityStock");
            if (tmp != null) {
                validParamList.add(tmp);
            }
        }
        //
        map.put("validParamList", validParamList);
        stockLog.debug("有效参数的数量：" + validParamList.size());
        map.put("invalidParamList", invalidParamList);
        stockLog.debug("无效参数的数量：" + invalidParamList.size());

        return map;
    }

    @Override @LogService("活动期间渠道商品推送独占量接收接口") 
    public Message setActivityStock(ActivityStock activityStock) {
        stockLog.debug("活动期间渠道商品推送独占量接收接口setActivityStock->开始");
        stockLog.debug("活动期间渠道商品推送独占量接收接口setActivityStock传入的参数是：" + activityStock);
        Map<String, Object> msg = null;
        try {
            //参数检查，数据封装
            msg = checkParam(activityStock);
            if (!(Boolean) msg.get("tag")) {
                stockLog.error("setActivityStock传入的参数无效：" + activityStock + ",无效的原因：" + msg.get("wrongMsg"));
                return new Message(false, Message.PARAMETER_WRONG + ",错误原因：" + msg.get("wrongMsg"));
            }

            //插入同步库临时表：
            int tag = this.tmpActivityStockMapper.insertSelective((TmpActivityStock) msg.get("tmpActivityStock"));
            return new Message(tag != 0, tag != 0 ? null : Message.INSERT_WRONG + "," + msg.get("wrongMsg"));

        } catch (Exception e) {
            stockLog.error("setActivityStock报异常：" + e.getMessage(), e);
            return new Message(false, Message.INSERT_DEBUG + ",异常信息：" + e.getMessage() + ",参数信息：" + activityStock);
        } finally {
            stockLog.debug("活动期间渠道商品推送独占量接收接口setActivityStock->结束");
        }
    }

    @SuppressWarnings("unchecked")
    @Override @LogService("活动期间渠道商品推送独占量接收接口list") 
    public Message setActivityStockList(List<ActivityStock> activityStockList) {
        stockLog.debug("活动期间渠道商品推送独占量接收接口setActivityStock->开始");
        stockLog.debug("传入的参数是：" + activityStockList);
        Map<String, Object> msg = null;
        try {
            //传入参数有效性检查：封装有效性数据：
            msg = checkParamList(activityStockList);
            stockLog.debug("无效的参数列表：" + msg.get("invalidParamList"));
            stockLog.debug("有效的参数封装后的列表：" + msg.get("validParamList"));

            List<TmpActivityStock> tmpList = (List<TmpActivityStock>) msg.get("validParamList");
            if (tmpList.size() == 0) {
                stockLog.error("传入的参数无效：" + msg.get("invalidParamList"));
                return new Message(false, Message.PARAMETER_WRONG + "无效的参数列表：" + msg.get("invalidParamList"));
            }
            //插入数据到临时表：
            int tag = this.tmpActivityStockDefineMapper.insertList(tmpList);
            stockLog.debug("活动期间渠道商品推送独占量接收接口插入到临时表的数据量：" + tag);
            //返回插入数据的结果
            return new Message(tag != 0, "无效的数据信息有：" + msg.get("invalidParamList"));
        } catch (Exception e) {
            stockLog.error("setActivityStock报异常！异常信息：" + e.getMessage(), e);
            return new Message(false, Message.INSERT_DEBUG + "," + e.getMessage() + "无效的参数信息有：" + msg.get("invalidParamList"));
        } finally {
            stockLog.debug("活动期间渠道商品推送独占量接收接口setActivityStock->结束");
        }
    }

}
