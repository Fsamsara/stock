package com.metersbonwe.stock.test.schedule;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.metersbonwe.stock.dal.auto.sync.mapper.TmpShopSafeStockMapper;
import com.metersbonwe.stock.facade.schedule.TmpShopSafeStockService;
import com.metersbonwe.stock.po.sync.TmpShopSafeStock;
import com.metersbonwe.stock.test.TestBase;

public class TmpSafetyStockServiceImplTest extends TestBase {

    @Autowired TmpShopSafeStockService stockShopSafeService;

    @Autowired TmpShopSafeStockMapper tmpShopSafeStockMapper;

    @Test
    public void doService() {
        //准备数据
      /*  try {
            for (int i = 0; i < 3; i++) {
                TmpShopSafeStock tmpShopSafeStock = new TmpShopSafeStock();
                tmpShopSafeStock.setWarehId("A01339S013");
                tmpShopSafeStock.setProdId("10102599030");
                tmpShopSafeStock.setUpdateTime(new Date());
                tmpShopSafeStock.setShopSafeStock(new BigDecimal(-1));
                tmpShopSafeStockMapper.insertSelective(tmpShopSafeStock);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("数据准备OK,开始测试");*/
        //准备服务
        stockShopSafeService.doService();
    }
}
