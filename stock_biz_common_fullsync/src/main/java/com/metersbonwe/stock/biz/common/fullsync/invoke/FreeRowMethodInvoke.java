package com.metersbonwe.stock.biz.common.fullsync.invoke;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.metersbonwe.stock.po.core.TmpStockWarehProdFree;

/**
 * 新老ERP自由量处理
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-1 上午11:23:45
 */
public class FreeRowMethodInvoke extends StockRowMethodInvoke {

    public FreeRowMethodInvoke(String selectSqlFileName, String countSqlFileName) {
        super();
        this.insertSqlFileName = "free_insert.sql";
        this.selectSqlFileName = selectSqlFileName;
        this.countSqlFileName = countSqlFileName;
    }

    @Override
    public void rowMethod(Map<String, StringBuilder> warehInserSqlMap, String insertAll, ResultSet rs) {
        try {
            TmpStockWarehProdFree freeBean = new TmpStockWarehProdFree();
            freeBean.setWarehId(rs.getString("WAREH_CODE"));
            freeBean.setProdId(rs.getString("SKU"));
            String used_ma =  rs.getString("USED_MA");
            used_ma = StringUtils.isEmpty(used_ma) ? "0" : used_ma;
            used_ma = used_ma.trim().length() > 1 ? "0" : used_ma;
            freeBean.setUsedMa(used_ma.trim());
            String is_shop = rs.getString("IS_SHOP");
            freeBean.setStkOnHand(getInt(rs, "STK_ON_HAND"));
            freeBean.setQtyCommitted(getInt(rs, "COMMITTED_NUM"));
            freeBean.setFreeShareStock(getInt(rs, "FREE_NUM"));
            freeBean.setSafeType(rs.getString("SAFEQTY_TYPE"));
            freeBean.setSafeStock(getInt(rs, "SAFETY_STOCK", -1));

            StringBuilder insertAllSql = getInserSql(freeBean.getWarehId(), warehInserSqlMap, insertAll);

            insertAllSql.append("(").append("'").append(freeBean.getWarehId()).append("','").append(freeBean.getProdId()).append("',")
                    .append(freeBean.getStkOnHand()).append(",").append(freeBean.getQtyCommitted()).append(",").append(freeBean.getFreeShareStock())
                    .append(",'").append(freeBean.getSafeType()).append("',").append(freeBean.getSafeStock()).append(",'")
                    .append(freeBean.getUsedMa()).append("',").append(is_shop).append(",now())\r\n,");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
