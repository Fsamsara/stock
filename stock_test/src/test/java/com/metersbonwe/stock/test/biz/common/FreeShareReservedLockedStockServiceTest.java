package com.metersbonwe.stock.test.biz.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.metersbonwe.stock.biz.common.service.FreeShareReservedLockedStockService;
import com.metersbonwe.stock.po.sync.UrUnitReservedResult;
import com.metersbonwe.stock.pojo.QryLockStockResultBean;
import com.metersbonwe.stock.test.TestBase;

public class FreeShareReservedLockedStockServiceTest extends TestBase {

    @Resource private FreeShareReservedLockedStockService freeShareReservedLockedStockServiceImpl;

    @Test
    public void unitReservedTest() {
        try {
            List<String> unitList = new ArrayList<String>();
            unitList.add("A00561");
            List<String> warehList = new ArrayList<String>();
            warehList.add("HQ01W550");
            warehList.add("HQ01W700");
            List<String> reservedTypeList = new ArrayList<String>();
            reservedTypeList.add("07");
            List<String> skuList = new ArrayList<String>();
            skuList.add("20629390148");
            skuList.add("20629390150");
            skuList.add("50006000128");
            List<UrUnitReservedResult> unitReservedList = freeShareReservedLockedStockServiceImpl.getUnitReserved(
                    unitList,
                    reservedTypeList,
                    warehList,
                    skuList);
            if (unitReservedList != null && unitReservedList.size() > 0) {
                System.out.println("查询预留量记录数:" + unitReservedList.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void lockStockTest() {
        try {
            List<String> warehList = new ArrayList<String>();
            warehList.add("HQ01W036");
            warehList.add("HQ01W700");
            warehList.add("HQ01W850");
            List<String> reservedTypeList = new ArrayList<String>();
            reservedTypeList.add("01");
            reservedTypeList.add("02");
            reservedTypeList.add("03");
            reservedTypeList.add("07");
            List<String> skuList = new ArrayList<String>();
            skuList.add("21472765144");
            skuList.add("21472765146");
            skuList.add("50006000128");
            skuList.add("53554998148");
            skuList.add("55650937129");
            List<QryLockStockResultBean> lockStockList = freeShareReservedLockedStockServiceImpl.getLockStock(reservedTypeList, warehList, skuList);
            if (lockStockList != null && lockStockList.size() > 0) {
                System.out.println("查询预留量记录数:" + lockStockList.size());
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

}
