package com.metersbonwe.stock.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

    private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";

//    private final static String url         = "jdbc:mysql://10.101.1.181:3306/stock_sale?useUnicode=true&characterEncoding=utf-8";
//
//    private final static String username    = "ry";
//
//    private final static String password = "123456";

//    private final static String url         = "jdbc:mysql://192.168.149.52:3306/kc?useUnicode=true&characterEncoding=utf-8";
//    private final static String username    = "admin";
//    private final static String password    = "admin52";
    	
      private final static String url         = "jdbc:mysql://10.100.22.231:3306/kc?useUnicode=true&characterEncoding=utf-8";
      private final static String username    = "openmall";
      private final static String password    = "123";


    static {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static Statement getStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    public static void execSqlU(String sql) throws SQLException {
        		Connection conn = null;
        		Statement stmt = null;
        		try {
        			conn = getConnection();
        			stmt = getStatement(conn);
        			stmt.executeUpdate(sql);
        		}finally {
        			try {
        				if (stmt != null) {
        					stmt.close();
        					stmt = null;
        				}
        				if (conn != null) {
        					conn.close();
        					conn = null;
        				}
        			} catch (SQLException e) {
        				e.printStackTrace();
        			}
        
        		}
    }

}
