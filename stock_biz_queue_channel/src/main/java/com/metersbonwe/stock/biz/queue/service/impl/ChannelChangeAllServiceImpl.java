package com.metersbonwe.stock.biz.queue.service.impl;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.AllocationRangeService;
import com.metersbonwe.stock.biz.common.service.FullChannelGroupService;
import com.metersbonwe.stock.biz.log.LogService;
import com.metersbonwe.stock.biz.queue.service.ChannelChangeAllService;
import com.metersbonwe.stock.dal.auto.core.mapper.TmpQueueAllMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelProd;
import com.metersbonwe.stock.po.core.TmpQueueAll;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
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
 * @date 2016/4/28
 */
@Service public class ChannelChangeAllServiceImpl extends FreeLockReservedBaseService implements ChannelChangeAllService, MessageListener {
    private static StockLog           log = StockLogFactory.getLogger(ChannelChangeAllServiceImpl.class);

    @Resource AllocationRangeService  allocationRangeService;

    @Resource FullChannelGroupService fullChannelGroupService;

    @Resource TmpQueueAllMapper       tmpQueueAllMapper;

    @LogService(value = "渠道表所有库存量队列", resolverType = "jmsTextMessageArgsResolver")
    @Override
    public void onMessage(Message message) {
        try {
            log.debug("计算渠道表所有库存量队列处理开始");
            TextMessage textMessage = (TextMessage) message;
            TmpQueueAll tmpQueueAll = JSON.parseObject(textMessage.getText(), TmpQueueAll.class);
            log.debug("计算渠道表所有库存量队列接收到数据：" + "仓库编码：" + tmpQueueAll.getWarehId() + "产品编码:" + tmpQueueAll.getProdId());
            processAllChange(tmpQueueAll);
            log.debug("计算渠道表所有库存量队列处理结束");
        } catch (Exception e) {
            log.error("计算渠道表所有库存量队列处理异常", e);
        }
    }

    @LogService("渠道表所有库存量队列")
    @Override
    public void processAllChange(TmpQueueAll tmpQueueAll) {
        String warehId = tmpQueueAll.getWarehId();
        String prodId = tmpQueueAll.getProdId();
        List<String> channelCodeList = allocationRangeService.getOnlineAllotScopeByWarehId(warehId);
        log.debug("仓对应的渠道为：" + channelCodeList.toString());
        boolean insertFlg = false;
        for (String channelCode : channelCodeList) {
            if (fullChannelGroupService.getChannelProdUpdateFlag(channelCode) && !insertFlg) {
                tmpQueueAllMapper.insert(tmpQueueAll);
                insertFlg = true;
            } else if (!fullChannelGroupService.getChannelProdUpdateFlag(channelCode)) {
                List<String> usefulWarehList = cacheServiceImpl.getChannelUsefulWarehFromCache(channelCode);
                if (usefulWarehList.size() == 0) {
                    log.debug("渠道：" + channelCode + "无可用仓");
                    return;
                }
                StockChannelProd stockChannelProd = createUpdateBean(usefulWarehList, channelCode, prodId);
                int updtCount = updateChannelProd(stockChannelProd);
                if (updtCount == 0) {
                    insertToStockChannelProd(stockChannelProd);
                    insertToStockChannelProdSub(channelCode, prodId);
                }
                List<ChannelProdBean> changeData = getChangeData(channelCode, prodId);
                sendToMq(changeData);
            }
        }
    }

    private StockChannelProd createUpdateBean(List<String> usefulWareh, String channelCode, String prodId) {
        List<String> reservedUsefulWareh = new ArrayList<>(usefulWareh);
        reservedUsefulWareh.retainAll(cacheServiceImpl.getB2BWarehFromCache());
        //获取店群预留量，预留量，自由量，锁定量
        String channelGroupCode = cacheServiceImpl.getShopGroupFromCache(channelCode);
        int channelGroupReservedQty = calReservedData(channelGroupCode, reservedUsefulWareh, prodId);
        int reservedQty = calReservedData(channelCode, reservedUsefulWareh, prodId);
        Map<String, BigDecimal> map = calFreeLockData(usefulWareh, prodId);
        int lockStock = map.get(Constants.ParamMapKey.LOCK_STOCK).intValue();
        int freeStock = map.get(Constants.ParamMapKey.FREE_STOCK).intValue();
        StockChannelProd stockChannelProd = new StockChannelProd();
        stockChannelProd.setChannelGroupPrivateStock(channelGroupReservedQty);
        stockChannelProd.setFinalFreeStock(freeStock);
        stockChannelProd.setLockStock(lockStock);
        stockChannelProd.setPrivateStock(reservedQty);
        stockChannelProd.setProdId(prodId);
        stockChannelProd.setChannelCode(channelCode);
        return stockChannelProd;
    }

}
