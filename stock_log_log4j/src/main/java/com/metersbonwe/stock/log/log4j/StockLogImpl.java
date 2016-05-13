package com.metersbonwe.stock.log.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.metersbonwe.stock.log.api.StockLog;

public class StockLogImpl implements StockLog {

    private Logger LOGGER;

    @Override
    public void setTargetLogClass(Class<?> clazz) {
        if (LOGGER == null) {
            LOGGER = LoggerFactory.getLogger(clazz);
        }
    }

    @Override
    public void debug(String message, Exception e) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(message, e);
        }
    }

    @Override
    public void debug(String message) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(message);
        }
    }

    @Override
    public void info(String message, Exception e) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(message, e);
        }
    }

    @Override
    public void info(String message) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(message);
        }
    }

    @Override
    public void error(String message, Exception e) {
        if (LOGGER.isErrorEnabled()) {
            LOGGER.error(message, e);
        }
    }

    @Override
    public void error(String message) {
        if (LOGGER.isErrorEnabled()) {
            LOGGER.error(message);
        }
    }

    @Override
    public void warn(String message, Exception e) {
        if (LOGGER.isWarnEnabled()) {
            LOGGER.warn(message, e);
        }
    }

    @Override
    public void warn(String message) {
        if (LOGGER.isWarnEnabled()) {
            LOGGER.warn(message);
        }
    }

}
