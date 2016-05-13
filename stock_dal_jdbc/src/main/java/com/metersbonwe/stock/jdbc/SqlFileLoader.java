package com.metersbonwe.stock.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;

public class SqlFileLoader {

    static StockLog log = StockLogFactory.getLogger(SqlFileLoader.class);

    public static String getSql(InputStream is) throws IOException {
        String s, line;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            s = "";
            line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("--")) {
                    continue;
                }
                s += line;
                s += "\r\n";
            }
        } finally {
            if (is != null) {
                is.close();
                is = null;
            }
        }
        log.debug(s);
        return s;
    }

    public static String getSql(String fileName) throws IOException {
        InputStream is = SqlFileLoader.class.getClassLoader().getResourceAsStream(fileName);
        return getSql(is);
    }

    public static String getSql(String fileName, int begin, int end) {
        String sql = "";
        try {
            sql = getSql(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sql = sql.replace("${begin}", "" + begin);
        sql = sql.replace("${end}", "" + end);
        log.debug(sql);
        return sql;
    }

}
