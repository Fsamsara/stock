package com.metersbonwe.stock.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.mtsbw.business.configuration.inventory.domain.StockChannel;
import com.mtsbw.business.configuration.inventory.domain.StockUnitChannel;
import com.mtsbw.business.configuration.inventory.domain.UnitChannelActivity;
import com.mtsbw.business.configuration.inventory.dubbo.api.IStockChannelServiceDubbo;
import com.mtsbw.business.configuration.inventory.dubbo.api.IStockUnitChannelServiceDubbo;
import com.mtsbw.business.configuration.inventory.dubbo.api.IUnitChannelActivityServiceDubbo;

public class ChannelCellMinMaxTest extends TestBase {

    @Resource IUnitChannelActivityServiceDubbo unitChannelActivityServiceDubbo;

    @Resource IStockUnitChannelServiceDubbo    stockUnitChannelServiceDubbo;

    @Resource IStockChannelServiceDubbo        stockChannelServiceDubbo;

    //    @Test
    public void channelActivity() {
        List<UnitChannelActivity> activities = Lists.newArrayList();
        UnitChannelActivity unitChannelActivity = new UnitChannelActivity();
        unitChannelActivity.setChannelCode("HQ01S115");
        unitChannelActivity.setGoodsCode("123456");
        activities.add(unitChannelActivity);
        List<UnitChannelActivity> reActivities = unitChannelActivityServiceDubbo.getUnitChannelActivityList(activities);
        System.out.println(JSON.toJSON(reActivities));
    }

    @Test
    public void channelMinMax() {
        List<String> channels = Lists.newArrayList();
        channels.add("HQ01S115");
        List<StockChannel> reChannels = stockChannelServiceDubbo.getStockChannelList(channels);
        System.out.println(JSON.toJSON(reChannels));
    }

    //        @Test
    public void channelCellMin() {
        List<StockUnitChannel> stockUnitChannels = Lists.newArrayList();
        StockUnitChannel stockUnitChannel = new StockUnitChannel();
        stockUnitChannel.setUnitChannelCode("HQ01S115");
        stockUnitChannel.setProdCode("12345678911");
        stockUnitChannels.add(stockUnitChannel);
        List<StockUnitChannel> reStockUnitChannels = stockUnitChannelServiceDubbo.getStockUnitChannelList(stockUnitChannels);
        System.out.println(JSON.toJSON(reStockUnitChannels));
    }
}
