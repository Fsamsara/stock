package com.metersbonwe.stock.test.biz.queue;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.alibaba.dubbo.common.json.JSON;
import com.metersbonwe.stock.biz.common.service.MqSendService;
import com.metersbonwe.stock.biz.common.service.OrderOccupyStockService;
import com.metersbonwe.stock.biz.common.service.OrderReleaseStockService;
import com.metersbonwe.stock.biz.queue.service.OnlineChannelStockQueueService;
import com.metersbonwe.stock.po.core.define.ChannelProdBean;
import com.metersbonwe.stock.pojo.StockChannelBean;
import com.metersbonwe.stock.test.TestBase;

public class OrderOccupyReleaseStockServiceTest extends TestBase {

    @Resource MqSendService                  mqSendServiceImpl;

    @Resource OrderOccupyStockService        orderOccupyStockServiceImpl;

    @Resource OrderReleaseStockService       orderReleaseStockServiceImpl;

    @Resource OnlineChannelStockQueueService onlineChannelStockQueueServiceImpl;

    //    @Test
    public void orderOccupyTest() {
        StockChannelBean stockChannelBean = new StockChannelBean();
        stockChannelBean.setBusinessId("123456789");
        stockChannelBean.setChannelCode("HQ01S115");
        stockChannelBean.setOccupyStock(2);
        stockChannelBean.setProdId("10111854030");
        stockChannelBean.setRelationChannel("HQ01S115");
        stockChannelBean.setSubOrderId("222222222");
        stockChannelBean.setOsOrderId("111111111");
        try {
            orderOccupyStockServiceImpl.processOrderOccupyStock(stockChannelBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    @Test
    public void orderReleaseTest() {
        try {
            orderReleaseStockServiceImpl.processOrderReleaseStock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void onlineSendedTest() {
        //        String message = "{\"channelCode\":\"HQ01S112\",\"eightProdId\":\"12345678\",\"finalFreeStock\":0,\"isPre\":1,\"lockStock\":0,\"orderPrivateTotalStock\":10,\"orderShareTotalStock\":10,\"preOrderTotalStock\":10,\"prePrivateStock\":10,\"privateStock\":0,\"prodId\":\"12345678902\",\"sixProdId\":\"123456\",\"tableSuffix\":\"hq01s112\"}";
        //        String message2 = "{\"channelCode\":\"HQ01S112\",\"eightProdId\":\"12345678\",\"finalFreeStock\":0,\"isPre\":1,\"lockStock\":0,\"orderPrivateTotalStock\":10,\"orderShareTotalStock\":10,\"preOrderTotalStock\":10,\"prePrivateStock\":10,\"privateStock\":0,\"prodId\":\"12345678902\",\"sixProdId\":\"123456\",\"tableSuffix\":\"hq01s112\"}";
        //        String message3 = "{\"channelCode\":\"HQ01S112\",\"eightProdId\":\"12345678\",\"finalFreeStock\":0,\"isPre\":1,\"lockStock\":0,\"orderPrivateTotalStock\":10,\"orderShareTotalStock\":10,\"preOrderTotalStock\":10,\"prePrivateStock\":10,\"privateStock\":0,\"prodId\":\"12345678902\",\"sixProdId\":\"123456\",\"tableSuffix\":\"hq01s112\"}";
        String message = "{\"channelCode\":\"HQ01S115\",\"eightProdId\":\"10102599\",\"finalFreeStock\":21,\"isPre\":0,\"lockStock\":2,\"orderPrivateTotalStock\":0,\"orderShareTotalStock\":0,\"orderShopGroupStock\":0,\"preOrderTotalStock\":0,\"prePrivateStock\":0,\"privateStock\":2,\"shopGroupStock\":2,\"prodId\":\"10102599030\",\"sixProdId\":\"101025\",\"tableSuffix\":\"hq01s115\"}";
        //        String message2 = "{\"channelCode\":\"HQ01S115\",\"eightProdId\":\"10985598\",\"finalFreeStock\":1,\"isPre\":0,\"lockStock\":1,\"orderPrivateTotalStock\":0,\"orderShareTotalStock\":0,\"preOrderTotalStock\":0,\"prePrivateStock\":1,\"privateStock\":1,\"prodId\":\"10985598044\",\"sixProdId\":\"109855\",\"tableSuffix\":\"hq01s115\"}";
        List<ChannelProdBean> beans = new ArrayList<>();
        try {
            ChannelProdBean channelProdBean = JSON.parse(message, ChannelProdBean.class);
            beans.add(channelProdBean);
            //            ChannelProdBean channelProdBean2 = JSON.parse(message2, ChannelProdBean.class);
            //            beans.add(channelProdBean2);
            //            ChannelProdBean channelProdBean3 = JSON.parse(message3, ChannelProdBean.class);
            //            beans.add(channelProdBean3);
            onlineChannelStockQueueServiceImpl.processReservedChangeList(beans);
        } catch (

        Exception e)

        {
            e.printStackTrace();
        }

    }

    //    @Test
    public void onlineSendedTest1() {
        String message = "{\"channelCode\":\"HQ01S115\",\"eightProdId\":\"10102599\",\"finalFreeStock\":4,\"isPre\":0,\"lockStock\":1,\"orderPrivateTotalStock\":0,\"orderShareTotalStock\":0,\"preOrderTotalStock\":0,\"prePrivateStock\":0,\"privateStock\":1,\"prodId\":\"10102599030\",\"sixProdId\":\"101025\",\"tableSuffix\":\"hq01s115\"}";
        String message2 = "{\"channelCode\":\"HQ01S115\",\"eightProdId\":\"10985598\",\"finalFreeStock\":4,\"isPre\":0,\"lockStock\":1,\"orderPrivateTotalStock\":0,\"orderShareTotalStock\":0,\"preOrderTotalStock\":0,\"prePrivateStock\":0,\"privateStock\":1,\"prodId\":\"10985598044\",\"sixProdId\":\"109855\",\"tableSuffix\":\"hq01s115\"}";
        //        String message3 = "{\"channelCode\":\"HQ01S112\",\"eightProdId\":\"12345678\",\"finalFreeStock\":0,\"isPre\":1,\"lockStock\":0,\"orderPrivateTotalStock\":10,\"orderShareTotalStock\":10,\"preOrderTotalStock\":10,\"prePrivateStock\":10,\"privateStock\":0,\"prodId\":\"12345678902\",\"sixProdId\":\"123456\",\"tableSuffix\":\"hq01s112\"}";
        List<ChannelProdBean> beans = new ArrayList<>();
        try {
            ChannelProdBean channelProdBean = JSON.parse(message, ChannelProdBean.class);
            beans.add(channelProdBean);
            ChannelProdBean channelProdBean2 = JSON.parse(message2, ChannelProdBean.class);
            beans.add(channelProdBean2);
            //            ChannelProdBean channelProdBean3 = JSON.parse(message3, ChannelProdBean.class);
            //            beans.add(channelProdBean3);
            mqSendServiceImpl.sendToOnLineChannelStock(beans, "hq01s115");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
