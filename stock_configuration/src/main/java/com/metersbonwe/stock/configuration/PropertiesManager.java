package com.metersbonwe.stock.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.metersbonwe.stock.log.api.StockLog;
import com.metersbonwe.stock.log.api.StockLogFactory;

/**
 * 通用配置文件工具类
 * 
 * @author 张瑞雨
 */
public class PropertiesManager {

    private static PropertiesManager propertiesManager;

    private static Object            lock             = new Object();

    //TODO 改为通用配置
    private static final String      CONFIG_FILE_NAME = "stock_define.properties";

    private Properties               pProps;

    public static final int          START_WITH       = 1;

    public static final int          END_WITH         = 2;

    private StockLog                 log              = StockLogFactory.getLogger(PropertiesManager.class);

    private PropertiesManager() {
        init();
    }

    public static PropertiesManager getPropertiesManager() {
        if (propertiesManager == null) {
            synchronized (lock) {
                if (propertiesManager == null) {
                    propertiesManager = new PropertiesManager();
                }
            }
        }
        return propertiesManager;
    }

    private void init() {
        pProps = new Properties();
        InputStream inputStream = null;
        try {
            String environment = System.getProperty("mb.environment", "dev");
            inputStream = this.getClass().getClassLoader().getResourceAsStream(environment + "/" + CONFIG_FILE_NAME);
            pProps.load(inputStream);
        } catch (Exception e) {
            log.error("加载通用配置文件出错", e);
            throw new RuntimeException("加载通用配置文件出错", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("关闭文件流失败", e);
                }
            }
        }
    }

    /**
     * 获取指定名称的属性值
     * 
     * @param name
     *            属性key
     * @param defaultVal
     *            该属性默认值
     * @return
     */
    public Object getPropertyItem(String name, Object defaultVal) {

        Object val = propertiesManager.pProps.get(name);

        return val != null && val.toString().length() > 0 ? val : defaultVal;
    }

    /**
     * 获取指定名称的属性值
     * 
     * @param name
     *            属性key
     * @return
     */
    public String getProperty(String name) {

        Object val = propertiesManager.pProps.get(name);

        if (val != null) {
            return val.toString().trim();
        }
        return "";
    }

    /**
     * 获取指定名称的属性值
     * 
     * @param name
     *            属性key
     * @return
     */
    public String getProperty(String name, String defaultValue) {

        Object val = propertiesManager.pProps.get(name);

        if (val != null && !StringUtils.isEmpty(val.toString())) {
            return val.toString().trim();
        }
        return defaultValue;
    }

    /**
     * 获取属性文件中属性键值对的数量
     * 
     * @return
     */
    public int getPropertySize() {
        Set<String> keys = getKeysAsSet();
        try {
            return keys != null ? keys.size() : 0;
        } catch (Exception e) {
            // logger.error(e.getMessage(), e);
            return 0;
        }
    }

    /**
     * 获取属性文件中所有属性的Key，以Set<String>形式返回
     * 
     * @return
     */
    public Set<String> getKeysAsSet() {
        try {
            Set<String> keys = null;
            keys = propertiesManager.pProps.stringPropertyNames();
            return keys;
        } catch (Exception e) {
            // logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 前缀取值列表
     * 
     * @param startStr
     *            前缀
     * @return 值列表
     */
    public List<String> getStartWith(String startStr) {
        return getList(startStr, START_WITH);
    }

    /**
     * 后缀取值列表
     * 
     * @param endStr
     *            后缀
     * @return 值列表
     */
    public List<String> getEndWith(String endStr) {
        return getList(endStr, END_WITH);
    }

    private List<String> getList(String str, int startOrend) {
        Set<Object> keys = propertiesManager.pProps.keySet();
        List<String> values = new LinkedList<String>();
        if (keys == null)
            return values;
        for (Iterator<Object> iter = keys.iterator(); iter.hasNext();) {
            String key = (String) iter.next();
            if (key == null)
                continue;
            if (startOrend == START_WITH) {
                if (key.startsWith(str)) {
                    values.add(getProperty(key));
                }
            } else if (startOrend == END_WITH) {
                if (key.endsWith(str)) {
                    values.add(getProperty(key));
                }
            }
        }
        return values;
    }

}
