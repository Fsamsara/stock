package com.metersbonwe.stock.biz.api.insert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.log.LogService;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelProdDetailDefineMapper;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelStatusDefineMapper;
import com.metersbonwe.stock.facade.api.StockChannelStatusFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.StockChannelStatusBean;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelStatus;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;

/**
 * @author 张洪琴 渠道+款进货(渠道+款上下架是否同步)接口实现类
 */
@Service public class StockChannelStatusFacadeImpl implements StockChannelStatusFacade {

    @Resource StockChannelStatusDefineMapper     stockChannelStatusDefineMapper;

    @Resource StockChannelProdDetailDefineMapper stockChannelProdDetailDefineMapper;

    @Resource MqSendService                      mqSendServiceImpl;

    private static StockLog                      stockLog = StockLogFactory.getLogger(StockChannelStatusFacadeImpl.class);

    /**
     * TODO 私有方法：查询渠道+SKU明细
     * 
     * @return
     */
    private List<ChannelProdBean> selectByList(List<StockChannelStatus> list) {

        List<ChannelProdBean> beanList = new ArrayList<ChannelProdBean>();
        for (StockChannelStatus stockChannelStatus : list) {
            List<ChannelProdBean> cpdList = this.stockChannelProdDetailDefineMapper.selectByChannelStatus(stockChannelStatus);
            beanList.addAll(cpdList);
        }
        return beanList;
    }

    /**
     * TODO 推送到线上MQ私有方法
     * 
     * @param list
     */
    private void sendToOnlineMq(List<ChannelProdBean> list) {
        for (ChannelProdBean channelProdBean : list) {
            this.mqSendServiceImpl.sendToOnLineChannelStock(channelProdBean, channelProdBean.getChannelCode());
        }
    }

    /**
     * 传入的参数有效性检查，对于有效的参数进行封装
     * 
     * @param stockChannelStatus
     * @return
     */
    private Map<String, Object> checkParam(StockChannelStatusBean stockChannelStatus) {
        Map<String, Object> msg = new HashMap<String, Object>();
        if (stockChannelStatus == null || StringUtils.isEmpty(stockChannelStatus.getChannelCode())
                || StringUtils.isEmpty(stockChannelStatus.getCreateBy()) || StringUtils.isEmpty(stockChannelStatus.getSaleStatus())
                || StringUtils.isEmpty(stockChannelStatus.getSixProdId()) || StringUtils.isEmpty(stockChannelStatus.getUpdateBy())
                || StringUtils.isEmpty(stockChannelStatus.getCreateBy()) || stockChannelStatus.getIsSync() == null
                || stockChannelStatus.getCreateTime() == null) {
            msg.put("tag", false);
        } else {
            msg.put("tag", true);
            // 封装数据：
            StockChannelStatus target = new StockChannelStatus();
            BeanUtils.copyProperties(stockChannelStatus, target);
            msg.put("stockChannelStatus", target);
        }
        return msg;
    }

    /**
     * 传入的参数有效性检查，对于有效的参数进行封装
     * 
     * @param stockChannelStatus
     * @return
     */
    private Map<String, Object> checkParamList(List<StockChannelStatusBean> stockChannelStatusList) {
        Map<String, Object> msg = new HashMap<String, Object>();
        List<StockChannelStatus> validParamList = new ArrayList<StockChannelStatus>();
        List<StockChannelStatusBean> invalidParamList = new ArrayList<StockChannelStatusBean>();

        if (stockChannelStatusList == null || stockChannelStatusList.size() == 0) {
            msg.put("tag", false);
            return msg;
        }
        stockLog.debug("传入的参数行数：" + stockChannelStatusList.size());

        for (StockChannelStatusBean stockChannelStatusBean : stockChannelStatusList) {
            Map<String, Object> map = checkParam(stockChannelStatusBean);
            if (!(boolean) map.get("tag")) {
                invalidParamList.add(stockChannelStatusBean);
            }
            StockChannelStatus s = (StockChannelStatus) map.get("stockChannelStatus");
            if (s != null) {
                validParamList.add(s);
            }
        }

        msg.put("validParamList", validParamList);
        stockLog.debug("有效参数的数量：" + validParamList.size());
        msg.put("invalidParamList", invalidParamList);
        stockLog.debug("无效参数的数量：" + invalidParamList.size());
        return msg;
    }

