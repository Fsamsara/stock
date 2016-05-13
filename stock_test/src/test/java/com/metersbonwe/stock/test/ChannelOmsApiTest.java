package com.metersbonwe.stock.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.metersbonwe.oms.channel.bean.SyncStockParam;
import com.metersbonwe.oms.channel.service.ChannelService;
import com.metersbonwe.oms.channel.service.SynChannelStockService;
import com.mtsbw.soa.udb.dubboservice.AllotScopeCashDubboService;

public class ChannelOmsApiTest extends TestBase {

    @Resource ChannelService             channelService;

    @Resource AllotScopeCashDubboService allotScopeCashDubboService;

    @Resource SynChannelStockService     synChannelStockServiceImpl;

    @Test
    public void channelOmsApiTest() {
        try {
            //            List<AllotScopeBean> allotScopeBeans = allotScopeCashDubboService.getAllotScopeBeanByChannel("HQ01S115", "0");
            //            System.out.println(JSON.toJSONString(allotScopeBeans));
            //            ChannelApiResult result = channelService.getAllSynStockChannelShop();
            //            List<ChannelShop> channelShops = result.getChannelShopList();
            //            System.out.println("channelShops:" + JSON.toJSONString(channelShops));
            //            ChannelApiResult result1 = channelService.getChannelGoods("HQ01S116", null, "1");
            //            List<ApiChannelGoods> channelGoods = result1.getChannelGoodsList();
            //            System.out.println("channelGoods:" + JSON.toJSONString(channelGoods));
            //            ChannelApiResult result2 = channelService.onSellList("HQ01S116", null, 1, 100);
            //            List<Map<String, String>> maps = result2.getShellList();
            //            System.out.println("maps:" + JSON.toJSONString(maps));
            SyncStockParam param = new SyncStockParam();
            param.setShopCode("HQ01S115");
            param.setSku("12345678911");
            param.setStockCount(10);
            List<SyncStockParam> params = Lists.newArrayList();
            params.add(param);
            synChannelStockServiceImpl.synStock(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
