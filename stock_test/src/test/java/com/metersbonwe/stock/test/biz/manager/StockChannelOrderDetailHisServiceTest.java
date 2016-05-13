package com.metersbonwe.stock.test.biz.manager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.biz.manager.service.StockChannelOrderDetailHisService;
import com.metersbonwe.stock.po.core.StockChannelOrderDetailHis;
import com.metersbonwe.stock.pojo.Page;
import com.metersbonwe.stock.pojo.PageThreadLocal;
import com.metersbonwe.stock.test.TestBase;

public class StockChannelOrderDetailHisServiceTest extends TestBase {
    
    @Resource
    StockChannelOrderDetailHisService stockChannelOrderDetailHisService;
    
    @Test
    public void test(){
        
//        StockChannelOrderDetailHisBean queryBean = new StockChannelOrderDetailHisBean();
        
        List<String> channelCodes = new ArrayList<String>();
        channelCodes.add("HQ01S001");
        channelCodes.add("HQ01S002");
        
        List<String> prodIds = new ArrayList<String>();
        prodIds.add("12345678901");
        prodIds.add("12345678902");
        
//        queryBean.setchannelCodes(channelCodes);
//        queryBean.setprodIds(prodIds);
        
        Page<?> page = new Page<>();
        page.setPageNo(1);
        page.setPageSize(4);
        PageThreadLocal.setThreadLocalPage(page);
        
        List<StockChannelOrderDetailHis> list = stockChannelOrderDetailHisService.selectByChannelAndProds(null);
        
        for (StockChannelOrderDetailHis stockChannelOrderDetailHisVo : list) {
            System.out.println(JSON.toJSONString(stockChannelOrderDetailHisVo));
        }
        
    }

}
