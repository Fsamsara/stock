package com.metersbonwe.stock.jdbc.mapper;

import java.sql.Connection;
import java.sql.SQLException;

public interface StockFullSyncMapper {

    Connection getConnection() throws SQLException;

    int execSqlU(String sql);
    
    public int getCount(String sql) throws SQLException;

}
