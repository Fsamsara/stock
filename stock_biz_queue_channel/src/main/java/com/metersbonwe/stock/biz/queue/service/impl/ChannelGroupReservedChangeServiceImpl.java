package com.metersbonwe.stock.biz.queue.service.impl;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.CacheService;
import com.metersbonwe.stock.biz.common.service.FullChannelGroupService;
import com.metersbonwe.stock.biz.log.LogService;
import com.metersbonwe.stock.biz.queue.service.ChannelGroupReservedChangeService;
import com.metersbonwe.stock.dal.auto.core.mapper.TmpQueueChannelgroupReservedMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelProd;
import com.metersbonwe.stock.po.core.TmpQueueChannelgroupReserved;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/4/25
 */
@Service
public class ChannelGroupReservedChangeServiceImpl extends FreeLockReservedBaseService implements ChannelGroupReservedChangeService , MessageListener {

    private static StockLog log = StockLogFactory.getLogger(ChannelGroupReservedChangeServiceImpl.class);

    @Resource CacheService cacheServiceImpl;

    @Resource FullChannelGroupService fullChannelGroupService;

    @Resource TmpQueueChannelgroupReservedMapper tmpQueueChannelgroupReservedMapper;
    
    @LogService(value="店群预留量变化队列",resolverType="jmsTextMessageArgsResolver")
    @Override public void onMessage(Message message) {
        try {
            log.debug("店群预留量变化队列处理开始");
            TextMessage textMessage = (TextMessage) message;
            TmpQueueChannelgroupReserved tmpQueueChannelGroupReserved = JSON.parseObject(textMessage.getText(), TmpQueueChannelgroupReserved.class);
            log.debug(
                    "店群预留量变化队列接收到数据：" + "店群编码：" + tmpQueueChannelGroupReserved.getChannelGroupId() + "产品编码:" + tmpQueueChannelGroupReserved
                            .getProdId());
            processReservedChange(tmpQueueChannelGroupReserved);
            log.debug("店群预留量变化队列处理结束");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
    
    @Override public void processReservedChange(TmpQueueChannelgroupReserved tmpQueueChannelGroupReserved) {
        String channelGroupId = tmpQueueChannelGroupReserved.getChannelGroupId();
        String prodId = tmpQueueChannelGroupReserved.getProdId();
        List<String> channels = getChannelsByChannelGroupId(channelGroupId);
        for (String channelCode : channels) {
            if (fullChannelGroupService.getChannelProdUpdateFlag(channelCode)) {
                tmpQueueChannelgroupReservedMapper.insert(tmpQueueChannelGroupReserved);
            }else {
                List<String> usefulWareh = cacheServiceImpl.getChannelUsefulWarehFromCache(channelCode);
                List<String> b2bWareh = cacheServiceImpl.getB2BWarehFromCache();
                usefulWareh.retainAll(b2bWareh);
                if (usefulWareh.size() == 0 || b2bWareh.size() == 0) {
                    log.debug("渠道：" + channelCode + "计算店群预留量无可用仓！");
                    return;
                }
                int channelGroupReservedQty = calReservedData(channelGroupId, usefulWareh, prodId);
                StockChannelProd stockChannelProd = createUpdateBean(channelCode, prodId);
                stockChannelProd.setChannelGroupPrivateStock(channelGroupReservedQty);
                int updtCount = updateChannelProd(stockChannelProd);
                if (updtCount == 0) {
                    //获取预留量，自由量，锁定量
                    int reservedQty = calReservedData(channelCode, usefulWareh, prodId);
                    Map<String, BigDecimal> map = calFreeLockData(usefulWareh, prodId);
                    int lockStock = map.get(Constants.ParamMapKey.LOCK_STOCK).intValue();
                    int freeStock = map.get(Constants.ParamMapKey.FREE_STOCK).intValue();
                    stockChannelProd.setFinalFreeStock(freeStock);
                    stockChannelProd.setLockStock(lockStock);
                    stockChannelProd.setPrivateStock(reservedQty);
                    insertToStockChannelProd(stockChannelProd);
                    //插入明细表
                    insertToStockChannelProdSub(channelCode, prodId);
                }
                sendToMq(getChangeData(channelCode, prodId));
            }
        }
    }

    private List<String> getChannelsByChannelGroupId(String channelGroupId) {
        Map<String, List<String>> channelGroupMap = cacheServiceImpl.getShopGroupMapFromCache();
        Set<String> channelSet = new HashSet<>();
        for(Map.Entry entry : channelGroupMap.entrySet()){
            if(entry.getValue().equals(channelGroupId) ){
                channelSet.add(String.valueOf(entry.getKey()));
            }
        }
        return new ArrayList<>(channelSet);
    }
}
