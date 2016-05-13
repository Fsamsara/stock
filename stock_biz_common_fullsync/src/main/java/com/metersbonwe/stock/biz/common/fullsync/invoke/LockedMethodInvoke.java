package com.metersbonwe.stock.biz.common.fullsync.invoke;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * 
 * 新老ERP锁定量处理方法 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-1 上午11:25:22
 */
public class LockedMethodInvoke extends StockRowMethodInvoke implements RowMethodInvoke {

    public LockedMethodInvoke(String selectSqlFileName, String countSqlFileName) {
        super();
        this.insertSqlFileName = "locked_insert.sql";
        this.selectSqlFileName = selectSqlFileName;
        this.countSqlFileName = countSqlFileName;
    }

    @Override
    public void rowMethod(Map<String, StringBuilder> warehInserSqlMap, String insertAll, ResultSet rs) {
        try {
            String wareh_id = rs.getString("WAREH_CODE");
            String prod_id = rs.getString("SKU");
            int lock_stock = getInt(rs, "LOCK_NUM");
            StringBuilder insertAllSql = getInserSql(wareh_id, warehInserSqlMap, insertAll);
            insertAllSql.append("(").append("'").append(wareh_id).append("','").append(prod_id).append("',").append(lock_stock)
                    .append(",now())\r\n,");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
