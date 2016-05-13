package com.metersbonwe.stock.test.biz.manager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.biz.manager.service.StockChannelSendedService;
import com.metersbonwe.stock.po.core.StockChannelSended;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.PageThreadLocal;
import com.metersbonwe.stock.pojo.StockChannelSendedBean;
import com.metersbonwe.stock.test.TestBase;

public class StockChannelSendedServiceTest extends TestBase {
    
    @Resource
    StockChannelSendedService stockChannelSendedService;
    
    @Test
    public void test() {
        StockChannelSendedBean stockChannelSendedBean = new StockChannelSendedBean();

        List<String> channelCodes = new ArrayList<String>();
        channelCodes.add("hq01s112");
        channelCodes.add("hq01s113");

        List<String> prodIds = new ArrayList<String>();
        prodIds.add("12345678901");
        prodIds.add("12345678902");
        
        stockChannelSendedBean.setChannelCodes(channelCodes);
        stockChannelSendedBean.setProdIds(prodIds);

        Page<?> page = new Page<>();
        page.setPageNo(1);
        page.setPageSize(2);
        PageThreadLocal.setThreadLocalPage(page);

        List<StockChannelSended> list = stockChannelSendedService.selectForChannelsAndProds(stockChannelSendedBean);

        for (StockChannelSended vo : list) {
            System.out.println(JSON.toJSONString(vo));
        }
    }

}
