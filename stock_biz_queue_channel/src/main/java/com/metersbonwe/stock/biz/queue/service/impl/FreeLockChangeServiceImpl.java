package com.metersbonwe.stock.biz.queue.service.impl;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.common.service.CacheService;
import com.metersbonwe.stock.biz.common.service.FullChannelGroupService;
import com.metersbonwe.stock.biz.log.LogService;
import com.metersbonwe.stock.biz.queue.service.FreeLockChangeService;
import com.metersbonwe.stock.dal.auto.core.mapper.TmpQueueFreeLockMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.po.core.StockChannelProd;
import com.metersbonwe.stock.po.core.TmpQueueFreeLock;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.utils.CommonUtil;
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
 * @description 自由量锁定量队列处理类
 * @date 2016/3/24
 */
@Service public class FreeLockChangeServiceImpl extends FreeLockReservedBaseService implements FreeLockChangeService, MessageListener {
    private static StockLog           logger = StockLogFactory.getLogger(FreeLockChangeServiceImpl.class);

    @Resource FullChannelGroupService fullChannelGroupService;

    @Resource TmpQueueFreeLockMapper  tmpQueueFreeLockMapper;

    @Resource CacheService            cacheServiceImpl;

    @Override             @LogService(value="自由量锁定量队列",resolverType="jmsTextMessageArgsResolver")
    public void onMessage(Message message) {
        try {
            logger.info("自由量锁定量队列处理开始");
            TextMessage msg = (TextMessage) message;
            TmpQueueFreeLock tmpQuequeFreeLock = JSON.parseObject(msg.getText(), TmpQueueFreeLock.class);
            logger.debug("自由量锁定量队列接收到数据：" + "仓库ID：" + tmpQuequeFreeLock.getWarehId() + "产品ID：" + tmpQuequeFreeLock.getProdId());
            processFreeLockChange(tmpQuequeFreeLock);
            logger.info("自由量锁定量队列处理结束");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @LogService("自由量锁定量队列")
    @Override
    public void processFreeLockChange(TmpQueueFreeLock tmpQueueFreeLock) {
        Date startDate = new Date();
        String warehId = tmpQueueFreeLock.getWarehId();
        String prodId = tmpQueueFreeLock.getProdId();
        List<String> channelCodeList = getChannelListByWarehId(warehId);
        logger.debug("仓对应的渠道为：" + channelCodeList.toString());
        boolean insertFlg = false;
        //按渠道最终可用仓分组渠道后的Map
        Map<List<String>, List<String>> warehChannelMap = new HashMap<>();
        for (String channelCode : channelCodeList) {
            if (fullChannelGroupService.getChannelProdUpdateFlag(channelCode) && !insertFlg) {
                tmpQueueFreeLockMapper.insert(tmpQueueFreeLock);
                insertFlg = true;
            } else if (!fullChannelGroupService.getChannelProdUpdateFlag(channelCode)) {
                List<String> usefulWarehList = cacheServiceImpl.getChannelUsefulWarehFromCache(channelCode);
                if (usefulWarehList != null && usefulWarehList.size() == 0)
                    continue;
                if (warehChannelMap.containsKey(usefulWarehList)) {
                    warehChannelMap.get(usefulWarehList).add(channelCode);
                } else {
                    List<String> channelCodes = new ArrayList<>();
                    channelCodes.add(channelCode);
                    warehChannelMap.put(usefulWarehList, channelCodes);
                }
            }
        }
        for (Map.Entry<List<String>, List<String>> entry : warehChannelMap.entrySet()) {
            List<String> warehList = entry.getKey();
            List<String> channelList = entry.getValue();
            updateChannelProd(warehList, channelList, prodId);
        }
        Date endDate = new Date();
        logger.debug("自由量锁定量队列处理耗时：" + CommonUtil.timeInterval(startDate, endDate));
        ;
    }

    /**
     * @description 更新渠道商品明细表，当找不到对应的sku的时候，需往渠道商品明细表及他的子表添加新的sku，
     * @param channelCodeList
     *            渠道List
     * @param usefulWarehList
     *            最终可用仓List
     * @param prodId
     *            商品11位码
     */
    private void updateChannelProd(List<String> usefulWarehList, List<String> channelCodeList, String prodId) {
        logger.debug("更新渠道表开始：可用仓" + usefulWarehList.toString() + "；渠道号：" + channelCodeList + "；商品：" + prodId);
        Map<String, BigDecimal> map = calFreeLockData(usefulWarehList, prodId);
        logger.debug("自由量锁定量队列获取的自由量锁定量map：" + map.toString());
        int lockStock = map.get(Constants.ParamMapKey.LOCK_STOCK).intValue();
        int freeStock = map.get(Constants.ParamMapKey.FREE_STOCK).intValue();
        for (String channelCodeTmp : channelCodeList) {
            StockChannelProd stockChannelProd = createUpdateBean(channelCodeTmp, prodId);
            stockChannelProd.setFinalFreeStock(freeStock);
            stockChannelProd.setLockStock(lockStock);
            int updateCount = updateChannelProd(stockChannelProd);
            if (updateCount == 0) {
                List<String> reservedUsefulWareh = new ArrayList<>(usefulWarehList);
                reservedUsefulWareh.retainAll(cacheServiceImpl.getB2BWarehFromCache());
                String groupId = cacheServiceImpl.getShopGroupFromCache(channelCodeTmp);
                int reservedQty = calReservedData(channelCodeTmp, reservedUsefulWareh, prodId);
                int channelGroupQty = calReservedData(groupId, reservedUsefulWareh, prodId);
                stockChannelProd.setPrivateStock(reservedQty);
                stockChannelProd.setChannelGroupPrivateStock(channelGroupQty);
                insertToStockChannelProd(stockChannelProd);
                insertToStockChannelProdSub(channelCodeTmp, prodId);
            }
            List<ChannelProdBean> changeData = getChangeData(channelCodeTmp, prodId);
            sendToMq(changeData);
        }
    }
}
