package com.metersbonwe.stock.test.schedule;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.metersbonwe.stock.dal.auto.core.mapper.StockShopRemailMapper;
import com.metersbonwe.stock.dal.auto.sync.mapper.TmpRemailedStockMapper;
import com.metersbonwe.stock.facade.schedule.TmpRemailedStockService;
import com.metersbonwe.stock.test.TestBase;

public class TmpRemailedStockServiceTest extends TestBase {

    @Autowired TmpRemailedStockService tmpRemailedStockService;

    @Autowired TmpRemailedStockMapper  tmpRemailedStockMapper;

    @Autowired StockShopRemailMapper   stockShopRemailMapper;

    @Test
    public void doService() {
        /*//准备数据
        String msg = String.format("仓库%S计算WS安全库存%d", "HQ01W500", 300);
        System.out.println(msg);

        Date aDate = DateUtil.string2Date("2016-03-28", "yyyy-MM-dd");
        System.out.println(aDate);

        Date date = new Date();
        Map<String, Date> map = new HashMap<String, Date>();
        String sDate = DateUtil.date2String(date, "yyyy-MM-dd");
        map.put("begin", DateUtil.string2Date(sDate + " 00:00:00", "yyyy-MM-dd HH:mm:ss"));
        map.put("end", DateUtil.string2Date(sDate + " 23:59:59", "yyyy-MM-dd HH:mm:ss"));

        System.out.println(String.format("begin:%tF %tT", map.get("begin"), map.get("begin")));
        System.out.println(String.format("begin:%tF %tT", map.get("end"), map.get("end")));

        StockShopRemailExample stockShopRemailExample = new StockShopRemailExample();
        stockShopRemailExample.createCriteria().andWarehIdEqualTo("HQ01W850").andUpdateTimeBetween(aDate, DateUtils.getBeforeDay(aDate, 1));
        List<StockShopRemail> bak = stockShopRemailMapper.selectByExample(stockShopRemailExample);
        System.out.println("bak" + bak.size());

        TmpRemailedStock tmpRemailedStock = new TmpRemailedStock();
        tmpRemailedStock.setWarehId("A00021S003");
        tmpRemailedStock.setRemailDate(aDate);
        tmpRemailedStock.setUpdateTime(new Date());
        tmpRemailedStockMapper.insertSelective(tmpRemailedStock);
        System.out.println("数据OK，开始测试");*/
        //开始测试 
        /*tmpRemailedStockService.doService();*/
        Set<String> skus=new HashSet<String>();
        skus.add("55");
        skus.add("55");
        skus.add("55");
        skus.add("56");
        String s="56";
        skus.add(s);
        for (String string : skus) {
            System.out.println(string);
        }
    }
}
