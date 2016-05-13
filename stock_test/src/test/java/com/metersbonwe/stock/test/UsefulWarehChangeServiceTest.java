package com.metersbonwe.stock.test;

/*import com.metersbonwe.stock.facade.schedule.UsefulWarehChangeService;
*/

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.metersbonwe.stock.facade.schedule.UsefulWarehChangeService;

/**
 * @author sky
 * @version V1.0
 * @description 可用仓变化测试类
 * @date 2016/3/23
 */
public class UsefulWarehChangeServiceTest extends TestBase {
    @Autowired UsefulWarehChangeService usefulWarehChangeService;

    @Test
    public void testMain() throws Exception {
        usefulWarehChangeService.processChannelUsefulWarehChange();
    }
}
