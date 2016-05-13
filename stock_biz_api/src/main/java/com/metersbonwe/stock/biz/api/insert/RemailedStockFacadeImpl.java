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
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpRemailedStockMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpRemailedStockDefineMapper;
import com.metersbonwe.stock.facade.api.RemailedStockFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.RemailedStock;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpRemailedStock;

/**
 * @author 张洪琴 门店日结接口实现类
 */
@Service public class RemailedStockFacadeImpl implements RemailedStockFacade {

    @Resource TmpRemailedStockMapper       tmpRemailedStockMapper;

    @Resource TmpRemailedStockDefineMapper tmpRemailedStockDefineMapper;

    private static StockLog                stockLog = StockLogFactory.getLogger(RemailedStockFacadeImpl.class);

    /**
     * 单个数据的有效性检查，如果有效，则封装数据
     * 
     * @param remailedStock
     * @return
     */
    private Map<String, Object> checkParam(RemailedStock remailedStock) {
        Map<String, Object> msg = new HashMap<String, Object>();
        if (remailedStock == null) {
            msg.put("tag", false);
            msg.put("wrongMsg", "不能传入空对象！");
        } else if (StringUtils.isEmpty(remailedStock.getWarehId())) {
            msg.put("tag", false);
            msg.put("wrongMsg", "传入的参数WarehId不能为空");
        } else {
            //封装数据：
            TmpRemailedStock target = new TmpRemailedStock();
            BeanUtils.copyProperties(remailedStock, target);
            if (target.getRemailDate() == null) {
                target.setRemailDate(new Date());
            }
            if (target.getUpdateTime() == null) {
                target.setUpdateTime(new Date());
            }
            msg.put("tag", true);
            msg.put("tmpRemailedStock", target);
        }
        return msg;
    }

    /**
     * 多个数据的有效性检查，如果有效，则封装数据
     * 
     * @param remailedStock
     * @return
     */
    private Map<String, Object> checkParamList(List<RemailedStock> remailedStockList) {
        Map<String, Object> msg = new HashMap<String, Object>();
        List<TmpRemailedStock> validParamList = new ArrayList<TmpRemailedStock>();
        List<RemailedStock> invalidParamList = new ArrayList<RemailedStock>();
        if (remailedStockList == null || remailedStockList.size() == 0) {
            msg.put("tag", false);
            return msg;
        }
        stockLog.debug("传入的参数数量：" + remailedStockList.size());
        //
        for (RemailedStock remailedStock : remailedStockList) {
            Map<String, Object> map = checkParam(remailedStock);
            if (!(Boolean) map.get("tag")) {
                invalidParamList.add(remailedStock);
            }
            TmpRemailedStock tmp = (TmpRemailedStock) map.get("tmpRemailedStock");
            if (tmp != null) {
                validParamList.add(tmp);
            }

        }
        msg.put("validParamList", validParamList);
        msg.put("invalidParamList", invalidParamList);
        stockLog.debug("有效参数数量：" + validParamList.size());
        stockLog.debug("无效参数数量：" + invalidParamList.size());
        return msg;
    }

    @Override
    @LogService("门店日结接口实现类")
    public Message setRemailedStock(RemailedStock remailedStock) {
        stockLog.debug("门店日结接口setRemailedStock-->开始");
        stockLog.debug("setRemailedStock传入的参数是：" + remailedStock);
        try {

            Map<String, Object> msg = checkParam(remailedStock);
            if (!(Boolean) msg.get("tag")) {
                stockLog.error("setRemailedStock传入的参数无效：" + remailedStock);
                return new Message(false, Message.PARAMETER_WRONG + "-->" + msg.get("wrongMsg") + "---->" + remailedStock);
            }

            //插入同步库临时表：
            int tag = this.tmpRemailedStockMapper.insertSelective((TmpRemailedStock) msg.get("tmpRemailedStock"));
            stockLog.debug("插入到临时表的行数：" + tag);
            return new Message(tag != 0, tag != 0 ? null : Message.INSERT_WRONG);

        } catch (Exception e) {
            stockLog.debug("setRemailedStock报异常", e);
            return new Message(false, Message.INSERT_DEBUG);
        } finally {
            stockLog.debug("门店日结接口setRemailedStock-->结束");
        }
    }

    @SuppressWarnings("unchecked")
    @Override @LogService("门店日结接口实现类")
    public Message setRemailedStockList(List<RemailedStock> remailedStockList) {
        stockLog.debug("门店日结接口setRemailedStock(多条数据传入)-->开始");
        stockLog.debug("setRemailedStock传入的参数是：" + remailedStockList);
        Map<String, Object> msg = null;
        try {

            msg = checkParamList(remailedStockList);
            stockLog.debug("传入的无效参数列表：" + msg.get("invalidParamList"));
            stockLog.debug("传入的有效参数封装后的列表：" + msg.get("validParamList"));

            //
            List<TmpRemailedStock> tmpList = (List<TmpRemailedStock>) msg.get("validParamList");
            if (tmpList.size() == 0) {
                stockLog.error("setRemailedStock传入的参数无效：" + msg.get("invalidParamList"));
                return new Message(false, Message.PARAMETER_WRONG + "---->" + msg.get("invalidParamList"));
            }

            //插入数据到临时表：
            int tag = this.tmpRemailedStockDefineMapper.insertList(tmpList);
            stockLog.debug("实际插入到临时表的数据量：" + tag);
            //
            return new Message(tag != 0, "传入的无效参数列表：" + msg.get("invalidParamList"));
        } catch (Exception e) {
            stockLog.error("setRemailedStock报异常", e);
            return new Message(false, Message.INSERT_DEBUG + "---->" + "传入的无效参数列表：" + msg.get("invalidParamList"));
        } finally {
            stockLog.debug("门店日结接口setRemailedStock（多条数据传入）-->结束");
        }
    }

}
