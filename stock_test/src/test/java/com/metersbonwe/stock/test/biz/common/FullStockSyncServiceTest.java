package com.metersbonwe.stock.test.biz.common;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.biz.common.service.ChangeFinalFreeShareStockService;
import com.metersbonwe.stock.biz.common.service.ChannelCalService;
import com.metersbonwe.stock.dal.define.sync.mapper.BfOrgShopDefineMapper;
import com.metersbonwe.stock.dal.define.sync.mapper.FullStockSyncDefineMapper;
import com.metersbonwe.stock.facade.sync.api.FullStockSyncService;
import com.metersbonwe.stock.po.core.StockWarehProd;
import com.metersbonwe.stock.test.TestBase;

public class FullStockSyncServiceTest extends TestBase {

    @Resource FullStockSyncDefineMapper        fullStockSyncDefineMapper;

    @Resource BfOrgShopDefineMapper            bfOrgShopDefineMapper;

    @Resource FullStockSyncService             fullStockSyncServiceImpl;

    @Resource ChangeFinalFreeShareStockService changeFinalFreeShareStockServiceImpl;

    @Resource ChannelCalService                channelCalServiceImpl;

    @Test
    public void testFinalFreeStock() throws Exception {
        StockWarehProd bean = new StockWarehProd();
        bean.setTableNum("03");
        changeFinalFreeShareStockServiceImpl.updateStockWarehProd(bean);
    }

    @Test
    public void testProcessChannelUsefulWarehChange() {
        channelCalServiceImpl.processChannelUsefulWarehChange(true);
    }

    @Test
    public void testPerformFullStockSync() {
        try {
            fullStockSyncServiceImpl.performFullStockSync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNerpFree() {
        try {
            //            bfOrgShopDefineMapper.selectAllForB2C();
            List<Map<String, Object>> item = fullStockSyncDefineMapper.selectFreeStockNERP(1, 1000);
            System.out.println(item.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNerpFreeCount() {
        try {
            //            bfOrgShopDefineMapper.selectAllForB2C();

            int count = fullStockSyncDefineMapper.countFreeStockNERP();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOerpFree() {
        try {
            //            bfOrgShopDefineMapper.selectAllForB2C();
            List<Map<String, Object>> item = fullStockSyncDefineMapper.selectFreeStockOERP(0, 1000);
            System.out.println(item.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOerpFreeCount() {
        try {
            //            bfOrgShopDefineMapper.selectAllForB2C();
            int count = fullStockSyncDefineMapper.countFreeStockOERP();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNerpLock() {
        try {
            //            bfOrgShopDefineMapper.selectAllForB2C();

            List<Map<String, Object>> item = fullStockSyncDefineMapper.selectLockStockNERP(0, 1000);

            System.out.println(item.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNerpLockCount() {
        try {
            int count = fullStockSyncDefineMapper.countLockStockNERP();

            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOerpLock() {
        try {
            List<Map<String, Object>> item = fullStockSyncDefineMapper.selectLockStockOERP(0, 1000);

            System.out.println(item.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOerpLockCount() {
        try {
            int count = fullStockSyncDefineMapper.countLockStockOERP();

            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    @Test
    //    public void testOerpLock() {
    //        try {
    //            List<Map<String, Object>> item = fullStockSyncDefineMapper.selectLockStockOERP(0, 1000);
    //                   
    //            System.out.println(item.size());
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //        }
    //    }

}
