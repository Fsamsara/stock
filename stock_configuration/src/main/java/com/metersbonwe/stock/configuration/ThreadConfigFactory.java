package com.metersbonwe.stock.configuration;

/**
 * 
 * 线程相关配置加载器
 *  
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-4-1 下午2:20:54
 */
public class ThreadConfigFactory {

    private static final PropertiesManager proper = PropertiesManager.getPropertiesManager();

    private ThreadConfigFactory() {};

    private static final String THREAD_CONFIG_PREFIX        = "thread.";

    private static final String THREAD_CONFIG_MAXSIZE       = ".maxsize";

    private static final String THREAD_CONFIG_MAXTHREADSIZE = ".maxthread";

    public static ThreadConfig getThreadConfig(String bizName) {
        ThreadConfig config = new ThreadConfig();
        config.setBizName(bizName);
        int maxSize = Integer.parseInt(proper.getProperty(getMaxSize(bizName), "" + config.getSize()));
        config.setSize(maxSize);
        int maxThreadSize = Integer.parseInt(proper.getProperty(getMaxThreadSize(bizName), "" + config.getMaxThreadCount()));
        config.setMaxThreadCount(maxThreadSize);
        return config;
    }

    private static String getMaxThreadSize(String bizName) {
        return THREAD_CONFIG_PREFIX + bizName + THREAD_CONFIG_MAXTHREADSIZE;
    }

    private static String getMaxSize(String bizName) {
        return THREAD_CONFIG_PREFIX + bizName + THREAD_CONFIG_MAXSIZE;
    }

}
