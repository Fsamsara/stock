package com.metersbonwe.stock.biz.common.service.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemEnvironmentListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemEnvironmentListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 获取操作系统类型
        String systemOS = System.getProperty("os.name");
        String value = System.getProperty("mb.environment");
        LOGGER.debug("当前操作系统类型:" + systemOS + ",当前使用配置环境标识:" + value);
        // 如果是window 且 系统环境变量未设置  设置默认为 dev 开发模式
        if (StringUtils.isBlank(value) && systemOS.toUpperCase().indexOf("WINDOWS") >= 0) {
            System.setProperty("mb.environment", "dev");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}

}
