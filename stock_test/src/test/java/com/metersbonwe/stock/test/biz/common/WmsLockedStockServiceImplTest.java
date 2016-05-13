package com.metersbonwe.stock.test.biz.common;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.metersbonwe.stock.biz.common.service.WmsLockedStockService;
import com.metersbonwe.stock.po.core.TmpStockWms;
import com.metersbonwe.stock.test.TestBase;

public class WmsLockedStockServiceImplTest extends TestBase {
    @Autowired
    WmsLockedStockService wmsLockedStockService;

    /*
     * @Test public void getTmpTableNameTst() { String tabaleName = wmsLockedStockService .getTmpTableNameFromStockCommonConfig();
     * System.out.println(tabaleName); }
     */

    /*
     * @Test public void getWmsLocedList() { List<TmpStockWms> tmpStockWmsList = wmsLockedStockService.selectTmpStockWmsList();
     * System.out.println("返回大小" + tmpStockWmsList.size()); }
     */

    /*
     * @Test public void updCommonConfigNewTableName() { String tableName = "TMP_WMS_STOCK_BAK";
     * wmsLockedStockService.updCommonConfigNewTableName(tableName); getTmpTableNameTst(); }
     */

    /*
     * @Test public void truncateTable() { String tableName = "TMP_WMS_STOCK_BAK"; wmsLockedStockService.truncateTable(tableName); tableName =
     * "TMP_WMS_STOCK"; wmsLockedStockService.truncateTable(tableName); }
     */
    @Test
    public void getWmsLoced() {
        String warehId = "HQ01W500";
        String prodId = "23790971142";
        TmpStockWms bak = wmsLockedStockService.selectTmpStockWms(warehId, prodId);
        if (null == bak) {
            System.out.println("没有数据");
        } else {
            System.out.println("获取数据,值是" + bak.getWmsStock());
        }
    }
}
