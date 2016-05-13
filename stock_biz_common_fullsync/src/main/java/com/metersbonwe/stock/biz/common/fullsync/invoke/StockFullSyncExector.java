package com.metersbonwe.stock.biz.common.fullsync.invoke;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.metersbonwe.stock.biz.common.service.MultiTableService;
import com.metersbonwe.stock.configuration.ThreadConfig;
import com.metersbonwe.stock.dal.define.core.mapper.FullStockCoreDefineMapper;
import com.metersbonwe.stock.jdbc.SqlFileLoader;
import com.metersbonwe.stock.jdbc.mapper.StockFullSyncMapper;
import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;
import com.metersbonwe.stock.pojo.sync.PageBean;
import com.metersbonwe.stock.pojo.sync.PageIndexBean;

@Service public class StockFullSyncExector {

    StockLog                            log = StockLogFactory.getLogger(StockFullSyncExector.class);

    @Resource ThreadPoolTaskExecutor    stockCommonExecutor;

    @Resource MultiTableService         multiTableServiceImpl;

    ThreadConfig                        config;

    @Resource StockFullSyncMapper       stockFullSyncMapperOracleImpl;

    @Resource StockFullSyncMapper       stockFullSyncMapperMysqlImpl;

    @Resource FullStockCoreDefineMapper fullStockCoreDefineMapper;

    public void preform(ThreadConfig config) throws SQLException, IOException {
        this.config = config;
        insertGroupShopReMail();
        log.debug("开始执行老ERP自由量查询");
        exec(new FreeRowMethodInvoke("free_old_erp.sql", "free_old_erp_count.sql"));
        log.debug("开始执行新ERP自由量查询");
        exec(new FreeRowMethodInvoke("free_new_erp.sql", "free_new_erp_count.sql"));
        log.debug("开始执行老ERP锁定量量查询");
        exec(new LockedMethodInvoke("locked_old_erp.sql", "locked_old_erp_count.sql"));
        log.debug("开始执行新ERP锁定量量查询");
        exec(new LockedMethodInvoke("locked_new_erp.sql", "locked_new_erp_count.sql"));
        config.waitAllThreadDown();
    }

    /**
     * 汇总门店未日结
     */
    protected void insertGroupShopReMail() {
        //        不需要线程数量控制
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.debug("正在汇总门店未日结-");
                fullStockCoreDefineMapper.insertGroupByShopReMail();
                log.debug("汇总门店未日结 执行结束");

            }
        }).start();
    }

    void exec(StockRowMethodInvoke methodInvoke) throws SQLException, IOException {
        exec(methodInvoke.getInsertSqlFileName(), methodInvoke.selectSqlFileName, methodInvoke.getCountSqlFileName(), methodInvoke);
    };

    private void exec(String insertAllFileName, String selectSqlFileName, String countSqlFileName, final RowMethodInvoke rowMethod)
            throws SQLException, IOException {

        final String insertAll = SqlFileLoader.getSql(insertAllFileName);
        int allCount = getStockAllSize(countSqlFileName);
        log.debug("总记录数" + allCount);

        PageBean page = new PageBean(config.getSize(), allCount);

        while (page.hasNext()) {
            if (config.isThreadPoolNotEmpty()) {
                PageIndexBean pageIndex = page.next();
                final String sqltmp = getSelectSql(selectSqlFileName, pageIndex);
                config.threadUp();
                stockCommonExecutor.execute(new Runnable() {
                    public void run() {
                        try {
                            execMethod(insertAll, rowMethod, sqltmp);
                        } catch (SQLException e) {
                            log.error("执行sql出错", e);
                        } finally {
                            config.threadDown();
                        }
                    }
                });
            }
        }
    }

    private String getSelectSql(String selectSqlFileName, PageIndexBean pageIndex) {
        return SqlFileLoader.getSql(selectSqlFileName, pageIndex.getBegin(), pageIndex.getEnd());
    }

    private void execMethod(String insertAll, RowMethodInvoke rowMethod, String sqltmp) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Map<String, StringBuilder> warehInserSqlMap = Maps.newHashMap();
        try {
            conn = stockFullSyncMapperOracleImpl.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqltmp);

            while (rs.next()) {
                rowMethod.rowMethod(warehInserSqlMap, insertAll, rs);
            }
            execInsertMysql(warehInserSqlMap);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        }
    }

    /**
     * 写入MYSQL临时表
     * 
     * @param warehInserSqlMap
     */
    private void execInsertMysql(final Map<String, StringBuilder> warehInserSqlMap) {
        //        final ThreadConfig insertSqlconfig = ThreadConfigFactory.getThreadConfig("insertsql");
        //        insertSqlconfig.setMaxThreadCount(10);
        for (Iterator<String> iterator = warehInserSqlMap.keySet().iterator(); iterator.hasNext();) {
            final String key = iterator.next();
            log.debug("开始插入第" + key + "张表的数据");
            //            insertSqlconfig.waitThreadPoolNotEmpty();
            //            insertSqlconfig.threadUp();
            StringBuilder insertAllSqltmp = null;
            try {
                insertAllSqltmp = warehInserSqlMap.get(key);
                insertAllSqltmp.deleteCharAt(insertAllSqltmp.length() - 1);
                long b = System.currentTimeMillis();
                stockFullSyncMapperMysqlImpl.execSqlU(insertAllSqltmp.toString());
                log.debug("第" + key + "张表的数据插入结束,耗时" + (System.currentTimeMillis() - b));
            } catch (Exception e) {
                log.error("插入MYSQL数据出错", e);
            } finally {
                //                insertSqlconfig.threadDown();
                //  free mem
                insertAllSqltmp = null;
                warehInserSqlMap.put(key, null);
            }
        } //end with for
          //        insertSqlconfig.waitAllThreadDown();
        warehInserSqlMap.clear();
    }

    private int getStockAllSize(String countSqlFileName) throws IOException, SQLException {
        String sqlcount = SqlFileLoader.getSql(countSqlFileName);
        return stockFullSyncMapperOracleImpl.getCount(sqlcount);
    }

}
