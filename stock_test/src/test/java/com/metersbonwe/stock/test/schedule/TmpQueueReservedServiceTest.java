package com.metersbonwe.stock.test.schedule;

/*import com.metersbonwe.stock.facade.schedule.UsefulWarehChangeService;
*/

import com.metersbonwe.stock.facade.schedule.TmpQueueReservedService;
import com.metersbonwe.stock.test.TestBase;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author sky
 * @version V1.0
 * @description 可用仓变化测试类
 * @date 2016/3/23
 */
public class TmpQueueReservedServiceTest extends TestBase {

    @Resource TmpQueueReservedService tmpQueueReservedService;

    @Test public void testMain() {
        tmpQueueReservedService.processTmpQueueReservedData();
    }
}