    @Override @LogService("渠道+款进货(渠道+款上下架是否同步)接口")
    public Message setStockChannelStatus(StockChannelStatusBean stockChannelStatus) {
        stockLog.debug(" 渠道+款进货(渠道+款上下架是否同步)接口setStockChannelStatus-->开始");
        stockLog.debug("setStockChannelStatus传入的数据：" + stockChannelStatus);
        Map<String, Object> msg = null;
        try {

            msg = checkParam(stockChannelStatus);
            if (!(boolean) msg.get("tag")) {
                stockLog.error("传入的参数无效！" + stockChannelStatus);
                return new Message(false, Message.PARAMETER_WRONG + "--->无效的参数：" + stockChannelStatus);
            }

            // 2.数据replace into到stock_channel_status（渠道商品状态明细表）
            StockChannelStatus target = (StockChannelStatus) msg.get("stockChannelStatus");
            int tag = this.stockChannelStatusDefineMapper.insertOrReplace(target);

            // 3.根据传入的渠道+款的信息,查询渠道+SKU明细信息（不查询下架状态的）：//
            List<ChannelProdBean> channelProdDetailList = this.stockChannelProdDetailDefineMapper.selectByChannelStatus(target);
            stockLog.debug("查询到的渠道+SKU明细信息数据量：" + channelProdDetailList.size());

            // 4.将查询到的渠道+SKU明细信息数据推送到线上MQ队列：ONLINE_CHANNEL_STOCK。(下架不推送)
            sendToOnlineMq(channelProdDetailList);
            stockLog.debug("将查询到的渠道+SKU明细信息推送到线上MQ结束");
            // 5.返回
            return new Message(tag != 0, tag != 0 ? null : Message.INSERT_WRONG);

        } catch (Exception e) {
            stockLog.error("setStockChannelStatus报异常", e);
            return new Message(false, Message.INSERT_DEBUG + "-->" + e.getMessage());
        } finally {
            stockLog.debug(" 渠道+款进货(渠道+款上下架是否同步)接口setStockChannelStatus-->结束");
        }
    }

    @Override @LogService("渠道+款进货(渠道+款上下架是否同步)接口")
    public Message setStockChannelStatusList(List<StockChannelStatusBean> stockChannelStatusList) {
        stockLog.debug(" 渠道+款进货(渠道+款上下架是否同步)接口setStockChannelStatus(多条数据传入)-->开始");
        stockLog.debug("setStockChannelStatus传入的数据：" + stockChannelStatusList);
        Map<String, Object> msg = null;
        try {

            msg = checkParamList(stockChannelStatusList);
            stockLog.debug("无效的参数列表：" + msg.get("invalidParamList"));
            stockLog.debug("有效的参数封装后的列表：" + msg.get("validParamList"));

            @SuppressWarnings("unchecked")
            List<StockChannelStatus> list = (List<StockChannelStatus>) msg.get("validParamList");
            if (list == null || list.size() == 0) {
                stockLog.error("传入的参数无效:" + msg.get("invalidParamList"));
                return new Message(false, Message.PARAMETER_WRONG + "-->" + msg.get("invalidParamList"));
            }

            // 2.数据replace into到stock_channel_status（渠道商品状态明细表）
            int tag = this.stockChannelStatusDefineMapper.insertOrReplaceList(list);

            // 3.根据传入的渠道+款的信息,查询渠道+SKU明细信息（不查询下架的）
            List<ChannelProdBean> channelProdDetailList = selectByList(list);
            stockLog.debug("查询到的渠道+SKU明细信息数据量：" + channelProdDetailList.size());

            // 4.将查询到的渠道+SKU明细信息数据推送到线上MQ队列：ONLINE_CHANNEL_STOCK。(下架不推送)
            sendToOnlineMq(channelProdDetailList);
            stockLog.debug("将查询到的渠道+SKU明细信息推送到线上MQ结束");
            // 5.返回
            return new Message(tag != 0, "无效的参数列表：" + msg.get("invalidParamList"));

        } catch (Exception e) {
            stockLog.error("setStockChannelStatus报异常", e);
            return new Message(false, Message.INSERT_DEBUG + "-->异常信息：" + e.getMessage() + ",无效的参数列表：" + msg.get("invalidParamList"));
        } finally {
            stockLog.debug(" 渠道+款进货(渠道+款上下架是否同步)接口setStockChannelStatus(多条数据传入)-->结束");
        }
    }

}
