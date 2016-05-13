package com.metersbonwe.stock.test.dal.define;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.metersbonwe.stock.dal.define.sync.mapper.ChangeQtyMapper;
import com.metersbonwe.stock.pojo.ChangeQtyGlobalBean;
import com.metersbonwe.stock.pojo.ChangeQtyInfoBean;
import com.metersbonwe.stock.test.TestBase;

public class ChangeQtyMapperTest extends TestBase {
    
    @Autowired
    private ChangeQtyMapper changeQtyMapper;
    
    @Test
    public void test(){
        
//        ChangeQtyGlobalBean changeQtyGlobalBean = new ChangeQtyGlobalBean();
//        
//        changeQtyGlobalBean.setMaxDataCount(1);
//        
//        List<ChangeQtyInfoBean> list = changeQtyMapper.selectTmpFreeQtyInfo(changeQtyGlobalBean);
//        
//        for (ChangeQtyInfoBean changeQtyInfoBean : list) {
//            System.out.println(JSON.toJSONString(changeQtyInfoBean));
//        }
        
//        ChangeQtyInfoBean changeQtyInfoBean = new ChangeQtyInfoBean();
//        
//        changeQtyInfoBean.setWarehId("40953");
//        changeQtyInfoBean.setProdId("456145");
//        changeQtyInfoBean.setDataSource("NERP");
//        changeQtyInfoBean.setId(new BigDecimal("2"));
//        
//        int count = changeQtyMapper.deleteTmpLockedQtyInfo(changeQtyInfoBean);
//        
//        System.out.println(count);
        
        ChangeQtyGlobalBean changeQtyGlobalBean = new ChangeQtyGlobalBean();
        
        changeQtyGlobalBean.setMaxDataCount(1);
        
        List<ChangeQtyInfoBean> list = changeQtyMapper.selectTmpReservedQtyInfo(changeQtyGlobalBean);
        
        for (ChangeQtyInfoBean changeQtyInfoBean : list) {
            System.out.println(JSON.toJSONString(changeQtyInfoBean));
        }
        
    }

}
