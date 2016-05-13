package com.metersbonwe.stock.test.biz.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.biz.manager.service.StockChannelProdService;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.PageThreadLocal;
import com.metersbonwe.stock.pojo.StockChannelProdBean;
import com.metersbonwe.stock.test.TestBase;

public class StockChannelProdServiceTest extends TestBase {

    @Resource
    StockChannelProdService stockChannelProdService;

    @Test
    public void test() {
        Map<String,List<String>> paramListMap = new HashMap<String,List<String>>();

        List<String> channelCodes = new ArrayList<String>();
        channelCodes.add("hq01s112");
        channelCodes.add("hq01s113");

        List<String> prodIds = new ArrayList<String>();
        prodIds.add("12345678901");
        prodIds.add("12345678902");
        
        paramListMap.put("channelCode", channelCodes);
        paramListMap.put("prodId", prodIds);

        Page<?> page = new Page<>();
        page.setPageNo(1);
        page.setPageSize(2);
        PageThreadLocal.setThreadLocalPage(page);

        List<StockChannelProdBean> list = stockChannelProdService.selectForChannelsAndProds(paramListMap);

        for (StockChannelProdBean bean : list) {
            System.out.println(JSON.toJSONString(bean));
        }
    }

}
