package com.metersbonwe.stock.biz.api.insert;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.ExceptionConstants;
import com.metersbonwe.stock.biz.log.LogService;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelSendedDefineMapper;
import com.metersbonwe.stock.facade.api.StockChannelSendedFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.StockChannelSendedBean;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelSended;

/**
 * @author zhq 推送线上回写接口实现类
 */
@Service public class StockChannelSendedFacadeImpl implements StockChannelSendedFacade {

    private static StockLog                  stockLog = StockLogFactory.getLogger(StockChannelSendedFacadeImpl.class);

    @Resource StockChannelSendedDefineMapper stockChannelSendedDefineMapper;

    /**
     * TODO 检查单个数据的有效性
     * 
     * @param stockChannelSendedBean
     * @return
     */
    private Map<String, Object> checkParam(StockChannelSendedBean stockChannelSendedBean) {
        Map<String, Object> msg = new HashMap<String, Object>();
        stockLog.debug("需要检查的数据是：" + stockChannelSendedBean);
        if (stockChannelSendedBean == null || StringUtils.isEmpty(stockChannelSendedBean.getChannelCode())
                || StringUtils.isEmpty(stockChannelSendedBean.getProdId()) || StringUtils.isEmpty(stockChannelSendedBean.getStatus())
                || stockChannelSendedBean.getAccTime() == null) {
            msg.put("tag", false);
        } else {
            StockChannelSended target = new StockChannelSended();
            target.setChannelCode(stockChannelSendedBean.getChannelCode());
            target.setProdId(stockChannelSendedBean.getProdId());
            target.setAccTime(stockChannelSendedBean.getAccTime());
            target.setStatus(stockChannelSendedBean.getStatus());
            target.setUpdateTime(new Date());
            if (StringUtils.isNotBlank(stockChannelSendedBean.getErrorDetail())) {
                target.setErrorDetail(stockChannelSendedBean.getErrorDetail());
            } else {
                target.setErrorDetail(ExceptionConstants.SUCCESS_MESSAGE);
            }
            msg.put("tag", true);
            msg.put("stockChannelSended", target);
            stockLog.debug("传入的参数封装后对应的数据是：" + target);
        }
        return msg;
    }

    /**
     * TODO 检查多个数据的有效性
     * 
     * @param stockChannelSendedBean
     * @return
     */
    private Map<String, Object> checkParamList(List<StockChannelSendedBean> stockChannelSendedBeanList) {
        Map<String, Object> msg = new HashMap<String, Object>();
        List<StockChannelSended> validParamList = new ArrayList<StockChannelSended>();
        List<StockChannelSendedBean> invalidParamList = new ArrayList<StockChannelSendedBean>();

        //
        if (stockChannelSendedBeanList == null || stockChannelSendedBeanList.size() == 0) {
            msg.put("tag", false);
            return msg;
        }
        stockLog.debug("传入的参数数据量：" + stockChannelSendedBeanList.size());

        for (StockChannelSendedBean stockChannelSendedBean : stockChannelSendedBeanList) {
            Map<String, Object> map = checkParam(stockChannelSendedBean);
            if (!(boolean) map.get("tag")) {
                invalidParamList.add(stockChannelSendedBean);
            }
            StockChannelSended s = (StockChannelSended) map.get("stockChannelSended");
            if (s != null) {
                validParamList.add(s);
            }
        }
        //
        msg.put("validParamList", validParamList);
        msg.put("invalidParamList", invalidParamList);
        stockLog.debug("有效参数数据量：" + validParamList.size());
        stockLog.debug("无效参数数据量：" + invalidParamList.size());
        return msg;
    }

    @Override
    @LogService("推送线上回写接口")
    public Message setStockChannelSended(StockChannelSendedBean stockChannelSendedBean) {
        stockLog.debug("推送线上回写接口（单条数据）--->开始");
        stockLog.debug("传入的参数是：" + stockChannelSendedBean);
        try {
            Map<String, Object> map = checkParam(stockChannelSendedBean);
            if (!(boolean) map.get("tag")) {
                stockLog.debug("传入的参数无效：" + stockChannelSendedBean);
                return new Message(false, "传入的参数无效：" + stockChannelSendedBean);
            }
            //更新到stock_channel_sended表：
            int tag = stockChannelSendedDefineMapper.update((StockChannelSended) map.get("stockChannelSended"));
            stockLog.debug("更新stock_channel_sended表对应的数据量：" + tag);

            return new Message(tag != 0, tag != 0 ? "更新成功！" : "更新失败");
        } catch (Exception e) {
            stockLog.error("推送线上回写接口实现类-->setStockChannelSended出现异常：" + e.getMessage(), e);
            return new Message(false, "出现异常：" + e.getMessage());
        } finally {
            stockLog.debug("推送线上回写接口（单条数据）--->结束");
        }
    }

    @Override
    @LogService("推送线上回写接口")
    public Message setStockChannelSendedList(List<StockChannelSendedBean> stockChannelSendedList) {
        stockLog.debug("推送线上回写接口（多条数据）--->开始");
        Map<String, Object> msg = null;
        try {
            msg = checkParamList(stockChannelSendedList);
            stockLog.debug("传入的无效参数有：" + msg.get("invalidParamList"));
            stockLog.debug("传入的有效参数封装后的数据：" + msg.get("validParamList"));

            @SuppressWarnings("unchecked")
            List<StockChannelSended> list = (List<StockChannelSended>) msg.get("validParamList");
            if (list.size() == 0) {
                stockLog.error("传入的参数无效：" + msg.get("invalidParamList"));
                return new Message(false, "传入的参数无效：" + msg.get("invalidParamList"));
            }

            //
            int tag = 0;
            for (StockChannelSended stockChannelSended : list) {
                int i = stockChannelSendedDefineMapper.update(stockChannelSended);
                tag += i;
            }
            //
            return new Message(tag != 0, "传入的无效参数有：" + msg.get("invalidParamList"));

        } catch (Exception e) {
            stockLog.error("推送线上回写接口实现类-->setStockChannelSended出现异常：" + e.getMessage(), e);
            return new Message(false, "出现异常：" + e.getMessage());
        } finally {
            stockLog.debug("推送线上回写接口（多条数据）--->结束");
        }
    }

}
