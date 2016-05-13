package com.metersbonwe.stock.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertiesUtil extends PropertyPlaceholderConfigurer {

    private static Map<String, String> ctxPropertiesMap;

    @Override
    protected void processProperties(
            ConfigurableListableBeanFactory beanFactoryToProcess,
            Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        ctxPropertiesMap = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            ctxPropertiesMap.put(keyStr, value);
        }
    }

    public static String getString(String name) {
        if (ctxPropertiesMap == null) {
            ctxPropertiesMap = new HashMap<String, String>();
        }
        return ctxPropertiesMap.get(name);
    }

    public static int getIntValue(String name, int defaultValue) {
        try {
            int r = Integer.parseInt(name);
            return r;
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
