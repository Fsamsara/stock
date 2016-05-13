package com.metersbonwe.stock.test.biz.api;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import com.metersbonwe.stock.Constants;
import com.metersbonwe.stock.facade.schedule.OnlinOfflineCompareService;
import com.metersbonwe.stock.test.TestBase;

/**
 * @author 张洪琴 活动期间渠道商品推送独占量接收接口实现类测试
 */
public class OnlineOfflineCompareTest extends TestBase {
    @Resource OnlinOfflineCompareService onlinOfflineCompareServiceImpl;

    public void onlineOfflinCompare() {
        Map<String, String> paraMap = new ConcurrentHashMap<>();
        try {
            paraMap.put(Constants.CHANNEL_CODE, "HQ01S115");
            onlinOfflineCompareServiceImpl.compareService(paraMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
