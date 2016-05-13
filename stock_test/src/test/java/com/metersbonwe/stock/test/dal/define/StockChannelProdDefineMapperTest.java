package com.metersbonwe.stock.test.dal.define;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.dal.define.core.mapper.StockChannelProdDefineMapper;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.PageThreadLocal;
import com.metersbonwe.stock.pojo.StockChannelProdBean;
import com.metersbonwe.stock.test.TestBase;

public class StockChannelProdDefineMapperTest extends TestBase {

    @Autowired StockChannelProdDefineMapper stockChannelProdDefineMapper;

    @Test
    public void mainTest() {

        //        ChannelProdBean channelProdBean = new ChannelProdBean();
        //        
        //        channelProdBean.setChannelCode("hq01s112");
        //        channelProdBean.setProdId("12345678901");
        //        
        //        channelProdBean = stockChannelProdDefineMapper.selectForChannelAndProd(channelProdBean);
        //        
        //        System.out.println(JSON.toJSONString(channelProdBean));

        StockChannelProdBean stockChannelProdBean = new StockChannelProdBean();

        List<String> channelCodes = new ArrayList<String>();
        channelCodes.add("hq01s112");
        channelCodes.add("hq01s113");

        List<String> prodIds = new ArrayList<String>();
        prodIds.add("12345678901");
        prodIds.add("12345678902");

        stockChannelProdBean.setChannelCodes(channelCodes);
        stockChannelProdBean.setProdIds(prodIds);

        Page<?> page = new Page<>();
        page.setPageNo(1);
        page.setPageSize(2);
        PageThreadLocal.setThreadLocalPage(page);

        List<StockChannelProdBean> list = stockChannelProdDefineMapper.selectForChannelsAndProds(stockChannelProdBean);

        for (StockChannelProdBean bean : list) {
            System.out.println(JSON.toJSONString(bean));
        }
    }

}
