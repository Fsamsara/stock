package com.metersbonwe.stock.biz.common.fullsync.invoke;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.biz.common.service.iocutils.SpringApplicationContextAware;

/**
 * 
 * 自由量锁定量都需要继承该类，
 * 提供了1.insert,select,count的sqlfileName
 * 2.提供了按仓拿表的方法
 * 3.提供了从spring容器中获取各种service和mapper的方法
 *  
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-1 上午11:19:35
 */
public abstract class StockRowMethodInvoke implements RowMethodInvoke {
    protected String insertSqlFileName ;

    protected String selectSqlFileName;

    protected String countSqlFileName;
    
    /**
     * 
     * 得到insert sql
     * @param code
     * @param warehInserSqlMap
     * @param insertAll
     * @return
     */
    protected StringBuilder getInserSql(String warehId, Map<String, StringBuilder> warehInserSqlMap, String insertAll) {
        
        String code = getMultiTableService().getTableSuffixByWarehId(warehId);
        
        if (!warehInserSqlMap.containsKey(code)) {
            warehInserSqlMap.put(code, new StringBuilder(setSuffix(warehId, insertAll)));
        }
        return warehInserSqlMap.get(code);
    }

    /**
     * 
     * 根据仓库id替换表中的通配符
     * @param warehId
     * @param insertAll
     * @return
     */
    protected String setSuffix(String warehId, String insertAll) {
        return insertAll.replace("${suffix}", getMultiTableService().getTableSuffixByWarehId(warehId));
    }

    @SuppressWarnings("unused") protected int getInt(ResultSet rs, String name, int defaultValue) throws SQLException {
        Double d = rs.getDouble(name);
        if (d == null)
            return defaultValue;
        return (int) Math.round(d);
    }

    protected int getInt(ResultSet rs, String name) throws SQLException {
        return getInt(rs, name, 0);
    }

    protected MultiTableService getMultiTableService() {
        return SpringApplicationContextAware.getBean("multiTableServiceImpl", MultiTableService.class);
    }
    
    

    public String getInsertSqlFileName() {
        return insertSqlFileName;
    }

    public void setInsertSqlFileName(String insertSqlFileName) {
        this.insertSqlFileName = insertSqlFileName;
    }

    public String getSelectSqlFileName() {
        return selectSqlFileName;
    }

    public void setSelectSqlFileName(String selectSqlFileName) {
        this.selectSqlFileName = selectSqlFileName;
    }

    public String getCountSqlFileName() {
        return countSqlFileName;
    }

    public void setCountSqlFileName(String countSqlFileName) {
        this.countSqlFileName = countSqlFileName;
    }
    
    
}
