package com.metersbonwe.stock.biz.queue.service.impl;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.CacheService;
import com.metersbonwe.stock.biz.common.service.impl.FullChannelGroupServiceImpl;
import com.metersbonwe.stock.biz.log.LogService;
import com.metersbonwe.stock.biz.queue.service.ReservedChangeService;
import com.metersbonwe.stock.dal.auto.core.mapper.TmpQueueReservedMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelProd;
import com.metersbonwe.stock.po.core.TmpQueueReserved;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author huangbiao
 * @version V1.0
 * @description
 * @date 2016/3/23
 */
@Service public class ReservedChangeServiceImpl extends FreeLockReservedBaseService implements ReservedChangeService, MessageListener {
    private static StockLog               logger = StockLogFactory.getLogger(ReservedChangeServiceImpl.class);

    @Resource FullChannelGroupServiceImpl fullChannelGroupService;

    @Resource TmpQueueReservedMapper      tmpQueueReservedMapper;

    @Resource CacheService                cacheServiceImpl;

    @LogService(value = "预留量队列", resolverType = "jmsTextMessageArgsResolver")
    @Override
    public void onMessage(Message message) {
        try {
            logger.info("预留量队列处理开始");
            TextMessage msg = (TextMessage) message;
            TmpQueueReserved tmpQueueReserved = JSON.parseObject(msg.getText(), TmpQueueReserved.class);
            logger.debug("预留量队列接收到数据：" + "渠道ID：" + tmpQueueReserved.getChannelCode() + "产品ID：" + tmpQueueReserved.getProdId());
            processReservedChange(tmpQueueReserved);
            logger.info("预留量队列处理结束");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @LogService("预留量队列")
    @Override
    public void processReservedChange(TmpQueueReserved tmpQueueReserved) {
        String channelCode = tmpQueueReserved.getChannelCode();
        String prodId = tmpQueueReserved.getProdId();
        if (fullChannelGroupService.getChannelProdUpdateFlag(channelCode)) {
            tmpQueueReservedMapper.insert(tmpQueueReserved);
        } else {
            List<String> usefulWarehSrc = cacheServiceImpl.getChannelUsefulWarehFromCache(channelCode);
            List<String> usefulWareh = new ArrayList<>(usefulWarehSrc);
            List<String> b2bWareh = cacheServiceImpl.getB2BWarehFromCache();
            if (usefulWareh.size() == 0 || b2bWareh == null || b2bWareh.size() == 0) {
                logger.debug("渠道：" + channelCode + "计算预留量无可用仓！");
                return;
            }
            usefulWareh.retainAll(b2bWareh);
            int reservedQty = calReservedData(channelCode, usefulWareh, prodId);
            StockChannelProd stockChannelProd = createUpdateBean(channelCode, prodId);
            stockChannelProd.setPrivateStock(reservedQty);
            int updtCount = updateChannelProd(stockChannelProd);
            if (updtCount == 0) {
                //获取店群预留量，自由量，锁定量
                String channelGroupCode = cacheServiceImpl.getShopGroupFromCache(channelCode);
                int channelGroupReservedQty = calReservedData(channelGroupCode, usefulWareh, prodId);
                Map<String, BigDecimal> map = calFreeLockData(usefulWarehSrc, prodId);
                int lockStock = map.get(Constants.ParamMapKey.LOCK_STOCK).intValue();
                int freeStock = map.get(Constants.ParamMapKey.FREE_STOCK).intValue();
                stockChannelProd.setChannelGroupPrivateStock(channelGroupReservedQty);
                stockChannelProd.setFinalFreeStock(freeStock);
                stockChannelProd.setLockStock(lockStock);
                insertToStockChannelProd(stockChannelProd);
                //插入明细表
                insertToStockChannelProdSub(channelCode, prodId);
            }
            sendToMq(getChangeData(channelCode, prodId));
        }
    }
}
