package com.metersbonwe.stock.jdbc.mapper.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Service;

import com.metersbonwe.stock.jdbc.mapper.StockFullSyncMapperImpl;

@Service public class StockFullSyncMapperMysqlImpl extends StockFullSyncMapperImpl {

    @Resource protected BasicDataSource stockCoreDataSource;

    @Override
    public Connection getConnection() throws SQLException {
        return stockCoreDataSource.getConnection();
    }

}
