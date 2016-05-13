package com.metersbonwe.stock.log.api;

public interface StockLog {

    void setTargetLogClass(Class<?> clazz);

    void debug(String message, Exception e);

    void debug(String message);

    void info(String message, Exception e);

    void info(String message);

    void error(String message, Exception e);

    void error(String message);

    void warn(String message, Exception e);

    void warn(String message);

}
