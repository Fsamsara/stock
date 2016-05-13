package com.metersbonwe.stock.test.biz.schedule;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.biz.schedule.service.ChangeQtySerivce;
import com.metersbonwe.stock.pojo.ChangeQtyGlobalBean;
import com.metersbonwe.stock.test.TestBase;

public class ChangeQtySerivceTest extends TestBase {
    
    @Resource(name="changeQtySerivce")
    private ChangeQtySerivce changeQtySerivce;
    
    @Test
    public void test(){
        
        ChangeQtyGlobalBean changeQtyGlobalBean =  new ChangeQtyGlobalBean();
        
        changeQtyGlobalBean.setChangeType(Constants.STOCK_CHANGE_TYPE_DAME_QTY);
        changeQtyGlobalBean.setMaxDataCount(100);
        
        try {
            changeQtySerivce.doService(changeQtyGlobalBean);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
