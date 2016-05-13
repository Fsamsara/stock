package com.metersbonwe.stock.biz.api.insert;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.biz.log.LogService;
import com.metersbonwe.stock.dal.define.sync.mapper.TmpChannelScopeDefineMapper;
import com.metersbonwe.stock.facade.api.ShopPropertyFacade;
import com.metersbonwe.stock.facade.api.bean.Message;
import com.metersbonwe.stock.facade.api.bean.ShopProperty;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.sync.TmpChannelScope;

/**
 * @author zhq 门店属性变化接收接口（是否同步）
 */
@Service public class ShopPropertyFacadeImpl implements ShopPropertyFacade {

    private static StockLog               stockLog = StockLogFactory.getLogger(ShopPropertyFacadeImpl.class);

    @Resource TmpChannelScopeDefineMapper tmpChannelScopeDefineMapper;

    @Resource AllocationRangeService      allocationRangeServiceImpl;

    /**
     * 单个数据有效性的判断
     * 
     * @param shopProperty
     * @return
     */
    private boolean checkParam(ShopProperty shopProperty) {
        if (shopProperty == null || StringUtils.isEmpty(shopProperty.getWarehId()) || StringUtils.isEmpty(shopProperty.getWarehState())) {
            return false;
        }
        return true;
    }

    /**
     * 多个参数的有效性检查
     * 
     * @param shopPropertyList
     * @return
     */
    private Map<String, Object> checkParamList(List<ShopProperty> shopPropertyList) {
        Map<String, Object> msg = new HashMap<String, Object>();
        List<ShopProperty> invalidParamList = new ArrayList<ShopProperty>();
        List<ShopProperty> validParamList = new ArrayList<ShopProperty>();

        if (shopPropertyList == null || shopPropertyList.size() == 0) {
            msg.put("tag", false);
            return msg;
        }
        stockLog.debug("传入的参数数据量：" + shopPropertyList.size());

        for (ShopProperty shopProperty : shopPropertyList) {
            boolean tag = checkParam(shopProperty);
            if (tag) {
                validParamList.add(shopProperty);
            }
            invalidParamList.add(shopProperty);
        }
        msg.put("invalidParamList", invalidParamList);
        msg.put("validParamList", validParamList);
        stockLog.debug("有效参数数据量：" + validParamList.size());
        stockLog.debug("无效参数数据量：" + invalidParamList.size());
        return msg;
    }

    @Override @LogService("门店属性变化接收接口（是否同步）")
    public Message setShopProperty(ShopProperty shopProperty) {
        stockLog.debug("门店属性变化接收接口setShopProperty-->开始");
        stockLog.debug("setShopProperty传入的参数是：" + shopProperty);
        try {
            // 1.OMS中心获取渠道列表
            List<String> channelList = allocationRangeServiceImpl.getAllUsefulChannel();
            stockLog.debug("setShopProperty从OMS中心获取渠道列表是：" + channelList);

            if (!checkParam(shopProperty)) {
                stockLog.error("传入的参数无效：" + shopProperty);
                return new Message(false, Message.PARAMETER_WRONG + "--->" + shopProperty);
            }

            // 2.封装渠道和传入的门店信息的笛卡尔积的数据到 TMP_CHANNEL_SCOPE临时表 对应的javabean：仓|店开关根据仓店开关来定,开为1关为0，是否配发范围变化为0
            List<TmpChannelScope> tmpList = new ArrayList<TmpChannelScope>();
            for (String channelCode : channelList) {
                TmpChannelScope tmp = new TmpChannelScope();
                tmp.setChannelCode(channelCode);
                tmp.setWarehId(shopProperty.getWarehId());
                tmp.setScopeChange("0");
                tmp.setWarehState(shopProperty.getWarehState());
                tmp.setUpdateTime(new Date());
                tmpList.add(tmp);
            }
            stockLog.debug("setShopProperty封装渠道和传入的门店信息的笛卡尔积数据量是：" + tmpList.size());
            // 3.将封装好的数据批量更新到同步库的TMP_CHANNEL_SCOPE
            int tag = tmpChannelScopeDefineMapper.insertList(tmpList);
            stockLog.debug("实际插入到临时表的数据量是：" + tag);
            return new Message(tag == tmpList.size() ? true : false, tag == tmpList.size() ? null : Message.INSERT_WRONG);

        } catch (Exception e) {
            stockLog.error("setShopProperty单个门店属性的变化报异常：" + e.getMessage());
            return new Message(false, Message.INSERT_DEBUG);
        } finally {
            stockLog.debug("门店属性变化接收接口setShopProperty-->结束");
        }
    }

    @Override @LogService("门店属性变化接收接口（是否同步）")
    public Message setShopPropertyList(List<ShopProperty> shopPropertyList) {
        stockLog.debug("门店属性变化接收接口setShopProperty（多条数据传入）-->开始");
        stockLog.debug("setShopProperty传入的参数是：" + shopPropertyList);
        Map<String, Object> msg = null;
        try {
            // 1.OMS中心获取渠道列表
            List<String> channelList = allocationRangeServiceImpl.getAllUsefulChannel();
            stockLog.debug("setShopProperty从OMS中心获取渠道列表是：" + channelList);
            //
            msg = checkParamList(shopPropertyList);
            stockLog.debug("无效的参数列表信息：" + msg.get("invalidParamList"));
            stockLog.debug("有效的参数列表信息：" + msg.get("validParamList"));

            @SuppressWarnings("unchecked")
            List<ShopProperty> spList = (List<ShopProperty>) msg.get("validParamList");
            if (spList.size() == 0) {
                stockLog.error("传入的参数无效：" + msg.get("invalidParamList"));
                return new Message(false, Message.PARAMETER_WRONG + "--->" + msg.get("invalidParamList"));
            }

            // 2.封装渠道和所有门店的笛卡尔积的数据到 TMP_CHANNEL_SCOPE临时表 对应的javabean：仓|店开关根据仓店开关来定,开为1关为0，是否配发范围变化为0
            List<TmpChannelScope> tmpList = new ArrayList<TmpChannelScope>();
            for (String channelCode : channelList) {
                for (ShopProperty shopProperty : spList) {
                    TmpChannelScope tmp = new TmpChannelScope();
                    tmp.setChannelCode(channelCode);
                    tmp.setWarehId(shopProperty.getWarehId());
                    tmp.setScopeChange("0");
                    tmp.setWarehState(shopProperty.getWarehState());
                    tmp.setUpdateTime(new Date());
                    tmpList.add(tmp);
                }
            }
            stockLog.debug("setShopProperty封装渠道和传入的门店信息的笛卡尔积数量是：" + tmpList.size());
            // 3.将封装好的数据批量更新到同步库的TMP_CHANNEL_SCOPE
            int tag = tmpChannelScopeDefineMapper.insertList(tmpList);
            stockLog.debug("实际插入到临时表的数据量是：" + tag);

            return new Message(tag != 0, "无效的参数列表信息：" + msg.get("invalidParamList"));

        } catch (Exception e) {
            stockLog.error("setShopProperty多个门店属性的变化报异常", e);
            return new Message(false, Message.INSERT_DEBUG + "--->异常信息：" + e.getMessage() + ",无效的参数信息：" + msg.get("invalidParamList"));
        } finally {
            stockLog.debug("门店属性变化接收接口setShopProperty（多条数据传入）-->结束");
        }
    }

}
