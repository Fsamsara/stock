package com.metersbonwe.stock.test.schedule;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.metersbonwe.stock.dal.auto.sync.mapper.TmpWmsPropertyMapper;
import com.metersbonwe.stock.facade.schedule.WmsAttributeChangesService;
import com.metersbonwe.stock.po.sync.TmpWmsProperty;
import com.metersbonwe.stock.test.TestBase;

public class WmsAttributeChangesServiceTest extends TestBase {

    @Resource
    WmsAttributeChangesService wmsAttributeChangesServiceImpl;

    @Autowired
    TmpWmsPropertyMapper tmpWmsPropertyMapper;

    @Test
    public void doService() {
        //准备数据
        try {
            for (int i = 0; i < 3; i++) {
                String usma = (i % 2) == 0 ? "1" : "0";
                TmpWmsProperty tmpWmsProperty = new TmpWmsProperty();
                tmpWmsProperty.setWarehId("HQ01W500");
                tmpWmsProperty.setUsedMa(usma);
                tmpWmsProperty.setUpdateTime(new Date());
                tmpWmsPropertyMapper.insertSelective(tmpWmsProperty);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        

        System.out.println("数据OK，开始测试");
        //开始测试
        wmsAttributeChangesServiceImpl.doService();
    }
}
