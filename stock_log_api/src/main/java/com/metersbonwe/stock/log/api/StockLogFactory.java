package com.metersbonwe.stock.log.api;

public class StockLogFactory {

    public static final String LOG_CLASS_NAME = "com.metersbonwe.stock.log.log4j.StockLogImpl";

    public static StockLog getLogger(Class<?> clazz) {
        StockLog stockLog = null;
        try {
            Object object = Class.forName(LOG_CLASS_NAME).newInstance();
            stockLog = (StockLog) object;
            stockLog.setTargetLogClass(clazz);
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return stockLog;
    }

}
