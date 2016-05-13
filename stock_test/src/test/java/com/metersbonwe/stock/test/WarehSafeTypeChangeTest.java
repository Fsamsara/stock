package com.metersbonwe.stock.test;

/*import com.metersbonwe.stock.facade.schedule.UsefulWarehChangeService;
*/

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.metersbonwe.stock.facade.schedule.WarehSafeTypeChangeService;

/**
 * @author sky
 * @version V1.0
 * @description 可用仓变化测试类
 * @date 2016/3/23
 */
public class WarehSafeTypeChangeTest extends TestBase {

    @Autowired
    WarehSafeTypeChangeService warehSafeTypeChangeService;

    @Test
    public void testMain(){
        warehSafeTypeChangeService.processTmpSafeTypeStockData();
    }
}
